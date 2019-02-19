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

import cn.gamers.dao.StudentDao;
import cn.gamers.dao.TclassDao;
import cn.gamers.domain.Student;
import cn.gamers.domain.T_Class;
import cn.gamers.domain.User;

/**
 * Servlet implementation class AddTclass
 */
@WebServlet("/AddTclass")
public class AddTclass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTclass() {
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
			String id = request.getParameter("id");
			String ttime = request.getParameter("ttime");
			String result = request.getParameter("result");
			T_Class tc = new T_Class();
			tc.setId(Integer.parseInt(id));
			tc.setResult(result);
			tc.setTtime(ttime);
			tdao.AddClass(tc);
			request.getRequestDispatcher("FindAllStudent").forward(request, response);
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
