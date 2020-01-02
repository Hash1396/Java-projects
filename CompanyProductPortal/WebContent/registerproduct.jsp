<%@page import="CPPpack.CompanyPojo"%>
<%@page import="CPPpack.CompanyDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>productportal.com</title>
<link rel="stylesheet" type="text/css" href="style.css">
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
           <li class="active"><a href="registerproduct.jsp">Register Product</a></li>
           <li><a href="displayproducts.jsp">Available Products</a></li>
           <li><a href="PortalLogin.html">Log-out</a></li>
        </ul>
      </div>
      <h3>Register Your Product :</h3>
      <div class="centre">
           <form action = "productServlet" method = "get"><br><br><br>
             <p class="font-weight-normal">Product Name: 
                <Input type = "text" placeholder="Enter product" name = "pname"><br>
                <small>Enter full name of the product.</small><br></p>
            <p class="font-weight-normal">Price: 
                <Input type = "text" placeholder="Enter Price" name = "price" ><br>
                <small>The price should be in Rupees.</small><br></p>
                 <% ArrayList <CompanyPojo> list = CompanyDAO.getCompanyList(); %>
             <p class="font-weight-normal">Select Company : 
                   <select name="pcompany">
                     <option value="">  click here  </option>
                     <%for(CompanyPojo c: list){ %>
                      <option value="<%=c.getCid() %>"><%=c.getCname() %></option>
                      <%} %>
                  </select><br>
                  <small>Select from the available companies.</small><br><br></p>
                <Input type = "Submit" class="btn btn-lg btn-outline-dark" value = "Register Product"></b>
         </form>
      </div>
    </header>

</body>
</html>