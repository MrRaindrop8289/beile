package cn.gamers.excel.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.excel.ReadWriteContractExcel;



/**
 * Servlet implementation class Excel_contract_dowload
 */
@WebServlet("/Excel_contract_dowload")
public class Excel_contract_dowload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excel_contract_dowload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		
				//Save_Excel
				OutputStream out = null;
				File f = new File("C:\\Excel Test Temp\\1.xls");
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
					ReadWriteContractExcel.WriteExcel(out);
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

				
				
				//Dowload
				
				response.setContentType("multipart/form-data");  
//				2)、设置Content-Disposition  
				response.setHeader("Content-Disposition", "attachment;filename=" + new String("合同信息.xls".getBytes("gb2312"),"ISO8859-1"));  
//				3)、输出流  
				OutputStream out1 = response.getOutputStream();  
//				4)、获取服务端生成的excel文件，这里的path等于4.8中的path  
				InputStream in = new FileInputStream(f);  
//				5)、输出文件  
				int b;  
				while((b=in.read())!=-1){  
				    out1.write(b);  
				}  
				in.close();  
				out.close();  
				f.delete();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
