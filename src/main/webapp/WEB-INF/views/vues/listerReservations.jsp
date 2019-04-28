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
                <th class="col-md-2">Adhérent</th>
                <th class="col-md-2">Date Réservation</th>
                <th class="col-md-4">status</th>
                <th></th>
            </tr>

            <c:forEach items="${reservations}" var="item">
                <tr>
                    <td>${item.getOeuvreventeByIdOeuvrevente().titreOeuvrevente}</td>
                    <td>${item.getAdherentByIdAdherent().prenomAdherent} ${item.getAdherentByIdAdherent().nomAdherent}</td>
                    <td>${item.dateReservation}</td>
                    <td>${item.statut}</td>
                    <td>
                        <c:if test='${item.statut == "en attente"}'>
                            <a class="btn btn-info" href="validerReservation.htm?idAdherent=${item.getAdherentByIdAdherent().idAdherent}&idOeuvre=${item.getOeuvreventeByIdOeuvrevente().idOeuvrevente}" role="button"><span
                                class="glyphicon glyphicon-pencil"></span> Valider</a>
                        </c:if>
                        <c:if test='${item.statut != "annulee"}'>
                        <a class="btn btn-danger" href="annulerReservation.htm?idAdherent=${item.getAdherentByIdAdherent().idAdherent}&idOeuvre=${item.getOeuvreventeByIdOeuvrevente().idOeuvrevente}" role="button"><span
                                class="glyphicon glyphicon-remove-circle"></span> Annuler</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>