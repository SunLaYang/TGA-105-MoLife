package com.tibame.tga105.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tibame.tga105.room.dao.RoomOrderDeatilDao;
import com.tibame.tga105.room.model.RoomOrderDeatilVo;

@Component
public class RoomOrderDeatilServiceImpl implements RoomOrderDeatilService{
	
	@Autowired
	private RoomOrderDeatilDao roomOrderDeatlDao;

	@Override
	public List<RoomOrderDeatilVo> getOrderDeatils() {
		return roomOrderDeatlDao.getOrderDeatils();
	}	

	
}
