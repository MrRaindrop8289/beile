package cn.gamers.service.manage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.ManageDao;
import cn.gamers.domain.Manage;

/**
 * Servlet implementation class FindAllTclass
 */
@WebServlet("/FindAllManage")
public class FindAllManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Manage> ml = new ArrayList<Manage>();
		ManageDao dao = new ManageDao();
		try{
			ml = dao.FindAllManage();
			request.setAttribute("ML", ml);
			
			for (Manage m: ml){
				String date = m.getDate();
				if(date != null){
					try{
						m.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date)));
					}catch (ParseException e) {  
			            e.printStackTrace();  
			        }  
				}
			}
			request.getRequestDispatcher("Client/Manage/Manage.jsp").forward(request, response);
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
