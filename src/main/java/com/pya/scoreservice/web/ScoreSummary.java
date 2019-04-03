package com.pya.scoreservice.web;

import com.pya.scoreservice.model.Score;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
final class ScoreSummary {

  private String id;

  private String uuid;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String storeId;

  private String userId;

  private String saleId;

  private int points;

  static ScoreSummary fromModel(final Score score) {
    return new ScoreSummary(
        score.getId(),
        score.getUuid(),
        score.getCreatedAt(),
        score.getUpdatedAt(),
        score.getStoreIdentifier(),
        score.getUserIdentifier(),
        score.getSaleIdentifier(),
        score.getPoints().getPoint()
    );
  }
}
