package com.insider.game.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class MyScore {
	private Integer myRank;
	private String myNickName;
	private Integer myAnswerNum;

	public static MyScore fromEntity(ScoreDto myScore, Integer myRank) {
		return MyScore.builder().myRank(myRank).myNickName(myScore.getNickName()).myAnswerNum(myScore.getAnswerNum())
				.build();
	}
}
