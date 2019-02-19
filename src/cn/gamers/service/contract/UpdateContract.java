package cn.gamers.service.contract;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.ContractDao;
import cn.gamers.domain.Contract;

/**
 * Servlet implementation class UpdateContract
 */
@WebServlet("/UpdateContract")
public class UpdateContract extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateContract() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ContractDao dao = new ContractDao();
		Contract c = new Contract();
		if(request.getParameter("delete") != null){
			try{
				dao.DeleteContract(request.getParameter("delete"));
				request.getRequestDispatcher("FindAllContract").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else if(request.getParameter("update") != null){
			try{
				c = dao.FindContractById(request.getParameter("update"));
				request.setAttribute("c", c);
				request.getRequestDispatcher("Client/Contract/UpdateContract.jsp").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else if (request.getParameter("id") != null){
			try{
				c = dao.FindContractById(request.getParameter("id"));
				c.setName(request.getParameter("name"));
				c.setType(request.getParameter("type"));
				c.setTclass(request.getParameter("tclass"));
				c.setLevel(request.getParameter("level"));
				c.setCmoney(request.getParameter("cmoney"));
				c.setDate(request.getParameter("date"));
				c.setCon(request.getParameter("con"));
				
				dao.UpadteContract(c);
				request.getRequestDispatcher("FindAllContract").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else if(request.getParameter("id2") != null){
			try{
			c = dao.FindContractById(request.getParameter("id2"));
			c.setIsprincipal(true);
			dao.UpadteContract(c);
			request.getRequestDispatcher("FindContractByIsP").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
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
