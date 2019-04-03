package com.pya.scoreservice.model;

import lombok.Getter;

public enum Points {
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5);

  @Getter
  int point;

  Points(final int point) {
    this.point = point;
  }

  public static Points create(int p) {
    switch (p) {
      case 1:
        return ONE;
      case 2:
        return TWO;
      case 3:
        return THREE;
      case 4:
        return FOUR;
      case 5:
        return FIVE;
      default:
        throw new IllegalArgumentException("Punctuation must be between 1 to 5 inclusive. " + p + " is invalid.");
    }
  }
}
