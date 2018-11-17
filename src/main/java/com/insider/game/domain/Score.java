package com.insider.game.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name="SCORE")
public class Score {
	@Id @GeneratedValue
	@Column(name="SCORE_ID")
	private Long id;
	private Integer answerNum;
	private String nickName;
}
