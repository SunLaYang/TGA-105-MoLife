package com.tibame.tga105.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga105.room.model.RoomOrderDeatilVo;
import com.tibame.tga105.room.service.RoomOrderDeatilService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoomOrderDeatlController {
	
	@Autowired
	private RoomOrderDeatilService roomOrderDeatilService;
	
	//============查詢訂單明細=============
	@GetMapping("/orderDeatils")
	public ResponseEntity<List<RoomOrderDeatilVo>> getOrdersDetail(){
		
		List<RoomOrderDeatilVo> roomOrderDeatilList = roomOrderDeatilService.getOrderDeatils();
		return ResponseEntity.status(HttpStatus.OK).body(roomOrderDeatilList);
		
	} 


}
