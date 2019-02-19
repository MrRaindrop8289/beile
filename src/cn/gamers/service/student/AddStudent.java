package cn.gamers.service.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.ManageDao;
import cn.gamers.dao.StudentDao;
import cn.gamers.dao.TclassDao;
import cn.gamers.domain.Manage;
import cn.gamers.domain.Student;
import cn.gamers.domain.T_Class;
import cn.gamers.domain.User;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
		List<T_Class> tcl = new ArrayList<T_Class>();
		try{
			if(request.getParameter("name") == null){
				request.setAttribute("Student", null);
				
				ManageDao mdao = new ManageDao();
				List<Manage> ml = new ArrayList<Manage>();
				ml = mdao.FindAllManage();
				request.setAttribute("ManageList", ml);
				
				request.getRequestDispatcher("Client/Student/AddStudent.jsp").forward(request, response);
			}else if(request.getParameter("newTclass") != null){
				int id;
				Student s = new Student();
				if(request.getParameter("id").equals("客户信息")){
					s.setShuju_ly(request.getParameter("shuju_ly"));
					s.setName(request.getParameter("name"));
					s.setGrade(request.getParameter("grade"));
					s.setPhone(request.getParameter("phone"));
					s.setNext_time(request.getParameter("next_time"));
					s.setContent(request.getParameter("content"));
					if(request.getParameter("point") != null){
						s.setPoint(true);
					}else{
						s.setPoint(false);
					}
					sdao.AddStudent(s);
					id = sdao.FindMaxId();
					s.setId(id);
				}else{
					s = sdao.FindStudentById(Integer.parseInt(request.getParameter("id")));
					s.setShuju_ly(request.getParameter("shuju_ly"));
					s.setName(request.getParameter("name"));
					s.setGrade(request.getParameter("grade"));
					s.setPhone(request.getParameter("phone"));
					s.setNext_time(request.getParameter("next_time"));
					s.setContent(request.getParameter("content"));
					if(request.getParameter("point") != null){
						s.setPoint(true);
					}else{
						s.setPoint(false);
					}
					sdao.UpdateStudentById(s);
					id = s.getId();
				}
				T_Class tc = new T_Class();
				tc.setId(id);
				tc.setTtime(request.getParameter("ttime"));
				tc.setResult(request.getParameter("result"));
				tdao.AddClass(tc);
				tcl = tdao.FindClassById(id);
				if(!tcl.isEmpty()){
					s.setTsum(tcl.size() + 1);
				}else{
					s.setTsum(1);
				}
				request.setAttribute("Student", s);
				request.setAttribute("TclassList", tcl);
				
				request.getRequestDispatcher("Client/Student/AddStudent.jsp").forward(request, response);
			}else if (request.getParameter("tclassid") != null){
				T_Class tc = tdao.FindClassBymId(Integer.parseInt(request.getParameter("tclassid")));
				Student s =  sdao.FindStudentById(tc.getId());
				
				request.setAttribute("Student", s);
				request.setAttribute("Tclass", tc);
				
				request.getRequestDispatcher("Client/Student/UpdateTclass.jsp").forward(request, response);
			}else if(request.getParameter("UpdateTclass") != null){
//				System.out.println("0.0" + request.getParameter("UpdateTclass"));
				T_Class tc = tdao.FindClassBymId(Integer.parseInt(request.getParameter("UpdateTclass")));
				Student s =  sdao.FindStudentById(tc.getId());

				User u = (User)request.getSession().getAttribute("User");
				if(u.getYonghu_jb() == 4){
					tc.setIs_gw_change(true);
				}
				tc.setTtime(request.getParameter("ttime"));
				tc.setResult(request.getParameter("result"));
				tdao.UpdateClass(tc);
				
				request.getRequestDispatcher("FindAllStudent").forward(request, response);
			}else if(request.getParameter("AddStudent") != null){
				Student s = new Student();
				if(request.getParameter("id").equals("系统自动生成")){
					s.setShuju_ly(request.getParameter("shuju_ly"));
					s.setName(request.getParameter("name"));
					s.setGrade(request.getParameter("grade"));
					s.setPhone(request.getParameter("phone"));
					s.setNext_time(request.getParameter("next_time"));
					s.setContent(request.getParameter("content"));
					if(request.getParameter("point") != null){
						s.setPoint(true);
					}else{
						s.setPoint(false);
					}
					sdao.AddStudent(s);
				}else{
					s = sdao.FindStudentById(Integer.parseInt(request.getParameter("id")));
					s.setShuju_ly(request.getParameter("shuju_ly"));
					s.setName(request.getParameter("name"));
					s.setGrade(request.getParameter("grade"));
					s.setPhone(request.getParameter("phone"));
					s.setNext_time(request.getParameter("nexy_time"));
					s.setContent(request.getParameter("content"));
					if(request.getParameter("point") != null){
						s.setPoint(true);
					}else{
						s.setPoint(false);
					}
					sdao.UpdateStudentById(s);
				}
				int id = s.getId();
				request.setAttribute("Id", id);
				request.getRequestDispatcher("FindAllStudent").forward(request, response);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			
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
