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
import cn.gamers.exception.CanNotDeleteException;

/**
 * Servlet implementation class UpdateUuser
 */
@WebServlet("/UpdateUuser")
public class UpdateUuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = (User)request.getSession().getAttribute("User");
		UserDao dao = new UserDao();
		if(request.getParameter("newPassword") != null){
			String newPassword = request.getParameter("newPassword");
			u.setPassword(newPassword);
			try{
				dao.UpdateUser(u);
				request.getRequestDispatcher("QuitServlet").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else if(request.getParameter("delete") != null){
			try{
				u = dao.FindUserByName(request.getParameter("delete"));
				dao.DeleteUser(u);
				request.getRequestDispatcher("FindAllUuser").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}catch(CanNotDeleteException e){
				e.printStackTrace();
			}
		}else if (request.getParameter("update") != null){
			try{
				u = dao.FindUserByName(request.getParameter("update"));
				String yonghu_jb = new String();
				switch(u.getYonghu_jb()){
					case 2:
						yonghu_jb = "行政";
						break;
					case 3:
						yonghu_jb = "教务";
						break;
					case 4:
						yonghu_jb = "课程顾问";
						break;
					case 5:
						yonghu_jb = "前台";
						break;
				}
				request.setAttribute("User1", u);
				request.setAttribute("yonghu_jb", yonghu_jb);
				
				request.getRequestDispatcher("Client/User/UpdateUserByP.jsp").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else if (request.getParameter("UpdateUser1") != null){
			try{
				u = dao.FindUserById(Integer.parseInt(request.getParameter("Id")));
				if(request.getParameter("UserName1") != null){
					System.out.println("UserName:" + request.getParameter("UserName1"));
					String name = request.getParameter("UserName1");

					System.out.println("Name:" + name);
					u.setUsername(name);
				}
				if(request.getParameter("PassWord1") != null){
					u.setPassword(request.getParameter("PassWord1"));
				}
				if(request.getParameter("yonghu_jb") != null){
					if(request.getParameter("yonghu_jb").equals("行政")){
						u.setYonghu_jb(2);
					}else if (request.getParameter("yonghu_jb").equals("教务")){
						u.setYonghu_jb(3);
					}else if (request.getParameter("yonghu_jb").equals("课程顾问")){
						u.setYonghu_jb(4);
					}else if(request.getParameter("yonghu_jb").equals("前台")){
						u.setYonghu_jb(5);
					}
				}
				dao.UpdateUser(u);
				
				request.getRequestDispatcher("FindAllUuser").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else if(request.getParameter("newPassword") == null){
			request.getRequestDispatcher("Client/User/UpdateUser.jsp").forward(request, response);
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
