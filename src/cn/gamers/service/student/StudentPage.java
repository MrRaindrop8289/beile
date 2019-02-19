package cn.gamers.service.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.domain.Student;

/**
 * Servlet implementation class StudentPage
 */
@WebServlet("/StudentPage")
public class StudentPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Student> sl = (List<Student>)request.getAttribute("StudentList");
		int i = Integer.parseInt(request.getParameter("i"));
		int start = (int)request.getAttribute("start");
		int end = (int)request.getAttribute("end");
		int now = (int)request.getAttribute("now");
		int all = (int)request.getAttribute("all");
		start += 2;
		end += 2;
		now += 1;
		if(start > sl.size() || end > i){
			start = sl.size();
			end = sl.size();
		}
		
		request.setAttribute("i", i);

		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("now", now);
		request.setAttribute("all", all);
		request.setAttribute("StudentList", request.getAttribute("StudentList"));
		request.getRequestDispatcher("Client/Student/Student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
