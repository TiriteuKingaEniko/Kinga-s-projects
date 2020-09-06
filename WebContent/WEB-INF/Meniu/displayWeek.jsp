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


	<table border=1
		class="table table-striped table-bordered table-responsive">
		<tr>
			<th>Masa
			</td>
			<th>Luni
			</td>
			<th>Marti
			</td>
			<th>Miercuri
			</td>
			<th>Joi
			</td>
			<th>Vineri
			</td>
			<th>Sambata
			</td>
			<th>Duminica
			</td>
		</tr>
		<tr>
			<th>Mic dejun</th>
			<td><c:forEach var="r" items="${model.monday1}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.mondayId}&type=1&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.tuesday1}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.tuesdayId}&type=1&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.wednesday1}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.wednesdayId}&type=1&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.thursday1}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.thursdayId}&type=1&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.friday1}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.fridayId}&type=1&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.saturday1}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.saturdayId}&type=1&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.sunday1}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.sundayId}&type=1&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
		</tr>
		<tr>
			<th>Pranz</th>
			<td><c:forEach var="r" items="${model.monday2}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.mondayId}&type=2&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.tuesday2}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.tuesdayId}&type=2&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.wednesday2}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.wednesdayId}&type=2&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.thursday2}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.thursdayId}&type=2&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.friday2}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.fridayId}&type=2&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.saturday2}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.saturdayId}&type=2&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.sunday2}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.sundayId}&type=2&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
		</tr>
		<tr>
			<th>Cina</th>
			<td><c:forEach var="r" items="${model.monday3}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.mondayId}&type=3&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.tuesday3}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.tuesdayId}&type=3&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.wednesday3}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.wednesdayId}&type=3&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.thursday3}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.thursdayId}&type=3&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.friday3}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.fridayId}&type=3&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.saturday3}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.saturdayId}&type=3&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
			<td><c:forEach var="r" items="${model.sunday3}">
					<div>
						<c:out value="${r.name}" />
						<a class="btn btn-danger"
							href="<c:url value='/delete-this-receipt.htm?dayId=${model.sundayId}&type=3&receiptId=${r.id}'/>">
							<svg width="1em" height="1em" viewBox="0 0 16 16"
								class="bi bi-trash" fill="currentColor"
								xmlns="http://www.w3.org/2000/svg">
  <path
									d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
  <path fill-rule="evenodd"
									d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
</svg>
						</a>
					</div>
				</c:forEach></td>
		</tr>

	</table>

	<br />


	<p>
		<a href="<c:url value='/reset.htm'/>"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">- Reseteaza toata saptamana</a>
	</p>


</body>


</html>