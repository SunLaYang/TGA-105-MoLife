package com.tibame.tga105.room.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tibame.tga105.room.model.PetroomVo;

public class PetroomRowMapper implements RowMapper<PetroomVo> {

	//要先確認sql是否有把用到的欄位都查詢出來
	@Override
	public PetroomVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PetroomVo petroomVo = new PetroomVo();
		petroomVo.setRoomTypeId(rs.getInt("room_type_id"));
		petroomVo.setRoomName(rs.getString("room_name"));
		petroomVo.setRoomDescription(rs.getString("room_description"));
		petroomVo.setPetNumber(rs.getInt("pet_number"));
		petroomVo.setRoomStatus(rs.getInt("room_status"));
		petroomVo.setRoomPrice(rs.getInt("room_price"));
		petroomVo.setRoomPic1(rs.getBytes("room_pic1"));
		petroomVo.setRoomPic2(rs.getBytes("room_pic2"));
		petroomVo.setRoomPic3(rs.getBytes("room_pic3"));

		return petroomVo;
	}

}
