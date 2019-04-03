package com.pya.scoreservice.usecase.find;

import com.pya.scoreservice.model.ScoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindServiceConfig {

  @Bean
  public FindScoreBySaleService findScoreBySaleService(final ScoreRepository scoreRepository) {
    return new FindBySaleServiceImpl(scoreRepository);
  }

  @Bean
  public FindScoresByStoreService findScoresByStoreService(final ScoreRepository scoreRepository) {
    return new FindByStoreServiceImpl(scoreRepository);
  }
}
