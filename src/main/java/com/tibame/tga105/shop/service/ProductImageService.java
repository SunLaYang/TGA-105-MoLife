package com.tibame.tga105.shop.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ProductImageService {

	@Value("${product.image.directory}")
	private String imageDirectory;

	@Resource(name = "productRedisTemplate")
	private RedisTemplate<String, byte[]> redisTemplate;

	public byte[] getImage(String imageName) throws IOException {
		byte[] imageBytes = redisTemplate.opsForValue().get(imageName);

		if (imageBytes == null) {
			File imageFile = new File(imageDirectory + imageName);
			BufferedImage image = ImageIO.read(imageFile);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpeg", baos);
			imageBytes = baos.toByteArray();

			redisTemplate.opsForValue().set(imageName, imageBytes);
		}
		return imageBytes;
	}

	public String saveImage(MultipartFile image) throws IOException {
		String originaName = image.getOriginalFilename();
		String suffix = originaName.substring(originaName.lastIndexOf("."));
		String imageName = UUID.randomUUID().toString() + suffix;

		File dir = new File(imageDirectory);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		image.transferTo(new File(dir, imageName));

		return imageName;
	}

}
