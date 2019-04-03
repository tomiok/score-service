package com.pya.scoreservice.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.Validate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "score")
@Getter
@Setter
public class Score {

  @Id
  private String id;

  /**
   * Global identifier.
   */
  private String uuid;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String userIdentifier;

  @Indexed(unique = true)
  private String saleIdentifier;

  private String storeIdentifier;

  /**
   * Will be active by default, if is deleted, will be turned off.
   */
  private boolean active;

  /**
   * Comment is free text - Empty opinion is allowed.
   */
  private String comment;

  private Points points;

  public Score() {
  }

  public Score(
      final String userIdentifier,
      final String saleIdentifier,
      final String storeIdentifier,
      final String comment,
      final Points points) {
    this.uuid = UUID.randomUUID().toString();
    this.createdAt = LocalDateTime.now();
    this.userIdentifier = userIdentifier;
    this.saleIdentifier = saleIdentifier;
    this.storeIdentifier = storeIdentifier;
    this.comment = comment;
    this.points = points;
    this.active = true;
  }
}
