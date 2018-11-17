package com.insider.game.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.insider.game.domain.Quiz;
import com.insider.game.dto.QuizDto;
import com.insider.game.repository.QuizRepository;

@Service
public class QuizService {
	@Resource
	private QuizRepository quizRepository;

	public List<QuizDto> findRandomQuizLimit10(List<Long> selectedIds) {
		List<Quiz> quizs;
		if (selectedIds == null) {
			quizs = quizRepository.find10RandValue();
		} else {
			quizs = quizRepository.findNotSelectedValue10Rand(selectedIds);
		}

		List<QuizDto> res = quizs.stream().map(QuizDto::fromEntity).collect(Collectors.toList());
		return res;
	}
}
