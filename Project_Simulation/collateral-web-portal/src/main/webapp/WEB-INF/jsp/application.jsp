<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Loan</title>
<link rel="stylesheet" href="/portal/css/bootstrap.min.css">
<link rel="stylesheet" href="/portal/css/name.css/" type="text/css" />
<script src="/portal/js/bootstrap.min.js"></script>
<!-- <style>
.list{
margin-left: 82%;
}
.btn {
	margin-left: auto;
	margin-right: auto;
	width: 100%;
}
</style> -->
</head>
<body>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="container">
		<div class="list">
			
		</div>

		<h1><button type="button" class="btn btn-secondary btn-lg btn-block">Enter the Application Details</button></h1>
		<div class="sub-container">

			<font color="red", size=12px>${errorMessage}</font>
			<form:form method="POST" modelAttribute="application" action="loanapplication">
				<table>
					<tr>
						<td><form:label path="applicationId">Application Id</form:label></td>
						<td><form:input class="form-control" path="applicationId" /></td>
					</tr>
					<tr>
						<td><form:label path="customerId">Customer Id</form:label></td>
						<td><form:input class="form-control" path="customerId" /></td>
					</tr>
					<tr>
						<td><form:label path="loanAmount">Loan Amount</form:label></td>
						<td><form:input class="form-control" path="loanAmount" /></td>
					</tr>
					<tr>
						<td><form:label path="tenure">Tenure</form:label></td>
						<td><form:input class="form-control" path="tenure" /></td>
					</tr>
					<tr>
						<td><form:label path="collateralDetails">Collateral Details</form:label></td>
						<td><form:input class="form-control" path="collateralDetails" /></td>
					</tr>
					<tr>
						<td><form:label path="status"></form:label></td>
						<td><form:hidden class="form-control" path="status" value="applied"/></td>
					</tr>
				</table>
				<div class="btn-width">
					<form:button class="btn btn-primary">Apply</form:button>
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