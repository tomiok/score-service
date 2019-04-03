package com.pya.scoreservice.model;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScoreRepository extends MongoRepository<Score, String> {

  Optional<Score> findBySaleIdentifier(String saleId);
}
