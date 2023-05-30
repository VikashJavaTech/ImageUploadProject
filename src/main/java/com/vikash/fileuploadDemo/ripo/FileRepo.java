package com.vikash.fileuploadDemo.ripo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikash.fileuploadDemo.entites.FileDetails;


public interface FileRepo extends JpaRepository<FileDetails, Integer> {

}
