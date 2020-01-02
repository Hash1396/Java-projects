package CPPpack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter p = resp.getWriter();
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		if(uname.length() == 0 || pass.length() == 0) {

			p.print("<script>");
			p.print("alert('Please Enter Valid UserName And Password.');");
			p.print("location = 'PortalLogin.html'");
			p.print("</script>");
			
	    }else if(uname.equals("hash") && pass.equals("1234")) {
	    	
	    	resp.sendRedirect("index.jsp");
	    
	    }else {
	    	
	    	p.print("<script>");
			p.print("alert('Invalid UserName or Password.');");
			p.print("location = 'PortalLogin.html'");
			p.print("</script>");
	    }
	}

}
