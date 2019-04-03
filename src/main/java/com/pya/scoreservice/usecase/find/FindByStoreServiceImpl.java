package com.pya.scoreservice.usecase.find;

import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;
import java.util.List;

public class FindByStoreServiceImpl implements FindScoresByStoreService {

  private final ScoreRepository scoreRepository;

  public FindByStoreServiceImpl(final ScoreRepository scoreRepository) {
    this.scoreRepository = scoreRepository;
  }

  @Override
  public List<Score> findScoresByStoreInRange(final Request request) {
    return scoreRepository.findByStoreIdentifierAndCreatedAtBetween(
        request.getStoreId(),
        request.getCommentedAtFrom(),
        request.getCommentedAtTo()
    );
  }
}
