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

import com.tibame.tga105.donate.model.AnimalTypeVO;
import com.tibame.tga105.donate.model.PlanVO;

@Repository
public class AnimalTypeJDBCDAO implements AnimalTypeDAO_interface {
	@Autowired
	private DataSource ds;

	// N_5_search.jsp
	private static final String GET_Plan_ByAnimalId_STMT = "SELECT plan_id, animal_photo, plan_name, reason FROM molife.plan WHERE animal_type_id=? and plan_status_id=3 order by plan_id DESC;";

	@Override
	public List<PlanVO> getPlanByAnimalId(Integer animalTypeId) {
		List<PlanVO> list = null;
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_Plan_ByAnimalId_STMT);
			pstmt.setInt(1, animalTypeId);
			ResultSet rs = pstmt.executeQuery();

			list = new ArrayList<PlanVO>();
			while (rs.next()) {
				PlanVO planVO = new PlanVO();
				planVO.setPlanId(rs.getInt("plan_id"));
				planVO.setPlanName(rs.getString("plan_name"));
				planVO.setReason(rs.getString("reason"));
				planVO.setAnimalPhoto(rs.getBytes("animal_photo"));

				list.add(planVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;

	}

	
	private static final String GET_ONE_STMT = "SELECT animal_type,animal_type_id FROM molife.animal_type where animal_type_id=?";
	@Override
	public AnimalTypeVO findByPrimaryKey(Integer animalTypeId) {

		AnimalTypeVO animalTypeVO = null;

		if (animalTypeId != null) {
			ResultSet rs = null;
			try {
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, animalTypeId);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					animalTypeVO = new AnimalTypeVO();
					animalTypeVO.setAnimalTypeId(rs.getInt("animal_type_id"));
					animalTypeVO.setAnimalType(rs.getString("animal_type"));
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
		return animalTypeVO;
	}

}
