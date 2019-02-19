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

import cn.gamers.dao.ConsultantDao;
import cn.gamers.dao.ContractDao;
import cn.gamers.domain.Consultant;
import cn.gamers.domain.Contract;

/**
 * Servlet implementation class SearchConByTime
 */
@WebServlet("/SearchConByTime")
public class SearchConByTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchConByTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sdate = request.getParameter("StartDate");
		String edate = request.getParameter("EndDate");
		String date = sdate + "~" + edate;
		
		ContractDao ContDao = new ContractDao();
		ConsultantDao ConsDao = new ConsultantDao();
		
		List<Contract> cl = new ArrayList<Contract>();
		
		request.setAttribute("StartDate", sdate);
		request.setAttribute("EndDate", edate);
		request.setAttribute("SEDate", date);
	
		try{
			if(sdate != null && edate != null && !sdate.equals("") && !edate.equals("")){
				cl = ContDao.FindContractByDate(sdate, edate);
			}else{
				System.out.println("sdate:" + sdate);
				cl = ContDao.FindAllContract();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			for(Contract c:cl){
				Consultant cs = ConsDao.FindConsultantByConAndDate(c.getCon(), date);
				if(cs == null){
					cs = new Consultant();
					cs.setSssj(date);
					cs.setKcgw(c.getCon());
					cs.setGjjj(c.getCmoney());
					cs.setHtgs(1);
					cs.setTcbl(null);
					if(c.isIsnow() == true){
						cs.setXcqy(1);
					}else{
						cs.setXcqy(0);
					}
					cs.setMgjj(0);
					cs.setGjjj(null);
					ConsDao.AddConsultant(cs);
				}else{
					cs.setHtgs(cs.getHtgs() + 1);
					int sum = Integer.parseInt(c.getCmoney()) + cs.getQyzje();
					cs.setQyzje(sum);
					if(c.isIsnow() == true){
						cs.setXcqy(cs.getXcqy() + 1);
					}
					ConsDao.UpdateConsultant(cs);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		request.setAttribute("ContractList", cl);
		request.getRequestDispatcher("Client/Contract/Contract.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
