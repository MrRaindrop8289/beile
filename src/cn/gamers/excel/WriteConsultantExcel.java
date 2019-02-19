package cn.gamers.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.gamers.dao.ConsultantDao;
import cn.gamers.domain.Consultant;



public class WriteConsultantExcel {
	public static void WriteExcel(OutputStream out) throws SQLException{
		HSSFWorkbook workbook = new HSSFWorkbook();
		ConsultantDao dao = new ConsultantDao();			
		
		List<Consultant> cl = dao.FindAllConsultant();		
		HSSFSheet sheet = workbook.createSheet("sheet0");
		HSSFRow row0 = sheet.createRow(0);
		for (int cellindex=0; cellindex < 8; cellindex++){			//修改
			HSSFCell cell = row0.createCell(cellindex);
			switch(cellindex){
				case 0:
					cell.setCellValue("搜索时间");
					break;
				case 1:
					cell.setCellValue("签约顾问");
					break;
				case 2:
					cell.setCellValue("合同个数");
					break;
				case 3:
					cell.setCellValue("签约总金额");
					break;
				case 4:
					cell.setCellValue("提成比例");
					break;
					
				case 5:
					cell.setCellValue("现场签约个数");
					break;
				case 6:
					cell.setCellValue("每个奖金");
					break;
				case 7:
					cell.setCellValue("共计奖金");
					break;
				case 8:
					cell.setCellValue("顾问确认");
					break;
				case 9:
					cell.setCellValue("校长确认");
					break;
			}
		}
		
		for (int rowIndex = 1; rowIndex <= cl.size(); rowIndex++){
			HSSFRow row = sheet.createRow(rowIndex);
			Consultant c = cl.get(rowIndex - 1);
			for (int cellIndex = 0; cellIndex < 8; cellIndex++){			//修改
				HSSFCell cell = row.createCell(cellIndex);
				switch(cellIndex){
					case 0:
						cell.setCellValue(c.getSssj());
						break;
					case 1:
						cell.setCellValue(c.getKcgw());
						break;
					case 2:
						cell.setCellValue(c.getHtgs());
						break;
					case 3:
						cell.setCellValue(c.getQyzje());
						break;
					case 4:
						cell.setCellValue(c.getTcbl());
						break;
					case 5:
						cell.setCellValue(c.getXcqy());
						break;
					case 6:
						cell.setCellValue(c.getMgjj());
						break;
					case 7:
						cell.setCellValue(c.getGjjj());
						break;
					case 8:
						if (c.isGwqr()){
							cell.setCellValue("是");
						}else{
							cell.setCellValue("否");
						}
						break;
					case 9:
						if (c.isXzqr()){
							cell.setCellValue("是");
						}else{
							cell.setCellValue("否");
						}
						break;
				}
			}
		}
		
		try{
			workbook.write(out);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
