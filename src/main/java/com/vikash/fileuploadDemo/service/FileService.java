package com.vikash.fileuploadDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikash.fileuploadDemo.entites.FileDetails;
import com.vikash.fileuploadDemo.ripo.FileRepo;

@Service
public class FileService {
	@Autowired
	private FileRepo fileRepo;
	public FileDetails saveFile( FileDetails file) {
		return fileRepo.save(file);
	}
	public List<FileDetails> findAllImage(){
		return fileRepo.findAll();
	}

}
