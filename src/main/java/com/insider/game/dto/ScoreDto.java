package com.insider.game.dto;

import com.insider.game.domain.Score;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ScoreDto {
	private Integer answerNum;
	private String nickName;
	
	public static ScoreDto fromEntity(Score score) {
		return ScoreDto.builder().answerNum(score.getAnswerNum()).nickName(score.getNickName()).build();
	}
}
