package com.pya.scoreservice.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
final class SaveScoreHttpCommand {

  private String storeIdentifier;

  private String userIdentifier;

  private String saleIdentifier;

  private int points;

  private String comment;
}
