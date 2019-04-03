package com.pya.scoreservice.web;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.pya.scoreservice.model.Points;
import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.usecase.delete.DeleteScoreService;
import com.pya.scoreservice.usecase.find.FindScoreBySaleService;
import com.pya.scoreservice.usecase.find.FindScoresByStoreService;
import com.pya.scoreservice.usecase.save.SaveScoreService;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {

  private final SaveScoreService saveScoreService;

  private final FindScoreBySaleService findScoreBySaleService;

  private final FindScoresByStoreService findScoresByStoreService;

  private final DeleteScoreService deleteScoreService;

  public ScoreController(
      final SaveScoreService saveScoreService,
      final FindScoreBySaleService findScoreBySaleService,
      final FindScoresByStoreService findScoresByStoreService,
      final DeleteScoreService deleteScoreService) {
    this.saveScoreService = saveScoreService;
    this.findScoreBySaleService = findScoreBySaleService;
    this.findScoresByStoreService = findScoresByStoreService;
    this.deleteScoreService = deleteScoreService;
  }

  @PostMapping
  public ResponseEntity<ScoreSummary> saveScore(@RequestBody SaveScoreHttpCommand cmd) {
    Score score = saveScoreService.save(new SaveScoreService.Request(
        cmd.getUserIdentifier(),
        cmd.getStoreIdentifier(),
        cmd.getSaleIdentifier(),
        cmd.getComment(),
        Points.create(cmd.getPoints())
    ));

    return ok(ScoreSummary.fromModel(score));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deleteScore(@PathVariable("id") String scoreId) {
    deleteScoreService.deleteById(new DeleteScoreService.Request(scoreId));
    return noContent().build();
  }

  @GetMapping
  @RequestMapping(params = "saleIdentifier")
  public ResponseEntity<ScoreSummary> findBySaleId(@RequestParam("saleIdentifier") String saleIdentifier) {
    Score score = findScoreBySaleService.findScoreBySale(new FindScoreBySaleService.Request(saleIdentifier));
    return ok(ScoreSummary.fromModel(score));
  }

  @GetMapping
  @RequestMapping(params = { "saleIdentifier", "timeFrom", "timeTo" })
  public ResponseEntity<List<ScoreSummary>> findByStoreIdInRange(
      @RequestParam("saleIdentifier") String saleIdentifier,
      @RequestParam("timeFrom") long from,
      @RequestParam("timeTo") long to) {
    List<Score> scores = findScoresByStoreService
        .findScoresByStoreInRange(new FindScoresByStoreService.Request(
            saleIdentifier,
            Instant.ofEpochMilli(from).atZone(ZoneId.systemDefault()).toLocalDateTime(),
            Instant.ofEpochMilli(to).atZone(ZoneId.systemDefault()).toLocalDateTime()
        ));
    List<ScoreSummary> summaries = scores
        .stream()
        .map(ScoreSummary::fromModel)
        .collect(toList());

    return ok(summaries);
  }
}
