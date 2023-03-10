package com.tibame.tga105.donate.model;

import java.sql.Date;
import java.util.Arrays;

public class PlanUpdateVO {
	
	private Integer updateId;
	private Integer planId;
	private Date updateDate;
	private String updateText;
	private byte[] updatePhoto;
	
	public Integer getUpdateId() {
		return updateId;
	}
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateText() {
		return updateText;
	}
	public void setUpdateText(String updateText) {
		this.updateText = updateText;
	}
	public byte[] getUpdatePhoto() {
		return updatePhoto;
	}
	public void setUpdatePhoto(byte[] updatePhoto) {
		this.updatePhoto = updatePhoto;
	}
	
	@Override
	public String toString() {
		return "PlanUpdateVO [updateId=" + updateId + ", planId=" + planId + ", updateDate=" + updateDate
				+ ", updateText=" + updateText + ", updatePhoto=" + Arrays.toString(updatePhoto) + "]";
	}
	
	
}
