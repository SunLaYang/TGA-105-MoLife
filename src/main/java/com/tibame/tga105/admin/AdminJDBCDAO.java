package com.tibame.tga105.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tibame.tga105.admin.VO.AdminVO;
import com.tibame.tga105.admin.dao.AdminDAOInterface;

public class AdminJDBCDAO implements AdminDAOInterface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/molife?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";	
	
	private static final String INSERT_STMT = "INSERT INTO admin (employee_account, employee_password, employee_name, employee_picture_id, employee_email, employee_auth_id, employee_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM admin order by admin_id";
	private static final String GET_ONE_STMT = "SELECT * FROM admin where admin_id = ?";
	private static final String DELETET = "DELETE FROM admin where admin_id = ?";
	private static final String EMPUPDATE = "UPDATE admin set employee_password = ?, employee_name = ?,  employee_picture_id = ?, employee_email= ? where admin_id = ?";
	private static final String BOSSUPDATE = "UPDATE admin set employee_password = ?, employee_name = ?,  employee_picture_id = ?, employee_email= ?, employee_auth_id=?, employee_status=? where admin_id = ?";
	private static final String LOGIN = "SELECT * FROM admin where employee_account = ? and employee_password = ?";
	

	@Override
	public void insert(AdminVO adminVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, adminVO.getEmpAcc());
			pstmt.setString(2, adminVO.getEmpPsd());
			pstmt.setString(3, adminVO.getEmpName());			
			pstmt.setBytes(4, adminVO.getEmpPicId());			
			pstmt.setString(5, adminVO.getEmpEmail());			
			pstmt.setInt(6, adminVO.getEmpAuthId());
			pstmt.setInt(7, adminVO.getEmpStatus());

			pstmt.executeUpdate();
			
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("讀不到資料庫driver"+e.getMessage());
			// 處裡SQL錯誤
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤" + se.getMessage());
//		 清理JDBC資源
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void empedit(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);			
			pstmt = con.prepareStatement(EMPUPDATE);

			pstmt.setString(1, adminVO.getEmpPsd());
			pstmt.setString(2, adminVO.getEmpName());
			pstmt.setBytes(3, adminVO.getEmpPicId());
			pstmt.setString(4, adminVO.getEmpEmail());
			pstmt.setInt(5, adminVO.getAdminId());

			pstmt.executeUpdate();
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("讀不到資料庫driver"+e.getMessage());	
			// 處理 任何 driver 錯誤
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤." + se.getMessage());
			// 清理 JDBC 資源
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}

	}

	@Override
	public void bossedit(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);			
			pstmt = con.prepareStatement(BOSSUPDATE);

			pstmt.setString(1, adminVO.getEmpPsd());
			pstmt.setString(2, adminVO.getEmpName());
			pstmt.setBytes(3, adminVO.getEmpPicId());
			pstmt.setString(4, adminVO.getEmpEmail());
			pstmt.setInt(5, adminVO.getEmpAuthId());
			pstmt.setInt(6, adminVO.getEmpStatus());
			pstmt.setInt(7, adminVO.getAdminId());

			pstmt.executeUpdate();
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("讀不到資料庫driver"+e.getMessage());	
			// 處理 任何 driver 錯誤
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤." + se.getMessage());
			// 清理 JDBC 資源
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}

	}

	@Override
	public void delete(Integer adminId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETET);

			pstmt.setInt(1, adminId);

			pstmt.executeUpdate();

		}catch (ClassNotFoundException e) {
			throw new RuntimeException("讀不到資料庫driver"+e.getMessage());
			// 處理 任何 driver 錯誤
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤." + se.getMessage());
			// 清理 JDBC 資源
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}

	}

	@Override
	public AdminVO findByPrimaryKey(Integer adminId) {

		AdminVO adminVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, adminId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// adminVo = Domain objects
				adminVO = new AdminVO();
				adminVO.setAdminId(rs.getInt("admin_id"));
				adminVO.setEmpAcc(rs.getString("employee_account"));
				adminVO.setEmpPsd(rs.getString("employee_password"));
				adminVO.setEmpName(rs.getString("employee_name"));
				adminVO.setEmpPicId(rs.getBytes("employee_picture_id"));
				adminVO.setEmpEmail(rs.getString("employee_email"));
				adminVO.setEmpAuthId(rs.getInt("employee_auth_id"));
				adminVO.setEmpStatus(rs.getInt("employee_status"));	
				
			}
			
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("讀不到資料庫driver"+e.getMessage());
			// 處理所有的driver錯誤
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤." + se.getMessage());
			// 清理 JDBC 資源
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return adminVO;
	}

	@Override
	public List<AdminVO> getAll() {
		List<AdminVO> list = new ArrayList<AdminVO>();
		AdminVO adminVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// adminVo = Domain objects
				adminVO = new AdminVO();
				adminVO.setAdminId(rs.getInt("admin_id"));
				adminVO.setEmpAcc(rs.getString("employee_account"));
				adminVO.setEmpPsd(rs.getString("employee_password"));
				adminVO.setEmpName(rs.getString("employee_name"));
				adminVO.setEmpPicId(rs.getBytes("employee_picture_id"));
				adminVO.setEmpEmail(rs.getString("employee_email"));
				adminVO.setEmpAuthId(rs.getInt("employee_auth_id"));
				adminVO.setEmpStatus(rs.getInt("employee_status"));					
				list.add(adminVO);// Store the row in the list						
			}
			
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("讀不到資料庫driver"+e.getMessage());
			// 處理 任何 driver 錯誤
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤." + se.getMessage());
			// 清理 JDBC 資源
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}		
		
		return list;
	}

	@Override
	public AdminVO login(String empAcc, String empPsd) {
		AdminVO adminVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(LOGIN);

			pstmt.setString(1, adminVO.getEmpAcc());
			pstmt.setString(2, adminVO.getEmpPsd());
			rs = pstmt.executeQuery();
			
				while (rs.next()) {

					adminVO = new AdminVO();
					adminVO.setAdminId(rs.getInt("admin_id"));
					adminVO.setEmpAcc(rs.getString("employee_account"));
					adminVO.setEmpPsd(rs.getString("employee_password"));
					adminVO.setEmpName(rs.getString("employee_name"));
					adminVO.setEmpPicId(rs.getBytes("employee_picture_id"));
					adminVO.setEmpEmail(rs.getString("employee_email"));
					adminVO.setEmpAuthId(rs.getInt("employee_auth_id"));
					adminVO.setEmpStatus(rs.getInt("employee_status"));
				}
			
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("讀不到資料庫driver"+e.getMessage());
			// 處理 任何 driver 錯誤
		} catch (SQLException se) {
			throw new RuntimeException("發生資料庫錯誤." + se.getMessage());
			// 清理 JDBC 資源
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return adminVO;
	}

}
