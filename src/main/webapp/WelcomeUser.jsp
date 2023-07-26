<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
 background-color: #f3d5b5;
	display: list-item;
}
a{
text-decoration: none;
}

</style>
<title>Welcome</title>
</head>
<body>
<h1>
        <Marquee scrollamount="15" behavior="alternate" direction="" bgcolor="grey"><%="Welcome "+session.getAttribute("name") %></marquee>
    </h1>
<div>
<h2>Personal Details</h2>
<table  border="1" bordercolor="black" cellpadding="2" >
<tr>
<td><%="Name" %></td>
<td><%=session.getAttribute("name")%></td>
</tr>
<tr>
<td><%="Email" %></td>
<td><%=session.getAttribute("email")%></td>
</tr>
<tr>
<td><%="Contact" %></td>
<td><%=session.getAttribute("contact")%></td>
</tr>
<tr>
<td><%="Gender" %></td>
<td><%=session.getAttribute("gender")%></td>
</tr>
<tr>
<td><%="Address" %></td>
<td><%=session.getAttribute("address")%></td>
</tr>
</table>
<br>
</div>
<button><a href="Update_Profile.html">UpdateProfile</a> </button>
</div>
<h2>Education Details</h2>
<div>
<table  border="1" bordercolor="black" cellpadding="5" borderstyle="none" >
<tr>
<td><%="Degree" %></td>
<td><%=session.getAttribute("degree")%></td>
</tr>
<tr>
<td><%="Stream" %></td>
<td><%=session.getAttribute("stream")%></td>
</tr>
<tr>
<td><%="Percentage" %></td>
<td><%=session.getAttribute("per")%></td>
</tr>
<tr>
<td><%="Year Of PassOut" %></td>
<td><%=session.getAttribute("yop")%></td>
</tr>
<tr>
<td><%="Cource Opted" %></td>
<td><%=session.getAttribute("cource")%></td>
</tr>
<tr>
<td colspan="2">Contact Admin For updation of Educational Details </td>
</tr>
</table>
</div>
</body>
</html>