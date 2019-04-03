package com.pya.scoreservice.usecase.delete;

import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;

public class DeleteScoreImpl implements DeleteScore {

  private final ScoreRepository scoreRepository;

  public DeleteScoreImpl(final ScoreRepository scoreRepository) {
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
