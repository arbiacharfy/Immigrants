<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="monAge" scope="session" class="ca.immigrants.models.AgeBean" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualiser</title>
<link rel="stylesheet" type="text/css" href="./CSS/bootstrap.min.css">
</head>
<body>

<div class="container">

		<table class="table table-bordered table-condensed table-striped">
			<caption class="text-center">Liste des ages</caption>
			<thead>
				<tr class="success">
					<th>min Age</th>
					<th>Max Age</th>
					<th>Points Age</th>
				</tr>
			</thead>
			<tbody>
				
				<%
					while (monAge.nextAgeReady()) {
				%>
				<tr>
					<td><jsp:getProperty name="monAge" property="minAge"></jsp:getProperty>
					</td>
					<td><jsp:getProperty name="monAge" property="maxAge"></jsp:getProperty>
					</td>
					<td><jsp:getProperty name="monAge" property="pointsAge"></jsp:getProperty>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		
	</div>
</body>
</html>