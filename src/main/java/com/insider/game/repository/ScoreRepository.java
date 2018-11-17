package com.insider.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insider.game.domain.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
	public List<Score> findTop10ByOrderByAnswerNumDesc();

	public Integer countByAnswerNumGreaterThan(Integer answerNum);
}
