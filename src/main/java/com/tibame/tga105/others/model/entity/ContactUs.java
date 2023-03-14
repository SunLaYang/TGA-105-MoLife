package com.tibame.tga105.others.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.LastModifiedDate;

import com.tibame.tga105.mem.model.MemVO;

@Entity
@Table(name = "contact_us")
public class ContactUs {
	
    @Id
    @Column(name = "msg_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer msgId;
    
    @Column(name = "member_id")
    private Integer memberId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "chat_title")
    private String chatTitle;
    
    @Column(name = "chat_content")
    private String chatContent;
    
    @Column(name = "reply_status")
    private Integer replyStatus;
    
    @Column(name = "createtime")
    @LastModifiedDate
    private Date createTime;
    
    @Column(name = "response")
    private String response;

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChatTitle() {
		return chatTitle;
	}

	public void setChatTitle(String chatTitle) {
		this.chatTitle = chatTitle;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public Integer getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(Integer replyStatus) {
		this.replyStatus = replyStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ContactUs [msgId=" + msgId + ", memberId=" + memberId + ", name=" + name + ", email=" + email
				+ ", chatTitle=" + chatTitle + ", chatContent=" + chatContent + ", replyStatus=" + replyStatus
				+ ", createTime=" + createTime + ", response=" + response + "]";
	}
    
    
}
