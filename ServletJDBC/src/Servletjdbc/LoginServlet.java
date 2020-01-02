package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	 //inits
	static StudentPojo curUser;
	static int id;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
	//take user input
	resp.setContentType("text/html");
	PrintWriter p = resp.getWriter();
	String uname = req.getParameter("uname");
	String pass = req.getParameter("pass");
	
	if(uname.length() == 0 || pass.length() == 0) {

		p.print("<script>");
		p.print("alert('Please Enter Valid UserName And Password.');");
		p.print("location = 'mypage.html'");
		p.print("</script>");
		
    }
	
	try {
	    
		//check if user exists
		curUser = StudentPojo.getLoginDetails(uname, pass);
		
	    //process returned user
		if(curUser == null) {
				p.print("<script>");
				p.print("alert('Invalid UserName or Password.');");
				p.print("location = 'mypage.html'");
				p.print("</script>");
			}else {
				id = curUser.getId();
				Cookie ck = new Cookie("uname", curUser.getUname());
				ck.setMaxAge(24*2*3600);
				resp.addCookie(ck);
				resp.sendRedirect("userpage");	
			}
		
	p.close();
	  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    
    /*
     * return curUser
     */
    public static StudentPojo getUser() {
    	StudentPojo e = StudentPojo.getUserByID(curUser);
        return e;
    }
    public static int getID() {
    	return id;
    }
    
}
