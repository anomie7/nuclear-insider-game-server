package com.insider.game.repository;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.insider.game.domain.Category;
import com.insider.game.domain.Hint;
import com.insider.game.domain.Quiz;
import com.insider.game.repository.QuizRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestQuizRepository {
	@Resource
	private QuizRepository quizRepository;

	@Before
	public void objGenerate() {
		Hint hint = Hint.builder().message("침몰").build();
		Hint hint2 = Hint.builder().message("마차씬").build();
		Hint hint3 = Hint.builder().message("셀린디온").build();
		Category category = Category.builder().name("영화").build();
		Category category2 = Category.builder().name("노래").build();
		Quiz quiz = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz2 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category2).build();
		Quiz quiz3 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz4 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category2).build();
		Quiz quiz5 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz6 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category2).build();
		Quiz quiz7 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz8 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category2).build();
		Quiz quiz9 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz10 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz11 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz12 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz13 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz14 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz15 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz16 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz17 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		Quiz quiz18 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category2).build();
		Quiz quiz19 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category2).build();
		Quiz quiz20 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category2).build();
		Quiz quiz21 = Quiz.builder().imagePath("imagePath/emoji.jpg").solution("타이타닉").category(category).build();
		quiz.addHint(hint);
		quiz.addHint(hint2);
		quiz.addHint(hint3);
		quizRepository.save(quiz);
		quizRepository.save(quiz2);
		quizRepository.save(quiz3);
		quizRepository.save(quiz4);
		quizRepository.save(quiz5);
		quizRepository.save(quiz6);
		quizRepository.save(quiz7);
		quizRepository.save(quiz8);
		quizRepository.save(quiz9);
		quizRepository.save(quiz10);
		quizRepository.save(quiz11);
		quizRepository.save(quiz12);
		quizRepository.save(quiz13);
		quizRepository.save(quiz14);
		quizRepository.save(quiz15);
		quizRepository.save(quiz16);
		quizRepository.save(quiz17);
		quizRepository.save(quiz18);
		quizRepository.save(quiz19);
		quizRepository.save(quiz20);
		quizRepository.save(quiz21);
	}
	
	@Test
	public void testFind10RandValue() {
		List<Quiz> quizs = quizRepository.find10RandValue();
		assertEquals(10, quizs.size());
	}
	
	@Test
	public void testFind10RandValueBeforeNotSelected() {
		Long selectedId = 1L;
		Quiz unselectedQuiz = quizRepository.Find10RandValueBeforeNotSelected(selectedId);
		assertEquals(false, unselectedQuiz.getId().equals(selectedId));
	}
	
	@Test
	public void testFindNotSelectedValue10Rand() {
		Long[] ids = {11L, 21L, 30L, 2L, 5L, 9L, 8L, 22L, 7L, 1L};
		List<Long> selectedIds = Arrays.asList(ids);
		List<Quiz> unSelectedQuizs = quizRepository.findNotSelectedValue10Rand(selectedIds);
		unSelectedQuizs.stream().forEach(quiz -> {
			assertEquals(true, selectedIds.stream().noneMatch(id -> id.equals(quiz.getId())));
		});
	}
}
