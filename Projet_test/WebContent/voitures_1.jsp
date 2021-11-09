<%@page import="web.VoitureModele"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Location-V</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header_1.jsp" %>
<p></p>
<div class="container">
<div class="card">
 <div class="card-header">
 location de voitures
 </div>
 <div class="card-body">
 <form action="chercher_admin.do" method="get">
 <label>Mot Clé</label>
 <input type="text" name="motCle" value="${model.f}" />
 <label>active</label>
 <input type="text" name="active" value="${model.a}" />
 <label >date début:</label>
 <input type="datetime-local" name="date_min" min="2021-01-01T00:00" max="2021-12-31T00:00" value ="${model.date_min}"/>
 <label >date fin:</label>
 <input type="datetime-local" name="date_fin" min="2021-01-01T00:00" max="2021-12-31T00:00" value ="${model.date_fin}"/>
 <button type="submit" class="btn btn-primary">Chercher</button>
 </form>
<c:if test = "${model.check == 4}">
         <p>Merci de spécifier une date de récupération valide<p>
</c:if>
 
<c:if test = "${model.check == 0}">
         <p>Merci de spécifier des dates valides<p>
</c:if>
<c:if test = "${model.check == 3}">
         <p>Merci de spécifier une date de retour valide<p>
</c:if>
 
 <table class="table table-striped">
 <tr>
 <th>ID</th><th>Voiture</th><th>carImage</th><th>description</th><th>Prix par jour(DH)</th><th>active</th><th>supression</th><th>édition</th>
 </tr>
 <c:forEach items="${model.voitures}" var="v">
 <tr>
 <td >${v.getID()}</td>
 <td>${v.getVoiture()}</td>
 <td><img src="${v.getCarImage()}" alt="car ${v.getID()}" style="height:100%;width:70%;"></td>
 <td>${v.getDescription()}</td>
 <td>${v.getPrix()}</td>
 <td>${v.getActive()}</td>
 <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimer.do?id=${v.getID() }">Supprimer</a></td>
 <td><a href="editer.do?id=${v.getID() }">éditer</a></td>
 </tr>
 </c:forEach>
 </table>
 </div>
</div>
</div>
</body>
</html>
