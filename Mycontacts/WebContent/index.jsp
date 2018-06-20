<%@ page language="java"
	import="java.util.*, Model.HibernateMyContactsDAO,Model.*,Exception.MyContactsException"
	contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}
h2{
    color: green;

}
#myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

#myTable {
  border-collapse: collapse;
  width: 100%;
  border: 1px solid #ddd;
  font-size: 16px;
  
}

#myTable th, #myTable td {
  text-align: left;
  padding: 12px;
}

#myTable tr {
  border-bottom: 1px solid #ddd;
}

#myTable tr.header, #myTable tr:hover {
  background-color: #ccffcc;
}
.addBtn {
	padding: 10px;
	width: 25%;
	padding: 15px 20px;
	border-radius: 25px;
	font-size: 18px;
	background: #d9d9d9;
	color: #555;
	float: left;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0
		rgba(0, 0, 0, .19);
	font-family: monospace;
	font-weight: bolder;
}
</style>
</head>
<body>

<h2 >My Contacts</h2>
  <%
	HibernateMyContactsDAO model = new HibernateMyContactsDAO();
  String phone=request.getParameter("phone"); 

	 if(phone != null){
  	String name = request.getParameter("user");
  	Contact contact = new Contact(phone,name);
  	try{
	model.addContact(contact);
  	}
  	catch(MyContactsException e){
  		System.out.println(e.getCause());
  	}
  }
  	%>
  	  <%=request.getContextPath()%>
  	
<%
List<Contact> userItems = model.getAllContacts();
	//List<Contact> userItems = (List<Contact>) session.getAttribute("userItems");
%>
<form action="/Mycontacts/Controller/servlet/get" method="post">

<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names or phone number.." title="Type in a name">
</form>


<table id="myTable">
  <tr class="header">
    <th style="width:60%;">Name</th>
    <th style="width:40%;">Phone Number</th>
  </tr>

  <%
  if(!userItems.isEmpty()){
  for(Contact c:userItems){
	  out.println("<tr><td>"+c.getUserName()+"<td>"+c.getPhoneNumber()+"</td></tr>");
 	 }
   }
  
  %>

</table>

<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    td2 = tr[i].getElementsByTagName("td")[1];


     if(td2 || td){
    	 if (td2.innerHTML.toUpperCase().indexOf(filter) > -1|| td.innerHTML.toUpperCase().indexOf(filter) > -1) {
    	        tr[i].style.display = "";
    	      } else {
    	        tr[i].style.display = "none";
    	      }
    }
  }
}
</script>

<div>
	<form action="addContact.jsp" >
		<span class="btn btn-success">
            <i class="fas fa-plus-circle fa-2x"></i> <input type="submit" value="Add New Contact" class="btn btn-success"/>
		</span>
	</form>
</div>	

</body>
</html>
