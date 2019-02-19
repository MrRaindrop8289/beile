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

import cn.gamers.dao.ConsultantDao;
import cn.gamers.domain.Consultant;
import cn.gamers.domain.User;

/**
 * Servlet implementation class FindAdminiByCon
 */
@WebServlet("/FindAdminiByCon")
public class FindAdminiByCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAdminiByCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = (User)request.getSession().getAttribute("User");
		ConsultantDao dao = new ConsultantDao();
		List<Consultant> cl = new ArrayList<Consultant>();
		System.out.println("0.0" + u.getUsername());
		if (u.getYonghu_jb() == 4){
			try{
				cl = dao.FindConsultantByCon(u.getUsername());
				request.setAttribute("ConsultantList", cl);
				System.out.println(cl.size());
				request.getRequestDispatcher("/Client/Admini/ConfrimByCon.jsp").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else{
			request.getRequestDispatcher("/Client/Admini/Admini.jsp").forward(request, response);
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
