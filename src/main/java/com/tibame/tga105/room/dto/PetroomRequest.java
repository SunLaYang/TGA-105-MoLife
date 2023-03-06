package com.tibame.tga105.room.dto;


public class PetroomRequest {
	
//	@NotBlank
	private String roomName;
//	@NotBlank
	private String roomDescription;
//	@NotNull
	private Integer petNumber;
//	@NotNull
	private Integer roomStatus;
//	@NotNull
	private Integer roomPrice;
	
	private byte[] image1;
	
	private byte[] image2;
	
	private byte[] image3;
	
	private String roomPic1;
	
	private String roomPic2;
	
	private String roomPic3;
	
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	public Integer getPetNumber() {
		return petNumber;
	}
	public void setPetNumber(Integer petNumber) {
		this.petNumber = petNumber;
	}
	public Integer getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(Integer roomStatus) {
		this.roomStatus = roomStatus;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public byte[] getImage1() {
		return image1;
	}
	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}
	public byte[] getImage2() {
		return image2;
	}
	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}
	public byte[] getImage3() {
		return image3;
	}
	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}
	public String getRoomPic1() {
		return roomPic1;
	}
	public void setRoomPic1(String roomPic1) {
		this.roomPic1 = roomPic1;
	}
	public String getRoomPic2() {
		return roomPic2;
	}
	public void setRoomPic2(String roomPic2) {
		this.roomPic2 = roomPic2;
	}
	public String getRoomPic3() {
		return roomPic3;
	}
	public void setRoomPic3(String roomPic3) {
		this.roomPic3 = roomPic3;
	}
	
	

}
