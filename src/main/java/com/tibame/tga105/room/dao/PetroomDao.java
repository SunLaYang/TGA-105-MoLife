package com.tibame.tga105.room.dao;

import java.util.List;

import com.tibame.tga105.room.dto.PetroomRequest;
import com.tibame.tga105.room.model.PetroomVo;

public interface PetroomDao {
	
	List<PetroomVo> getPetrooms();
	
	PetroomVo getPetroomById(Integer roomTypeId);
	
	PetroomVo getPetroomByName(String roomName);
	
	Integer createPetroom(PetroomRequest petroomRequest);
	
	void updatePetroom(Integer roomTypeId, PetroomRequest petroomRequest);


}
