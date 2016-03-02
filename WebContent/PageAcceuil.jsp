<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="age" scope="session"
	class="ca.immigrants.models.AgeBean" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Age</title>
</head>
<body>
	minimum Age :
	<jsp:getProperty property="minAge" name="age" />
	maximum Age :
	<jsp:getProperty property="maxAge" name="age" />
	Points Age :
	<jsp:getProperty property="pointsAge" name="age" />

</body>
</html>