package com.tibame.tga105.room.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tibame.tga105.room.model.RoomorderVO;

public class RoomorderRowMapper implements RowMapper<RoomorderVO>{

	//查詢方法需要有這個轉換數據的rowmapper 才能將從資料查詢出來的數據轉換成java Object
	@Override               //resultSet 是去存放從資料庫所查出來的數據
	public RoomorderVO mapRow(ResultSet rs, int i) throws SQLException {
		RoomorderVO roomorderVO = new RoomorderVO();
		
		
		roomorderVO.setRoomOrderId(rs.getInt("roomorder_id"));
		roomorderVO.setMemberId(rs.getInt("member_id"));
		roomorderVO.setRoomTotalAmount(rs.getInt("room_total_amount"));
		roomorderVO.setRoomOrderStatus(rs.getInt("room_order_status"));
		roomorderVO.setTotalOfPet(rs.getInt("total_of_pet"));
		roomorderVO.setRoomCheckInDate(rs.getDate("room_checkin_date"));
		roomorderVO.setRoomCheckOutDate(rs.getDate("room_checkout_date"));
		roomorderVO.setPayerName(rs.getString("payer_name"));
		roomorderVO.setPayerPhone(rs.getString("payer_phone"));
		roomorderVO.setRoomCheckDate(rs.getTimestamp("room_check_date"));
		roomorderVO.setOrderStatus(rs.getInt("order_status"));
		
		
//		roomorderVO.setRoomTypeId(rs.getInt("room_type_id"));
//		roomorderVO.setRoomName(rs.getString("room_name"));
		
		//mapRow的返回值 是表示要將資料庫中的數據轉換成什麼樣的java Object
		return roomorderVO;
	}

	
	
	

}
