package com.pya.scoreservice.usecase.save;

import com.pya.scoreservice.model.Points;
import com.pya.scoreservice.model.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface SaveScoreService {

  /**
   * Save a {@link Score} in the database.
   *
   * @param request A command containing all the data needed to create the score.
   *
   * @return The score created.
   */
  Score save(Request request);

  @Getter
  @Setter
  @AllArgsConstructor
  class Request {

    private String userIdentifier;
    private String storeIdentifier;
    private String saleIdentifier;
    private String comment;
    private Points points;

  }
}
