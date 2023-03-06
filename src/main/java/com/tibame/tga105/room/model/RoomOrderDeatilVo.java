package com.tibame.tga105.room.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) //將null值過濾掉
@JsonIgnoreProperties(ignoreUnknown = true)//將多出來的key給忽略掉

public class RoomOrderDeatilVo {
	
	private Integer roomorderDetailId;
	private Integer roomTypeId;
	private Integer roomorderId;
	
	public Integer getRoomorderDetailId() {
		return roomorderDetailId;
	}
	public void setRoomorderDetailId(Integer roomorderDetailId) {
		this.roomorderDetailId = roomorderDetailId;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public Integer getRoomorderId() {
		return roomorderId;
	}
	public void setRoomorderId(Integer roomorderId) {
		this.roomorderId = roomorderId;
	}
	
}
