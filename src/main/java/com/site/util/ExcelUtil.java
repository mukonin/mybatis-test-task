package com.site.util;

import com.site.exception.DocumentProcessingException;
import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.site.ApplicationConstant.EMPTY;

@UtilityClass
public class ExcelUtil {

	public static byte[] convert(Object[][] table) {

		try (XSSFWorkbook workbook = new XSSFWorkbook();
		     ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

			XSSFSheet sheet = workbook.createSheet();

			mapToSheet(table, sheet);

			workbook.write(outputStream);
			byte[] result = outputStream.toByteArray();

			workbook.close();
			outputStream.close();

			return result;
		} catch (IOException ex) {
			throw new DocumentProcessingException("Error processing Excel document");
		}
	}

	private static void mapToSheet(Object[][] table, XSSFSheet sheet) {
		for (int rowIndex = 0; rowIndex < table.length; rowIndex++) {
			Row row = sheet.createRow(rowIndex);
			for (int cellIndex = 0; cellIndex < table[rowIndex].length; cellIndex++) {
				Cell cell = row.createCell(cellIndex);
				Object cellData = table[rowIndex][cellIndex];
				setCellValue(cell, cellData);
			}
		}
	}

	private static void setCellValue(Cell cell, Object cellData) {
		if (cellData == null) {
			cell.setCellValue(EMPTY);
		} else if (cellData instanceof String) {
			cell.setCellValue((String) cellData);
		} else if (cellData instanceof Integer) {
			cell.setCellValue((Integer) cellData);
		} else {
			throw new IllegalArgumentException("Excell cell data type " + cellData.getClass() + "not supported");
		}
	}
}