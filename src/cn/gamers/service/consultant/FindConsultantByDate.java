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
 * Servlet implementation class FindConsultantByDate
 */
@WebServlet("/FindConsultantByDate")
public class FindConsultantByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindConsultantByDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConsultantDao dao = new ConsultantDao();
		Consultant cs = new Consultant();
		List<Consultant> cl = new ArrayList<Consultant>();
		String date = request.getParameter("SEDate");
		int sum_htgs = 0;
		int sum_qyzje = 0;
		int sum_xcqr = 0;
		int sum_gjjj = 0;
		if(request.getParameter("addtcbl") == null){
			try{
				cl = dao.FindConsultantByDate(date);
				for (Consultant c : cl){
					if (c.getMgjj() != 0){
						int sum = c.getMgjj()*c.getHtgs();
						c.setGjjj(String.valueOf(sum));
					}
					sum_htgs += c.getHtgs();
					sum_qyzje += c.getQyzje();
					sum_xcqr += c.getXcqy();
					sum_gjjj += Integer.parseInt(c.getGjjj());
				}
				
				cs.setKcgw("共计");
				cs.setHtgs(sum_htgs);
				cs.setQyzje(sum_qyzje);
				cs.setXcqy(sum_xcqr);
				cs.setGjjj(String.valueOf(sum_gjjj));
				cs.setSssj(date);
				dao.AddConsultant(cs);
				cl = dao.FindConsultantByDate(date);
				request.setAttribute("ConsultantList", cl);
				request.setAttribute("SEDate", date);
				request.getRequestDispatcher("Client/Contract/Consultant.jsp").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}else if(request.getParameter("DeleteAll") != null){
			try{
				dao.DeleteAllConsultant();
				request.getRequestDispatcher("FindAllContract").forward(request, response);
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}else{
			try{
				cs = dao.FindConsultantById(Integer.parseInt(request.getParameter("addtcbl")));
				cs.setTcbl(request.getParameter("tcbl"));
				dao.UpdateConsultant(cs);
				cl = dao.FindConsultantByDate(date);
				request.setAttribute("ConsultantList", cl);
				request.setAttribute("SEDate", date);
				request.getRequestDispatcher("Client/Contract/Consultant.jsp").forward(request, response);
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
