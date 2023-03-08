package com.tibame.tga105.room.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.tibame.tga105.room.dto.RoomderQueryParams;
import com.tibame.tga105.room.dto.RoomorderRequest;
import com.tibame.tga105.room.model.RoomorderVO;

public interface RoomorderDao {
	
	Integer countOrder(RoomderQueryParams roomderQueryParams);
	
	List<RoomorderVO> getRoomorders(RoomderQueryParams roomderQueryParams);
	
	RoomorderVO getRoomorderById(Integer roomOrderId);
	
//	List<RoomorderVO> getRoomorderByMemberId(Integer memberId);
	
	//創建訂單
	Integer createRoomorder(RoomorderRequest roomorderRequest);
	
	//同步進入訂單明細
	void createRoomOrderDetail(Integer roomOrderId,RoomorderRequest roomorderRequest);
	
	void updateRoomorder(Integer roomOrderId, RoomorderRequest roomorderRequest);
	
	//取消訂單專用
		void updateRoomorderForCancel(Integer roomOrderId, RoomorderRequest roomorderRequest);
		
	
	void deleteRoomOrder(Integer roomOrderId);
	
	//======================join============
	List<Map<String, Object>> getRoomorderPages(RoomorderVO roomorderVO);
	
	List<Map<String, Object>> getRoomorderByMemberId(RoomorderVO roomorderVO,Integer memberId);
	
	List<Map<String, Object>> getRoomorderDate(Integer roomTypeId,LocalDate beginDate,LocalDate lastDayOfMonth);

}
