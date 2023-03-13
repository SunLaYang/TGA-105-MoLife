package com.tibame.tga105.donate.dao;

import java.util.List;

import com.tibame.tga105.donate.model.PaymentVO;

public interface PaymentDAO_interface {

	// 1.會員中心-List會員捐款紀錄
	public List<PaymentVO> getMy(Integer memberId);

	// 2.後台-List所有會員捐款紀錄
	public List<PaymentVO> getAllPay();

	// 3.新增付款
	public PaymentVO insert(PaymentVO paymentVO);
	
	// 4.捐款成功頁面
	public List<PaymentVO> successPage(Integer memberId);
	
}
