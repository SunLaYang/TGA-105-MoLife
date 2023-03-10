package com.tibame.tga105.donate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tibame.tga105.donate.model.PaymentVO;
import com.tibame.tga105.donate.model.PlanStatusVO;
import com.tibame.tga105.donate.model.PlanVO;

@Repository
public class PaymentJDBCDAO implements PaymentDAO_interface {
	@Autowired
	private DataSource ds;

	// 1.會員中心-List會員捐款紀錄
	private static final String GET_MYPAY_STMT = 
			"SELECT PY.payment_date, PY.payment_id, plan_name, PY.plan_id, plan_status, PY.payment_amount\r\n"
			+ "FROM( \r\n"
			+ "	 (payment AS PY\r\n"
			+ "	 INNER JOIN plan AS P\r\n"
			+ "	 ON PY.plan_id = P.plan_id\r\n"
			+ "	 )\r\n"
			+ "INNER JOIN plan_status AS PS\r\n"
			+ "ON PY.plan_status_id = PS.plan_status_id\r\n"
			+ ")\r\n"
			+ "WHERE PY.member_id=?\r\n"
			+ "GROUP BY payment_id\r\n"
			+ "ORDER BY payment_date DESC;";

	@Override
	public List<PaymentVO> getMy(Integer memberId) {
		List<PaymentVO> list = null;
		
		if (memberId != null) {
			ResultSet rs = null;
			try (
				Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(GET_MYPAY_STMT);) {
				
				pstmt.setInt(1, memberId);
				rs = pstmt.executeQuery();
				list = new ArrayList<PaymentVO>();
				while (rs.next()) {
					PaymentVO paymentVO = new PaymentVO();
					paymentVO.setPaymentDate(rs.getTimestamp("payment_date"));
					paymentVO.setPaymentId(rs.getInt("payment_id"));
					paymentVO.setPlanId(rs.getInt("plan_id"));
					paymentVO.setPaymentAmount(rs.getInt("payment_amount"));
					
					//planVO-計畫名稱
					PlanVO planVO = new PlanVO();
					planVO.setPlanName(rs.getString("plan_name"));
					
					//planStatusVO-計畫進度
					PlanStatusVO planStatusVO = new PlanStatusVO();
					planStatusVO.setPlanStatus(rs.getString("plan_status"));
					
					paymentVO.setPlanVO(planVO);
					paymentVO.setPlanStatusVO(planStatusVO);
					
					list.add(paymentVO);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	// 2.後台-List所有會員捐款紀錄
	private static final String GET_ALLPLAN_STMT = 
			"SELECT PY.payment_date, plan_name, PY.plan_id, plan_status, PY.member_id, PY.payment_id, PY.payment_amount\r\n"
			+ "FROM ( \r\n"
			+ "		(payment AS PY \r\n"
			+ "		INNER JOIN plan AS P\r\n"
			+ "        ON PY.plan_id = P.plan_id\r\n"
			+ "		)\r\n"
			+ "INNER JOIN plan_status AS PS\r\n"
			+ "ON PY.plan_status_id = PS.plan_status_id \r\n"
			+ "	)\r\n"
			+ "ORDER BY payment_date DESC;";

	@Override
	public List<PaymentVO> getAllPay() {
		List<PaymentVO> list = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALLPLAN_STMT);) {
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<PaymentVO>();

			while (rs.next()) {
				PaymentVO paymentVO = new PaymentVO();
				paymentVO.setPaymentDate(rs.getTimestamp("payment_date"));
				paymentVO.setPlanId(rs.getInt("plan_id"));
				paymentVO.setMemeberId(rs.getInt("member_id"));
				paymentVO.setPaymentId(rs.getInt("payment_id"));
				paymentVO.setPaymentAmount(rs.getInt("payment_amount"));
				
				//planVO-計畫名稱
				PlanVO planVO = new PlanVO();
				planVO.setPlanName(rs.getString("plan_name"));
				
				//planStatusVO-計畫進度
				PlanStatusVO planStatusVO = new PlanStatusVO();
				planStatusVO.setPlanStatus(rs.getString("plan_status"));
				
				paymentVO.setPlanVO(planVO);
				paymentVO.setPlanStatusVO(planStatusVO);
				
				list.add(paymentVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 3.新增付款
	private static final String INSERT_STMT = "INSERT INTO payment (plan_id, member_id, plan_status_id, payment_date, payment_amount) VALUES (?, ?, ?, ?, ?);";

	@Override
	public PaymentVO insert(PaymentVO bean) {
		PaymentVO result = null;
		if (bean != null) {
			try (
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);)  {

				pstmt.setInt(1, bean.getPlanId());
				pstmt.setInt(2, bean.getMemeberId());
				pstmt.setInt(3, bean.getPlanStatusId());
				pstmt.setTimestamp(4, bean.getPaymentDate());
				pstmt.setInt(5, bean.getPaymentAmount());

				int i = pstmt.executeUpdate();
				if (i==1) {
					result = bean;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

}
