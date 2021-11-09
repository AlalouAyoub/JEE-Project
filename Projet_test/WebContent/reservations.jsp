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
 Mes résservations
 </div>
 <div class="card-body">
 <table class="table table-striped">
 <tr>
 <th>ID</th><th>Voiture</th><th>Prix par jour(DH)</th><th>Nom</th><th>Prenom</th><th>Tel</th><th>supression</th>
 </tr>
 <c:forEach items="${reservations}" var="r">
 <tr>
 <td >${r.getID()}</td>
 <td>${r.getNom_v()}</td>
 <td>${r.getPrix()}</td>
 <td>${r.getNom_u()}</td>
 <td>${r.getPrenom_u()}</td>
 <td>${r.getTel()}</td>
 <td><a onclick="return confirm('Etes-vous sûr ?')" href="annuler_r.do?id=${r.getID() }">Annuler</a></td>
 </tr>
 </c:forEach>
 </table>
 </div>
</div>
</div>
</body>
</html>
