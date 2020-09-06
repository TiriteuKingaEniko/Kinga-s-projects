<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<Style>
.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 50%;
}

td.fitwidth {
	width: 1px;
	white-space: nowrap;
}

th.fitwidth {
	width: 1px;
	white-space: nowrap;
}

.container {
	max-width: 1200px;
	margin: auto;
	backround: #f2f2f2;
	overflow: auto;
}

.gallery {
	margin: 5px 10px;
	border: 1px solid #ccc;
	float: left;
	width: 390px;
}

.gallery img {
	width: 100%;
	height: auto;
}

.desc {
	padding: 15px;
	text-align: center;
}
}
</Style>
</head>
<body>
	<jsp:include page="/WEB-INF/Common/navbar.jsp" />

	<div class=container>

		<c:forEach var="r" items="${model.receiptList}">
			<div class="gallery">
				<img src="/MyReceiptBook/Pictures/${r.name}.jpg"
					alt="Poza cu mancarea">
				<div class="desc">
					<h5>
						<c:out value="${r.name}" />
					</h5>

					<button class="btn btn-success">
						<a style="color: #FFFFFF"
							href="<c:url value='/find-receipt.htm?id=${r.id }'/>">
							Detalii reteta</a>
					</button>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>