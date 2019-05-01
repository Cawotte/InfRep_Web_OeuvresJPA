<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body>
<%@include file="../navigation.jsp"%>
<H1> Modification d'un emprunt </H1>
<form method="post" action="updateEmprunt.htm" onsubmit="return teste()">
    <div class="col-md-12 well well-md">
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Titre de l'oeuvre : </label>
            <div class="col-md-3">
                <INPUT type="text" name="titre" value="${emprunt.titreOeuvrepret}" id="nom" class="form-control" min="0">
            </div>

        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Propriétaire :</label>
            <div class="col-md-3">
                <select name="proprietaire" class="form-control">
                    <c:forEach items="${proprietaires}" var="item">
                        <option value="${item.idProprietaire}" <c:if test="${emprunt.getProprietaireByIdProprietaire().equals(item)}">selected</c:if>>${item.nomProprietaire} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <input type="hidden" name="empruntId" value="${emprunt.idOeuvrepret}">
        <div class="form-group">
            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                Modifier
            </button>

            <a href="listerEmprunts.htm">
                <button type="button" class="btn btn-default btn-primary"
                <span class="glyphicon glyphicon-remove"></span> Annuler

                </button>
            </a>
        </div>
    </div>
</form>
<%@include file="../footer.jsp"%>
</body>

</html>