package com.insider.game.web;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insider.game.dto.ScoreDto;
import com.insider.game.service.ScoreService;

@RestController
public class ScoreController {
	@Resource
	private ScoreService scoreService;
	
	@PostMapping("/Score")
	public ResponseEntity<ScoreResponse> getGameResult(@RequestBody ScoreDto myScore){
		ScoreResponse body = scoreService.findGameResult(myScore);
		return ResponseEntity.ok().body(body);
	}
}
