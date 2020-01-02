package CPPpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productDisplay")

public class DisplayProducts extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter p = resp.getWriter();
		
		ArrayList<ProductPojo>list = CompanyDAO.getProductCompany();
		
		p.print("<table>");
		p.print("<thead align='center'><th scope='col'>Product ID</th>"+
		                      "<th scope='col'>Product Name</th>"+
				              "<th scope='col'>Price(Rs)</th>"+
		                      "<th scope='col'>Company Name</th></thead>");
		for(ProductPojo pp : list) {
		
			p.print("<tbody align='center'><tr><th scope='row'> "+pp.getPid()+"</th>");
			p.print("<td> "+pp.getPname()+"</td>");
			p.print("<td> "+pp.getPrice()+"</td>");
			p.print("<td> "+pp.getCname()+"</td>");
		
		}
		p.print("</table>");
		p.close();
	}

}
