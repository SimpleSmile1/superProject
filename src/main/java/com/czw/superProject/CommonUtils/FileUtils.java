package com.czw.superProject.CommonUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.springframework.core.io.ClassPathResource;

import com.czw.superProject.Constants.ProConstants;
import com.itextpdf.awt.geom.misc.RenderingHints.Key;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class FileUtils {
	
	public static File createCSVFile(List<Object> head, List<List<Object>> dataList, String outPutPath, String fileName) {
		File csvFile = null;
		BufferedWriter csvWriter = null;
		try {
			csvFile = new File(outPutPath + File.separator + fileName + ProConstants.CSV);
			File parent = csvFile.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			csvFile.createNewFile();
			csvWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile),ProConstants.GBK),1024);
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
		StringBuffer sBuffer = new StringBuffer();
		for (Object data : row) {
			sBuffer = sBuffer.append(ProConstants.QUOTES).append(data).append(ProConstants.QUOTES).append(ProConstants.COMMA);
		}
		sBuffer.replace(sBuffer.length()-1, sBuffer.length(), ProConstants.BLANK);
		csvWriter.write(sBuffer.toString());
		csvWriter.newLine();
	}

	public static File createPdfFile(Map<String, Object> data, String outPutPath, String fileName) {
//		ClassPathResource classPathResource = new ClassPathResource(ProConstants.TEMPLATE + "汽车维修.pdf");
//		String inputPath = classPathResource.getPath();
		String inputPath = "D:\\workspace\\superProject\\src\\main\\resources\\templates\\汽车维修.pdf";
		File pdfFile = null;
		OutputStream os = null;
		PdfStamper ps = null;
		PdfReader reader = null;
		try {
			os = new FileOutputStream(outPutPath + File.separator + fileName + ".pdf");
			reader = new PdfReader(inputPath);
			ps = new PdfStamper(reader, os);
			BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
			AcroFields form = ps.getAcroFields();
			form.addSubstitutionFont(bf);
			for (String key : data.keySet()) {
				form.setField(key, String.valueOf(data.get(key)));
			}
			ps.setFormFlattening(true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				reader.close();
				os.close();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pdfFile;
	}
}
