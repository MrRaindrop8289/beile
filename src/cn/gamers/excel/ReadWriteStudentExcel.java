package cn.gamers.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.gamers.dao.StudentDao;
import cn.gamers.dao.TclassDao;
import cn.gamers.domain.Student;
import cn.gamers.domain.T_Class;

public class ReadWriteStudentExcel {
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
	public static int readExcel(String path,String name) throws Exception{
		
		
		
		String fileName = path + "\\" + name;
		
		/*修改*/
		
		Workbook workbook = null;
		try{
			File excelFile = new File(fileName);
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
			List<CellRangeAddress> cras = getCombineCell(sheet);  
			
			
			Row row;
			Cell cell;
			int rows = sheet.getLastRowNum();
			StudentDao Sdao = new StudentDao();
			TclassDao Tdao = new TclassDao();
			for (int irow = 2; irow <= rows; irow++){
				row = sheet.getRow(irow);
				Student s = new Student();
				for (int j = 0; j < 9 ;j++){
					if (j == 7){
						Sdao.AddStudent(s);
					}
					if (!isMergedRegion(sheet,irow,j)){
						
						int lastRow = getRowNum(cras,sheet.getRow(irow).getCell(0),sheet);

						for (;irow < lastRow; irow++){
							row = sheet.getRow(irow);
							T_Class tl = new T_Class();
							tl.setId(Sdao.FindMaxId());
//							if(HSSFDateUtil.isCellDateFormatted(row.getCell(7))){
//								
//							}
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
							Date date = row.getCell(7).getDateCellValue();
							System.out.println(sdf.format(date));
							tl.setTtime(sdf.format(date));
							row.getCell(8).setCellType(CellType.STRING);
							tl.setResult(row.getCell(8).getStringCellValue());
							Tdao.AddClass(tl);
						}
					}else{
						cell = row.getCell(j);
							switch(j){
							case 0:
								cell.setCellType(CellType.STRING);
								String m = cell.getStringCellValue();
								s.setShuju_ly(m);
								break;
							case 1:
								cell.setCellType(CellType.STRING);
								String m1 = cell.getStringCellValue();
								s.setName(m1);
								break;
							case 2:
								cell.setCellType(CellType.STRING);
								String m2 = cell.getStringCellValue();
								s.setPhone(m2);
								break;
							case 3:
								cell.setCellType(CellType.STRING);
								String m3 = cell.getStringCellValue();
								s.setGrade(m3);
								break;
							case 4:
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
				                Date date = cell.getDateCellValue();
								s.setNext_time(sdf.format(date));
								break;
							case 5:
								cell.setCellType(CellType.STRING);
								String m4 = cell.getStringCellValue();
								s.setContent(m4);
								break;
							case 6:
								cell.setCellType(CellType.STRING);
								String m5 = cell.getStringCellValue();
								if (m5.equals("1")){
									s.setPoint(true);
								}else{
									s.setPoint(false);
								}
								break;
							}
					}
				}

			}
			return rows - 3;
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static void WriteExcel(OutputStream out) throws SQLException{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("sheet0");
		HSSFRow row0 = sheet.createRow(0);
		StudentDao Sdao = new StudentDao();			//修改
		TclassDao Tdao = new TclassDao();
		List<Student> sl = Sdao.FindAllStudent();		//修改
		for (int cellindex=0; cellindex < 9; cellindex++){			//修改
			HSSFCell cell = row0.createCell(cellindex);
			switch(cellindex){
				case 0:
					cell.setCellValue("渠道");
					break;
				case 1:
					cell.setCellValue("姓名");
					break;
				case 2:
					cell.setCellValue("联系方式");
					break;
				case 3:
					cell.setCellValue("年纪");
					break;
				case 4:
					cell.setCellValue("下次预约时间");
					break;
				case 5:
					cell.setCellValue("沟通内容");
					break;
				case 6:
					cell.setCellValue("重点");
					break;
				case 7:
					cell.setCellValue("试听时间");
					break;
				case 8:
					cell.setCellValue("试听结果");
					break;
			}
		}
		Student s = sl.get(0);
		List<T_Class> tcl = Tdao.FindClassById(s.getId());
		int rowIndex = 1;
		for (int rowIndexS = 0; rowIndexS < sl.size(); rowIndexS++){
			HSSFRow row = sheet.createRow(rowIndex);
			s = sl.get(rowIndexS);
			System.out.println("Scount:" + rowIndexS);
			tcl = Tdao.FindClassById(s.getId());
			
			int End = rowIndex;
			if(tcl.size() > 1){
				End = rowIndex + tcl.size() - 1;


				System.out.println("rowIndex:" + rowIndex);
				System.out.println("!:" + s.getShuju_ly());
				CellRangeAddress c0 = new CellRangeAddress(rowIndex,End,0,0);
				sheet.addMergedRegion(c0);
				
				CellRangeAddress c1 = new CellRangeAddress(rowIndex,End,(short)1,(short)1);
				sheet.addMergedRegion(c1);
				
				CellRangeAddress c2 = new CellRangeAddress(rowIndex,End,(short)2,(short)2);
				sheet.addMergedRegion(c2);
				CellRangeAddress c3 = new CellRangeAddress(rowIndex,End,(short)3,(short)3);
				sheet.addMergedRegion(c3);
				
				CellRangeAddress c4 = new CellRangeAddress(rowIndex,End,(short)4,(short)4);
				sheet.addMergedRegion(c4);
				
				CellRangeAddress c5 = new CellRangeAddress(rowIndex,End,(short)5,(short)5);
				sheet.addMergedRegion(c5);
				
			
				CellRangeAddress c6 = new CellRangeAddress(rowIndex,End,(short)6,(short)6);
				sheet.addMergedRegion(c6);
				

				row.createCell(0).setCellValue(s.getShuju_ly());
				row.createCell(1).setCellValue(s.getName());
				row.createCell(2).setCellValue(s.getPhone());
				row.createCell(3).setCellValue(s.getGrade());
				row.createCell(4).setCellValue(s.getNext_time());
				row.createCell(5).setCellValue(s.getContent());
				row.createCell(6).setCellValue(s.getContent());
				int max = rowIndex + tcl.size();
				
				int l = rowIndex;
				for (; rowIndex < max; rowIndex++){
					
					System.out.println(s.getId());
					
					
					row.createCell(0).setCellValue(s.getShuju_ly());
					row.createCell(1).setCellValue(s.getName());
					row.createCell(2).setCellValue(s.getPhone());
					row.createCell(3).setCellValue(s.getGrade());
					if(s.getNext_time() != null){
						try{
							row.createCell(4).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(
									new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s.getNext_time())));
						} catch (ParseException e) {  
				            e.printStackTrace();  
				        } 
					}else{
						row.createCell(4).setCellValue("无");
					}
					row.createCell(5).setCellValue(s.getContent());
					if (s.isPoint()){
						row.createCell(6).setCellValue("是");
					}else{
						row.createCell(6).setCellValue("否");
					}
					
					 Row r1 = sheet.createRow(rowIndex);
					 if(tcl.get(rowIndex - l).getTtime() != null){
						 try{
							 r1.createCell(7).setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(
										new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tcl.get(rowIndex - l).getTtime())));			
							} catch (ParseException e) {  
					            e.printStackTrace();  
					        } 
					 }else{
						 r1.createCell(7).setCellValue("null");
					 }
					 r1.createCell(8).setCellValue(tcl.get(rowIndex - l).getResult());
				}
			}else{
				row.createCell(0).setCellValue(s.getShuju_ly());
				row.createCell(1).setCellValue(s.getName());
				row.createCell(2).setCellValue(s.getPhone());
				row.createCell(3).setCellValue(s.getGrade());
				row.createCell(4).setCellValue(s.getNext_time());
				row.createCell(5).setCellValue(s.getContent());
				if (s.isPoint()){
					row.createCell(6).setCellValue("是");
				}else{
					row.createCell(6).setCellValue("否");
				}
				if(tcl.size() == 1){
					 try{
						 row.createCell(7).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(
									new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tcl.get(0).getTtime())));			
					} catch (ParseException e) {  
			            e.printStackTrace();  
			        } 
					row.createCell(8).setCellValue(tcl.get(0).getResult());
				}else{
					row.createCell(7).setCellValue("无");
					row.createCell(8).setCellValue("无");
				}
				rowIndex++;
			}
			System.out.println("End:" + End);
			System.out.println("rowIndex:" + rowIndex);
			
			
			
		}
		
		try{
			workbook.write(out);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	/**  
	    * 合并单元格处理,获取合并行  
	    * @param sheet  
	    * @return List<CellRangeAddress>  
	    */    
	    public static List<CellRangeAddress> getCombineCell(Sheet sheet)    
	    {    
	        List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();    
	        //获得一个 sheet 中合并单元格的数量    
	        int sheetmergerCount = sheet.getNumMergedRegions();    
	        //遍历所有的合并单元格    
	        for(int i = 0; i<sheetmergerCount;i++)     
	        {    
	            //获得合并单元格保存进list中    
	            CellRangeAddress ca = sheet.getMergedRegion(i);    
	            list.add(ca);    
	        }    
	        return list;    
	    }  
	      
	    private static int getRowNum(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet){  
	        int xr = 0;  
	        int firstC = 0;    
	        int lastC = 0;    
	        int firstR = 0;    
	        int lastR = 0;    
	        for(CellRangeAddress ca:listCombineCell)    
	        {  
	            //获得合并单元格的起始行, 结束行, 起始列, 结束列    
	            firstC = ca.getFirstColumn();    
	            lastC = ca.getLastColumn();    
	            firstR = ca.getFirstRow();    
	            lastR = ca.getLastRow();    
	            if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)     
	            {    
	                if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)     
	                {    
	                    xr = lastR;  
	                }   
	            }    
	              
	        }  
	        return xr;  
	          
	    }  
	    /**  
	     * 判断单元格是否为合并单元格，是的话则将单元格的值返回  
	     * @param listCombineCell 存放合并单元格的list  
	     * @param cell 需要判断的单元格  
	     * @param sheet sheet  
	     * @return  
	     */   
	     public String isCombineCell(List<CellRangeAddress> listCombineCell,Cell cell,Sheet sheet)  
	     throws Exception{   
	         int firstC = 0;    
	         int lastC = 0;    
	         int firstR = 0;    
	         int lastR = 0;    
	         String cellValue = null;    
	         for(CellRangeAddress ca:listCombineCell)    
	         {  
	             //获得合并单元格的起始行, 结束行, 起始列, 结束列    
	             firstC = ca.getFirstColumn();    
	             lastC = ca.getLastColumn();    
	             firstR = ca.getFirstRow();    
	             lastR = ca.getLastRow();    
	             if(cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR)     
	             {    
	                 if(cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC)     
	                 {    
	                     Row fRow = sheet.getRow(firstR);    
	                     Cell fCell = fRow.getCell(firstC);  
	                     fCell.setCellType(CellType.STRING);
	                     cellValue = fCell.getStringCellValue();  
	                     break;    
	                 }   
	             }    
	             else    
	             {    
	                 cellValue = "";    
	             }    
	         }    
	         return cellValue;    
	     }  
	      
	      
	      
	    /**   
	    * 判断指定的单元格是否是合并单元格   
	    * @param sheet    
	    * @param row 行下标   
	    * @param column 列下标   
	    * @return   
	    */    
	    private static boolean isMergedRegion(Sheet sheet,int row ,int column) {    
	      int sheetMergeCount = sheet.getNumMergedRegions();    
	      for (int i = 0; i < sheetMergeCount; i++) {    
	        CellRangeAddress range = sheet.getMergedRegion(i);    
	        int firstColumn = range.getFirstColumn();    
	        int lastColumn = range.getLastColumn();    
	        int firstRow = range.getFirstRow();    
	        int lastRow = range.getLastRow();    
	        if(row >= firstRow && row <= lastRow){    
	            if(column >= firstColumn && column <= lastColumn){    
	                return true;    
	            }    
	        }  
	      }    
	      return false;    
	    }  
}
