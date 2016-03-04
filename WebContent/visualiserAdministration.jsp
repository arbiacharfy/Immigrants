<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="model"  class="ca.immigrants.models.AgeBean" scope="request"></jsp:useBean>
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
							
					while (model.nextPersonneReady()) {
						 System.out.println("Test : "+model.getMaxAge());
				%>
				<tr>
					<td><jsp:getProperty name="model" property="minAge"></jsp:getProperty>
					</td>
					<td><jsp:getProperty name="model" property="maxAge"></jsp:getProperty>
					</td>
					<td><jsp:getProperty name="model" property="pointsAge"></jsp:getProperty>
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