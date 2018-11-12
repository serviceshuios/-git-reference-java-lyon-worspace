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
			<h2 class="sub-header">Afficher un client</h2>
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
			<h3>Informations client</h3>
			<dl class="dl-horizontal">
				<dt>Nom</dt>
				<dd>
					<c:out value="${client.nom}" />
				</dd>
				<dt>Prénom</dt>
				<dd>
					<c:out value="${client.prenom}" />
				</dd>
				<dt>Entreprise</dt>
				<dd>
					<c:out value="${client.nomEntreprise}" />
				</dd>
				<dt>Adresse</dt>
				<dd>
					<c:out value="${client.adresse}" />
				</dd>
				<dt>Code Postal</dt>
				<dd>
					<c:out value="${client.codePostal}" />
				</dd>
				<dt>Ville</dt>
				<dd>
					<c:out value="${client.ville}" />
				</dd>
				<dt>Téléphone</dt>
				<dd>
					<c:out value="${client.telephone}" />
				</dd>
				<dt>Email</dt>
				<dd>
					<c:out value="${client.email}" />
				</dd>
			</dl>

			<c:forEach var="c" items="${client.comptes}">
				<!-- determiner le type de class fille -->
				<c:if test="${c['class'].simpleName == 'CompteCourant'}">
					<h3>Compte courant</h3>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>NUMERO COMPTE</th>
									<th>SOLDE</th>
									<th>DECOUVERT</th>
									<th>DATE OUVERTURE</th>
									<th>ACTION</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="${c.numeroCompte}" /></td>
									<td><c:out value="${c.solde}" /></td>
									<td><c:out value="${c.decouvert}" /></td>
									<td><c:out value="${c.dateOuverture}" /></td>
									<td><a class="btn btn-default"
										href="Virement?idclient=<c:out value='${client.idClient}' />&idcompte=<c:out value='${c.idCompte}' />">Effectuer
											virement</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</c:if>
				<c:if test="${c['class'].simpleName == 'CompteEpargne'}">
					<h3>Compte epargne</h3>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>NUMERO COMPTE</th>
									<th>SOLDE</th>
									<th>REMUNERATION</th>
									<th>DATE OUVERTURE</th>
									<th>ACTION</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="${c.numeroCompte}" /></td>
									<td><c:out value="${c.solde}" /></td>
									<td><c:out value="${c.remuneration}" /></td>
									<td><c:out value="${c.dateOuverture}" /></td>
									<td><a class="btn btn-default"
										href="Virement?idclient=<c:out value='${client.idClient}' />&idcompte=<c:out value='${c.idCompte}' />">Effectuer
											virement</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</c:if>

			</c:forEach>
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
