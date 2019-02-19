package cn.gamers.test;

import org.apache.commons.fileupload.FileUploadException;

import cn.gamers.excel.ReadWriteStudentExcel;

public class StudentExcelTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadWriteStudentExcel rwse = new ReadWriteStudentExcel();
		try{
			rwse.readExcel("F:\\Excel Test Temp", "1521.xlsx");
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
