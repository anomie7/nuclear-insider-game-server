package com.insider.game.web;

import java.util.List;

import com.insider.game.dto.MyScore;
import com.insider.game.dto.ScoreDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ScoreResponse {
	private MyScore myScore;
	private List<ScoreDto> top10Score;
}
