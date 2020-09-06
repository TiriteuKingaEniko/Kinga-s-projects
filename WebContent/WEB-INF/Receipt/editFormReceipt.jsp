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
	<h1>Editeaza reteta</h1>

	<form:form action="edit-save-receipt.htm" method="post"
		commandName="receipt">
		
			<form:input path="id" readonly="true" value="${model.receipt.id}" hidden="true"/>
			<table class="table table-striped table-bordered table-responsive">
			<tr>
			<td>Numele retetei </td>
			<td><form:input path="name" /></td>
			</tr>
		<tr>
			<td>Timp de preparare aproximativ</td>
			<td><form:input path="preparingMinutes" /></td>
			<td>minute </td>
			</tr>
			<tr>
			<td>Tipul retetei</td>
			<td><form:select path="type.name">
				<form:option value="none" label="Alege tipul retetei" />
				<form:options itemValue="name" items="${model.typeList}"
					itemLabel="name" />
			</form:select> </td>
			</tr>
		<tr>
		<td>Descrierea retetei </td>
		<td><form:input path="description" /> </td>
		</tr>
		</table>

		<h2>Lista de ingrediente:</h2>
		<br />
		
		<table class="table table-striped table-bordered table-responsive">
			<c:forEach items="${model.receipt.ingredientList}" var="item"
				varStatus="status">
				<tr>
					<td><form:input
							path="ingredientList[${status.index}].ingredient.name"
							readonly="true" /></td>
					<td><form:input
							path="ingredientList[${status.index}].quantity" /></td>
					<td><form:input
							path="ingredientList[${status.index}].ingredient.unit"
							readonly="true" /></td>
					<form:input path="ingredientList[${status.index}].ingredient.id"
						value="${item.ingredient.id}" hidden="true" />
					<form:input path="ingredientList[${status.index}].receiptId"
						value="${item.receiptId}" hidden="true" />
					<form:input path="ingredientList[${status.index}].ingredientId"
						value="${item.ingredientId}" hidden="true" />
				</tr>
			</c:forEach>
		</table>
		
		<p>
		<a href="<c:url value='/add-otherReceiptIngredient.htm?id=${model.receipt.id}'/>"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">+Adauga alte ingrediente la aceasta reteta</a>
	</p>
		
		<input type="submit" value="Editeaza-Salveaza" class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true"/>
	</form:form>

</body>
</html>