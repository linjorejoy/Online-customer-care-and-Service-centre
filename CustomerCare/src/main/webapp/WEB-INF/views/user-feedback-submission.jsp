<%@ include file="common/header-user.jspf"%>
<div class="container-fluid flex-column p-0">
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
				<button class="btn btn-light dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					Menu<span class="badge badge-danger ml-2">${emailCount}</span>
				</button>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="dropdownMenuButton">
					<a href="/logout" class="dropdown-item"> Logout</a> <a
						class="dropdown-item" href="#">Mail<span
						class="badge badge-danger ml-2">${emailCount}</span></a> <a
						class="dropdown-item" href="/user-home?userId=${user.userId}">Home</a>
					<a class="dropdown-item" href="#">View Profile</a>
					<!-- <a class="dropdown-item" href="#">Something	else here</a> -->
				</div>
			</div>
		</div>
	</nav>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<div>
			<form:form modelAttribute="complaint" action="/submit-feedback?userId=${userId}"
				method="POST">
				<form:hidden path="complaintId" value="${complaintId}" />
				<c:forEach var="feedback" items="${complaint.feedbackList}"
					varStatus="i">

					<div class="col-10 jobs_index_middle_panels">
						<div class="card card-body  card-body-cascade text-center">
							<h4>
								<form:label path="feedbackList[${i.index}]">${feedback.question}</form:label>
							</h4>
							<form:textarea path="feedbackList[${i.index}].answer"
								class="form-control z-depth-1 p-4"
								id="exampleFormControlTextarea6" rows="3"
								placeholder="Write your Feedback here..." />
							<!--<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>-->
						</div>

					</div>
				</c:forEach>

				<div class="col-10 jobs_index_middle_panels">
					<div class="card card-body  card-body-cascade text-center">
						<h4>
							<form:label path="suggestions">Please Give any Suggestions</form:label>
						</h4>
						<form:textarea path="suggestions"
							class="form-control z-depth-1 p-4"
							id="exampleFormControlTextarea6" rows="3"
							placeholder="Write your Suggestions here..." />

						<input type="submit" value="Submit Feedback"
							class="btn btn-success mt-4 mb-4" />
					</div>
				</div>
			</form:form>


		</div>
	</div>

	<%@ include file="common/footer-role-selection.jspf"%>
</div>
<%@ include file="common/end-tags-role-selection.jspf"%>