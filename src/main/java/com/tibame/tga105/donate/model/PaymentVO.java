package com.tibame.tga105.donate.model;

import java.sql.Timestamp;

public class PaymentVO {
	private Integer paymentId;
	private Integer planId;
	private Integer memeberId;
	private Timestamp paymentDate;
	private Integer paymentAmount;
	private PlanVO planVO;
	private PlanStatusVO planStatusVO;
	
	
	public void setPlanVO(PlanVO planVO) {
		this.planVO = planVO;
	}
	
	public PlanVO getPlanVO() {
		return planVO;
	}

	public void setPlanStatusVO(PlanStatusVO planStatusVO) {
		this.planStatusVO = planStatusVO;
	}
	
	public PlanStatusVO getPlanStatusVO() {
		return planStatusVO;
	}

	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public Integer getMemeberId() {
		return memeberId;
	}
	public void setMemeberId(Integer memeberId) {
		this.memeberId = memeberId;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Integer getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Integer paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	@Override
	public String toString() {
		return "PaymentVO [paymentId=" + paymentId + ", planId=" + planId + ", memeberId=" + memeberId
				+", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount
				+ "]";
	}
	
}
