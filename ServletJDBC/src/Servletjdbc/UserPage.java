package Servletjdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserPage extends HttpServlet{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	resp.setContentType("text/html");
	PrintWriter p = resp.getWriter();
	StudentPojo sp = LoginServlet.getUser();
	if(sp == null) {
		p.println("<head><meta charset='ISO-8859-1' name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>" + 
				"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>" + 
				"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>" + 
				"<style>body" +  
				"	{" + 
				"		margin:auto;" + 
				"		text-align: center;" + 
				"	}" + 
				"h4{position:absolute; left:160px; top:100px}"+
				"h8{position:absolute; left:1200px; top:100px}"+ 
				"h10{position:absolute; left:160px; top:150px}</style>" + 
				"</head>" + 
				"<body>" + 
				"<div class = 'jumbotron'><br><h1>Welcome to Student.In</h1><br>" + 
				"  <h3>Your Profile</h3></div><h2><br>You Don't Have A Profile Created Yet<br><br>"+
				"<a href = 'data.html' class='btn btn-secondary btn-lg active' role='button'>Create your profile now</a></h2>"+
				"<br><form action = 'disp' method = 'get'>" + 
				" 	<h8><b><input type = 'submit' name = 'disp' class='btn btn-outline-dark' value = 'View All Profiles'></b></h8>"+ 
				" 	</form>"+
				"<br><form action = 'delacc' method = 'get'>" + 
				" 	<h10><b><input type = 'submit' name = 'delacc' class='btn btn-outline-dark' value = 'Delete Your Account'></b></h10>"+ 
				" 	</form>"+
				"	<form action = 'logout' method = 'post'>" + 
				" 	<h4><b><input type = 'submit' name = 'logout' class='btn btn-outline-dark' value = 'Log-Out'></b></h4>" + 
				" 	</form>"+
				"</body>");
	}else {
	     p.println("<head><meta charset='ISO-8859-1' name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>" + 
	     	"<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>" + 
	     	"<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js' integrity='sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM' crossorigin='anonymous'></script>" + 
	     	"<style>body" +  
			"	{" + 
			"		margin:auto;" + 
			"		text-align: center;" + 
			"	}" + 
			"h4{position:absolute; left:160px; top:100px}"+
			"h7{position:absolute; left:1200px; top:100px}"+
			"h8{position:absolute; left:1200px; top:200px}" + 
			"h9{position:absolute; left:1200px; top:150px}"+
			"h10{position:absolute; left:160px; top:150px}</style>"+
			"</head>" + 
			"<body>" + 
			"<div class = 'jumbotron'><br><h1>Welcome to Student.In</h1><br>" + 
			"  <h3>Your Profile</h3></div>"
			+ "<table class='table table-striped table-bordered'>"
			+ "<tbody align='center'><tr>"
			+ "<th>User ID</th>"
			+ "<td>"+sp.getId()+"</td></tr>"
			+ "<tr>"
			+ "<th>First Name</th>"
			+ "<td>"+sp.getFname()+"</td></tr>"
			+ "<tr>"
			+ "<th>Last Name</th>"
			+"<td>"+sp.getLname()+"</td></tr>"
			+ "<tr>"
			+ "<th>Gender</th>"
			+ "<td>"+sp.getGender()+"</td></tr>"
			+ "<tr>"
			+ "<th>Email ID</th>"
			+ "<td>"+sp.getEmail()+"</td></tr>"
			+ "<tr>"
			+ "<th>Contact Number</th>"
			+ "<td>"+sp.getCont()+"</td></tr>"
			+ "<tr>"
			+ "<th>Institute</th>"
			+ "<td>"+sp.getColl()+"</td></tr>"
			+ "<tr>"
			+ "<th>Domain</th>"
			+ "<td>"+sp.getProfile()+"</td></tr>"+
			" <form action = 'edit' method = 'post'>" + 
            " 	<h7><b><input type = 'submit' name = 'editinfo' class='btn btn-outline-dark' value = 'Edit Your Profile'></b></h7>"+ 
	        " 	</form>"+
			"<br><form action = 'delete' method = 'get'>"+ 
			" 	<h9><b><input type = 'submit' name = 'deleteinfo' class='btn btn-outline-dark' value = 'Delete Your Profile'></b></h9>"+ 
			" 	</form>"+
	        "<br><form action = 'disp' method = 'get'>" + 
			" 	<h8><b><input type = 'submit' name = 'disp' class='btn btn-outline-dark' value = 'View All Profiles'></b></h8>"+ 
			" 	</form>"+
			"<br><form action = 'delacc' method = 'get'>" + 
			" 	<h10><b><input type = 'submit' name = 'delacc' class='btn btn-outline-dark' value = 'Delete Your Account'></b></h10>"+ 
			" 	</form>"+
			"	<form action = 'logout' method = 'post'>" + 
			" 	<h4><b><input type = 'submit' name = 'logout' class='btn btn-outline-dark' value = 'Log-Out'></b></h4>" + 
			" 	</form>"+ 
			"</body>");
	}
  }
}
