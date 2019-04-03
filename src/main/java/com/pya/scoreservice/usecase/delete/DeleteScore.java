package com.pya.scoreservice.usecase.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface DeleteScore {

  void deleteById(Request request);

  @Getter
  @Setter
  @AllArgsConstructor
  class Request {

    private String scoreId;
  }
}
