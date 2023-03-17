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
import com.tibame.tga105.donate.model.PlanStatusVO;
import com.tibame.tga105.donate.model.PlanVO;

@Repository
public class PlanJDBCDAO implements PlanDAO_interface {

	@Autowired
	private DataSource ds;

	// 新增計畫
	private static final String INSERT_STMT = "INSERT INTO plan (proposal_date, plan_name, animal_type_id, address, reason, donate_days, donate_goal, animal_video_link, plan_status_id, animal_photo, member_id) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	@Override
	public PlanVO insert(PlanVO bean) {
		PlanVO result = null;

		if (bean != null) {
			try {
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setDate(1, bean.getProposalDate());
				pstmt.setString(2, bean.getPlanName());
				pstmt.setInt(3, bean.getAnimalTypeId());
				pstmt.setString(4, bean.getAddress());
				pstmt.setString(5, bean.getReason());
				pstmt.setInt(6, bean.getDonateDays());
				pstmt.setInt(7, bean.getDonateGoal());
				pstmt.setString(8, bean.getAnimalVideoLink());
				pstmt.setInt(9, bean.getPlanStatusId());
				pstmt.setBytes(10, bean.getAnimalPhoto());
				pstmt.setInt(11, bean.getMemberId());

				int i = pstmt.executeUpdate();
				// 若新增成功，表示executeUpdate()受到影響的行數為1)
				if (i == 1) {
					result = bean;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// List募款中計畫詳情
	private static final String GET_ONE_STMT = 
			"select A.plan_id, A.animal_photo, A.plan_name, animal_type, A.address, A.reason, A.donate_end_date, A.animal_video_link, A.donate_goal, IFNULL(SUM(B.payment_amount),0) AS donate_amount\r\n"
			+ "FROM (\r\n"
			+ "		(plan AS A\r\n"
			+ "        LEFT JOIN payment B \r\n"
			+ "		ON A.plan_id = B.plan_id\r\n"
			+ "        )\r\n"
			+ "		LEFT JOIN  animal_type AS ANI\r\n"
			+ "        ON A.animal_type_id = ANI.animal_type_id\r\n"
			+ "        )\r\n"
			+ "WHERE A.plan_id=?\r\n"
			+ "GROUP BY plan_id;";
	@Override
	public List<PlanVO> getOnePlan(Integer planId) {
		List<PlanVO> list = null;

		try (
			Connection con = ds.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT);) {

				pstmt.setInt(1, planId);
				ResultSet rs = pstmt.executeQuery();
				list = new ArrayList<PlanVO>();
				while (rs.next()) {			
					PlanVO planVO = new PlanVO();
					planVO.setPlanId(rs.getInt("plan_id"));
					planVO.setAnimalPhoto(rs.getBytes("animal_photo"));
					planVO.setPlanName(rs.getString("plan_name"));
					planVO.setAddress(rs.getString("address"));
					planVO.setReason(rs.getString("reason"));
					planVO.setDonateEndDate(rs.getDate("donate_end_date"));
					planVO.setAnimalVideoLink(rs.getString("animal_video_link"));
					planVO.setDonateGoal(rs.getInt("donate_goal"));
					planVO.setDonateAmount(rs.getInt("donate_amount"));
					
					//動物類型
					AnimalTypeVO animalTypeVO =  new AnimalTypeVO();
					animalTypeVO.setAnimalType(rs.getString("animal_type"));
					
					planVO.setAnimalTypeVO(animalTypeVO);
					
					list.add(planVO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		return list;
	}

	
	// List會員自己的計畫紀錄
	private static final String GET_ByMember_STMT = 
			"SELECT A.proposal_date, A.plan_name, A.plan_id, A.plan_status_id, plan_status, IFNULL(SUM(PY.payment_amount),0) AS donate_amount, plan_status_comment \r\n"
			+ "FROM ( \r\n"
			+ "		( plan AS A\r\n"
			+ "		LEFT JOIN payment AS PY \r\n"
			+ "        ON A.plan_id = PY.plan_id\r\n"
			+ "		)\r\n"
			+ "INNER JOIN plan_status AS PS\r\n"
			+ "ON A.plan_status_id = PS.plan_status_id \r\n"
			+ "	)\r\n"
			+ "WHERE A.member_id= ?    \r\n"
			+ "GROUP BY plan_id\r\n"
			+ "ORDER BY plan_id DESC;";
	@Override
	public List<PlanVO> findBymemberId(Integer memberId) {

		List<PlanVO> result = null;
		PlanVO planVO = null;
		
		if (memberId!=null) {
			ResultSet rs = null;
			try (
				Connection  con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_ByMember_STMT);) {
				
				pstmt.setInt(1, memberId);
				rs = pstmt.executeQuery();
				result = new ArrayList<PlanVO>();
				while (rs.next()) {
					planVO = new PlanVO();
					planVO.setProposalDate(rs.getDate("proposal_date"));
					planVO.setPlanName(rs.getString("plan_name"));
					planVO.setPlanId(rs.getInt("plan_id"));	
					planVO.setPlanStatusId(rs.getInt("plan_status_id"));
					//直接寫
					planVO.setDonateAmount(rs.getInt("donate_amount"));
					planVO.setPlanStatusComment(rs.getString("plan_status_comment"));
					
					//planStatusVO-計畫進度
					PlanStatusVO planStatusVO = new PlanStatusVO();
					planStatusVO.setPlanStatus(rs.getString("plan_status"));
					
					planVO.setPlanStatusVO(planStatusVO);
					
					result.add(planVO);
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
		return result;
	}

	
	// 首頁-計畫 (照片/名稱/原因) //animal_photo,
	private static final String GET_All_STMT = "select animal_photo,plan_name,reason,plan_id FROM plan WHERE plan_status_id=3;";
	@Override
	public List<PlanVO> getall() {

		List<PlanVO> result = null;
		PlanVO planVO = null;

		try (
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_All_STMT);
			ResultSet rs = pstmt.executeQuery();) {
			
			result = new ArrayList<PlanVO>();
			while (rs.next()) {
				planVO = new PlanVO();
				planVO.setAnimalPhoto(rs.getBytes("animal_photo"));
				planVO.setPlanId(rs.getInt("plan_id"));
				planVO.setPlanName(rs.getString("plan_name"));
				planVO.setReason(rs.getString("reason"));

				result.add(planVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return result;
	}

	

	// 後台-List所有會員計畫紀錄
	private static final String GET_ForAmdin_STMT = 
			"select P.proposal_date, P.plan_name, P.plan_id, P.member_id, P.plan_status_id, P.plan_status_comment, plan_status\r\n"
			+ "FROM plan AS P\r\n"
			+ "INNER JOIN plan_status AS PS\r\n"
			+ "ON P.plan_status_id = PS.plan_status_id \r\n"
			+ "order by plan_id DESC;";
	@Override
	public List<PlanVO> getallForAdmin() {

		List<PlanVO> result = null;
		PlanVO planVO = null;
		PlanStatusVO planStatusVO = null;

		try (
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ForAmdin_STMT);
			ResultSet rs = pstmt.executeQuery();) {
			
			result = new ArrayList<PlanVO>();
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
				
				result.add(planVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	
	// 後台-修改計畫進度/donate_end_date/plan_status_comment
	private static final String UPDATE = "UPDATE plan set plan_status_id=?, donate_end_date=?, plan_status_comment=? where plan_id=?;";
	@Override
	public PlanVO update(Integer planStatusId, java.util.Date donateEndDate, 
			String planStatusComment, Integer planId) {

		PlanVO result = null;
		if (planId!=null) {
			try {
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, planStatusId);
				
				if (donateEndDate!=null) {
					long time = donateEndDate.getTime();
					pstmt.setDate(2, new java.sql.Date(time));
				} else {
					pstmt.setDate(2, null);
				}
				pstmt.setString(3, planStatusComment);
				pstmt.setInt(4, planId);

				int i = pstmt.executeUpdate();
				
				if (i==1) {
					result = this.getOnePlanForAdmin(planId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return result;
	}


	// 7.後臺修改頁面-顯示計畫內容
	private static final String GET_OnePlan_ForAdmin_STMT = 
			"SELECT P.plan_id, P.animal_photo, P.proposal_date, P.plan_name, P.address, P.reason, P.donate_days, P.donate_goal, P.animal_video_link, animal_type\r\n"
			+ "FROM plan P \r\n"
			+ " JOIN animal_type A\r\n"
			+ " ON P.animal_type_id = A.animal_type_id\r\n"
			+ "WHERE plan_id=?;";
	
	@Override
	public PlanVO getOnePlanForAdmin(Integer planId) {

		PlanVO result = null;
		AnimalTypeVO animalTypeVO = null;
		
		if (planId!=null) {
			ResultSet rs = null;
			try (
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_OnePlan_ForAdmin_STMT);) {

				pstmt.setInt(1, planId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					
					result = new PlanVO();
					result.setPlanId(rs.getInt("plan_id"));
					result.setAnimalPhoto(rs.getBytes("animal_photo"));
					result.setProposalDate(rs.getDate("proposal_date"));
					result.setPlanName(rs.getString("plan_name"));
					result.setAddress(rs.getString("address"));
					result.setReason(rs.getString("reason"));
					result.setDonateDays(rs.getInt("donate_days"));
					result.setDonateGoal(rs.getInt("donate_goal"));
					result.setAnimalVideoLink(rs.getString("animal_video_link"));
					
					animalTypeVO = new AnimalTypeVO();
					animalTypeVO.setAnimalType(rs.getString("animal_type"));
					
					result.setAnimalTypeVO(animalTypeVO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
			}
		}
		 return result;
	}

	// 抓取動物圖片
	private static final String GET_Photo_STMT = "SELECT animal_photo FROM plan where plan_id=?;";
	@Override
	public PlanVO getAnimalPhoto(Integer planId) {
		PlanVO result = null;
		
		if (planId!=null) {
			ResultSet rs = null;
			
			try (
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_Photo_STMT);){
				
				pstmt.setInt(1, planId);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					result = new PlanVO();
					result.setAnimalPhoto(rs.getBytes("animal_photo"));
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
		return result;
	}
	
	
	// 9.提案成功頁面
	private static final String SUCCESS_STMT = 
			"SELECT plan_id, plan_name\r\n"
			+ "FROM plan\r\n"
			+ "WHERE member_id=?\r\n"
			+ "ORDER BY plan_id DESC\r\n"
			+ "LIMIT 1;";
	@Override
	public PlanVO successPage(Integer memberId) {
		PlanVO result = null;
		
		if (memberId!=null) {
			ResultSet rs = null;
			try (
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SUCCESS_STMT);) {

				pstmt.setInt(1, memberId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					result = new PlanVO();
					result.setPlanId(rs.getInt("plan_id"));
					result.setPlanName(rs.getString("plan_name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
			}
		}
		 return result;
	}

//	public PlanVO getAnimalPhotoById(Integer planId) throws SQLException {
//		PlanVO planVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = ds.getConnection();
//			pstmt = con.prepareStatement("SELECT plan_id,animal_photo FROM molife.plan WHERE plan_id=?");
//			pstmt.setInt(1, planId);
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				planVO = new PlanVO();
//				planVO.setPlanId(rs.getInt("plan_id"));
//				planVO.setAnimalPhoto(rs.getBytes("animal_photo"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			con.close();
//			pstmt.close();
//			rs.close();
//		}
//
//		return planVO;
//	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * PlanJDBCDAO dao = new PlanJDBCDAO();
	 * 
	 * // // PlanVO vo1 = new PlanVO(); //
	 * vo1.setProposalDate(java.sql.Date.valueOf("2023-02-23")); //
	 * vo1.setPlanName("test"); // vo1.setAnimalTypeId(1); //
	 * vo1.setAddress("test"); // vo1.setReason("test"); // vo1.setDonateDays(1000);
	 * // vo1.setDonateGoal(1000); // vo1.setAnimalVideoLink("test"); //
	 * vo1.setAnimalPhoto(null); // vo1.setPlanStatusId(1); // vo1.setMemberId(1);
	 * // dao.insert(vo1);
	 * 
	 * 
	 * // List�@�ӶҴڤ��p�e�Ա� // PlanVO vo2 = dao.getOnePlan(1); //
	 * System.out.println(vo2.getAnimalPhoto()); //
	 * System.out.println(vo2.getAnimalTypeId()); //
	 * System.out.println(vo2.getAddress()); // System.out.println(vo2.getReason());
	 * // System.out.println(vo2.getDonateEndDate()); //
	 * System.out.println(vo2.getAnimalVideoLink()); //
	 * System.out.println(vo2.getDonateGoal());
	 * 
	 * 
	 * 
	 * // List�|���ۤv���p�e���� // List<PlanVO> list = dao.findBymemberId(18); //
	 * for (PlanVO vo : list) { // System.out.println(vo.getProposalDate()); //
	 * System.out.println(vo.getPlanName()); // System.out.println(vo.getPlanId());
	 * // System.out.println(vo.getTotalAmount()); //
	 * System.out.println(vo.getPlanStatusComment()); //
	 * System.out.println("=========="); // }
	 * 
	 * 
	 * 
	 * // 4.����-List�X�Ҵڤ��p�e (�Ӥ�/�W��/��]) // List<PlanVO> list = dao.getall();
	 * // for (PlanVO vo : list) { // System.out.println(vo.getPlanName()); //
	 * System.out.println(vo.getReason()); //
	 * System.out.println(vo.getAnimalPhoto()); // System.out.println("-------"); //
	 * }
	 * 
	 * 
	 * // 5.��x-List�Ҧ��|���p�e���� // List<PlanVO> list = dao.getallForAdmin(); //
	 * for (PlanVO vo : list) { // System.out.println(vo.getProposalDate()); //
	 * System.out.println(vo.getPlanName()); // System.out.println(vo.getPlanId());
	 * // System.out.println(vo.getMemberId()); //
	 * System.out.println(vo.getPlanStatusId()); //
	 * System.out.println(vo.getPlanStatusComment()); //
	 * System.out.println("-------"); // }
	 * 
	 * 
	 * 
	 * //�ק� �p�e�i��/donate_end_date/plan_status_comment // PlanVO vo2 = new
	 * PlanVO(); // vo2.setPlanStatusId(4); // vo2.setDonateEndDate(null); //
	 * vo2.setPlanStatusComment("test0223"); // vo2.setPlanId(6); //
	 * dao.update(vo2);
	 * 
	 * 
	 * }
	 */

}
