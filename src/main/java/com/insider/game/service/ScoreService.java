package com.insider.game.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.insider.game.domain.Score;
import com.insider.game.dto.MyScore;
import com.insider.game.dto.ScoreDto;
import com.insider.game.repository.ScoreRepository;
import com.insider.game.web.ScoreResponse;

@Service
public class ScoreService {
	@Resource
	private ScoreRepository scoreRepository;

	public ScoreResponse findGameResult(ScoreDto myScore) {
		scoreRepository.save(Score.builder().answerNum(myScore.getAnswerNum()).nickName(myScore.getNickName()).build());
		List<Score> top10Score = scoreRepository.findTop10ByOrderByAnswerNumDesc();
		Integer myRank = scoreRepository.countByAnswerNumGreaterThan(myScore.getAnswerNum());
		List<ScoreDto> top10ScoreDto = top10Score.stream().map(ScoreDto::fromEntity).collect(Collectors.toList());
		MyScore MyScoreDto = MyScore.fromEntity(myScore, myRank);
		return ScoreResponse.builder().top10Score(top10ScoreDto).myScore(MyScoreDto).build();
	}
}
