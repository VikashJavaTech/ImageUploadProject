package com.vikash.fileuploadDemo.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vikash.fileuploadDemo.entites.FileDetails;
import com.vikash.fileuploadDemo.service.FileService;

@Controller
public class FileUploadController {

	@Autowired
	private FileService fileService;

	@GetMapping("/")
	public String formdetails(Model m) {
		m.addAttribute("list",fileService.findAllImage());
		return "form";
	}

	@PostMapping("/upload")
	public String imageupload(@RequestParam MultipartFile img, HttpSession session) {

		FileDetails im = new FileDetails();
		im.setName(img.getOriginalFilename());
		FileDetails upimg = fileService.saveFile(im);
		if (upimg != null) {
			try {
				File savefile = new ClassPathResource("static/images").getFile();
				Path path = Paths.get(savefile.getAbsolutePath() + File.separator + img.getOriginalFilename());
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		session.setAttribute("msg", "image Uploading successfully");
		return "redirect:/";
	}

}
