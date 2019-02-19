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

import cn.gamers.dao.ManageDao;
import cn.gamers.dao.StudentDao;
import cn.gamers.dao.TclassDao;
import cn.gamers.domain.Manage;
import cn.gamers.domain.Student;
import cn.gamers.domain.T_Class;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
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
			if(request.getParameter("delete") != null){
				sdao.DeleteStudentById(Integer.parseInt(request.getParameter("delete")));
				request.getRequestDispatcher("FindAllStudent").forward(request, response);
			}else if(request.getParameter("update") != null){
				
				ManageDao mdao = new ManageDao();
				List<Manage> ml = new ArrayList<Manage>();
				ml = mdao.FindAllManage();
				request.setAttribute("ManageList", ml);
				Student s = sdao.FindStudentById(Integer.parseInt(request.getParameter("update")));
				tcl = tdao.FindClassById(s.getId());
				if(!tcl.isEmpty()){
					s.setTsum(tcl.size());
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
				request.setAttribute("now", request.getAttribute("now"));
				request.setAttribute("Student", s);
				request.setAttribute("TclassList", tcl);
				request.getRequestDispatcher("Client/Student/UpdateStudent.jsp").forward(request, response);
			}else if(request.getParameter("addTclass") != null){
				ManageDao mdao = new ManageDao();
				List<Manage> ml = new ArrayList<Manage>();
				ml = mdao.FindAllManage();
				request.setAttribute("ManageList", ml);
				Student s = sdao.FindStudentById(Integer.parseInt(request.getParameter("addTclass")));
				request.setAttribute("Student", s);
				request.getRequestDispatcher("Client/Student/AddTclass.jsp").forward(request, response);
			}else if(request.getParameter("tclassid") != null){
				T_Class tc = tdao.FindClassBymId(Integer.parseInt(request.getParameter("tclassid")));
				Student s = sdao.FindStudentById(Integer.parseInt(request.getParameter("id")));
				
				ManageDao mdao = new ManageDao();
				List<Manage> ml = new ArrayList<Manage>();
				ml = mdao.FindAllManage();
				request.setAttribute("ManageList", ml);
				
				request.setAttribute("Student", s);
				request.setAttribute("Tclass", tc);
				
				request.getRequestDispatcher("Client/Student/UpdateTclass.jsp").forward(request, response);
			}else if(request.getParameter("UpdateStudent") != null){
				ManageDao mdao = new ManageDao();
				List<Manage> ml = new ArrayList<Manage>();
				ml = mdao.FindAllManage();
				request.setAttribute("ManageList", ml);
				Student s = sdao.FindStudentById(Integer.parseInt(request.getParameter("UpdateStudent")));
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
				request.getRequestDispatcher("FindAllStudent").forward(request, response);
			}else if(request.getParameter("newTclass") != null){
				ManageDao mdao = new ManageDao();
				List<Manage> ml = new ArrayList<Manage>();
				ml = mdao.FindAllManage();
				request.setAttribute("ManageList", ml);
				
				T_Class tc = new T_Class();
				tc.setId(Integer.parseInt(request.getParameter("newTclass")));
				tc.setTtime(request.getParameter("ttime"));
				tc.setResult(request.getParameter("result"));
				tdao.AddClass(tc);
				Student s = sdao.FindStudentById(Integer.parseInt(request.getParameter("update")));
				tcl = tdao.FindClassById(s.getId());
				if(!tcl.isEmpty()){
					s.setTsum(tcl.size());
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
				request.setAttribute("Student", s);
				request.setAttribute("TclassList", tcl);
				request.getRequestDispatcher("Client/Student/UpdateStudent.jsp").forward(request, response);
			}else if (request.getParameter("next") != null){
				sl = (List<Student>)request.getSession().getAttribute("StudentList");
				int start = (int)request.getSession().getAttribute("start");
				int end = (int)request.getSession().getAttribute("end");
				int now = (int)request.getSession().getAttribute("now");
				int all = (int)request.getSession().getAttribute("all");
				int size = (int)request.getSession().getAttribute("size");
				start += 2;
				end += 2;
				now += 1;
				System.out.println("Size:" + sl.size() + "Start:" + start + "End" + end + "Now:" + now + "All:" + all);

				request.getSession().setAttribute("start", start);
				request.getSession().setAttribute("end", end);
				request.getSession().setAttribute("now", now);
				request.getSession().setAttribute("all", all);
				request.getSession().setAttribute("size", size);
				request.getSession().setAttribute("StudentList", sl);
				request.getRequestDispatcher("Client/Student/Student.jsp").forward(request, response);
			}else if (request.getParameter("previous") != null){
				sl = (List<Student>)request.getSession().getAttribute("StudentList");
				int start = (int)request.getSession().getAttribute("start");
				int end = (int)request.getSession().getAttribute("end");
				int now = (int)request.getSession().getAttribute("now");
				int all = (int)request.getSession().getAttribute("all");
				int size = (int)request.getSession().getAttribute("size");
				
				start -= 2;
				end -= 2;
				now -= 1;
				

				request.getSession().setAttribute("start", start);
				request.getSession().setAttribute("end", end);
				request.getSession().setAttribute("now", now);
				request.getSession().setAttribute("all", all);
				request.getSession().setAttribute("size", size);
				request.getSession().setAttribute("StudentList", sl);
				request.getRequestDispatcher("Client/Student/Student.jsp").forward(request, response);
			}
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
