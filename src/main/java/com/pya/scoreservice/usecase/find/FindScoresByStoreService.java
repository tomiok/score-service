package com.pya.scoreservice.usecase.find;

import com.pya.scoreservice.model.Score;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public interface FindScoresByStoreService {

  /**
   * @param request The store identifier and the dates in range.
   *
   * @return A list of the scores in that range for that store identifier.
   */
  List<Score> findScoresByStoreInRange(Request request);

  @Getter
  @Setter
  class Request {

    private String storeIdentifier;

    private LocalDateTime commentedAtFrom;

    private LocalDateTime commentedAtTo;
  }
}
