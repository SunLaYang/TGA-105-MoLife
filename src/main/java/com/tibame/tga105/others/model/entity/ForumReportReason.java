package com.tibame.tga105.others.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forum_article_report_reason")
public class ForumReportReason {
	
    @Id
    @Column(name = "forum_article_report_reason_no")
    private Integer forumArticleReportReasonNo;
    
    @Column(name = "forum_article_report_reason_contain")
    private String forumArticleReportReasonContain;

	public Integer getForumArticleReportReasonNo() {
		return forumArticleReportReasonNo;
	}

	public void setForumArticleReportReasonNo(Integer forumArticleReportReasonNo) {
		this.forumArticleReportReasonNo = forumArticleReportReasonNo;
	}

	public String getForumArticleReportReasonContain() {
		return forumArticleReportReasonContain;
	}

	public void setForumArticleReportReasonContain(String forumArticleReportReasonContain) {
		this.forumArticleReportReasonContain = forumArticleReportReasonContain;
	}

	@Override
	public String toString() {
		return "ForumReportReason [forumArticleReportReasonNo=" + forumArticleReportReasonNo
				+ ", forumArticleReportReasonContain=" + forumArticleReportReasonContain + "]";
	}
    
}
