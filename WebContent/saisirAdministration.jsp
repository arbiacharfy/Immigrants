<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

		<h2> Information sur l'age</h2>
		<form method="get" action="/AgeControllerServlet">
			Age minimum : <input type="text" name="minAge" required="required" /><br />
			Age maximum : <input type="text" name="maxAge" required="required" /><br />
			Age points : <input type="text" name="pointsAge" required="required" /><br />
			<input type="submit" value="Enregistrez" />

		</form>
	</div>
</body>
</body>
</html>