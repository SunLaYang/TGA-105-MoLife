package com.tibame.tga105.room.service;

import java.util.List;

import com.tibame.tga105.room.dto.PetroomRequest;
import com.tibame.tga105.room.model.PetroomVo;

public interface PetroomService {
	
	List<PetroomVo> getPetrooms();
	
	PetroomVo getPetroomById(Integer roomTypeId);
	
	Integer createPetroom(PetroomRequest petroomRequest);
	
	void updatePetroom(Integer roomTypeId, PetroomRequest petroomRequest);
	
	
	
}
