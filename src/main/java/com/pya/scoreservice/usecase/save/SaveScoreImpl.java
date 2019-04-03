package com.pya.scoreservice.usecase.save;

import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;
import org.springframework.transaction.annotation.Transactional;

public class SaveScoreImpl implements SaveScore {

  private final ScoreRepository scoreRepository;

  public SaveScoreImpl(final ScoreRepository scoreRepository) {
    this.scoreRepository = scoreRepository;
  }

  @Override
  public Score save(final Request request) {
    Score score = new Score(
        request.getUserIdentifier(),
        request.getSaleIdentifier(),
        request.getStoreIdentifier(),
        request.getOpinion(),
        request.getPoints()
    );
    return scoreRepository.save(score);
  }
}
