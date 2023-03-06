package com.tibame.tga105.room.service;

import java.util.List;
import java.util.Map;

import com.tibame.tga105.room.dto.RoomderQueryParams;
import com.tibame.tga105.room.dto.RoomorderRequest;
import com.tibame.tga105.room.model.RoomorderVO;

public interface RoomorderService {
	
	Integer countOrder(RoomderQueryParams roomderQueryParams);
	
	List<RoomorderVO> getRoomorders(RoomderQueryParams roomderQueryParams);
	
	RoomorderVO getRoomorderById(Integer roomOrderId);
	
//	List<RoomorderVO> getRoomorderByMemberId(Integer memberId);
	
	Integer createRoomorder(RoomorderRequest roomorderRequest);
	
	void updateRoomorder(Integer roomOrderId, RoomorderRequest roomorderRequest);
	
	void deleteRoomOrder(Integer roomOrderId);
	
	//=============================
	List<Map<String, Object>> getRoomorderPages(RoomorderVO roomorderVO);
	
	List<Map<String, Object>> getRoomorderByMemberId(RoomorderVO roomorderVO, Integer memberId);
	
	List<Map<String, Object>> getRoomorderDate(Integer roomTypeId);
	
	


}
