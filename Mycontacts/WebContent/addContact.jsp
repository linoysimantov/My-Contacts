<%@page import="Exception.MyContactsException"%>
<%@ page language="java"
	import="java.util.*, Model.HibernateMyContactsDAO,Model.*"
	contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Contact</title>


</head>


<form action="index.jsp" method="post">
<div>
							<div style="margin-top: 20px; margin-left: 20px;">
								<label for="user" class="label" ></label>Contact Name<input
								name="user" id="user" type="text" class="input" placehodler="contact name"
								pattern="([a-zA-Z0-9!#$%&'*+\/=?^_`{|}~.-]+)*" required>
								</div>
								<div style="margin-top: 20px; margin-left: 20px;">
							<label for="phone" class="label" ></label> Phone Number<input id="phone"
								name="phone" type="text" class="input" placehodler="contact number"
								pattern="^0\d{8,9}$" required>
						</div>
	</div>					
						<div style="margin-top: 20px; margin-left: 20px;"><span class="btn btn-success">
            <i class="fas fa-plus-circle fa-2x"></i> <input type="submit" value="Add Contact" class="btn btn-success"/>
						</span>
						</div>
						
						</form>
						
<body>



</body>


</html>