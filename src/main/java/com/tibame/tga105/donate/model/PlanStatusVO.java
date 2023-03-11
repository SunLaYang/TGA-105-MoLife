package com.tibame.tga105.donate.model;

public class PlanStatusVO {
	private Integer planStatusId;
	private String planStatus;
	private PaymentVO paymentVO;
	
	public void setPaymentVO(PaymentVO paymentVO) {
		this.paymentVO = paymentVO;
	}
	
	public PaymentVO getPaymentVO() {
		return paymentVO;
	}
	
	public Integer getPlanStatusId() {
		return planStatusId;
	}
	public void setPlanStatusId(Integer planStatusId) {
		this.planStatusId = planStatusId;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
	@Override
	public String toString() {
		return "PlanStatusVO [planStatusId=" + planStatusId + ", planStatus=" + planStatus + "]";
	}
	
}
