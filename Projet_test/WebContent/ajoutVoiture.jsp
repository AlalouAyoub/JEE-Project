<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Location-V</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header_1.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Information voiture</div>
			<div class="card-body">
				<form action="save.do" method="post">
					<div class="form-group">
						<label class="control-label">Nom voiture :</label> <input
							type="text" name="nom" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">Car Image :</label> <input
							type="text" name="CarI" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">Prix :</label> <input type="text"
							name="prix" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">Description</label> <input
							type="text" name="Description" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">active</label> <input type="text"
							name="active" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">Date début</label> <input type="text"
							name="date_min" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">date_fin</label> <input type="text"
							name="date_fin" class="form-control" />
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
