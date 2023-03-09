package com.tibame.tga105.shop.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/productimages")
public class ProductImageController {

	@GetMapping("/{imageName}")
	public ResponseEntity<byte[]> select(@PathVariable String imageName) {
		if (imageName == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			// 讀取圖像檔案
			File imageFile = new File("C:\\MoLife\\image\\" + imageName);
			BufferedImage image = ImageIO.read(imageFile);

			// 將圖像資料轉換成byte陣列
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpeg", baos);
			byte[] imageData = baos.toByteArray();

			// 設定回傳的內容類型為image/jpeg
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);

			// 回傳ResponseEntity
			return new ResponseEntity<byte[]>(imageData, headers, HttpStatus.OK);

		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public String insert(MultipartFile image) {
		if (image != null) {
			String originaName = image.getOriginalFilename();
			String suffix = originaName.substring(originaName.lastIndexOf("."));
			// UUID
			String imageName = UUID.randomUUID().toString() + suffix;

			File dir = new File("C:\\MoLife\\image");
			if (!dir.exists()) {
				dir.mkdirs();
			}

			try {
				image.transferTo(new File(dir, imageName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return imageName;
		}
		return null;
	}
}
