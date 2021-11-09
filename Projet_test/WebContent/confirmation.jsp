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
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
 <div class="card-header">
Information voiture
 </div>
 <div class="card-body">
 <form action="Confirmation_r.do" method="post">
 <div hidden class="form-group">
 <label class="control-label">ID_voiture :</label>
 <input type="text" name="ID" class="form-control" value="${voiture.getID()}"/>
 </div>
 <div class="form-group">
 <label class="control-label">Nom voiture :</label>
 <input type="text" name="nom_v" class="form-control" value="${voiture.getVoiture()}"/>
 </div>
 <div class="form-group">
 <label class="control-label">Prix :</label>
 <input type="text" name="prix" class="form-control" value="${voiture.getPrix()}"/>
 </div>
 <div class="form-group">
 <label class="control-label">Description</label>
 <input type="text" name="Description" class="form-control" value="${voiture.getDescription()}"/>
 </div>
 <div class="form-group">
 <label class="control-label">Votre prénom</label>
 <input type="text" name="prenom" class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">Votre nom</label>
 <input type="text" name="nom" class="form-control"/>
 </div>
 <div class="form-group">
 <label class="control-label">Votre numéro de téléphone</label>
 <input type="text" name="tel" class="form-control"/>
 </div>
 <div>
 <button type="submit" onclick="return confirm('Etes-vous sûr ?')" class="btn btn-primary">Réserver</button>
 </div>
 </form>
 </div>
</div>
</div>
</body>
</html>
