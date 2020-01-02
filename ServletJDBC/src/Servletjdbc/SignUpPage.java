package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpPage extends HttpServlet{

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
			String uname = req.getParameter("uname");
			String pass = req.getParameter("pass");
			String pass1 = req.getParameter("pass1");
			int str = 0;
			
			if(uname.length() == 0 || pass.length() == 0 || pass1.length() == 0) {

				p.print("<script>");
				p.print("alert('Empty Fields Found!!!..Please Fill All The Fields.');");
				p.print("location = 'SignUp.html'");
				p.print("</script>");
				
		    }else{
		    
		    	str = pass.compareTo(pass1);
		    }

            if(str == 0) {
		    	
		    	e.setUname(uname);
		    	e.setPass(pass);
		   
		    }else {
		    	
		    	p.print("<script>");
				p.print("alert('Passwords Don't Match');");
				p.print("location = 'SignUp.html'");
				p.print("</script>");
		    		    
			}

	    	   int st = StudentPojo.signUp(e);
				if(st > 0)
				{
					p.print("<script type='text/javascript'>");
					p.print("alert('Account Created Successfully');");
					p.print("location = 'mypage.html'");
					p.print("</script>");
				}
				else
				{
					p.print("<script type='text/javascript'>");
					p.print("alert('Error While Creating Account!!! Please Try Again.');");
					p.print("location = 'SignUp.html'");
					p.print("</script>");
             	}			
			p.close();
		}
}
