package com.pya.scoreservice.usecase.delete;

import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;

public class DeleteScoreServiceImpl implements DeleteScoreService {

  private final ScoreRepository scoreRepository;

  DeleteScoreServiceImpl(final ScoreRepository scoreRepository) {
    this.scoreRepository = scoreRepository;
  }

  @Override
  public void deleteById(final Request request) {
    Score score =
        scoreRepository
            .findById(request.getScoreId())
        .orElseThrow(
            () -> new IllegalArgumentException("The score with id " + request.getScoreId() + " does not exists.")
        );

    score.setActive(false);
    scoreRepository.save(score);
  }
}
