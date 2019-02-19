package cn.gamers.service.contract;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.ContractDao;
import cn.gamers.dao.UserDao;
import cn.gamers.domain.Contract;
import cn.gamers.domain.User;

/**
 * Servlet implementation class AddContract
 */
@WebServlet("/AddContract")
public class AddContract extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContract() {
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
		if(request.getParameter("name") != null){
			c.setCon(request.getParameter("con"));
			c.setCmoney(request.getParameter("cmoney"));
			String date;
			if(request.getParameter("date") != null && !request.getParameter("date").trim().equals("")){
				date = request.getParameter("date");
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.format(new Date());
			}
			c.setDate(date);
			if(request.getParameter("isnow") != null){
				c.setIsnow(true);
			}else{
				c.setIsnow(true);
			}
			c.setLevel(request.getParameter("level"));
			c.setName(request.getParameter("name"));
			c.setTclass(request.getParameter("tclass"));
			c.setType(request.getParameter("type"));
			
			try{
				dao.AddContract(c);
				request.getRequestDispatcher("FindAllContract").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else{
			List<User> ConList = new ArrayList<User>();
			UserDao Udao = new UserDao();
			try{
				ConList = Udao.FindUserByLevel(4);
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			request.setAttribute("ConList", ConList);
			request.getRequestDispatcher("Client/Contract/AddContract.jsp").forward(request, response);
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
