<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/Common/navbar.jsp" />
	<h1>Adauga ingredientele</h1>

	<form:form action="save-addReceiptIngredient.htm" method="post"
		commandName="receiptIngredient">
		
		<form:input path="receiptId" readOnly="true" hidden="true"
			value="${model.receiptIngredient.receiptId}" />
		<br />
		<table class="table table-striped table-bordered table-responsive">
		<tr>
		<td> Ingredient </td>
		<td><form:select path="ingredient.name">
			<form:option value="NONE" label="Alege ingredientul" />
			<form:options itemValue="name" items="${model.ingredientDropDown}"
				itemLabel="name" />
		</form:select></td>
		</tr>
		<tr>
		<td> Cantitate </td>
		<td><form:input path="quantity" /> </td>
		<td>
		<form:input path="ingredient.unit" readonly="true"/> </td>
		</tr>
		</table>
		<br />
		
		<p>
		<a href="edit-receipt.htm?id=${model.receiptIngredient.receiptId}"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">Inapoi la pagina de editare</a>
	</p>
		
		<input type="submit" value="Adauga" class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true" />


	</form:form>




</body>
</html>