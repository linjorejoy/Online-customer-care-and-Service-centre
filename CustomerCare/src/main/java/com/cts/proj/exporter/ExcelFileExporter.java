package com.cts.proj.exporter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cts.proj.model.Complaint;

public class ExcelFileExporter {
	public static ByteArrayInputStream complaintToExcel(Complaint complaint) {
		try (Workbook workbook = new XSSFWorkbook()) {

			Sheet sheet = workbook.createSheet("complaint");

			Row row0 = sheet.createRow(0);
			Cell cell = row0.createCell(0);
			cell.setCellValue("Complaint ID");
			cell = row0.createCell(1);
			cell.setCellValue(complaint.getComplaintId());

			Row row1 = sheet.createRow(1);
			cell = row1.createCell(0);
			cell.setCellValue("User ID");
			cell = row1.createCell(1);
			cell.setCellValue(complaint.getUser().getUserId());

			Row row2 = sheet.createRow(2);
			cell = row2.createCell(0);
			cell.setCellValue("Analyst ID");
			cell = row2.createCell(1);
			cell.setCellValue(complaint.getAnalyst().getAnalystId());

			Row row3 = sheet.createRow(3);
			cell = row3.createCell(0);
			cell.setCellValue("Phone Number");
			cell = row3.createCell(1);
			cell.setCellValue(complaint.getPhoneNumber());

			Row row4 = sheet.createRow(4);
			cell = row4.createCell(0);
			cell.setCellValue("Email ID");
			cell = row4.createCell(1);
			cell.setCellValue(complaint.getUser().getEmailId());

			Row row5 = sheet.createRow(5);
			cell = row5.createCell(0);
			cell.setCellValue("Category");
			cell = row5.createCell(1);
			cell.setCellValue(complaint.getCategory());

			Row row6 = sheet.createRow(6);
			cell = row6.createCell(0);
			cell.setCellValue("Status");
			cell = row6.createCell(1);
			cell.setCellValue(complaint.getStatus());

			Row row7 = sheet.createRow(7);
			cell = row7.createCell(0);
			cell.setCellValue("Description");
			cell = row7.createCell(1);
			cell.setCellValue(complaint.getDescription());

			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			return new ByteArrayInputStream(outputStream.toByteArray());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
