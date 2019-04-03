package com.pya.scoreservice.usecase.save;

import com.pya.scoreservice.model.ScoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveServiceConfig {

  @Bean
  public SaveScoreService saveScoreService(final ScoreRepository scoreRepository) {
    return new SaveScoreServiceImpl(scoreRepository);
  }
}
