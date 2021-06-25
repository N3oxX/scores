package com.mtzperez.store.scores;

import com.mtzperez.store.scores.entity.Score;
import com.mtzperez.store.scores.repository.ScoreRepository;
import com.mtzperez.store.scores.service.ScoreServiceImpl;
import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceScoreApplicationTests {

	@InjectMocks
	ScoreServiceImpl scoreService;
	@Mock
	private  ScoreRepository scoreRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getScoresTest() {
		Score score = new Score();
		score.setStatus("done");
		score.setId(1L);
		Mockito.when(scoreRepository.save(Mockito.any(Score.class))).thenReturn(score);
		scoreService.createScore(score);
		Mockito.when(scoreRepository.findById(1L)).thenReturn(java.util.Optional.of(score));
		Score score2 = scoreService.getScore(1L);
	//	assertEquals(score.getStatus(), score2.getStatus());
	}
}
