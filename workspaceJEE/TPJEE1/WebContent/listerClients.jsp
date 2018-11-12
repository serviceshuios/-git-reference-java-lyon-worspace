<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,metier.Client"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css" />
<title>Liste des Clients</title>
</head>
<body>
<% List<Client> clients = ((List<Client>) request.getAttribute("lesClients")); %>
<div id="content">
		<div class="block">
			<h2>Lister les clients</h2>
			<table>
				<tr>
					<th>ID</th>
					<th>NOM</th>
				    <th>PRENOM</th>
				    <th>YEUX</th>
				    <th>AGE</th>
				</tr>
				<%for (Client c : clients) { %> 
				<tr>
					<td><%=c.getId() %></td>
					<td><%=c.getNom() %></td> 
					<td><%=c.getPrenom() %></td>
					<td><%=c.getCouleurYeux() %></td>
					<td><%=c.getAge() %></td>
				</tr>
				<%} %> 
			</table>
		</div>
</div>

</body>
</html>