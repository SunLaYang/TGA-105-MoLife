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
public class PlanStatusJDBCDAO implements PlanStatusDAO_interface {
	@Autowired
	private DataSource ds;

	// admin-查詢某個進度狀態的計畫 donatePlanResultAdmin.jsp
	private static final String GET_Plan_ByStatusId_STMT =
			"select P.proposal_date, P.plan_name, P.plan_id, P.member_id, P.plan_status_id, P.plan_status_comment, plan_status\r\n"
			+ "FROM plan AS P\r\n"
			+ "INNER JOIN plan_status AS PS\r\n"
			+ "ON P.plan_status_id = PS.plan_status_id\r\n"
			+ "WHERE P.plan_status_id=?\r\n"
			+ "order by proposal_date DESC;";
	@Override
	public List<PlanVO> getPlanByStatusId(Integer planStatusId) {
		List<PlanVO> list = null;
		PlanVO planVO = null;
		PlanStatusVO planStatusVO = null;

		try (
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_Plan_ByStatusId_STMT);) {

			pstmt.setInt(1, planStatusId);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<PlanVO>();
			while (rs.next()) {
				planVO = new PlanVO();
				planVO.setProposalDate(rs.getDate("proposal_date"));
				planVO.setPlanName(rs.getString("plan_name"));
				planVO.setPlanId(rs.getInt("plan_id"));
				planVO.setMemberId(rs.getInt("member_id"));
				planVO.setPlanStatusId(rs.getInt("plan_status_id"));
				planVO.setPlanStatusComment(rs.getString("plan_status_comment"));

				planStatusVO = new PlanStatusVO();
				planStatusVO.setPlanStatus(rs.getString("plan_status"));
				
				planVO.setPlanStatusVO(planStatusVO);
				
				list.add(planVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	// admin-查詢某個進度狀態的捐款 donatePayResultAdmin.jsp
	private static final String GET_Pay_ByStatusId_STMT = 
			"SELECT PY.payment_date, plan_name, PY.plan_id, plan_status, PY.member_id, PY.payment_id, PY.payment_amount\r\n"
					+ "FROM( \r\n"
					+ "	 (payment AS PY\r\n"
					+ "	  INNER JOIN plan AS P\r\n"
					+ "	  ON PY.plan_id = P.plan_id\r\n"
					+ "	  )\r\n"
					+ "	  INNER JOIN plan_status AS PS\r\n"
					+ "	  ON P.plan_status_id = PS.plan_status_id\r\n"
					+ "	)\r\n"
					+ "WHERE P.plan_status_id=?\r\n"
					+ "GROUP BY payment_id\r\n"
					+ "ORDER BY payment_id DESC;";
	@Override
	public List<PaymentVO> getPayByStatusId(Integer planStatusId) {
		List<PaymentVO> list = null ;

		try (
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_Pay_ByStatusId_STMT);) {
			
			pstmt.setInt(1, planStatusId);
			ResultSet rs = pstmt.executeQuery();
			list= new ArrayList<PaymentVO>();
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

	
	private static final String GET_ONE_STMT = "SELECT plan_status_id , plan_status FROM molife.plan_status where plan_status_id=?;";
	@Override
	public PlanStatusVO findByPrimaryKey(Integer planStatusId) {
		PlanStatusVO planStatusVO = null;
		if (planStatusId != null) {
			ResultSet rs = null;
			try {
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, planStatusId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					planStatusVO = new PlanStatusVO();
					planStatusVO.setPlanStatusId(rs.getInt("plan_status_id"));
					planStatusVO.setPlanStatus(rs.getString("plan_status"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
		}

		return planStatusVO;
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * PlanStatusJDBCDAO dao = new PlanStatusJDBCDAO();
	 * 
	 * // // PlanStatusVO vo1 = dao.findByPrimaryKey(4); //
	 * System.out.println(vo1.getPlanStatusId()+","); //
	 * System.out.println(vo1.getPlanStatus()+" "); //
	 * System.out.println("---------------------");
	 * 
	 * // ��x-���׶Ҵڬ���-�d�߬Y�Ӷi�ת��A���p�e // List<PlanVO> list =
	 * dao.getPlanByStatusId(4); // for (PlanVO plan : list) { //
	 * System.out.println(plan.getProposalDate()); //
	 * System.out.println(plan.getPlanName()); //
	 * System.out.println(plan.getPlanId()); //
	 * System.out.println(plan.getMemberId()); //
	 * System.out.println(plan.getPlanStatusId()); //
	 * System.out.println(plan.getPlanStatusComment()); //
	 * System.out.println("---------------------"); // }
	 * 
	 * // ��x-���ڬ����d��-�d�߬Y�Ӷi�ת��A���p�e (�p�e�W��join) // List<PaymentVO> list
	 * = dao.getPayByStatusId(4); // for (PaymentVO pay : list) { //
	 * System.out.println(pay.getPaymentDate()); //
	 * System.out.println(pay.getPlanId()); //
	 * System.out.println(pay.getPlanStatusId()); //
	 * System.out.println(pay.getMemeberId()); //
	 * System.out.println(pay.getPaymentId()); //
	 * System.out.println(pay.getPaymentAmount()); // }
	 * 
	 * }
	 */

}
