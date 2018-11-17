package com.insider.game.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insider.game.dto.QuizDto;
import com.insider.game.service.QuizService;

@RestController
public class QuizController {
	@Resource
	private QuizService quizService;
	
	@GetMapping("/quiz")
	public ResponseEntity<List<QuizDto>> getQuiz(@RequestParam(required=false) List<Long> selectedIds){
		List<QuizDto> body = quizService.findRandomQuizLimit10(selectedIds);
		if(body.isEmpty()) {
			return ResponseEntity.ok().body(null);
		}
		return ResponseEntity.ok().body(body);
	}
}
