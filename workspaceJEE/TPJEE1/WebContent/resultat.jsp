<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css" />
<title>Ma première JSP</title>
</head>
<body>
	<p>
		Bonjour, nous sommes le <span><%=new java.util.Date()%></span>
	</p>
	<p>
		Bonjour
		<%=request.getAttribute("leprenom")%>
		<%=request.getAttribute("lenom")%></p>
	<p>
		le mot de passe saisi est le
		<%=request.getAttribute("lemdp")%></p>

	<%
		String[] loisirs = ((String[]) request.getAttribute("lesloisirs"));
		if (loisirs != null) {
			for (int i = 0; i < loisirs.length; i++) {
	%>
	<p>
		Vous aimez
		<%=loisirs[i]%>
	</p>
	<% }
}
%>
</body>
</html>