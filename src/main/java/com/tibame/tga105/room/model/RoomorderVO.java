package com.tibame.tga105.room.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // 將null值過濾掉
@JsonIgnoreProperties(ignoreUnknown = true) // 將多出來的key給忽略掉
@Entity
@Table(name = "roomorder")
public class RoomorderVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roomorder_id")
	private Integer roomOrderId;
	@Column(name = "member_id")
	private Integer memberId;
	@Column(name = "room_total_amount")
	private Integer roomTotalAmount;
	@Column(name = "room_order_status")
	private Integer roomOrderStatus;
	@Column(name = "total_of_pet")
	private Integer totalOfPet;
	@Column(name = "room_checkin_date")
	private Date roomCheckInDate;
	@Column(name = "room_checkout_date")
	private Date roomCheckOutDate;
	@Column(name = "payer_name")
	private String payerName;
	@Column(name = "payer_phone")
	private String payerPhone;
	@Column(name = "room_check_date")
	private Timestamp roomCheckDate;
	@Column(name = "order_status")
	private Integer orderStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	private PetroomVo petRoom;

	// join用
	private String roomName;
	@Column(name = "room_type_id_join")
	private Integer roomTypeId;

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public Integer getRoomOrderId() {
		return roomOrderId;
	}

	public void setRoomOrderId(Integer roomOrderId) {
		this.roomOrderId = roomOrderId;
	}

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

	public Timestamp getRoomCheckDate() {
		return roomCheckDate;
	}

	public void setRoomCheckDate(Timestamp roomCheckDate) {
		this.roomCheckDate = roomCheckDate;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

}
