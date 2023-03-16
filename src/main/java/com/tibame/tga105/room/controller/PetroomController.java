package com.tibame.tga105.room.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tibame.tga105.room.dto.PetroomRequest;
import com.tibame.tga105.room.model.PetroomVo;
import com.tibame.tga105.room.service.PetroomService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PetroomController {

	@Autowired
	private PetroomService petroomService;

	// =============新增房型===========
	@PostMapping("/petrooms/createroom")
		public PetroomVo createPetroom(
				@RequestBody @Valid PetroomRequest petroomRequest) throws IOException {
		
		//接收前端傳入的圖片
		byte[] image1 = Base64.getMimeDecoder().decode(petroomRequest.getRoomPic1().substring(petroomRequest.getRoomPic1().indexOf(",") + 1));
		byte[] image2 = Base64.getMimeDecoder().decode(petroomRequest.getRoomPic2().substring(petroomRequest.getRoomPic2().indexOf(",") + 1));
		byte[] image3 = Base64.getMimeDecoder().decode(petroomRequest.getRoomPic3().substring(petroomRequest.getRoomPic3().indexOf(",") + 1));
		
		petroomRequest.setImage1(image1);
		petroomRequest.setImage2(image2);
		petroomRequest.setImage3(image3);
		
		

		//====================================

		Integer roomTypeId = petroomService.createPetroom(petroomRequest);

		PetroomVo petroomVo = petroomService.getPetroomById(roomTypeId);

		return petroomVo;
	}

	//===========修改房型=================
	@PutMapping("/petrooms/{roomTypeId}")
	public ResponseEntity<PetroomVo> updatePetroom(@PathVariable Integer roomTypeId,
			@RequestBody @Valid PetroomRequest petroomRequest) {

		// 先查詢這房型是否存在
		PetroomVo petroomVo = petroomService.getPetroomById(roomTypeId);

		if (petroomVo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		byte[] image1 = Base64.getMimeDecoder().decode(petroomRequest.getRoomPic1().substring(petroomRequest.getRoomPic1().indexOf(",") + 1));
		byte[] image2 = Base64.getMimeDecoder().decode(petroomRequest.getRoomPic2().substring(petroomRequest.getRoomPic2().indexOf(",") + 1));
		byte[] image3 = Base64.getMimeDecoder().decode(petroomRequest.getRoomPic3().substring(petroomRequest.getRoomPic3().indexOf(",") + 1));
		
		petroomRequest.setImage1(image1);
		petroomRequest.setImage2(image2);
		petroomRequest.setImage3(image3);

		// 修改房型的詳細數據
		petroomService.updatePetroom(roomTypeId, petroomRequest);

		PetroomVo updatePetroom = petroomService.getPetroomById(roomTypeId);

		return ResponseEntity.status(HttpStatus.OK).body(updatePetroom);
	}

	// ================查詢所有房型==============
	@GetMapping("/petrooms")
	public ResponseEntity<List<PetroomVo>> getPetrooms() {
		
		List<PetroomVo> petroomList = petroomService.getPetrooms();
		
		return ResponseEntity.status(HttpStatus.OK).body(petroomList);

	}

	// =============查詢單筆房型詳細===================
	@GetMapping("/petrooms/{roomTypeId}")
	public ResponseEntity<PetroomVo> getPetroom(@PathVariable Integer roomTypeId) {

		PetroomVo petroomVo = petroomService.getPetroomById(roomTypeId);

		if (petroomVo != null) {
			return ResponseEntity.status(HttpStatus.OK).body(petroomVo);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	// =================查詢單張房型圖片=============
	@GetMapping("/image1/{roomTypeId}")
	public void showImg(@PathVariable Integer roomTypeId, HttpServletResponse res, PetroomVo petroomVo)
			throws IOException {

		petroomVo = petroomService.getPetroomById(roomTypeId);
		res.setContentType("image/jped, image/jpg, image/png, image/gif");
		res.getOutputStream().write(petroomVo.getRoomPic1());
		res.getOutputStream().close();

	}

	@GetMapping("/image2/{roomTypeId}")
	public void showImg2(@PathVariable Integer roomTypeId, HttpServletResponse res, PetroomVo petroomVo)
			throws IOException {

		petroomVo = petroomService.getPetroomById(roomTypeId);
		res.setContentType("image/jped, image/jpg, image/png, image/gif");
		res.getOutputStream().write(petroomVo.getRoomPic2());
		res.getOutputStream().close();

	}

	@GetMapping("/image3/{roomTypeId}")
	public void showImg3(@PathVariable Integer roomTypeId, HttpServletResponse res, PetroomVo petroomVo)
			throws IOException {

		petroomVo = petroomService.getPetroomById(roomTypeId);
		res.setContentType("image/jped, image/jpg, image/png, image/gif");
		res.getOutputStream().write(petroomVo.getRoomPic3());
		res.getOutputStream().close();

	}

}
