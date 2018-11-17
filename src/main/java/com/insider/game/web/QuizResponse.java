package com.insider.game.web;

import java.util.List;

import com.insider.game.dto.QuizDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizResponse {
	private List<QuizDto> quizs;
	@Builder.Default
	private boolean clear = false;
}
