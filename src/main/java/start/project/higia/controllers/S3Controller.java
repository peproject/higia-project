package start.project.higia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import start.project.higia.services.S3Service;

@Controller
public class S3Controller {

	@Autowired
	private S3Service s3Service;

	@RequestMapping(value = "/upload", headers = "Content-Type= multipart/form-data", method = RequestMethod.POST)
	public ResponseEntity<String> upload(@RequestParam(value = "file") MultipartFile file) {
		return new ResponseEntity<>(s3Service.uploadFile(file), HttpStatus.OK);
	}

	@GetMapping("/photo")
	public String uploadPhoto() {
		return "photo";
	}
}
