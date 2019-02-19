package cn.gamers.excel.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.gamers.excel.ReadWriteStudentExcel;

/**
 * Servlet implementation class Excel_student_sumbit
 */
@WebServlet("/Excel_student_sumbit")
public class Excel_student_sumbit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Excel_student_sumbit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		int number = 0;
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File f = new File("C:\\Excel Test Temp");
			if (!f.exists()){
				f.mkdirs();
			}
			factory.setRepository(f);
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setHeaderEncoding("utf-8");
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			for(FileItem fileItem : fileItems){
				String fileName = fileItem.getName();
				String newfileName = new String("123") + "_" + fileName;
				File file = new File("C:\\Excel Test Temp\\" + newfileName);

				fileItem.write(file);
				fileItem.delete();
				System.out.println(file.getAbsolutePath());
				ReadWriteStudentExcel rwe = new ReadWriteStudentExcel();
				number = rwe.readExcel(f.getAbsolutePath() , newfileName);

			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("Number", number);
		request.getRequestDispatcher("FindAllStudent").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
