<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Identification sur ProxiBanque</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<!-- DEBUT MESSAGE -->
		<c:if test="${not empty alertDanger}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${alertDanger}" />
			</div>
		</c:if>
		<c:if test="${not empty alertSuccess}">
			<div class="alert alert-success" role="alert">
				<c:out value="${alertSuccess}" />
			</div>
		</c:if>
		<!-- FIN MESSAGE -->
		<form class="form-signin" method="post" action="LoginServlet">
			<h2 class="form-signin-heading">Veuillez vous identifier</h2>
			<label for="login" class="sr-only">Login</label> <input type="text"
				id="login" name="login" class="form-control" placeholder="Login"
				required> <label for="pwd" class="sr-only">Mot de
				passe</label> <input type="password" id="pwd" name="pwd"
				class="form-control" placeholder="Mot de passe" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">S'identifier</button>
		</form>
	</div>
	<!-- /container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>