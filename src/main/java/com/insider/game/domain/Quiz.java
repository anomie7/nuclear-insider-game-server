package com.insider.game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
public class Quiz {
	@Id
	@GeneratedValue
	@Column(name = "QUIZ_ID")
	private Long id;
	private String solution;
	private String imagePath;
	@Builder.Default
	private boolean delete = false;

	@OneToMany(cascade=CascadeType.ALL,mappedBy="quiz")
	@Builder.Default
	private List<Hint> hint = new ArrayList<>();

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CATEGORY_ID")
	private Category category;

	public void addHint(Hint hint) {
		if(this.hint != null && !this.hint.contains(hint) ) {
			this.hint.add(hint);
		}
	}

	public List<String> getHintMessage() {
		return this.hint.stream().map(obj -> obj.getMessage()).collect(Collectors.toList());
	}
}
