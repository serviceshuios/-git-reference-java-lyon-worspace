<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Liste des clients</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/starter-template.css" rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ProxiBanque</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="ListerClients">Lister clients</a></li>
				</ul>
				<p class="navbar-text navbar-right">
					<a href="LogoutServlet">Se deconnecter</a>
				</p>
				<p class="navbar-text navbar-right">
					Connecté en tant que <strong><c:out
							value="${conseiller.prenom}" /> <c:out value="${conseiller.nom}" />
					</strong>
				</p>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">

		<div class="starter-template">
			<h1>Gestion des clients</h1>
			<h2 class="sub-header">Liste des clients</h2>
			<c:if test="${! empty clients}">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>NOM</th>
								<th>PRENOM</th>
								<th>NOM ENTREPRISE</th>
								<th>ACTIONS</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="c" items="${clients}">
								<tr>
									<td><c:out value="${c.idClient}"></c:out></td>
									<td><c:out value="${c.nom}"></c:out></td>
									<td><c:out value="${c.prenom}"></c:out></td>
									<td><c:out value="${c.nomEntreprise}"></c:out></td>
									<td><a class="btn btn-default"
										href="AfficherClient?id=<c:out value='${c.idClient}' />">Afficher</a><a
										class="btn btn-default"
										href="AfficherClient?action=modifier&id=<c:out value='${c.idClient}' />">Modifier</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>

	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
