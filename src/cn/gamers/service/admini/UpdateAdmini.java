package cn.gamers.service.admini;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.AdminiDao;
import cn.gamers.domain.Admini;

/**
 * Servlet implementation class UpdateAdmini
 */
@WebServlet("/UpdateAdmini")
public class UpdateAdmini extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdmini() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminiDao dao = new AdminiDao();
		Admini a = new Admini();
		try{
			if (request.getParameter("delete") != null){
				a = dao.FindAdminiById(Integer.parseInt(request.getParameter("delete")));
				dao.DeleteAdmini(a);
				request.getRequestDispatcher("/Client/Admini/Admini.jsp").forward(request, response);
			}else if (request.getParameter("update") != null){
				a = dao.FindAdminiById(Integer.parseInt(request.getParameter("update")));
				request.setAttribute("a", a);
				request.getRequestDispatcher("/Client/Admini/UpdateAdmini.jsp").forward(request, response);
			}else if (request.getParameter("id") != null){
				a.setCon(request.getParameter("con"));
				a.setDate(request.getParameter("date"));
				a.setHtje(request.getParameter("htje"));
				a.setName(request.getParameter("name"));
				a.setXcjl(request.getParameter("xcjl"));
				dao.UpdateAdmini(a, Integer.parseInt(request.getParameter("id")));
				request.getRequestDispatcher("FindAllAdmini").forward(request, response);
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
