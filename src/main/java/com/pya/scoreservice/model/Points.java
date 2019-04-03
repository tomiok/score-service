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

}
