<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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



	<div class="col-md-9">
		<div class="card flex-md-row mb-4 box-shadow h-md-250">
			<div class="card-body d-flex flex-column align-items-start">
				<strong class="d-inline-block mb-2 text-primary">Reteta mea</strong>
				<h3 class="mb-0">
					<c:out value="${model.nume}" />
				</h3>
				<p class="card-text mb-auto">
				<p>
					Timp de preparare aproximativ:
					<c:out value="${model.preparingMinutes}" />
					minute <br> Categorie de reteta:
					<c:out value="${model.receiptType}" />
				</p>
				<br>
				<p>
					<a class="btn btn-primary" data-toggle="collapse"
						href="#multiCollapseExample1" role="button" aria-expanded="false"
						aria-controls="multiCollapseExample1">Lista de ingrediente</a>
					<button class="btn btn-primary" type="button"
						data-toggle="collapse" data-target="#multiCollapseExample2"
						aria-expanded="false" aria-controls="multiCollapseExample2">Descriere</button>
				</p>
				<div class="row">
					<div class="col">
						<div class="collapse multi-collapse" id="multiCollapseExample1">
							<div class="card card-body">
								<table class="table table-bordered table-hover dataTable table"
									id="dataTable" width="100%" role="grid"
									aria-describedby="dataTable_info" style="width: 100%;">
									<thead>
										<tr role="row">
											<th colspan=3 style="width: 112px;">Lista de ingrediente</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${model.ingredientList}" var="item">
											<c:if test="${item.quantity>0}">
												<tr>
													<td><c:out value="${item.ingredient.name}" /></td>
													<td><c:out value="${item.quantity}" /></td>
													<td><c:out value="${item.ingredient.unit}" /></td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="col">
						<div class="collapse multi-collapse" id="multiCollapseExample2">
							<div class="card card-body">
								<p>
									<c:out value="${model.description}" />
								<p>
							</div>
						</div>
					</div>
				</div>


			</div>
			<img class="card-img-right flex-auto d-none d-md-block"
				src="/MyReceiptBook/Pictures/${model.nume}.jpg"
				alt="Poza cu mancarea" style="width: 250px; height: 250px;"
				>
		</div>
	</div>


	<p>
		<a href="start-week.htm?id=${model.id}"
			class="btn btn-primary btn-lg active" role="button"
			aria-pressed="true">+Adauga aceasta reteta la meniul saptamanii</a>
	</p>

</body>
</html>
