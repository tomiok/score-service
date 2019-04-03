package com.pya.scoreservice.usecase.find;

import com.pya.scoreservice.model.Score;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public interface FindScoreBySaleService {

  Score findScoreBySale(Request request);

  @Getter
  @Setter
  @AllArgsConstructor
  class Request {

    private String saleId;
  }
}
