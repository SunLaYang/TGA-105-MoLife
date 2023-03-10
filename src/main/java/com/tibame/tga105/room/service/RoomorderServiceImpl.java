package com.tibame.tga105.room.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tibame.tga105.room.dao.PetroomDao;
import com.tibame.tga105.room.dao.RoomorderDao;
import com.tibame.tga105.room.dto.RoomderQueryParams;
import com.tibame.tga105.room.dto.RoomorderRequest;
import com.tibame.tga105.room.model.PetroomVo;
import com.tibame.tga105.room.model.RoomOrderDeatilVo;
import com.tibame.tga105.room.model.RoomorderVO;

@Component
public class RoomorderServiceImpl implements RoomorderService {

	@Autowired
	private RoomorderDao roomorderDao;

	@Autowired
	private PetroomDao petroomDao;

	@Override
	public List<RoomorderVO> getRoomorders(RoomderQueryParams roomderQueryParams) {

		return roomorderDao.getRoomorders(roomderQueryParams);
	}

	@Override
	public RoomorderVO getRoomorderById(Integer roomOrderId) {
		return roomorderDao.getRoomorderById(roomOrderId);
	}

	// 創建訂單需要分成兩部分
	@Transactional // 新增交易控制避免數據不一致
	@Override
	public Integer createRoomorder(RoomorderRequest roomorderRequest) {
		// 新增一個List 去裝傳進來得數值
		List<RoomOrderDeatilVo> roomOrderDeatilList = new ArrayList<>();

		PetroomVo petroomVo = petroomDao.getPetroomById(roomorderRequest.getRoomTypeId());

		// 創建訂單
		Integer roomOrderId = roomorderDao.createRoomorder(roomorderRequest);// 先在roomorder table新增資料
		roomorderDao.createRoomOrderDetail(roomOrderId, roomorderRequest);// 同時要去room order detail表新增

		return roomOrderId;
	}

	@Override
	public void updateRoomorder(Integer roomOrderId, RoomorderRequest roomorderRequest) {
		roomorderDao.updateRoomorder(roomOrderId, roomorderRequest);

	}

	// ================取消訂單專用==============
	@Override
	public void updateRoomorderForCancel(Integer roomOrderId, RoomorderRequest roomorderRequest) {
		roomorderDao.updateRoomorderForCancel(roomOrderId, roomorderRequest);

	}

	@Override
	public void deleteRoomOrder(Integer roomOrderId) {

		roomorderDao.deleteRoomOrder(roomOrderId);
	}

	@Override
	public List<Map<String, Object>> getRoomorderPages(RoomorderVO roomorderVO) {

		return roomorderDao.getRoomorderPages(roomorderVO);
	}

	@Override
	public Integer countOrder(RoomderQueryParams roomderQueryParams) {

		return roomorderDao.countOrder(roomderQueryParams);
	}

	@Override
	public List<Map<String, Object>> getRoomorderByMemberId(RoomorderVO roomorderVO, Integer memberId) {
		return roomorderDao.getRoomorderByMemberId(roomorderVO, memberId);
	}

	// =======================================房型訂單日期業務邏輯=================================================
	@Override
	public List<Map<String, Object>> getRoomorderDate(Integer roomTypeId) {

		// 先取出當天日期，然後去比對這天日期的月起始日跟月結束日
		LocalDate beginDate = LocalDate.now();
		// 當月月份 + 2 代表查詢這三個月 5代表查半年內
		LocalDate lastDayOfMonth = beginDate.plusMonths(5).with(TemporalAdjusters.lastDayOfMonth());

		// 宣告回傳的資料
//		 List<Map<String, Object>> checkDateList = new ArrayList<Map<String, Object>>();

		// 撈出資料庫的資廖
		List<Map<String, Object>> cdList = roomorderDao.getRoomorderDate(roomTypeId, beginDate, lastDayOfMonth);

		// 宣告回傳資料 調用下列getCdList方法
		List<Map<String, Object>> checkDateList = getCdList(cdList);

		// 回傳資料
		return checkDateList;
	}

	// 實作getCdList方法
	private List<Map<String, Object>> getCdList(List<Map<String, Object>> cdList) {

		List<Map<String, Object>> checkDateList = new ArrayList<Map<String, Object>>();

		// 第一次先遍歷資料庫撈出來的資料
		for (Map<String, Object> data : cdList) {

			String bDate = data.get("room_checkin_date").toString();
			String eDate = data.get("room_checkout_date").toString();

			// 把string格式化成localDate 資料型別
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date1 = LocalDate.parse(bDate, fmt);
			LocalDate date2 = LocalDate.parse(eDate, fmt);

			// 取出起訖日的日期區間
			long daysBetween = ChronoUnit.DAYS.between(date1, date2);

			System.out.println(date1);
			System.out.println(date2);
			System.out.println("日期 " + bDate + " 和日期 " + eDate + " 之間相差 " + daysBetween + " 天");

			// 第二次遍歷 把起訖日的差額拆分成為一天，列出區間的每一天
//            {
//            	"beginDate": "2023-03-09",
//            	"room_type_id": "2",
//            	"lastDayOfMonth": "2023-03-10"
//            	},
//            	{
//            	"beginDate": "2023-03-10",
//            	"room_type_id": "2",
//            	"lastDayOfMonth": "2023-03-11"
//            	},
//            	{
//            	"beginDate": "2023-03-11",
//            	"room_type_id": "2",
//            	"lastDayOfMonth": "2023-03-12"
//            	}
			// 類似上述這樣

			for (long i = 0; i < daysBetween; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("room_type_id", data.get("room_type_id").toString());
				map.put("beginDate", date1.plusDays(i).toString());
				map.put("lastDayOfMonth", date1.plusDays(i + 1).toString());

				// 把完成拆分的每一筆資料塞回回傳的List
				checkDateList.add(map);

			}

		}

		return checkDateList;
	}

//	public static void main(String[] args) {
//		 LocalDate currentDate = LocalDate.now();
//	        System.out.println("當前日期是: " + currentDate);
//	        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
//	        System.out.println(firstDayOfMonth);
//	        LocalDate lastDayOfMonth = currentDate.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
//	        System.out.println("當前日期的月底是：" + lastDayOfMonth);
//	        LocalDate twoMonthsLater = currentDate.plusMonths(2);
//	        System.out.println(twoMonthsLater);
//	        
//	}

}
