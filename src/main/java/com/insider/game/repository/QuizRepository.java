package com.insider.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insider.game.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
	
	@Query(nativeQuery=true, value="SELECT * FROM QUIZ ORDER BY RAND() LIMIT 10")
	public List<Quiz> find10RandValue();
	
	@Query(nativeQuery=true, value="SELECT * FROM QUIZ WHERE QUIZ_ID <> ?1 ORDER BY RAND() LIMIT 1")
	public Quiz Find10RandValueBeforeNotSelected(Long selectedId);
	
	@Query(nativeQuery=true, value="SELECT * FROM QUIZ WHERE QUIZ_ID NOT IN (?1) ORDER BY RAND() LIMIT 10")
	public List<Quiz> findNotSelectedValue10Rand(List<Long> selectedIds);

}
