<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Effectuer un virement</title>
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
			<h2 class="sub-header">Virement compte à compte</h2>
			<!-- DEBUT MESSAGE -->
			<c:if test="${not empty alertDanger}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${alertDanger}" />
				</div>
			</c:if>
			<!-- FIN MESSAGE -->
			<form class="form-horizontal" method="post"
				action="EffectuerVirement">
				<input type="hidden" name="idclient"
					value="<c:out value="${idclient}" />" />

				<h3>Compte à débiter</h3>
				<input type="hidden" name="idcomptedebiteur"
					value="<c:out value="${compteDebiteur.idCompte}" />" />
				<dl class="dl-horizontal">
					<dt>Numéro de compte</dt>
					<dd>
						<c:out value="${compteDebiteur.numeroCompte}" />
					</dd>
					<dt>Solde</dt>
					<dd>
						<c:out value="${compteDebiteur.solde}" />
					</dd>
				</dl>
				<h3>Compte à créditer</h3>
				<div class="form-group">
					<label for="comptecrediteur" class="col-sm-2 control-label">Numéro
						de compte :</label>
					<div class="col-sm-10">
						<select class="form-control" id="comptecrediteur"
							name="idcomptecrediteur" required>
							<option value="" selected disabled>Choisissez un compte</option>
							<c:forEach var="c" items="${autresComptes}">
								<option value="<c:out value='${c.idCompte}' />"><c:out
										value="${c.numeroCompte}" /></option>
							</c:forEach>
						</select>
					</div>
				</div>
				<h3>Montant à virer</h3>
				<div class="form-group">
					<label for="montant" class="col-sm-2 control-label">Montant</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="montant"
							placeholder="Montant" name="montant" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Effectuer
							virement</button>
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
