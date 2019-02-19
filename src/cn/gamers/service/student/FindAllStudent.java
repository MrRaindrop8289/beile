package cn.gamers.service.student;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.StudentDao;
import cn.gamers.dao.TclassDao;
import cn.gamers.domain.Student;
import cn.gamers.domain.T_Class;

/**
 * Servlet implementation class FindAllStudent
 */
@WebServlet("/FindAllStudent")
public class FindAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDao sdao = new StudentDao();
		TclassDao tdao = new TclassDao();
		List<Student> sl = new ArrayList<Student>();
		List<T_Class> tcl = new ArrayList<T_Class>();
		
		try{
			sl = sdao.FindAllStudent();
			for(Student s:sl){
				List<T_Class> tl = tdao.FindClassById(s.getId());
				if(!tl.isEmpty()){
					s.setTsum(tl.size());
				}else{
					s.setTsum(1);
				}
				
				String date = s.getNext_time();
				if(date != null){
					try{
						s.setNext_time(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(date)));
					}catch (ParseException e) {  
			            e.printStackTrace();  
			        }  
				}
			}
			
			if(sl.size() > 0){
				System.out.println("Size:" + sl.size());
				request.getSession().setAttribute("start", 0);
				request.getSession().setAttribute("end", 1);
			}
			int all = 0;
			if(sl.size() % 2 ==0){
				all = sl.size() / 2;
			}else{
				all = sl.size() / 2 + 1;
			}
			System.out.println("all" + all);
				request.getSession().setAttribute("Number", request.getAttribute("Number"));
				request.getSession().setAttribute("all", all);
				request.getSession().setAttribute("now", 1);
				request.getSession().setAttribute("size", sl.size());
				request.getSession().setAttribute("StudentList", sl);
			request.getRequestDispatcher("Client/Student/Student.jsp").forward(request, response);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
