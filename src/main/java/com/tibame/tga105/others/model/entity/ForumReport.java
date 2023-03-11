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
@Table(name = "forum_article_report")
public class ForumReport {
	
    @Id
    @Column(name = "forum_article_report_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forumArticleReportNo;
    
    @Column(name = "admin_id")
    private Integer adminId;
    
    @Column(name = "forum_article_no")
    private Integer forumArticleNo;
    
    @Column(name = "member_id")
    private Integer memberId;
    
    @Column(name = "forum_title")
    private String forumTitle;
    
    @Column(name = "forum_content")
    private String forumContent;
    
    @Column(name = "forum_article_report_reason_no")
    private Integer forumArticleReportReasonNo;
    
    @Column(name = "forum_article_report_time")
    @LastModifiedDate
    private Date forumArticleReportTime;
    
    @Column(name = "forum_article_report_status")
    private Integer forumArticleReportStatus;
    
    @Column(name = "forum_article_status")
    private Integer forumArticleStatus;

	public Integer getForumArticleReportNo() {
		return forumArticleReportNo;
	}

	public void setForumArticleReportNo(Integer forumArticleReportNo) {
		this.forumArticleReportNo = forumArticleReportNo;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getForumArticleNo() {
		return forumArticleNo;
	}

	public void setForumArticleNo(Integer forumArticleNo) {
		this.forumArticleNo = forumArticleNo;
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

	public Integer getForumArticleReportReasonNo() {
		return forumArticleReportReasonNo;
	}

	public void setForumArticleReportReasonNo(Integer forumArticleReportReasonNo) {
		this.forumArticleReportReasonNo = forumArticleReportReasonNo;
	}

	public Date getForumArticleReportTime() {
		return forumArticleReportTime;
	}

	public void setForumArticleReportTime(Date forumArticleReportTime) {
		this.forumArticleReportTime = forumArticleReportTime;
	}

	public Integer getForumArticleReportStatus() {
		return forumArticleReportStatus;
	}

	public void setForumArticleReportStatus(Integer forumArticleReportStatus) {
		this.forumArticleReportStatus = forumArticleReportStatus;
	}

	public Integer getForumArticleStatus() {
		return forumArticleStatus;
	}

	public void setForumArticleStatus(Integer forumArticleStatus) {
		this.forumArticleStatus = forumArticleStatus;
	}

	@Override
	public String toString() {
		return "ForumReport [forumArticleReportNo=" + forumArticleReportNo + ", adminId=" + adminId
				+ ", forumArticleNo=" + forumArticleNo + ", memberId=" + memberId + ", forumTitle=" + forumTitle
				+ ", forumContent=" + forumContent + ", forumArticleReportReasonNo=" + forumArticleReportReasonNo
				+ ", forumArticleReportTime=" + forumArticleReportTime + ", forumArticleReportStatus="
				+ forumArticleReportStatus + ", forumArticleStatus=" + forumArticleStatus + "]";
	}

}
