package com.vikash.fileuploadDemo.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDetails {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	

}
