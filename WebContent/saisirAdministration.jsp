<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./CSS/bootstrap.min.css">

<title>Enregistrer Age</title>
</head>
<body>
<body>
	<div class="container">

		<h2>Information sur l'age</h2>
		<form method="get" action="/TP1INF3005/AgeControllerServlet">
			<table class="table table-bordered table-condensed table-striped">
				<thead>
					<tr class="success">
						<th>Age minimum</th>
						<th>Age maximum</th>
						<th>Age points</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td><input type="text" name="minAge" /></td>
						<td><input type="text" name="maxAge" /></td>
						<td><input type="text" name="pointsAge" /></td>
					</tr>

				</tbody>
				<tfoot>
					<tr>
						<td colspan="3"><input type="submit" value="Enregistrez" />
						</td>
					</tr>
				</tfoot>

			</table>



		</form>
	</div>
</body>
</body>
</html>