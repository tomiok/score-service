package com.pya.scoreservice.usecase.delete;

import com.pya.scoreservice.model.ScoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteServiceConfig {

  @Bean
  public DeleteScoreService deleteScoreService(final ScoreRepository scoreRepository) {
    return new DeleteScoreServiceImpl(scoreRepository);
  }
}
