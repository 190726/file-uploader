package com.sk.file.api;

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
		System.out.println(message);
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getResource());
		return new Response("success");
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