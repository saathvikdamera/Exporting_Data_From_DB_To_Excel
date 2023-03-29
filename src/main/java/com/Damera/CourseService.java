package com.Damera;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository course;
	
	public void generateExcel(HttpServletResponse response) throws Exception {
		
		List<Course> courses = course.findAll();
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Couses Info");
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Price");
		
		int dataRowIndex = 1;
		
		for(Course c : courses) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(c.getCourseId());
			dataRow.createCell(1).setCellValue(c.getCourseName());
			dataRow.createCell(2).setCellValue(c.getPrice());
			dataRowIndex++;
		}
		
		ServletOutputStream os = response.getOutputStream();
		workbook.write(os);
		workbook.close();
		os.close();
		
	}
	

}
