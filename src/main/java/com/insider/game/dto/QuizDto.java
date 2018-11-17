package com.insider.game.dto;

import java.util.List;

import com.insider.game.domain.Quiz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
public class QuizDto {
	private Long id;
	private String solution;
	private String imagePath;
	private List<String> hints;
	private String category;
	
	public static QuizDto fromEntity(Quiz quiz) {
		return QuizDto.builder().id(quiz.getId()).solution(quiz.getSolution()).imagePath(quiz.getImagePath())
				.hints(quiz.getHintMessage()).category(quiz.getCategory().getName()).build();
	}
}
