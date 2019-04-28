<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<script type="text/javascript">
    function valider() {
        if ((document.formResa.date.value !== "")) {
            return true;
        }
        alert("Merci de saisir remplir la date")
        return false;
    }
</script>
<H1> Reservation d'une oeuvre </H1>
<form method="post" action="addReservation.htm" name="formResa" onsubmit="return valider()">
    <div class="col-md-12 well well-md">
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Oeuvre</label>
            <div class="col-md-3">
                <div class="form-control">${oeuvre.titreOeuvrevente}</div>
                <input type="hidden" name="idOeuvre" value="${oeuvre.idOeuvrevente}"/>
            </div>

        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Date de Reservation</label>
            <div class="col-md-3">
                <INPUT type="date" name="date" value="" id="date" class="form-control" min="0">
            </div>
        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Adherent : </label>
            <div class="col-md-3">
                <select name="adherent" class="form-control">
                    <c:forEach items="${adherents}" var="item">
                        <option value="${item.idAdherent}">${item.nomAdherent} </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                Valider
            </button>

            <a href="listerOeuvres.htm">
                <button type="button" class="btn btn-default btn-primary"
                <span class="glyphicon glyphicon-remove"></span> Annuler

                </button>
            </a>
        </div>
    </div>
</form>
<%@include file="footer.jsp"%>
</body>