<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-user-complaint">
		<div class="heading-complaint-status-user">
			<h1 class="heading-compliant-status-h1">Complaint Successful</h1>
		</div>
		<div class="form-complaint-status-user">
			<form:form action="/" modelAttribute="complaint" method="get">
				<div class="form-input-complaint-status-user">
					<form:label>Complaint ID:</form:label>
					<form:label>${complaint.complaintId}</form:label>
				</div>

				<div class="form-input-complaint-status-user">
					<form:label>User ID:</form:label>
					<form:label>${complaint.complaintUserId}</form:label>
				</div>
				<div class="form-input-complaint-status-user">
					<form:label>Phone Number:</form:label>
					<form:label>${complaint.phoneNumber}</form:label>
				</div>
				<div class="form-input-complaint-status-user">
					<form:label>Category:</form:label>
					<form:label>${complaint.category}</form:label>
				</div>
				<div class="form-input-complaint-status-user-1">
					<form:label>Description</form:label>
					<form:label>${complaint.description}</form:label>
				</div>
				<div class="form-buttons-complaint-status-user">
					<input type="Submit" class="button" name="submit" value="Submit" />
				</div>



			</form:form>






		</div>
		</div>




		<%@ include file="common/footer-user.jspf"%>
	</div>
	<%@ include file="common/end-tags-user.jspf"%>