package com.insider.game.service;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.insider.game.domain.Score;
import com.insider.game.dto.ScoreDto;
import com.insider.game.repository.ScoreRepository;
import com.insider.game.web.ScoreResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestScoreService {
	@Resource
	private ScoreService scoreService;
	@Resource
	private ScoreRepository scoreRepository;

	@Before
	public void generateObj() {
		for (int i = 0; i < 100; i++) {
			Score score = Score.builder().answerNum(i).nickName("지윤" + i).build();
			scoreRepository.save(score);
		}
	}

	@Test
	public void test() {
		ScoreDto myScore = ScoreDto.builder().answerNum(50).nickName("성진").build();
		ScoreResponse scoreResponse = scoreService.findGameResult(myScore);
		assertEquals(true, scoreResponse.getMyScore().getMyRank().equals(49));
		assertEquals(10, scoreResponse.getTop10Score().size());
	}

}
