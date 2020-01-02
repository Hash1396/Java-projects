package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePage extends HttpServlet {
	
    /**serial ID
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	resp.setContentType("text/html");
	PrintWriter p = resp.getWriter();
	StudentPojo e = LoginServlet.getUser();

	p.print("<head><meta charset='ISO-8859-1' name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>" + 
			"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>" + 
			"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>" + 
			"<style>body" + 
			"	{" + 
			"		margin:auto;" + 
			"		text-align: center;" + 
			"	}"+ 
			"h8{position:absolute; left:160px; top:100px}</style>"+ 
			"</head>" +
			"<body>"+ 
			"<div class='jumbotron'><br><h1>Welcome to Student.In</h1><br>"+ 
			"  <h3>Update Your Profile</h3></div>"+ 
			"<form action = 'update' method = 'post'>");
	p.print("<input type = 'hidden' name = 'id' value = '"+e.getId()+"'>");
	p.print("<br><p class='font-weight-normal'>First Name : <input type = 'text' name = 'fname' value = '"+e.getFname()+"'>");
	p.print("<br><br>Last Name : <input type = 'text' name = 'lname' value = '"+e.getLname()+"'>");
	p.print("<br><br>Gender : Male <input type = 'radio' name = 'gender' value = 'male'>");
	p.print(" Female <input type = 'radio' name = 'gender' value = 'female'>");
	p.print("<br><br>Email : <input type = 'text' name ='email' value = '"+e.getEmail()+"'>");
	p.print("<br><br>Contact No. : <input type = 'text' name = 'cont' value = '"+e.getCont()+"'>");
	p.print("<br><br>Institute : <input type = 'text' name = 'coll' value = '"+e.getColl()+"'>");
	p.print("<br><br>Domain : <select name = 'profile' value = '"+e.getProfile()+"'><option>java</option>" + 
			"<option>c++</option>" + 
			"<option>python</option>" + 
			"<option>php</option></select></p>");

	p.print("<br><input type = 'submit' class='btn btn-outline-dark' value = 'Update Profile'> ");
	
	p.print("<br><h8><input type = 'button' onclick = 'gotoDisplay()' class='btn btn-outline-dark' value = 'Back'></button></h8>");
	p.print("</form></body>");
	
	p.print("<script>");
	p.print("function gotoDisplay(){");
	p.print("alert('Update Canceled...');");
	p.print("location = 'userpage';");
	p.print("}");
	p.print("</script>");
	
	p.close();
  }
}
