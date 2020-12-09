<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-user-complaint">
		<div class="heading-complaint-user">
			<h1 class="heading-compliant-h1">Complaint Submission</h1>
		</div>
		<div class="form-complaint-user">
			<form:form action="/register-complaint" modelAttribute="complaint" method="post">
				<div class="form-input-complaint-user">
					<form:label path="complaintId">Complaint ID:</form:label>
					<form:label path="complaintId">${initializedComplaint.complaintId}</form:label>
				</div>
				<div class="form-input-complaint-user">
					<form:label path="user.userId">User ID:</form:label>
					<form:input path="user.userId" id="complaintUserId"
						></form:input>
				</div>
				<div class="form-input-complaint-user">
					<form:label path="phoneNumber">Phone Number:</form:label>
					<form:input path="phoneNumber" id="phoneNumber" value="${user.phoneNumber}"
						></form:input>
				</div>
				<div class="form-input-complaint-user">
					<form:label path="category">Category:</form:label>
					<form:select path="category" id="category" items="${categories}"/>
				</div>
				<div class="form-input-complaint-user-1">
					<form:label path="description">Description:</form:label>
					<form:textarea path="description" id="description" rows="5"
						cols="20" />
					<form:errors path="description"></form:errors>
				</div>
				<div class="form-buttons-complaint-user">
					<input type="Submit" class="button" name="submit" value="Submit" />
				</div>
				
				<form:hidden path="analyst.analystId" value="${initializedComplaint.analyst.analystId}" />
				<form:hidden path="category" value="${initializedComplaint.category}"/>
				<form:hidden path="suggestions" value="${initializedComplaint.suggestions}"/>
				<form:hidden path="status" value="${initializedComplaint.status}"/>
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>