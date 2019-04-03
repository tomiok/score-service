package com.pya.scoreservice.usecase.save;

import com.pya.scoreservice.model.Points;
import com.pya.scoreservice.model.Score;
import lombok.Getter;
import lombok.Setter;

public interface SaveScore {

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
  class Request {

    private String userIdentifier;
    private String storeIdentifier;
    private String saleIdentifier;
    private String opinion;
    private Points points;

  }
}
