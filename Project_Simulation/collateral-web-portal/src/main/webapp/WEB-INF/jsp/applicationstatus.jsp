<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Status</title>
<link rel="stylesheet" href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css" />
<script src="/portal/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="common/header.jsp"%>

	<div class="container">
		<h1><button type="button" class="btn btn-secondary btn-lg btn-block">Application Details</button></h1>
		<div class="sub-container">
			<font color="red">${errorMessage}</font>
			<form:form method="POST" modelAttribute="status" action="viewstatus">

				<table>
					<tr>
						<td><form:label path="applicationId">Application ID</form:label></td>
						<td><form:input class="form-control" path="applicationId" /></td>
					</tr>

					<tr>
						<td></td>
					</tr>
					<tr>
						<td></td>
					</tr>

				</table>
				<div class="btn-width">
					<form:button class="btn btn-primary">fetch</form:button>
				</div>

			</form:form>
		</div>


		<div class="sub-container">



			<table class="table table-bordered">
				<thead class="thead-light">
					<tr>

						<th scope="col">Application ID</th>
						<th scope="col">Customer Id</th>
						<th scope="col">Loan Amount</th>
						<th scope="col">Tenure</th>
						<th scope="col">Collateral Details</th>
						<th scope="col">Status</th>


					</tr>
				</thead>
				<tbody>
					<tr>

						<th scope="row">${app.getApplicationId()}</th>
						<td>${app.getCustomerId()}</td>
						<td>${app.getLoanAmount()}</td>
						<td>${app.getTenure()}</td>
						<td>${app.getCollateralDetails()}</td>
						<td>${app.getStatus()}</td>

					</tr>
				</tbody>
			</table>

		</div>



	</div>
	<%@ include file="common/footer.jsp"%>
</body>
</html>