package cn.gamers.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.UserDao;
import cn.gamers.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		try{
			User u = new UserDao().FindUserByName(userName);
			if (u != null){
				if (passWord != null && passWord.equals(u.getPassword()) ){
					request.getSession().setAttribute("User", u);
					request.getRequestDispatcher("Client/Main.jsp").forward(request, response);
				}else{
					request.setAttribute("PassWordError", 1);
					request.getRequestDispatcher("Client/Login.jsp").forward(request, response);

				}
			}else{
				request.setAttribute("UserNameError", 1);
				request.getRequestDispatcher("Client/Login.jsp").forward(request, response);

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
