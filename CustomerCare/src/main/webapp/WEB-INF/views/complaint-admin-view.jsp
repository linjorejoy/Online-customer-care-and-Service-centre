<%@ include file="common/header-admin.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<!-- <div class="complaint-view-heading">Complaint</div> -->

		<div class="complaint-view-form"></div>
		<form:form class="text-center border border-light p-5"
			action="/update-complaint-admin" modelAttribute="complaint"
			method="POST">
			<h1>Complaint View</h1>
			<div class="form-row mb-2">
				<div class="col">
					<form:label class="form-control" path="complaintId">Complaint Id :</form:label>
				</div>
				<div class="col">
					<form:input class="form-control" path="complaintId"
						value="${complaint.complaintId}" />
				</div>
				<div class="col">
					<form:label class="form-control" path="user.userId">User Id :</form:label>
				</div>
				<div class="col">
					<form:input class="form-control" path="user.userId"
						value="${complaint.user.userId}" />
				</div>
			</div>
			<div class="form-row mb-2">
				<div class="col">
					<form:label class="form-control" path="phoneNumber">Phone Number :</form:label>
				</div>
				<div class="col">
					<form:input class="form-control" path="phoneNumber"
						value="${complaint.phoneNumber}" />
				</div>
				<div class="col">
					<form:label class="form-control" path="user.emailId">Email Id :</form:label>
				</div>
				<div class="col">
					<form:input class="form-control" path="user.emailId"
						value="${complaint.user.emailId}" />
				</div>
			</div>
			<div class="form-row mb-2">
				<div class="col">
					<form:label class="form-control" path="category">Category :</form:label>
				</div>
				<div class="col">
					<form:select class="form-control" path="category"
						items="${category}" />
				</div>
				<div class="col">
					<form:label class="form-control" path="status">Status</form:label>
				</div>
				<div class="col">
					<form:select class="form-control" path="status" items="${status}"></form:select>
				</div>
			</div>
			<div class="form-row mb-2">
				<div class="col">
					<form:label class="form-control" path="analyst.analystId">Assigned Analyst</form:label>
				</div>
				<div class="col">
					<form:select class="form-control" path="analyst.analystId"
						items="${supportLevelWithId}" />
				</div>
			</div>
			<div class="form-group shadow-textarea">
				<label for="exampleFormControlTextarea6">Description</label>
				<form:textarea path="description" class="form-control z-depth-1 p-4"
					id="exampleFormControlTextarea6" rows="4" cols="100"
					value="${complaint.description}"></form:textarea>
				<form:errors path="description"></form:errors>
			</div>
			<div class="complaint-view-inputs-assign">
				<input class="btn btn-success" type="submit" value="Assign">
				
				<a class="btn btn-primary
				" 
					href="/download/complaint.xlsx?complaintId=${complaint.complaintId}">Download
					Excel File<span class="material-icons"> get_app </span>
				</a>
			</div>

		</form:form>
	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>