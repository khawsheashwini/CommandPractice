package com.jbk.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;

import jxl.Sheet;
import jxl.Workbook;

public class UtilityCls {
	public static int WaitTime=30;
	
	public void clearText(WebElement ele) {
		ele.clear();
	}
//email.clear();.......cleraText(email);
	
	public void click(WebElement ele) {
		ele.click();
	}
	
	public void sendkeysToEnterData(WebElement ele,String data) {
		ele.sendKeys(data);
	}
	
	public String getTextData(WebElement ele) {
		return ele.getText();
		
	}
	
	public ArrayList<String> readDataOdCol(String fileName,String sheetName,int colNo) throws Exception{
		ArrayList<String> expList=new ArrayList<>();
		FileInputStream fis=new FileInputStream(fileName);
		Workbook wb=Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet(sheetName);
		int row=sh.getRows();
		for(int i=1;i<row;i++) {
			expList.add(sh.getCell(colNo, i).getContents());
		}
		System.out.println(expList);
		return expList;
	}
	
	//readDataOdCol("excel.xls","sheet1",2)
	
	public static void waitBeforeCloseBrowser() throws Exception {
		Thread.sleep(WaitTime);
	}
	
}
