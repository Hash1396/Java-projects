package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateExecution extends HttpServlet {

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
		
		
		/*System.out.println("eid = "+e.getId());
		System.out.println("Fname = "+e.getFname());
		System.out.println("Lname = "+e.getLname());
		System.out.println("Mob = "+e.getMob());
		System.out.println("Email = "+e.getEmail());
		System.out.println("Gender = "+e.getGender());
		System.out.println("Profile = "+e.getProfile());
		*/
		
		if(req.getParameter("fname").length() == 0 || req.getParameter("lname").length() == 0 || req.getParameter("gender").length() == 0 || req.getParameter("email").length() == 0 || req.getParameter("cont").length() == 0 || req.getParameter("coll").length() == 0 || req.getParameter("profile").length() == 0) {
			
			p.print("<script type = 'text/javascript'>");
			p.print("alert('Error while Updating Profile');");
			p.print("location = 'userpage'");
			p.print("</script>");
		
		}else {
			e = new StudentPojo();
			e.setId(Integer.parseInt(req.getParameter("id")));
			e.setFname(req.getParameter("fname"));
			e.setLname(req.getParameter("lname"));
			e.setGender(req.getParameter("gender"));
			e.setEmail(req.getParameter("email"));
			e.setCont(req.getParameter("cont"));
			e.setColl(req.getParameter("coll"));
			e.setProfile(req.getParameter("profile"));
		}
		
		int st = StudentPojo.studUpdate(e);
		if(st>0)
		{
			p.print("<script type = 'text/javascript'>");
			p.print("alert('Profile Updated successfully');");
			p.print("location = 'userpage'");
			p.print("</script>");
		}
		else
		{
			p.print("<script type = 'text/javascript'>");
			p.print("alert('Error while Updating Profile');");
			p.print("location = 'userpage'");
			p.print("</script>");

		}
		p.close();
	}
}
