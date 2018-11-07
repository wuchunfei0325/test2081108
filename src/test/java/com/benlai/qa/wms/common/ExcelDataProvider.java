package com.benlai.qa.wms.common;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelDataProvider {
	private Workbook book = null;
	private Sheet sheet = null;
	private int rowNum = 0;
	private int currentRowNo = 0;
	private int columnNum = 0;
	private String[] columnnName;

	// 重构构造函数，将待测试类名和方法名传入函数
	public ExcelDataProvider(String classname, String methodname) {

		try {

			int dotNum = classname.indexOf(".");

			if (dotNum > 0) {
				classname = classname.substring(classname.lastIndexOf(".") + 1, classname.length());
			}
			// 从/data文件夹下读取以类名命名的excel文件
			String path = "data/" + classname + ".xls";
			InputStream inputStream = new FileInputStream(path);

			book = Workbook.getWorkbook(inputStream);
			// 取sheet
			sheet = book.getSheet(methodname);
			rowNum = sheet.getRows();
			Cell[] cell = sheet.getRow(0);
			columnNum = cell.length;
			columnnName = new String[cell.length];

			for (int i = 0; i < cell.length; i++) {
				columnnName[i] = cell[i].getContents().toString();
			}
			this.currentRowNo++;

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("unable to read Excel data");
		}
	}

	// 判断Excel表中是否存在下一行数据
	public boolean hasNext() {

		if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {
			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		} else {
			// sheet下一行内容为空判定结束
			if ((sheet.getRow(currentRowNo))[0].getContents().equals(""))
				return false;
			return true;
		}
	}

	// 读取Excel中某一行数据，并为下一行做准备
	public List<String> getdata_list() {

		Cell[] c = sheet.getRow(this.currentRowNo);
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < this.columnNum; i++) {
			String temp = "";
			try {
				temp = c[i].getContents().toString();
			} catch (ArrayIndexOutOfBoundsException ex) {
				temp = "";
			}
			if (temp != null && !temp.equals(""))
				list.add(temp);
		}

		this.currentRowNo++;
		return list;
	}

	public void remove() {
		throw new UnsupportedOperationException("remove unsupported.");
	}
	
	public  static List<String>  readExcel() {
		String url="";
		String name = "";
		String psd = "";
	    String realname = "";
		String class_name = "Login";
		String method_name = "benlai_login";
		List<String> info_list=null;
		ExcelDataProvider excel_driver = new ExcelDataProvider(class_name, method_name);

		while (excel_driver.hasNext() == true) {
			info_list= excel_driver.getdata_list();
			int info_size = info_list.size();
/*
			for (int i = 0; i < info_size; i++) {
				url=info_list.get(0);
				name = info_list.get(1);
				psd = info_list.get(2);
				realname = info_list.get(3);
				
			}*/
			//System.out.println(ErrorUser + " " + ErrorPwd + " " + RightUser + " " + RightPwd + " " + RUser);
			
		}
		return info_list;
	}
}
