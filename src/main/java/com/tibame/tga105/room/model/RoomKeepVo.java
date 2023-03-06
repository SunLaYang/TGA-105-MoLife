package com.tibame.tga105.room.model;

import java.io.Serializable;


import lombok.Data;

@Data
public class RoomKeepVo implements Serializable{
	
	
	private Integer roomKeepId;
	private String roomName;
	private Integer memberId;
	

}
