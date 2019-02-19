package cn.gamers.service.uuser;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.UserDao;
import cn.gamers.domain.User;

/**
 * Servlet implementation class AddUuser
 */
@WebServlet("/AddUuser")
public class AddUuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User();
		UserDao dao = new UserDao();
		u.setUsername(request.getParameter("username"));
		u.setPassword("123456");
		if(request.getParameter("xingzheng") != null){
			u.setYonghu_jb(2);
		}else if(request.getParameter("jiaowu") != null){
			u.setYonghu_jb(3);
		}else if(request.getParameter("kcgw") != null){
			u.setYonghu_jb(4);
		}else if(request.getParameter("qiantai") != null){
			u.setYonghu_jb(5);
		}
		try{
			dao.AddUser(u);
			request.getRequestDispatcher("Client/User/User.jsp").forward(request, response);
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
