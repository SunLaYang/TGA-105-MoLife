package com.tibame.tga105.room.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomkeepController {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@PostMapping("/favorites/{key}/{value}")

		public ResponseEntity<?> addFavorites(@PathVariable("key")String memberId,@PathVariable("value")String roomName){
		
		redisTemplate.opsForValue().set(memberId, roomName);
		
		return ResponseEntity.ok().build();
	}
	
	//===============================================
	
	@GetMapping("/favorites")
	public ResponseEntity<?> getFavorites(@RequestParam("memberId") String memberId){
		String key = "favorites" + memberId;
		Set<Object> favorites = redisTemplate.opsForSet().members(key);
		return ResponseEntity.ok(favorites);
	}
	
	@DeleteMapping("/favorites")
	public ResponseEntity<?> removeFavorites(@RequestParam("memberId") String memberId,
			@RequestParam("roomName") String roomName){
		String key = "favorites" + memberId;
		redisTemplate.opsForSet().add(key, roomName);
		return ResponseEntity.ok().build();
	}

}
