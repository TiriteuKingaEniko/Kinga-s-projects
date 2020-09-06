<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Cauta in numele retetelor:

	<form:form action="search-what-receipt.htm" method="post" commandName="receipt">
			
			<form:input path="name" />

		<input type="submit" value="Cauta" />
		</br>
		<a href='index.html'>Inapoi la pagina de pornire </a>
	</form:form>

</body>
</html>