<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>

	<div class="container">
		<a class="btn btn-secondary" href="index.htm" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
		<h2>Catalogue des Oeuvres</h2>
		<div class="container">
			<table class="table table-hover">
				<tr>
					<th class="col-md-1">Titre</th>
					<th class="col-md-2">Prix</th>
					<th class="col-md-2">Prénom Propriétaire</th>
					<th class="col-md-4">Nom Propriétaire</th>
				</tr>

				<c:forEach items="${mesOeuvres}" var="item">
					<tr>
						<td>${item.titreOeuvrevente}</td>
						<td>${item.prixOeuvrevente}</td>
						<td>${item.getProprietaireByIdProprietaire().prenomProprietaire}</td>
						<td>${item.getProprietaireByIdProprietaire().nomProprietaire}</td>
						<td><a class="btn btn-info" href="modifierOeuvre.htm?id=${item.idOeuvrevente}" role="button"><span
								class="glyphicon glyphicon-pencil"></span> Modifier</a>
							<a class="btn btn-danger" href="supprimerOeuvre.htm?id=${item.idOeuvrevente}" role="button"><span
									class="glyphicon glyphicon-remove-circle"></span> Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
    </div>
<%@include file="footer.jsp"%>
</body>

</html>