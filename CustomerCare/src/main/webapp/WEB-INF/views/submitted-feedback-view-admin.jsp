<%@ include file="common/header-admin.jspf"%>
<div class="container-fluid p-0">
	<nav class="navbar navbar-inverse navbar-dark bg-primary">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/roleSelectionPage">Customer Care</a>
			</div>
			<!-- <ul class="nav navbar-nav navbar-right">

				<li><a href="/admin-login"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul> -->
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Menu</button>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="dropdownMenuButton">
					<a href="/admin-home" class="dropdown-item"> Home</a> <a
						href="/logout" class="dropdown-item"> Logout</a>

				</div>
			</div>

		</div>
	</nav>
	<div class="container mt-3">
		<div class="p-5 text-center bg-image"
			style="background-image: url('https://raw.githubusercontent.com/linjorejoy/host-images-for-projects/99a4ed29e9bcf72ea77f2f51770d3ab682e5b2f7/svg/undraw_like_dislike_1dfj.svg'); width: 200px; height: 200px; background-size: contain; background-repeat: no-repeat; position: absolute; left: 20px; top: 200px;transform: scaleX(-1);"></div>

<div class="p-5 text-center bg-image"
			style="background-image: url('https://raw.githubusercontent.com/linjorejoy/host-images-for-projects/99a4ed29e9bcf72ea77f2f51770d3ab682e5b2f7/svg/undraw_like_dislike_1dfj.svg'); width: 200px; height: 200px; background-size: contain; background-repeat: no-repeat; position: absolute; right: 20px; bottom: 120px;"></div>
		<c:forEach var="feedbackList" items="${feedbacksMap}">
			<div class="card m-4 p-2 shadow p-3 mb-5 bg-white rounded">
				<div class="form-row mb-2">
					<div class="col-3 align-text-top">
						<c:set var="complaint" value="${feedbackList['key']}"></c:set>
						<table>
							<tr>
								<td>User ID :</td>
								<td>${complaint.user.userId}</td>
							</tr>
							<tr>
								<td></td>
								<td>${complaint.user.firstName}${complaint.user.lastName}</td>
							</tr>
							<tr>
								<td></td>
								<td>${complaint.user.emailId}</td>
							</tr>
							<tr>
								<td>Analyst Id :</td>
								<td>${complaint.analyst.analystId}</td>
							</tr>
							<tr>
								<td></td>
								<td>${complaint.analyst.firstName}</td>
							</tr>
							<tr>
								<td>Complaint ID:</td>
								<td>${complaint.complaintId}</td>
							</tr>
						</table>
					</div>
					<div class="col-8">
						<c:forEach var="feedback" items="${feedbackList['value']}">
							<div class="card p-2 m-1">
								<div style="font-weight: bold;">
									<h5>${feedback.question}</h5>
								</div>
								<c:if test="${feedback.answer == null}">**Not Answered**</c:if>
								<div>
									<p>${feedback.answer}</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				Suggestions given : ${complaint.suggestions}
			</div>
		</c:forEach>


	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</body>
</html>