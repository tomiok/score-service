package com.pya.scoreservice.usecase.find;

import com.pya.scoreservice.model.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface FindScoreBySaleService {

  /**
   * Find a Score given a sale id. Only one opinion can be sent within a sale.
   *
   * @param request The sale identifier to fetch the opinion.
   *
   * @return The {@link Score} with that sale identifier.
   */
  Score findScoreBySale(Request request);

  @Getter
  @Setter
  @AllArgsConstructor
  class Request {

    private String saleIdentifier;
  }
}
