<%@ include file="common/header-user.jspf"%>
<div class="container-fluid">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<div class="heading-complaint-user">
			<!-- <h1 class="heading-compliant-h1">Complaint Submission</h1> -->
		</div>
		<div class="card container">
			<h1 class="heading-compliant-h1">Complaint Submission</h1>
			<form:form
				action="/register-complaint?userId=${user.userId}&complaintId=${baseComplaint.complaintId}"
				modelAttribute="complaint" method="post" cssClass="">
				<div class="form-row mb-2 p-2">
					<div class="col">
						<form:label class="form-control" path="complaintId">Complaint ID:</form:label>
					</div>
					<div class="col">
						<label class="form-control">User Id: </label>
					</div>
					<div class="col">
						<form:label class="form-control" path="phoneNumber">Phone Number:</form:label>
					</div>
					<div class="col">
						<form:label class="form-control" path="category">Category:</form:label>
					</div>

				</div>
				<div class="form-row mb-2 p-2">
					<div class="col">
						<label
							class="form-control badge  badge-light  align-items-center justify-content-center">${baseComplaint.complaintId}</label>
					</div>
					<div class="col">
						<label class="form-control badge  badge-light">${user.userId}</label>
					</div>
					<div class="col">
						<form:input class="form-control" path="phoneNumber"
							id="phoneNumber" value="${user.phoneNumber}"></form:input>
						<form:errors path="phoneNumber"></form:errors>
					</div>
					<div class="col">
						<form:select class="form-control" path="category" id="category"
							items="${categories}" />

					</div>

				</div>
				<div class="form-group shadow-textarea">
					<label for="exampleFormControlTextarea6">Write Your
						Complaint</label>
					<form:textarea path="description"
						class="form-control z-depth-1 p-4"
						id="exampleFormControlTextarea6" rows="3"
						placeholder="Write your Complaint here..."></form:textarea>
					<form:errors path="description"></form:errors>
				</div>
				<div class="p-4">
					<input type="Submit" class="btn btn-success" name="submit"
						value="Submit" />
				</div>

			</form:form>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>
