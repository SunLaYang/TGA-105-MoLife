package com.tibame.tga105.donate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibame.tga105.donate.dao.PaymentDAO_interface;
import com.tibame.tga105.donate.dao.PaymentJDBCDAO;
import com.tibame.tga105.donate.model.PaymentVO;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDAO_interface dao;
	
	public PaymentService() {
		dao = new PaymentJDBCDAO();
	}

	// 1.會員中心-List會員捐款紀錄
	public List<PaymentVO> getMy(Integer memberId) {
		return dao.getMy(memberId);
	}

	// 2.後台-List所有會員捐款紀錄
	public List<PaymentVO> getAllPay() {
		return dao.getAllPay();
	}

	// 3.新增付款
	public PaymentVO addPayment(PaymentVO bean) {
		PaymentVO result = null;
		if (bean!=null) {
			result = dao.insert(bean);
		}
		return result;
	}

}
