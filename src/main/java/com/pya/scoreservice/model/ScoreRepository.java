package com.pya.scoreservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoreRepository extends MongoRepository<Score, String> {

  Optional<Score> findBySaleIdentifier(String saleId);

  List<Score> findByStoreIdentifierAndCreatedAtBetween(
      String storeIdentifier,
      LocalDateTime createdAtFrom,
      LocalDateTime createdAtTo);
}
