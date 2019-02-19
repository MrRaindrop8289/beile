package cn.gamers.service.contract;

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

import cn.gamers.dao.ContractDao;
import cn.gamers.domain.Contract;

/**
 * Servlet implementation class FindContractByIsP
 */
@WebServlet("/FindContractByIsP")
public class FindContractByIsP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindContractByIsP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ContractDao dao = new ContractDao();
		List<Contract> cl = new ArrayList<Contract>();
		try{
			cl = dao.FindContractByIsP();
			for (Contract c:cl){
				String date = c.getDate();
				try{
					c.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(date)));
				}catch (ParseException e) {  
		            e.printStackTrace();  
		        }  
			}
			request.setAttribute("ContractList", cl);
			if(cl != null ){
				request.getRequestDispatcher("Client/Contract/ConfirmContractByP.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("FindAllContract").forward(request, response);
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
