<%@ include file="common/header-admin.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div class="center-complaint-view-admin">
		<div class="complaint-view-heading">Complaint</div>

		<div class="complaint-view-form"></div>
		<form:form action="/" modelAttribute="complaint" method="GET">
			<div class="complaint-view-inputs">
				<label>Complaint ID:</label> <label>${complaint.complaintId}</label>
			</div>
			<div class="complaint-view-inputs">
				<label>User ID:</label> <label>${complaint.user.userId}</label>
			</div>
			<div class="complaint-view-inputs">
				<label>Phone number:</label> <label>${complaint.phoneNumber}</label>
			</div>
			<div class="complaint-view-inputs">
				<label>Email ID:</label> <label>${complaint.user.emailId}</label>
			</div>
			<div class="complaint-view-inputs">
				<label>Category:</label><label>${category}</label>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="status">Status</form:label>
				<form:select path="status" items="${status}"></form:select>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="supportLevel">Assigned Analyst</form:label>
				<form:select path="supportLevel" items="${supportLevel}"></form:select>
			</div>
			<div class="complaint-view-inputs">
				<label>Description:</label> <label>${complaint.description}</label>
			</div>
			<div class="complaint-view-inputs-assign">
				<input type="submit" value="Assign">
			</div>
			
		</form:form>
	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>