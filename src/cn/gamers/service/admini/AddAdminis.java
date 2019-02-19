package cn.gamers.service.admini;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gamers.dao.AdminiDao;
import cn.gamers.domain.Admini;

/**
 * Servlet implementation class AddAdmini
 */
@WebServlet("/AddAdmini")
public class AddAdminis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminiDao dao = new AdminiDao();
		Admini a = new Admini();
		try{
			a.setCon(request.getParameter("con"));
			String date = "";
			if(request.getParameter("date") != null && !request.getParameter("date").trim().equals("")){
				date = request.getParameter("date");
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.format(new Date());
			}
			a.setDate(date);
			a.setHtje(request.getParameter("htje"));
			a.setName(request.getParameter("name"));
			a.setXcjl(request.getParameter("xcjl"));
			dao.AddAdmini(a);
			response.setContentType("text/html;charset=GBK");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");   
			out.print("<script>");
			out.print("alert('添加行政数据成功！');");
			out.print("</script>");
			request.getRequestDispatcher("FindAllAdmini").forward(request, response);
		}catch(SQLException e){
			response.setContentType("text/html;charset=GBK");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");   
			out.print("<script>");
			out.print("alert('添加行政数据失败！');");
			out.print("</script>");
			request.getRequestDispatcher("FindAllAdmini").forward(request, response);
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
