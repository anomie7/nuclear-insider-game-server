package com.insider.game.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.insider.game.domain.Score;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestScoreRepository {
	@Resource
	private ScoreRepository scoreRepository;
	
	@Before
	public void test() {
		for(int i = 0; i < 100; i++) {
			Score score = Score.builder().answerNum(i).nickName("지윤" + i).build();
			scoreRepository.save(score);
		}
	}
	
	@Test
	public void findScoreTop10() {
		 List<Score> res = scoreRepository.findTop10ByOrderByAnswerNumDesc();
		 assertEquals(10, res.size());
	}
	
//	@Test
//	public void findMyScore() {
//		Integer answerNum = 1;
//		Integer myScore = scoreRepository.countByAnswerNumGreaterThan(answerNum);
//		assertEquals(true, myScore.equals(98));
//	}

}
