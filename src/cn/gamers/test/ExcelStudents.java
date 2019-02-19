package cn.gamers.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import cn.gamers.excel.ReadWriteStudentExcel;

public class ExcelStudents {
    public static void main(String[] args) {  
    	OutputStream out = null;
		File f = new File("C:\\Excel Test Temp\\12345123167.xls");
		if (!f.exists()){
			try{
				f.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		System.out.println(f.getAbsolutePath());
		try{
			out = new FileOutputStream(f);
			ReadWriteStudentExcel.WriteExcel(out);
		}catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            if(out !=null){
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
		f.delete();
    }  
}
