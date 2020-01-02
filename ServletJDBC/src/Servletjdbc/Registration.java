package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			resp.setContentType("text/html");
			PrintWriter p = resp.getWriter();
			
			StudentPojo e = new StudentPojo();
			e.setId(LoginServlet.getID());
			e.setFname(req.getParameter("fname"));
			e.setLname(req.getParameter("lname"));
			e.setGender(req.getParameter("gender"));
			e.setEmail(req.getParameter("email"));
			e.setCont(req.getParameter("cont"));
			e.setColl(req.getParameter("coll"));
			e.setProfile(req.getParameter("profile"));
			
			if(req.getParameter("fname").length() == 0 || req.getParameter("lname").length() == 0 || req.getParameter("gender").length() == 0 || req.getParameter("email").length() == 0 || req.getParameter("cont").length() == 0 || req.getParameter("coll").length() == 0 || req.getParameter("profile").length() == 0) {
				
				p.print("<script>");
				p.print("alert('Empty Fields Found!!!..Please Fill All The Fields.');");
				p.print("location = 'data.html'");
				p.print("</script>");
			
			}

		    int st = StudentPojo.register(e);
			if(st > 0)
			{
				p.print("<script type='text/javascript'>");
				p.print("alert('Profile Created Successfully');");
				p.print("location = 'userpage'");
				p.print("</script>");
			}
			else
			{
				p.print("<script type='text/javascript'>");
				p.print("alert('Error While Creating Profile!!! Please Try Again.');");
				p.print("location = 'data.html'");
				p.print("</script>");

			}
			
			p.close();
		}
	}

