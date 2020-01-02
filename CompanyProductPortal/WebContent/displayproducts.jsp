<%@page import="CPPpack.ProductPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="CPPpack.CompanyDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<title>productportal.com</title>
</head>
<body>
    <header>  
      <div class="main">
        <div class="logo">
           <h1>Product Portal</h1>
        </div>
        <ul>
           <li><a href="index.jsp">Home</a></li>
           <li><a href="registercompany.jsp">Register Company</a></li>
           <li><a href="registerproduct.jsp">Register Product</a></li>
           <li class="active"><a href="displayproducts.jsp">Available Products</a></li>
           <li><a href="PortalLogin.html">Log-out</a></li>
        </ul>
      </div>
      <h3>Available Products :</h3>
      <%ArrayList<ProductPojo>list = CompanyDAO.getProductCompany(); %>
     <div class="disp">
      <table class="table table-bordered table-striped">
        <thead class="thead-dark" align="center">
          <th scope="col">Product ID</th>
		  <th scope="col">Product Name</th>
	      <th scope="col">Price(Rs)</th>
		  <th scope="col">Company Name</th>
		</thead>
		<% for(ProductPojo pp : list) { %>
		<tbody align="center">
		   <tr>
		     <th scope="row"><%=pp.getPid()%></th>
		     <th scope="row"><%=pp.getPname()%></th>
		     <th scope="row"><%=pp.getPrice()%></th>
		     <th scope="row"><%=pp.getCname()%></th>
		   </tr>
		</tbody>
		<% } %>
	  </table>
	</div>       
</body>
</html>