package com.tibame.tga105.others.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forum_document")
public class Forum {
	
    @Id
    @Column(name = "forum_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forumNo;
    
    @Column(name = "member_id")
    private Integer memberId;
    
    @Column(name = "forum_title")
    private String forumTitle;
    
    @Column(name = "forum_content")
    private String forumContent;
    
    @Column(name = "forum_createtime")
    private Date forumCreateTime;
    
    @Column(name = "forum_status")
    private Integer forumStatus;

	public Integer getForumNo() {
		return forumNo;
	}

	public void setForumNo(Integer forumNo) {
		this.forumNo = forumNo;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}

	public Date getForumCreateTime() {
		return forumCreateTime;
	}

	public void setForumCreateTime(Date forumCreateTime) {
		this.forumCreateTime = forumCreateTime;
	}

	public Integer getForumStatus() {
		return forumStatus;
	}

	public void setForumStatus(Integer forumStatus) {
		this.forumStatus = forumStatus;
	}

	@Override
	public String toString() {
		return "Forum [forumNo=" + forumNo + ", memberId=" + memberId + ", forumTitle=" + forumTitle + ", forumContent="
				+ forumContent + ", forumCreateTime=" + forumCreateTime + ", forumStatus=" + forumStatus + "]";
	}
    
}
