package com.site.util;

import com.site.exception.DocumentProcessingException;
import lombok.experimental.UtilityClass;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static com.site.ApplicationConstant.EMPTY;

@UtilityClass
public class WordUtil {

	public static byte[] convert(Object[][] tableData) {
		try (XWPFDocument document = new XWPFDocument();
		     ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

			XWPFTable table = document.createTable(tableData.length, tableData[0].length);

			for (int rowIndex = 0; rowIndex < tableData.length; rowIndex++) {
				XWPFTableRow row = table.getRow(rowIndex);
				for (int cellIndex = 0; cellIndex < tableData[rowIndex].length; cellIndex++) {
					String value = tableData[rowIndex][cellIndex] == null
							? EMPTY
							: tableData[rowIndex][cellIndex].toString();
					row.getCell(cellIndex).setText(value);
				}
			}

			document.write(outputStream);
			byte[] result = outputStream.toByteArray();

			document.close();
			outputStream.close();

			return result;
		} catch (IOException ex) {
			throw new DocumentProcessingException("Error processing Word document");
		}
	}
}