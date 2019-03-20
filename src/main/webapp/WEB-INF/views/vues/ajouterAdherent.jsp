<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<H1> Ajout d'un adhérent </H1>
<form method="post" action="insererAdherent.htm" onsubmit="return teste()">
<div class="col-md-12 well well-md">
    <h1>Ajouter Séjour</h1>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Nom de l'adherent : </label>
        <div class="col-md-3">
            <INPUT type="text" name="txtnom" value="" id="nom" class="form-control" min="0">
        </div>

    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Prénom de l'adherent : </label>
        <div class="col-md-3">
            <INPUT type="text" name="txtprenom" value="" id="prenom" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Ville de l'adherent : </label>
        <div class="col-md-3">
            <INPUT type="text" name="txtville" value="" id="ville" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
            Ajouter
        </button>

        <a href="listerAdherent.htm">
            <button type="button" class="btn btn-default btn-primary"
            <span class="glyphicon glyphicon-remove"></span> Annuler

            </button>
        </a>
    </div>
</div>
</form>
<%@include file="footer.jsp"%>
</body>

</html>