package cn.gamers.service.manage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.ManageDao;
import cn.gamers.domain.Manage;

/**
 * Servlet implementation class UpdateTclass
 */
@WebServlet("/UpdateManage")
public class UpdateManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Manage m = new Manage();
		ManageDao dao = new ManageDao();
		try{
			if(request.getParameter("delete") != null){
				dao.DeleteT_Class(Integer.parseInt(request.getParameter("delete")));
				request.getRequestDispatcher("FindAllManage").forward(request, response);
			}else if(request.getParameter("update") != null){
				m = dao.FindManageById(Integer.parseInt(request.getParameter("update")));
				request.setAttribute("m", m);
				request.getRequestDispatcher("Client/Manage/UpdateManage.jsp").forward(request, response);
			}else if(request.getParameter("id") != null){
				m = dao.FindManageById(Integer.parseInt(request.getParameter("id")));
				m.setDate(request.getParameter("date"));
				m.setJb(Integer.parseInt(request.getParameter("jb")));
				dao.Update_Class(m);
				request.getRequestDispatcher("FindAllManage").forward(request, response);
			}else if(request.getParameter("id2") != null){
				String date;
				if(request.getParameter("date") != null && !request.getParameter("date").trim().equals("")){
					date = request.getParameter("date");
				}else{
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					date = sdf.format(new Date());
				}
				m.setDate(date);
				m.setJb(Integer.parseInt(request.getParameter("jb")));
				dao.AddT_Class(m);
				request.getRequestDispatcher("FindAllManage").forward(request, response);
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
