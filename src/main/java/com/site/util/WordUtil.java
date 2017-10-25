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

			if (tableData.length > 0) {

				XWPFTable table = document.createTable(0, tableData[0].length);

				for (Object[] aTableData : tableData) {
					XWPFTableRow row = table.createRow();
					for (int cellIndex = 0; cellIndex < aTableData.length; cellIndex++) {
						String value = aTableData[cellIndex] == null
								? EMPTY
								: aTableData[cellIndex].toString();
						row.getCell(cellIndex).setText(value);
					}
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