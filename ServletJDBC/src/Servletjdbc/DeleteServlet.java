package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter p=resp.getWriter();
		
		int id = LoginServlet.getID();
		int status = StudentPojo.deleteStud(id);
		
		if(status>0)
		{
			p.print("<script>");
			p.print("alert('Profile Deleted Successfully');");
			p.print("location = 'userpage'");
			p.print("</script>");
		}
		else
		{
			p.print("<script>");
			p.print("alert('Error While Deleting Profile');");
			p.print("location = 'userpage'");
			p.print("</script>");
		}
		p.close();
	}
}
