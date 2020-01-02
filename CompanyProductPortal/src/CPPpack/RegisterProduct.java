package CPPpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productServlet")

public class RegisterProduct extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter p = resp.getWriter();
		
		ProductPojo po = new ProductPojo();
		
		po.setPname(req.getParameter("pname"));
		po.setPrice(Float.parseFloat(req.getParameter("price")));
		po.setCid(Integer.parseInt(req.getParameter("pcompany")));
		
		int st = CompanyDAO.registerProduct(po);	
		if(st>0)
		{
			p.print("<script type='text/javascript'>");
			p.print("alert('Product Registration successful');");
			p.print("location='registerproduct.jsp'");
			p.print("</script>");
		}
		else
		{
			p.print("<script type='text/javascript'>");
			p.print("alert('Product Registration Failed');");
			p.print("location='registerproduct.jsp'");
			p.print("</script>");

		}
		p.close();
	}

 }
