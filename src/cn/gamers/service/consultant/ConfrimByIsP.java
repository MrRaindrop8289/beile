package cn.gamers.service.consultant;

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

/**
 * Servlet implementation class ConfrimByIsP
 */
@WebServlet("/ConfrimByIsP")
public class ConfrimByIsP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfrimByIsP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConsultantDao dao = new ConsultantDao();
		List<Consultant> cl = new ArrayList<Consultant>();
		
		try{
			cl = dao.FindConsultantByP();
			request.setAttribute("ConsultantList", cl);
			request.getRequestDispatcher("Client/Contract/ConfirmConsultantByP.jsp").forward(request, response);
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
