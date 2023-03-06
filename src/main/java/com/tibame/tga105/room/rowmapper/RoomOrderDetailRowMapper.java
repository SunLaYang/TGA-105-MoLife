package com.tibame.tga105.room.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tibame.tga105.room.model.RoomOrderDeatilVo;

public class RoomOrderDetailRowMapper implements RowMapper<RoomOrderDeatilVo>{

	@Override
	public RoomOrderDeatilVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RoomOrderDeatilVo roomOrderDeatilVo = new RoomOrderDeatilVo();
		roomOrderDeatilVo.setRoomorderDetailId(rs.getInt("roomorder_detail_id"));
		roomOrderDeatilVo.setRoomTypeId(rs.getInt("room_type_id"));
		roomOrderDeatilVo.setRoomorderId(rs.getInt("roomorder_id"));
		
		
		return roomOrderDeatilVo;
	}

}
