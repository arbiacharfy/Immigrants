<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="age" scope="session"
	class="ca.immigrants.models.AgeBean" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualiser</title>
<link rel="stylesheet" type="text/css" href="./CSS/bootstrap.min.css">
</head>
<body>

<div class="container">

		<table class="table table-bordered table-condensed table-striped">
			<caption class="text-center">Liste des personnes
				enregistrées</caption>
			<thead>
				<tr class="success">
					<th>id</th>
					<th>Nom</th>
					<th>Prenom</th>
				</tr>
			</thead>
			<tbody>
				<!-- ceci illustre un exemple de boucle -->
				<%
					while (true) {
				%>
				<tr>
					<td><jsp:getProperty name="model" property="idPersonne"></jsp:getProperty>
					</td>
					<td><jsp:getProperty name="model" property="nomPersonne"></jsp:getProperty>
					</td>
					<td><jsp:getProperty name="model" property="prenomPersonne"></jsp:getProperty>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		minimum Age :
		<jsp:getProperty property="minAge" name="age" />
		maximum Age :
		<jsp:getProperty property="maxAge" name="age" />
		Points Age :
		<jsp:getProperty property="pointsAge" name="age" />
	</div>
</body>
</html>