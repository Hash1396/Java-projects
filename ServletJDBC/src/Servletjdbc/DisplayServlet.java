package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter p = resp.getWriter();
		ArrayList<StudentPojo> el = StudentPojo.showProfiles();
		
		p.print("<head><meta charset='ISO-8859-1' name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>" + 
				"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>" + 
				"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>" + 
				"<style>body"+ 
				"	{"+ 
				"		margin:auto;"+ 
				"		text-align: center;"+ 
                "	}"+ 
                "h8{position:absolute; left:160px; top:100px}</style>"+
				"</head>"+ 
				"<body>"+ 
				"<div class='jumbotron'><br><h1>Welcome to Student.In</h1><br>"+ 
				"<h3>Profile List</h3></div>"
				+ "<form action='userpage'><h8><input type = 'Submit' class='btn btn-outline-dark' value='Back'></h8></form></body>");
		p.print("<table class = 'table table-borderless table-striped'>");
		p.print("<thead align='center'><th scope='col'>User ID</th>"+
		                      "<th scope='col'>First Name</th>"+
				              "<th scope='col'>Last Name</th>"+
		                      "<th scope='col'>Gender</th>"+
				              "<th scope='col'>Email</th>"+
		                      "<th scope='col'>Contact</th>"+ 
		                      "<th scope='col'>Institute</th>"+ 
		                      "<th scope='col'>Domain</th></thead>");
		
		for(StudentPojo e : el)
		{
			p.print("<tbody align='center'><tr><th scope='row'> "+e.getId()+"</th>");
			p.print("<td> "+e.getFname()+"</td>");
			p.print("<td> "+e.getLname()+"</td>");
			p.print("<td> "+e.getGender()+"</td>");
			p.print("<td> "+e.getEmail()+"</td>");
			p.print("<td> "+e.getCont()+"</td>");
			p.print("<td> "+e.getColl()+"</td>");
			p.print("<td> "+e.getProfile()+"</td>");
			p.print("</tr></tbody>");
			
		}
		p.print("</table>");
		//p.print("</body>");
		p.close();
	}
}