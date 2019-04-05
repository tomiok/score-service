package com.pya.scoreservice;

import com.pya.scoreservice.model.Points;
import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.usecase.save.SaveScoreService;

public class TestFixtures {

  public static SaveScoreService.Request createSaveRequest(
      String userId,
      String storeId,
      String saleId,
      String comment,
      Points points
  ) {
    return new SaveScoreService.Request(userId, storeId, saleId, comment, points);
  }

  public static Score createScore(
      String userId,
      String storeId,
      String saleId,
      String comment,
      Points points
  ) {
    return new Score(userId, saleId, storeId, comment, points);
  }
}
