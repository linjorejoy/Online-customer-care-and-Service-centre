<%@ include file="common/header-analyst.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-analyst">
		<div class="complaints-analyst-view-heading">
			<h1>Complaint Details</h1>
		</div>
		<div class="form-complaint-status-user">
				<form:form action="/update-complaint-analyst" modelAttribute="complaint" method="POST">
			<div class="complaint-view-inputs">
				<form:label path="complaintId">Complaint Id :</form:label>
				<form:input path="complaintId" value="${complaint.complaintId}"/>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="user.userId">User Id :</form:label>
				<form:input path="user.userId" value="${complaint.user.userId}"/>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="phoneNumber">Phone Number :</form:label>
				<form:input path="phoneNumber" value="${complaint.phoneNumber}"/>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="user.emailId">Email Id :</form:label>
				<form:input path="user.emailId" value="${complaint.user.emailId}"/>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="category">Category :</form:label>
				<form:select path="category" items="${category}"/>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="status">Status</form:label>
				<form:select path="status" items="${status}"></form:select>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="analyst.analystId">Assigned Analyst</form:label>
				<form:select path="analyst.analystId" items="${supportLevelWithId}"/>
			</div>
			<div class="complaint-view-inputs">
				<form:label path="complaintId">Complaint Id :</form:label>
				<form:textarea path="description" value="${complaint.description}"/>
			</div>
			<div class="complaint-view-inputs-assign">
				<input type="submit" value="Assign">
				<a href="/download/complaint.xlsx?complaintId=${complaint.complaintId}">Download</a>
			</div>
			
		</form:form>

		</div>

	</div>

	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>