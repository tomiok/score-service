package com.pya.scoreservice.usecase.find;

import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;

public class FindBySaleServiceImpl implements FindScoreBySaleService {

  private final ScoreRepository scoreRepository;

  FindBySaleServiceImpl(final ScoreRepository scoreRepository) {
    this.scoreRepository = scoreRepository;
  }

  @Override
  public Score findScoreBySale(final Request request) {
    return scoreRepository
        .findBySaleIdentifier(request.getSaleIdentifier())
        .orElseThrow(
            () -> new IllegalArgumentException("The score with sale id " + request.getSaleIdentifier() + " does not exists.")
        );
  }
}
