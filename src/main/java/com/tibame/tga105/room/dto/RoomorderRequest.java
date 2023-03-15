package com.tibame.tga105.room.dto;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

public class RoomorderRequest {

//	private Integer roomOrderId;

//	@NotNull
	private Integer memberId;
//	@NotNull
	private Integer roomTotalAmount;
//	@NotNull
	private Integer roomOrderStatus;
//	@NotNull
	private Integer totalOfPet;
//	@NotNull
	private Date roomCheckInDate;
//	@NotNull
	private Date roomCheckOutDate;
//	@NotNull
	private String payerName;
//	@NotNull
	private String payerPhone;
//	@NotNull
	private Integer orderStatus;

	private Integer roomTypeId;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getRoomTotalAmount() {
		return roomTotalAmount;
	}

	public void setRoomTotalAmount(Integer roomTotalAmount) {
		this.roomTotalAmount = roomTotalAmount;
	}

	public Integer getRoomOrderStatus() {
		return roomOrderStatus;
	}

	public void setRoomOrderStatus(Integer roomOrderStatus) {
		this.roomOrderStatus = roomOrderStatus;
	}

	public Integer getTotalOfPet() {
		return totalOfPet;
	}

	public void setTotalOfPet(Integer totalOfPet) {
		this.totalOfPet = totalOfPet;
	}

	public Date getRoomCheckInDate() {
		return roomCheckInDate;
	}

	public void setRoomCheckInDate(Date roomCheckInDate) {
		this.roomCheckInDate = roomCheckInDate;
	}

	public Date getRoomCheckOutDate() {
		return roomCheckOutDate;
	}

	public void setRoomCheckOutDate(Date roomCheckOutDate) {
		this.roomCheckOutDate = roomCheckOutDate;
	}

	public String getPayerName() {
		return payerName;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	public String getPayerPhone() {
		return payerPhone;
	}

	public void setPayerPhone(String payerPhone) {
		this.payerPhone = payerPhone;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

}
