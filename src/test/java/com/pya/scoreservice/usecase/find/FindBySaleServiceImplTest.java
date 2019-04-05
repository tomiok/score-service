package com.pya.scoreservice.usecase.find;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pya.scoreservice.TestFixtures;
import com.pya.scoreservice.model.Points;
import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;
import java.util.Optional;
import java.util.UUID;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FindBySaleServiceImplTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Mock
  private ScoreRepository scoreRepository;

  @InjectMocks
  private FindBySaleServiceImpl findBySaleService;

  @Test
  public void findScoreBySale() {

    String saleId = UUID.randomUUID().toString();
    String userId = UUID.randomUUID().toString();
    String storeId = UUID.randomUUID().toString();

    Score score = TestFixtures.createScore(userId, storeId, saleId, "Really nice restaurant!", Points.FOUR);

    when(scoreRepository.findBySaleIdentifier(saleId)).thenReturn(Optional.of(score));

    Score actual = findBySaleService.findScoreBySale(new FindScoreBySaleService.Request(saleId));

    assertThat(actual).isNotNull();
    assertThat(actual.getComment()).isEqualTo("Really nice restaurant!");
    assertThat(actual.getUuid()).isNotEmpty();
    assertThat(actual.getPoints()).isEqualTo(Points.FOUR);

    verify(scoreRepository, times(1)).findBySaleIdentifier(saleId);
  }
  @Test
  public void shouldFailGivenWrongSaleId() {
    thrown.expect(IllegalArgumentException.class);
    findBySaleService.findScoreBySale(new FindScoreBySaleService.Request("someId"));
    verify(scoreRepository, times(1)).findBySaleIdentifier("someId");
  }
}