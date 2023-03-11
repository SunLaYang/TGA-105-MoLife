package com.tibame.tga105.others.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "post_info")
public class PostInfo {
	
    @Id
    @Column(name = "info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoId;
    
    @Column(name = "member_id")
    private Integer memberId;
    
    @Column(name = "admin_id")
    private Integer adminId;
    
    @Column(name = "info_type")
    private Integer infoType;
    
    @Column(name = "info_title")
    private String infoTitle;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "info_date")
    @LastModifiedDate
    private Date infoDate;
    
    @Column(name = "info_status")
    private Integer infoStatus;

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getInfoType() {
		return infoType;
	}

	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(Date infoDate) {
		this.infoDate = infoDate;
	}

	public Integer getInfoStatus() {
		return infoStatus;
	}

	public void setInfoStatus(Integer infoStatus) {
		this.infoStatus = infoStatus;
	}

	@Override
	public String toString() {
		return "PostInfo [infoId=" + infoId + ", memberId=" + memberId + ", adminId=" + adminId + ", infoType="
				+ infoType + ", infoTitle=" + infoTitle + ", content=" + content + ", infoDate=" + infoDate
				+ ", infoStatus=" + infoStatus + "]";
	}
    
}
