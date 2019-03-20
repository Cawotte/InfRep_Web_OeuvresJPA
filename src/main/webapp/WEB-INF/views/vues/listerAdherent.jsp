<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
	<div class="jumbotron text-center">
		<h1>Listing des adhérents</h1>
	</div>

	<div class="container">
		<a class="btn btn-secondary" href="index.htm" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
		<h2>Tableau des Adhérents</h2>
		<div class="container">
			<h3>Liste des Adhérents</h3>
			<table class="table table-hover">
				<tr>
					<th class="col-md-1">Numero</th>
					<th class="col-md-2">Nom</th>
					<th class="col-md-2">Prénom</th>
					<th class="col-md-4">Ville</th>

				</tr>

				<c:forEach items="${mesAdherents}" var="item">
					<tr>
						<td>${item.idAdherent}</td>
						<td>${item.nomAdherent}</td>
						<td>${item.prenomAdherent}</td>
						<td>${item.villeAdherent}</td>
						<td><a class="btn btn-info" href="modifierAdherent.htm?id=${item.idAdherent}" role="button"><span
								class="glyphicon glyphicon-pencil"></span> Modifier</a>
							<a class="btn btn-danger" href="supprimerAdherent.htm?id=${item.idAdherent}" role="button"><span
									class="glyphicon glyphicon-remove-circle"></span> Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
    </div>
<%@include file="footer.jsp"%>
</body>

</html>