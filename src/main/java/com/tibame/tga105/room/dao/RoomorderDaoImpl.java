package com.tibame.tga105.room.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.tibame.tga105.room.dto.RoomderQueryParams;
import com.tibame.tga105.room.dto.RoomorderRequest;
import com.tibame.tga105.room.model.RoomorderVO;
import com.tibame.tga105.room.rowmapper.RoomorderRowMapper;

@Component
public class RoomorderDaoImpl implements RoomorderDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// =====================查全部訂單================================

	@Override
	public List<RoomorderVO> getRoomorders(RoomderQueryParams roomderQueryParams) {
		String sql = "SELECT roomorder_id, member_id, room_total_amount, room_order_status, total_of_pet, room_checkin_date, room_checkout_date, payer_name, payer_phone, room_check_date, order_status FROM roomorder WHERE 1=1";

		Map<String, Object> map = new HashMap<>();

		sql = addFilteringSql(sql, map, roomderQueryParams);

		// 在where語句最後面去拼上sql語法(1:一定要用字串拼接，不能傳變數 2:不需要判斷null因為我們有初始值)
		sql = sql + " ORDER BY " + roomderQueryParams.getOrderBy() + " " + roomderQueryParams.getSort();

		// 分頁的DAO
		sql = sql + " LIMIT :limit OFFSET :offset";
		map.put("limit", roomderQueryParams.getLimit());
		map.put("offset", roomderQueryParams.getOffset());

		List<RoomorderVO> roomorderList = namedParameterJdbcTemplate.query(sql, map, new RoomorderRowMapper());

		return roomorderList;
	}
	// ======================查單筆訂單==========================

	@Override
	public RoomorderVO getRoomorderById(Integer roomOrderId) {

		String sql = "SELECT roomorder_id, member_id, room_total_amount, room_order_status, total_of_pet, room_checkin_date, room_checkout_date, payer_name, payer_phone, room_check_date, order_status FROM roomorder WHERE roomorder_id = :roomOrderId";

		Map<String, Object> map = new HashMap<>();
		map.put("roomOrderId", roomOrderId);

		// query()永遠都會回傳list 裡面可能有多筆 一筆 0筆
		List<RoomorderVO> roomorderList = namedParameterJdbcTemplate.query(sql, map, new RoomorderRowMapper());

		if (roomorderList.size() > 0) {
			return roomorderList.get(0);
		} else {
			return null;
		}
	}

	// ====================新增訂單===========================

	@Override
	public Integer createRoomorder(RoomorderRequest roomorderRequest) {

		String sql = "INSERT INTO roomorder (member_id, room_total_amount, room_order_status, total_of_pet, room_checkin_date, room_checkout_date, payer_name, payer_phone, order_status) VALUES (:memberId, :roomTotalAmount, :roomOrderStatus, :totalOfPet, :roomCheckInDate, :roomCheckOutDate, :payerName, :payerPhone, :orderStatus)";

		Map<String, Object> map = new HashMap<>();
		map.put("memberId", roomorderRequest.getMemberId());
		map.put("roomTotalAmount", roomorderRequest.getRoomTotalAmount());
		map.put("roomOrderStatus", roomorderRequest.getRoomOrderStatus());
		map.put("totalOfPet", roomorderRequest.getTotalOfPet());
		map.put("roomCheckInDate", roomorderRequest.getRoomCheckInDate());
		map.put("roomCheckOutDate", roomorderRequest.getRoomCheckOutDate());
		map.put("payerName", roomorderRequest.getPayerName());
		map.put("payerPhone", roomorderRequest.getPayerPhone());
		map.put("orderStatus", roomorderRequest.getOrderStatus());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

		int roomOrderId = keyHolder.getKey().intValue();

		return roomOrderId;

	}

	// ===================新增到訂單明細========================

	@Override
	public void createRoomOrderDetail(Integer roomOrderId, RoomorderRequest roomorderRequest) {

		String sql = "INSERT INTO room_order_detail (room_type_id, roomorder_id) VALUES (:roomTypeId, :roomorderId)";

		Map<String, Object> map = new HashMap<>();
		map.put("roomTypeId", roomorderRequest.getRoomTypeId());
		map.put("roomorderId", roomOrderId);

		namedParameterJdbcTemplate.update(sql, map);

	}

	// =============修改訂單======================

	@Override
	public void updateRoomorder(Integer roomOrderId, RoomorderRequest roomorderRequest) {
		String sql = "UPDATE roomorder SET member_id = :memberId, room_total_amount = :roomTotalAmount, room_order_status = :roomOrderStatus, total_of_pet = :totalOfPet, room_checkin_date = :roomCheckInDate, room_checkout_date = :roomCheckOutDate, payer_name = :payerName, payer_phone = :payerPhone, order_status = :orderStatus  WHERE roomorder_id = :roomOrderId";

		Map<String, Object> map = new HashMap<>();
		map.put("roomOrderId", roomOrderId);

		map.put("memberId", roomorderRequest.getMemberId());
		map.put("roomTotalAmount", roomorderRequest.getRoomTotalAmount());
		map.put("roomOrderStatus", roomorderRequest.getRoomOrderStatus());
		map.put("totalOfPet", roomorderRequest.getTotalOfPet());
		map.put("roomCheckInDate", roomorderRequest.getRoomCheckInDate());
		map.put("roomCheckOutDate", roomorderRequest.getRoomCheckOutDate());
		map.put("payerName", roomorderRequest.getPayerName());
		map.put("payerPhone", roomorderRequest.getPayerPhone());
		map.put("orderStatus", roomorderRequest.getOrderStatus());

		namedParameterJdbcTemplate.update(sql, map);

	}

	// ===========刪除訂單===========================
	@Override
	public void deleteRoomOrder(Integer roomOrderId) {
		String sql = "DELETE FROM roomorder WHERE roomorder_id = :roomorder_id";

		Map<String, Object> map = new HashMap<>();
		map.put("roomorder_id", roomOrderId);

		namedParameterJdbcTemplate.update(sql, map);

	}

	// ====================顯示後台訂單頁面=================
	@Override
	public List<Map<String, Object>> getRoomorderPages(RoomorderVO roomorderVO) {
		String sql = "SELECT o.roomorder_id , r.room_name , o.room_checkin_date , o.room_checkout_date,o.room_total_amount,d.room_comment,o.room_order_status "
				+ "				 FROM roomorder o "
				+ "				 JOIN room_order_detail d ON o.roomorder_id = d.roomorder_id"
				+ "				 JOIN petroom r ON d.room_type_id = r.room_type_id";
//				+ "				 WHERE o.roomorder_id = :roomorder_id";

		Map<String, Object> map = new HashMap<>();

//		map.put("roomorder_id", roomorderVO.getRoomOrderId());

		List<Map<String, Object>> roomorderList = new ArrayList<Map<String, Object>>();
		roomorderList = namedParameterJdbcTemplate.queryForList(sql, map);

		return roomorderList;

	}

	// ============計算總訂單筆數(分頁 + 總比數)的DAO=================
	@Override
	public Integer countOrder(RoomderQueryParams roomderQueryParams) {

		String sql = "SELECT count(*) FROM roomorder WHERE 1=1";

		Map<String, Object> map = new HashMap<>();

		sql = addFilteringSql(sql, map, roomderQueryParams);

		// 用付款人姓名查詢(沒有傳值近來就不會有下列判斷)
//		if (roomderQueryParams.getSearch() != null) {
//			sql = sql + " AND payer_name LIKE :search";
//			map.put("search", "%" + roomderQueryParams.getSearch() + "%");
//		}
//
//		// 用入住狀態收尋
//		if (roomderQueryParams.getSearchStatus() != null) {
//			sql = sql + " AND room_order_status LIKE :searchStatus";
//			map.put("searchStatus", "%" + roomderQueryParams.getSearchStatus() + "%");
//		}

		Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);// 表示將count的值轉成Integer的值

		return total;
	}

	// 提煉上面的sql拼接語句方法，只有在這個class內會用到的話 要用private 因為實際工作中希望更好的管理程式的使用範圍
	private String addFilteringSql(String sql, Map<String, Object> map, RoomderQueryParams roomderQueryParams) {

		// 用付款人姓名查詢(沒有傳值近來就不會有下列判斷)
		if (roomderQueryParams.getSearch() != null) {
			sql = sql + " AND payer_name LIKE :search";
			map.put("search", "%" + roomderQueryParams.getSearch() + "%");
		}

		// 用入住狀態收尋
		if (roomderQueryParams.getSearchStatus() != null) {
			sql = sql + " AND room_order_status LIKE :searchStatus";
			map.put("searchStatus", "%" + roomderQueryParams.getSearchStatus() + "%");
		}

		return sql;

	}

	// ===============會員訂單完整明細==================

	@Override
	public List<Map<String, Object>> getRoomorderByMemberId(RoomorderVO roomorderVO, Integer memberId) {
		String sql = "SELECT o.roomorder_id, r.room_name, o.room_check_date, o.room_total_amount, o.order_status "
				+ "FROM roomorder o " + "JOIN room_order_detail d ON o.roomorder_id = d.roomorder_id "
				+ "JOIN petroom r ON d.room_type_id = r.room_type_id " + "WHERE o.member_id = :memberId";

		Map<String, Object> map = new HashMap<>();

		map.put("memberId", memberId);

		System.out.println("map contains memberId: " + memberId);

		List<Map<String, Object>> roomorderList = new ArrayList<Map<String, Object>>();

		roomorderList = namedParameterJdbcTemplate.queryForList(sql, map);

		return roomorderList;

	}

	// 查詢房型有被預定的日期
	@Override
	public List<Map<String, Object>> getRoomorderDate(Integer roomTypeId,LocalDate beginDate,LocalDate lastDayOfMonth) {

		String sql = "SELECT d.room_type_id,r.room_checkin_date,r.room_checkout_date " + "from roomorder r "
				+ "join room_order_detail d " + "on r.roomorder_id = d.roomorder_id "
				+ "where room_type_id = :roomTypeId AND room_checkin_date >= :beginDate AND room_checkout_date <= :lastDayOfMonth;";

		Map<String, Object> map = new HashMap<>();

		map.put("roomTypeId", roomTypeId);
		map.put("beginDate", beginDate);
		map.put("lastDayOfMonth", lastDayOfMonth);

		System.out.println("map contains roomTypeId: " + roomTypeId + "," + beginDate + "," + lastDayOfMonth);

		List<Map<String, Object>> roomorderList = new ArrayList<Map<String, Object>>();

		roomorderList = namedParameterJdbcTemplate.queryForList(sql, map);

		return roomorderList;
	}

}
