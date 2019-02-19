package cn.gamers.service.admini;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.AdminiDao;
import cn.gamers.domain.Admini;

/**
 * Servlet implementation class FindAllUser
 */
@WebServlet("/FindAllAdmini")
public class FindAllAdmini extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllAdmini() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminiDao dao = new AdminiDao();
		List<Admini> al = new ArrayList<Admini>();
		try{
			al = dao.FindAllAdmini();
			request.setAttribute("AdminiList", al);
			System.out.println(al.get(0).getCon() + " " +al.get(0).getDate());
			request.getRequestDispatcher("Client/Admini/Admini.jsp").forward(request, response);
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
