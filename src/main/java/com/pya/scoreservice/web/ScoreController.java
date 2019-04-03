package com.pya.scoreservice.web;

import com.pya.scoreservice.usecase.delete.DeleteScoreService;
import com.pya.scoreservice.usecase.find.FindScoreBySaleService;
import com.pya.scoreservice.usecase.find.FindScoresByStoreService;
import com.pya.scoreservice.usecase.save.SaveScoreService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  public ResponseEntity<ScoreSummary> saveScore(SaveScoreHttpCommand cmd) {

    return null;
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deleteScore(@PathVariable String scoreId) {

    return null;
  }

  @GetMapping
  @RequestMapping(params = "saleId")
  public ResponseEntity<ScoreSummary> findBySaleId(@RequestParam("saleId") String saleId) {

    return null;
  }

  @GetMapping
  @RequestMapping(params = { "saleId", "timeFrom", "timeTo" })
  public ResponseEntity<List<ScoreSummary>> findByStoreIdInRange(
      @RequestParam("saleId") String saleId,
      @RequestParam("timeFrom") long from,
      @RequestParam("timeTo") long to) {

    return null;
  }
}
