package com.pya.scoreservice.usecase.save;

import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;

public class SaveScoreServiceImpl implements SaveScoreService {

  private final ScoreRepository scoreRepository;

  public SaveScoreServiceImpl(final ScoreRepository scoreRepository) {
    this.scoreRepository = scoreRepository;
  }

  @Override
  public Score save(final Request request) {
    Score score = new Score(
        request.getUserIdentifier(),
        request.getSaleIdentifier(),
        request.getStoreIdentifier(),
        request.getComment(),
        request.getPoints()
    );
    return scoreRepository.save(score);
  }
}
