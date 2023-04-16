package com.jt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class FileController {
	
	/**
	 * 1.准备文件存储目录
	 * 2.获取文件名称
	 * 3.利用工具API实现文件上传
	 * @param fileImage
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/file")
	public String file(MultipartFile fileImage) throws IllegalStateException, IOException {
		//获取图片名称
		log.info("fileImage==="+fileImage.toString());
		String fileName = fileImage.getOriginalFilename();
		System.out.println("fileName=="+fileName);
		if(fileName.matches("^.*(jpg|png|gif)$")){
			if(fileName.matches("^.*(jpg|png|gif)$")){
				File fileDir = new File("C:/JT-SOFTWARE/images");
				if(!fileDir.exists()) {
					//如果没有目录应该先创建目录
					fileDir.mkdirs();
				}

				String path = fileDir.getPath()+"/"+fileName;

				//文件实现上传
				fileImage.transferTo(new File(path));
			}
			return "文件上传成功!!!!";
		}
		return "上传文件失败，只能传图片格式的";
	}
	
}
