package com.pya.scoreservice.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
final class SaveScoreHttpCommand {

  private long createdAt;

  private String storeId;

  private String userId;

  private String saleId;

  private int points;
}
