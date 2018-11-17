package com.insider.game.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Hint {
	@Id @GeneratedValue
	@Column(name="HINT_ID")
	private Long id;
	private String message;
	@ManyToOne
	@JoinColumn(name="QUIZ_ID")
	private Quiz quiz;
}
