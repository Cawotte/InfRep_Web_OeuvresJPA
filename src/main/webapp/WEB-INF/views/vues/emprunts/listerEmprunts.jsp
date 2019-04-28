<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp"%>

	<div class="container">
		<a class="btn btn-secondary" href="index.htm" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
		<h2>Liste des Emprunts</h2>
		<div class="container">
			<table class="table table-hover">
				<tr>
					<th class="col-md-2">Titre</th>
					<th class="col-md-2">Prénom Propriétaire</th>
					<th class="col-md-2">Nom Propriétaire</th>
				</tr>

				<c:forEach items="${mesEmprunts}" var="item">
					<tr>
						<td>${item.titreOeuvrepret}</td>
						<td>${item.getProprietaireByIdProprietaire().prenomProprietaire}</td>
						<td>${item.getProprietaireByIdProprietaire().nomProprietaire}</td>
						<td><a class="btn btn-warning" href="modifierEmprunt.htm?id=${item.idOeuvrepret}" role="button"><span
								class="glyphicon glyphicon-pencil"></span> Modifier</a>
							<a class="btn btn-danger" href="supprimerEmprunt.htm?id=${item.idOeuvrepret}" role="button"><span
									class="glyphicon glyphicon-remove-circle"></span> Supprimer</a>
					</tr>
				</c:forEach>
			</table>
		</div>
    </div>
<%@include file="../footer.jsp"%>
</body>

</html>