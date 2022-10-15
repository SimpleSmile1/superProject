package com.czw.superProject.CommonUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class FileUtils {
	
	public static File createCSVFile(List<Object> head, List<List<Object>> dataList, String outPutPath, String fileName) {
		File csvFile = null;
		BufferedWriter csvWriter = null;
		try {
			csvFile = new File(outPutPath + File.separator + fileName + ".csv");
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();
			csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile),"GBK"),1024);
			writerRow(head,csvWriter);
			for (List<Object> rowList : dataList) {
				writerRow(rowList, csvWriter);
			}
			csvWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				csvWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return csvFile;
	}
	
	public static void writerRow(List<Object> row, BufferedWriter csvWriter) throws IOException{
		for (Object data : row) {
			StringBuffer sBuffer = new StringBuffer();
			String rowDataString = sBuffer.append("\"").append(data).append("\",").toString();
			csvWriter.write(rowDataString);
		}
		csvWriter.newLine();
	}
}
