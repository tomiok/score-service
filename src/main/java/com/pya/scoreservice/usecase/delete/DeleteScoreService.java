package com.pya.scoreservice.usecase.delete;

import com.pya.scoreservice.model.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface DeleteScoreService {

  /**
   * Logic delete for the {@link Score} - put the flag {@link Score#active} to false.
   *
   * @param request The score id.
   */
  void deleteById(Request request);

  @Getter
  @Setter
  @AllArgsConstructor
  class Request {

    private String scoreId;
  }
}
