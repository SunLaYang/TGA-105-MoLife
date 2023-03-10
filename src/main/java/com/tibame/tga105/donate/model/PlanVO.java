package com.tibame.tga105.donate.model;

import java.sql.Date;
import java.util.Arrays;

public class PlanVO {
	private Integer planId;
	private String planName;
	private Integer planStatusId;
	private String planStatusComment;
	private Integer memberId;
	private Date proposalDate;
	private Integer donateDays;
	private Integer donateGoal;
	private String address;
	private String reason;
	private byte[] animalPhoto;
	private String animalVideoLink;
	private Date donateStartDate;
	private Date donateEndDate;
	private Integer animalTypeId;
	private Integer donateAmount;
	private PlanStatusVO planStatusVO;
	private PaymentVO paymentVO;
	private AnimalTypeVO animalTypeVO;


	public AnimalTypeVO getAnimalTypeVO() {
		return animalTypeVO;
	}

	public void setAnimalTypeVO(AnimalTypeVO animalTypeVO) {
		this.animalTypeVO = animalTypeVO;
	}

	public void setPlanStatusVO(PlanStatusVO planStatusVO) {
		this.planStatusVO = planStatusVO;
	}

	public PlanStatusVO getPlanStatusVO() {
		return planStatusVO;
	}
	
	public void setPaymentVO(PaymentVO paymentVO) {
		this.paymentVO = paymentVO;
	}
	
	public PaymentVO getPaymentVO() {
		return paymentVO;
	}
	
	
	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Integer getPlanStatusId() {
		return planStatusId;
	}

	public void setPlanStatusId(Integer planStatusId) {
		this.planStatusId = planStatusId;
	}

	public String getPlanStatusComment() {
		return planStatusComment;
	}

	public void setPlanStatusComment(String planStatusComment) {
		this.planStatusComment = planStatusComment;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Date getProposalDate() {
		return proposalDate;
	}

	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}

	public Integer getDonateDays() {
		return donateDays;
	}

	public void setDonateDays(Integer donateDays) {
		this.donateDays = donateDays;
	}

	public Integer getDonateGoal() {
		return donateGoal;
	}

	public void setDonateGoal(Integer donateGoal) {
		this.donateGoal = donateGoal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public byte[] getAnimalPhoto() {
		return animalPhoto;
	}

	public void setAnimalPhoto(byte[] animalPhoto) {
		this.animalPhoto = animalPhoto;
	}

	public String getAnimalVideoLink() {
		return animalVideoLink;
	}

	public void setAnimalVideoLink(String animalVideoLink) {
		this.animalVideoLink = animalVideoLink;
	}

	public Date getDonateStartDate() {
		return donateStartDate;
	}

	public void setDonateStartDate(Date donateStartDate) {
		this.donateStartDate = donateStartDate;
	}

	public Date getDonateEndDate() {
		return donateEndDate;
	}

	public void setDonateEndDate(Date donateEndDate) {
		this.donateEndDate = donateEndDate;
	}

	public Integer getAnimalTypeId() {
		return animalTypeId;
	}

	public void setAnimalTypeId(Integer animalTypeId) {
		this.animalTypeId = animalTypeId;
	}
	
	public Integer getDonateAmount() {
		return donateAmount;
	}

	public void setDonateAmount(Integer donateAmount) {
		this.donateAmount = donateAmount;
	}

	@Override
	public String toString() {
		return "PlanVO [planId=" + planId + ", planName=" + planName + ", planStatusId=" + planStatusId
				+ ", planStatusComment=" + planStatusComment + ", memberId=" + memberId + ", proposalDate="
				+ proposalDate + ", donateDays=" + donateDays + ", donateGoal=" + donateGoal + ", address=" + address
				+ ", reason=" + reason + ", animalPhoto=" + Arrays.toString(animalPhoto) + ", animalVideoLink="
				+ animalVideoLink + ", donateStartDate=" + donateStartDate + ", donateEndDate=" + donateEndDate
				+ ", animalTypeId=" + animalTypeId + ", planStatusVO=" + planStatusVO + ", paymentVO=" + paymentVO
				+ ", donateAmount=" + donateAmount + "]";
	}
	
	

//	private PlanStatusVO xxx;
//	public static void main(String[] args) throws SQLException {
//		try (ResultSet rs = null) {
//			while (rs.next()) {
//				PlanVO vo = new PlanVO();
////				vo.setAddress(X);			
	
//	PlanStatusVO a = new PlanStatusVO();
//				a.setPlanStatus(null);
//				
//				vo.setXxx(a);
//				
//				a.get
//			}
//		}
//	}


}
