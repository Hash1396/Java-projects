package CPPpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/companyServlet")
	public class RegisterCompany extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			resp.setContentType("text/html");
			PrintWriter p = resp.getWriter();
			
			CompanyPojo c = new CompanyPojo();
			c.setCname(req.getParameter("cname"));
			c.setCountry(req.getParameter("country"));
			
			int st = CompanyDAO.register(c);	
			if(st>0)
			{
				p.print("<script type='text/javascript'>");
				p.print("alert('Company Registration successful');");
				p.print("location='registercompany.jsp'");
				p.print("</script>");
			}
			else
			{
				p.print("<script type='text/javascript'>");
				p.print("alert('Company Registration Failed');");
				p.print("location='registercompany.jsp'");
				p.print("</script>");

			}
			p.close();
		}
	}
