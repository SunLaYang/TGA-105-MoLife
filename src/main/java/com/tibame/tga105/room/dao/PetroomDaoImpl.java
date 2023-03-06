package com.tibame.tga105.room.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.tibame.tga105.room.dto.PetroomRequest;
import com.tibame.tga105.room.model.PetroomVo;
import com.tibame.tga105.room.rowmapper.PetroomRowMapper;

@Component
public class PetroomDaoImpl implements PetroomDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// =========新增房型=====================
	@Override
	public Integer createPetroom(PetroomRequest petroomRequest) {
		String sql = "INSERT INTO petroom(room_name, room_description, pet_number, room_status, room_price, room_pic1, room_pic2, room_pic3) VALUES (:roomName, :roomDescription, :petNumber, :roomStatus, :roomPrice, :roomPic1, :roomPic2, :roomPic3)";

		Map<String, Object> map = new HashMap<>();
		map.put("roomName", petroomRequest.getRoomName());
		map.put("roomDescription", petroomRequest.getRoomDescription());
		map.put("petNumber", petroomRequest.getPetNumber());
		map.put("roomStatus", petroomRequest.getRoomStatus());
		map.put("roomPrice", petroomRequest.getRoomPrice());
		map.put("roomPic1", petroomRequest.getImage1());
		map.put("roomPic2", petroomRequest.getImage2());
		map.put("roomPic3", petroomRequest.getImage3());

		KeyHolder keyHolder = new GeneratedKeyHolder();// 接住pk自動生成的id
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
		int roomTypeId = keyHolder.getKey().intValue();// 接住後轉成int
		return roomTypeId;
	}
	
	
	//================查詢前端進來的RoomName=================
	@Override
	public PetroomVo getPetroomByName(String roomName) {
		String sql = "SELECT room_type_id, room_name, room_description, pet_number, room_status, room_price, room_pic1, room_pic2, room_pic3 FROM petroom WHERE room_name = :room_name";
		
		Map<String, Object> map = new HashMap<>();
		map.put("room_name", roomName);

		List<PetroomVo> petroomList = namedParameterJdbcTemplate.query(sql, map, new PetroomRowMapper());


		if (petroomList.size() > 0) {
			return petroomList.get(0);
		} else {
			
			return null;
		}

	}
	
	//====================查詢全部房型=====================
	@Override
	public List<PetroomVo> getPetrooms() {
		String sql = "SELECT room_type_id, room_name, room_description, pet_number, room_status, room_price, room_pic1, room_pic2, room_pic3 FROM petroom";
		
		Map<String, Object> map = new HashMap<>();
		
		List<PetroomVo> petroomList = namedParameterJdbcTemplate.query(sql, map, new PetroomRowMapper());
		
		return petroomList;
	}


	// ===================查詢單筆房型========================
	@Override
	public PetroomVo getPetroomById(Integer roomTypeId) {
		String sql = "SELECT room_type_id, room_name, room_description, pet_number, room_status, room_price, room_pic1, room_pic2, room_pic3 FROM petroom WHERE room_type_id = :roomTypeId";

		Map<String, Object> map = new HashMap<>();
		map.put("roomTypeId", roomTypeId);

		List<PetroomVo> petroomList = namedParameterJdbcTemplate.query(sql, map, new PetroomRowMapper());


		if (petroomList.size() > 0) {
			return petroomList.get(0);
		} else {
			
			return null;
		}

	}

	//==========================修改房型=====================
	@Override
	public void updatePetroom(Integer roomTypeId, PetroomRequest petroomRequest) {
		
		String sql = "UPDATE petroom SET room_name = :roomName, room_description = :roomDescription, pet_number = :petNumber, room_status = :roomStatus, room_price = :roomPrice, room_pic1 = :roomPic1, room_pic2 = :roomPic2, room_pic3 = :roomPic3 WHERE room_type_id = :roomTypeId";

		Map<String, Object> map = new HashMap<>();
		map.put("roomTypeId", roomTypeId);
		
		map.put("roomName", petroomRequest.getRoomName());
		map.put("roomDescription", petroomRequest.getRoomDescription());
		map.put("petNumber", petroomRequest.getPetNumber());
		map.put("roomStatus", petroomRequest.getRoomStatus());
		map.put("roomPrice", petroomRequest.getRoomPrice());
		map.put("roomPic1", petroomRequest.getImage1());
		map.put("roomPic2", petroomRequest.getImage2());
		map.put("roomPic3", petroomRequest.getImage3());
		
		namedParameterJdbcTemplate.update(sql, map);
		
		
	}

	
}
