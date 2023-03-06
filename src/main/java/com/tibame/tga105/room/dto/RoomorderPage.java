package com.tibame.tga105.room.dto;

import java.sql.Date;

public class RoomorderPage {

  private Integer roomorderId;
  private String roomName;
  private Date room_checkin_date;
  private Date room_checkout_date;
  private Integer roomTotalAmount;
  private String roomComment;
  private Integer roomOrderStatus;
  
public Integer getRoomorderId() {
	return roomorderId;
}
public void setRoomorderId(Integer roomorderId) {
	this.roomorderId = roomorderId;
}
public String getRoomName() {
	return roomName;
}
public void setRoomName(String roomName) {
	this.roomName = roomName;
}
public Date getRoom_checkin_date() {
	return room_checkin_date;
}
public void setRoom_checkin_date(Date room_checkin_date) {
	this.room_checkin_date = room_checkin_date;
}
public Date getRoom_checkout_date() {
	return room_checkout_date;
}
public void setRoom_checkout_date(Date room_checkout_date) {
	this.room_checkout_date = room_checkout_date;
}
public Integer getRoomTotalAmount() {
	return roomTotalAmount;
}
public void setRoomTotalAmount(Integer roomTotalAmount) {
	this.roomTotalAmount = roomTotalAmount;
}
public String getRoomComment() {
	return roomComment;
}
public void setRoomComment(String roomComment) {
	this.roomComment = roomComment;
}
public Integer getRoomOrderStatus() {
	return roomOrderStatus;
}
public void setRoomOrderStatus(Integer roomOrderStatus) {
	this.roomOrderStatus = roomOrderStatus;
}
  
  
  
  
  
//  SELECT o.roomorder_id , r.room_name , o.room_checkin_date , o.room_checkout_date,o.room_total_amount,d.room_comment,o.room_order_status 
//  FROM roomorder o
//  JOIN room_order_detail d ON o.roomorder_id = d.roomorder_id
//  JOIN petroom r ON d.room_type_id = r.room_type_id
//  WHERE o.roomorder_id = ?;
  
	
	
}
