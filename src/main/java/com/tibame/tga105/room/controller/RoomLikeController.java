package com.tibame.tga105.room.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga105.room.dao.RoomLikeRepository;

@RestController
public class RoomLikeController {
	
	  	@Autowired
	    private RoomLikeRepository roomLikeRepo;
	    
	  	//按讚
	    @GetMapping("/room/like")
	    public ResponseEntity<String> likeRoom(@RequestParam("memberId") String memberId, 
	                                           @RequestParam("roomName") String roomName) {
	        boolean success = roomLikeRepo.likeRoom(memberId, roomName);
	        if (success) {
	            long count = roomLikeRepo.getRoomLikeCount(roomName);
	            return ResponseEntity.ok(String.format("%d", count));
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                                 .body("會員已經按過讚了!");
	        }
	    }
	    
	    //查讚數
	    @GetMapping("/room/like/count")
	    public long getRoomLikeCount(@RequestParam("roomName") String roomName) {
	        return roomLikeRepo.getRoomLikeCount(roomName);
	    }
	    
	    //取消按讚
	    @DeleteMapping("/room/like")
	    public ResponseEntity<String> deleteLikedRoom(@RequestParam("memberId") String memberId,
	                                                   @RequestParam("roomName") String roomName) {
	        boolean success = roomLikeRepo.deleteLikedRoom(memberId, roomName);
	        if (success) {
	            long count = roomLikeRepo.getRoomLikeCount(roomName);
	            return ResponseEntity.ok(String.format("%d", count));
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                                 .body("尚未按讚!");
	        }
	    }
	    
	}