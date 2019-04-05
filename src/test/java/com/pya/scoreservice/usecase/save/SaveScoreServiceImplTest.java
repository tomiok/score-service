package com.pya.scoreservice.usecase.save;

import static org.assertj.core.api.Assertions.assertThat;

import com.pya.scoreservice.TestFixtures;
import com.pya.scoreservice.model.Points;
import com.pya.scoreservice.model.Score;
import com.pya.scoreservice.model.ScoreRepository;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SaveScoreServiceImplTest {

  @Mock
  private ScoreRepository scoreRepository;

  @InjectMocks
  private SaveScoreServiceImpl saveScoreService;

  @Test
  public void save() {
    String userId = UUID.randomUUID().toString();
    String storeId = UUID.randomUUID().toString();
    String saleId = UUID.randomUUID().toString();
    String comment = "Your food is awesome!";

    SaveScoreService.Request request = TestFixtures.createSaveRequest(
        userId, storeId, saleId, comment, Points.FIVE
    );

    Score saved = new Score(
        request.getUserIdentifier(),
        request.getSaleIdentifier(),
        request.getStoreIdentifier(),
        request.getComment(),
        request.getPoints());

    saved.setId("uniqueId");
    Mockito.when(scoreRepository.save(ArgumentMatchers.any(Score.class))).thenReturn(saved);

    Score actual = saveScoreService.save(request);

    assertThat(actual.getId()).isEqualTo("uniqueId");
    assertThat(actual.getUuid()).isNotEmpty();
    assertThat(actual.getUpdatedAt()).isNull();
    assertThat(actual.getComment()).isEqualTo(comment);
  }
}