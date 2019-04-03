package com.pya.scoreservice.usecase.find;

import com.pya.scoreservice.model.Score;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public interface FindScoresByStore {

  List<Score> findScoresByStoreInRange(Request request);

  @Getter
  @Setter
  class Request {

    private String storeId;

    private LocalDateTime commentedAt;


  }
}
