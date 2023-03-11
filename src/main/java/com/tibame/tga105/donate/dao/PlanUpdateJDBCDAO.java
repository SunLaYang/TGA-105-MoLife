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

import com.tibame.tga105.donate.model.PlanUpdateVO;

@Repository
public class PlanUpdateJDBCDAO implements PlanUpdate_interface {

	@Autowired
	private DataSource ds;

	// 1.計畫詳情-List狀態更新 N_2_ongoingAndPay.jsp
	private static final String GET_Update_ByPlan_STMT = "SELECT update_id, update_date, update_text, update_photo FROM molife.plan_update where plan_id=? ORDER BY update_date DESC ;";
	@Override
	public List<PlanUpdateVO> getUpdateByPlanId(Integer planId) {
		List<PlanUpdateVO> list = null;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_Update_ByPlan_STMT);) {

			pstmt.setInt(1, planId);
			ResultSet rs = pstmt.executeQuery();
			list = new ArrayList<PlanUpdateVO>();
			while (rs.next()) {
				PlanUpdateVO planUpdateVO = new PlanUpdateVO();
				planUpdateVO.setUpdateId(rs.getInt("update_id"));
				planUpdateVO.setUpdateDate(rs.getDate("update_date"));
				planUpdateVO.setUpdateText(rs.getString("update_text"));
				planUpdateVO.setUpdatePhoto(rs.getBytes("update_photo"));

				list.add(planUpdateVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

	// 2.會員中心-新增狀態更新 N_4-2_updateStatus.jsp
	private static final String INSERT_STMT = "INSERT INTO plan_update (plan_id, update_date, update_text, update_photo) VALUES (?,?,?,?);";
	@Override
	public PlanUpdateVO insert(PlanUpdateVO planUpdateVO) {
		PlanUpdateVO result=null;
		try (
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);) {
			
			pstmt.setInt(1, planUpdateVO.getPlanId());
			pstmt.setDate(2, planUpdateVO.getUpdateDate());
			pstmt.setString(3, planUpdateVO.getUpdateText());
			pstmt.setBytes(4, planUpdateVO.getUpdatePhoto());

			int i = pstmt.executeUpdate();
			if (i==1) {
				result = planUpdateVO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	// 3.獲取動物圖片 N_2_ongoingAndPay.jsp
	private static final String GET_Photo_STMT = "SELECT update_photo FROM plan_update WHERE update_id=?;";
	@Override
	public PlanUpdateVO getAnimalPhoto(Integer updateId) {
		PlanUpdateVO planUpdateVO = null;

		try (
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_Photo_STMT);){
			
			pstmt.setInt(1, updateId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				planUpdateVO = new PlanUpdateVO();
				planUpdateVO.setUpdatePhoto(rs.getBytes("update_photo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return planUpdateVO;
	}

	
}
