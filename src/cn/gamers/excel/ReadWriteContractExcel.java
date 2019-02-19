package cn.gamers.excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.gamers.dao.ContractDao;
import cn.gamers.domain.Contract;


public class ReadWriteContractExcel {
	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";
	
	public static Workbook getWorkbook(InputStream in, File file) throws IOException{
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL_XLS)){
			wb = new HSSFWorkbook(in);
		}else if (file.getName().endsWith(EXCEL_XLSX)){
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}
	
	public static void checkExcelVaild(File file) throws Exception{
		if (!file.exists()){
			throw new Exception("文件不存在");
		}
		if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){
			throw new Exception("文件不是Excel");
		}
	}
	
	@SuppressWarnings("finally")
	public static void readExcel(String path,String name) throws Exception{
		
		String fileName = path + "\\" + name;
		
		/*修改*/
		
		Workbook workbook = null;
		try{
			File excelFile = new File(fileName);
			FileInputStream is = new FileInputStream(excelFile);
			checkExcelVaild(excelFile);
			try {  
		        workbook = new HSSFWorkbook(new FileInputStream(excelFile));  
		} catch (OfficeXmlFileException e) {  
		    try {  
		        workbook = new XSSFWorkbook(new FileInputStream(excelFile));  
		    } catch (Exception e2) {  
		        /** 
		         * 此时就是真正的异常啦 
		         */  
		    }  
		} catch (Exception e) {  
		    /** 
		     * 此时就是真正的异常啦 
		     */  
		}
			
		/*修改*/	
			int sheetCount = workbook.getNumberOfSheets();
			System.out.println(sheetCount);
			Sheet sheet = workbook.getSheetAt(0);
			Row row;
			Cell cell;
			int rows = sheet.getLastRowNum();
			for (int irow = 2; irow <= rows; irow++){
				row = sheet.getRow(irow);
				int line = row.getPhysicalNumberOfCells();
				Contract c = new Contract();
				for (int j = 0; j < line ;j++){
					cell = row.getCell(j);
					cell.setCellType(CellType.STRING);
					String m = cell.getStringCellValue();
					if (m != null && !m.equals("")){
						switch(j){
						case 0:
							c.setType(m);
							break;
						case 1:
							c.setName(m);
							break;
						case 2:
							c.setTclass(m);
							break;
						case 3:
							c.setLevel(m);
							break;
						case 4:
							c.setCmoney(m);
							break;
						case 5:
							c.setCon(m);
							break;
						case 6:
							if (m.equals("1")){
								c.setIsprincipal(true);
							}else{
								c.setIsprincipal(false);
							}
							break;
						}
					}
				}c.setIsnow(false);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				c.setDate(sdf.format(new Date()));
				
				ContractDao dao = new ContractDao();
				dao.AddContract(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void WriteExcel(OutputStream out) throws SQLException{
		HSSFWorkbook workbook = new HSSFWorkbook();
		ContractDao dao = new ContractDao();			//修改
		
		List<Contract> cl = dao.FindAllContract();		//修改
		HSSFSheet sheet = workbook.createSheet("sheet0");
		HSSFRow row0 = sheet.createRow(0);
		for (int cellindex=0; cellindex < 8; cellindex++){			//修改
			HSSFCell cell = row0.createCell(cellindex);
			switch(cellindex){
				case 0:
					cell.setCellValue("合同日期");
					break;
				case 1:
					cell.setCellValue("合同类型");
					break;
				case 2:
					cell.setCellValue("姓名");
					break;
				case 3:
					cell.setCellValue("班型");
					break;
				case 4:
					cell.setCellValue("级别");
					break;
				case 5:
					cell.setCellValue("合同金额");
					break;
				case 6:
					cell.setCellValue("签约顾问");
					break;
				case 7:
					cell.setCellValue("校长确认");
					break;
			}
		}
		
		for (int rowIndex = 1; rowIndex <= cl.size(); rowIndex++){
			HSSFRow row = sheet.createRow(rowIndex);
			Contract c = cl.get(rowIndex - 1);
			for (int cellIndex = 0; cellIndex < 8; cellIndex++){			//修改
				HSSFCell cell = row.createCell(cellIndex);
				switch(cellIndex){
					case 0:
						try{
							cell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(
									new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(c.getDate())));			
						} catch (ParseException e) {  
				            e.printStackTrace();  
				        } 
						break;
					case 1:
						cell.setCellValue(c.getType());
						break;
					case 2:
						cell.setCellValue(c.getName());
						break;
					case 3:
						cell.setCellValue(c.getTclass());
						break;
					case 4:
						cell.setCellValue(c.getLevel());
						break;
					case 5:
						cell.setCellValue(c.getCmoney());
						break;
					case 6:
						cell.setCellValue(c.getCon());
						break;
					case 7:
						if (c.isIsprincipal()){
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
