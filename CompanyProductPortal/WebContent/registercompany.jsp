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
           <li class="active"><a href="registercompany.jsp">Register Company</a></li>
           <li><a href="registerproduct.jsp">Register Product</a></li>
           <li><a href="displayproducts.jsp">Available Products</a></li>
           <li><a href="PortalLogin.html">Log-out</a></li>
        </ul>
      </div>
      <h3>Register Your Company :</h3>
      <div class="centre">
           <form action = "companyServlet" method = "get"><br>
             <p class="font-weight-heavy">Company Name:
                <Input type = "text" placeholder="Enter company" name = "cname" ><br>
                <small>Enter full name of the Company.</small><br></p>
            <p class="font-weight-heavy">Country:
                <Input type = "text" placeholder="Enter country" name = "country" ><br>
                <small>Please check the availability of your country in our forums.</small><br><br></p>
                <Input type = "Submit" class="btn btn-lg btn-outline-dark" value = "Register Company"></b>
         </form>
      </div>
    </header>
    
</body>
</html>