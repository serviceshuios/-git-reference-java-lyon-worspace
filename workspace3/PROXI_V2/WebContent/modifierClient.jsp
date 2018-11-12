<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Afficher client</title>
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
			<h2 class="sub-header">Modifier un client</h2>
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
			<form class="form-horizontal" method="post" action="ModifierClient">
				<input type="hidden" name="id"
					value="<c:out value='${client.idClient}' />" />
				<fieldset>
					<legend>Informations personnelles</legend>
					<div class="form-group">
						<label for="nom" class="col-sm-2 control-label">Nom</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nom"
								placeholder="Nom" name="nom"
								value="<c:out value='${client.nom}' />" required />
						</div>
					</div>
					<div class="form-group">
						<label for="prenom" class="col-sm-2 control-label">Prénom</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="prenom"
								placeholder="Prénom" name="prenom"
								value="<c:out value='${client.prenom}' />" required />
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Adresse</legend>
					<div class="form-group">
						<label for="adresse" class="col-sm-2 control-label">Adresse</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="adresse"
								placeholder="Adresse" name="adresse"
								value="<c:out value='${client.adresse}' />" required />
						</div>
					</div>
					<div class="form-group">
						<label for="ville" class="col-sm-2 control-label">Ville</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="ville"
								placeholder="Ville" name="ville"
								value="<c:out value='${client.ville}' />" required />
						</div>
					</div>
					<div class="form-group">
						<label for="codepostal" class="col-sm-2 control-label">Code
							postal</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="codepostal"
								placeholder="Code postal" name="codepostal"
								value="<c:out value='${client.codePostal}' />" required />
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Communication</legend>
					<div class="form-group">
						<label for="telephone" class="col-sm-2 control-label">Téléphone</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="telephone"
								placeholder="Téléphone" name="telephone"
								value="<c:out value='${client.telephone}' />" required />
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email"
								placeholder="Email" name="email"
								value="<c:out value='${client.email}' />" required />
						</div>
					</div>
				</fieldset>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Modifier</button>
					</div>
				</div>
			</form>



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
