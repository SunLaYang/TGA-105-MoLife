package com.tibame.tga105.room.dao;

import java.util.List;

import com.tibame.tga105.room.model.RoomOrderDeatilVo;

public interface RoomOrderDeatilDao {

	List<RoomOrderDeatilVo> getOrderDeatils();
	
//	RoomOrderDeatilVo getOrderDetailsByMemID(Integer memberId);
	
}
