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
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Information voiture</div>
			<div class="card-body">
				<form action="admin.do" method="post">
					<div class="form-group">
						<label class="control-label">nom</label> <input type="text"
							name="nom" class="form-control" />
					</div>
					<div class="form-group">
						<label class="control-label">mot de passe</label> <input
							type="password" name="mdp" class="form-control" />
					</div>
					<c:if test="${a == 1}">
						<p>Vos informations sont incorrects
						<p>
					</c:if>
					<div>
						<button type="submit" class="btn btn-primary">Se
							connecter</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
