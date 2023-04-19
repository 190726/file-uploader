package com.sk.file.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {
	
	@PostMapping("/upload1")
	public Response upload1(
			@RequestParam(value = "message") String message,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		log(message, Collections.singletonList(file));
		return new Response("success");
	}
	
	@PostMapping("/upload2")
	public Response upload2(
			@RequestParam(value = "message") String message,
			@RequestParam(value = "file", required = false) MultipartFile[] file) {
		log(message, Arrays.asList(file));
		return new Response("success");
	}
	
	private void log(String message, List<MultipartFile> file) {
		System.out.println(message);
		file.forEach(f ->{
			System.out.println(f.getName());
			System.out.println(f.getSize());
			System.out.println(f.getOriginalFilename());
		});
		
	}
	
	static class Response{
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Response(String message) {
			super();
			this.message = message;
		}
		
	}
}