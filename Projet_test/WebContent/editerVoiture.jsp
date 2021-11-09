<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
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
Modification des voitures
</div>
<div class="card-body">
<form action="update.do" method="post">
<div hidden class="form-group">
<label class="control-label">ID:</label>
<input type="text" name="id" class="form-control" value="${voiture.getID()}"/>
</div>
<div class="form-group">
<label class="control-label">Nom  :</label>
<input type="text" name="nom" class="form-control" value="${voiture.getVoiture()}"/>
</div>
<div class="form-group">
<label class="control-label">Prix :</label>
<input type="text" name="prix" class="form-control" value="${voiture.getPrix()}"/>
</div>
<div class="form-group">
<label class="control-label">Description :</label>
<input type="text" name="description" class="form-control" value="${voiture.getDescription()}"/>
</div>
<div class="form-group">
<label class="control-label">Image :</label>
<input type="text" name="CarI" class="form-control" value="${voiture.getCarImage()}"/>
</div>
<div class="form-group">
<label class="control-label">active :</label>
<input type="text" name="active" class="form-control" value="${voiture.getActive()}"/>
</div>
<div class="form-group">
<label class="control-label">date début :</label>
<input type="text" name="date_debut" class="form-control" value="${voiture.getDate_debut()}"/>
</div>
<div class="form-group">
<label class="control-label">date fin  :</label>
<input type="text" name="date_fin" class="form-control" value="${voiture.getDate_fin()}"/>
</div>
<div>
<button onclick="return confirm('Etes-vous sûr ?')" type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>