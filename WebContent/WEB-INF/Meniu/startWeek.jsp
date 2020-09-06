<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Insert title here</title>
<style>


.button {
	border: none;
	color: white;
	padding: 16px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: white;
	color: black;
	border: 2px solid #4CAF50;
}

.button1:hover {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/Common/navbar.jsp" />
	
		<table border=1 class="table table-striped table-bordered table-responsive">
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
				<th style="white-space: nowrap">Mic dejun</th>
				<td><c:forEach var="r" items="${model.monday1}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
					
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.mondayId}&type=1&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.tuesday1}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.tuesdayId}&type=1&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.wednesday1}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.wednesdayId}&type=1&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.thursday1}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.thursdayId}&type=1&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.friday1}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.fridayId}&type=1&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.saturday1}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.saturdayId}&type=1&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.sunday1}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.sundayId}&type=1&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
			</tr>
			<tr>
				<th style="white-space: nowrap">Pranz</th>
				<td><c:forEach var="r" items="${model.monday2}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.mondayId}&type=2&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.tuesday2}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.tuesdayId}&type=2&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.wednesday2}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.wednesdayId}&type=2&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.thursday2}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.thursdayId}&type=2&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.friday2}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.fridayId}&type=2&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.saturday2}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.saturdayId}&type=2&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.sunday2}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.sundayId}&type=2&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
			</tr>
			<tr>
				<th style="white-space: nowrap">Cina</th>
				<td><c:forEach var="r" items="${model.monday3}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.mondayId}&type=3&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.tuesday3}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.tuesdayId}&type=3&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.wednesday3}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.wednesdayId}&type=3&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.thursday3}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.thursdayId}&type=3&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.friday3}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.fridayId}&type=3&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.saturday3}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.saturdayId}&type=3&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
				<td><c:forEach var="r" items="${model.sunday3}">
						<div>
							<c:out value="${r.name}" />
						</div>
					</c:forEach>
					<div>
						<button class="btn btn-success">
							<a style="color: #FFFFFF"
								href="<c:url value='/add-receipt-for-this-meal.htm?dayId=${model.sundayId}&type=3&receiptId=${model.receiptId}'/>">+Adauga
								reteta</a>
						</button>

					</div></td>
			</tr>
		</table>

</body>
</html>