package com.Damera;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Course {
	
	@Id
	private Integer courseId;
	private String courseName;
	private Double price;

}
