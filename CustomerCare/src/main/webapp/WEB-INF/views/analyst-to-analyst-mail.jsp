<%@ include file="common/header-admin.jspf"%>
<div class="container-fluid">
	<%@ include file="common/nav-bar-admin.jspf"%>

	<div
		class="container text-left d-flex align-items-center justify-content-center">
		<div class="email-div">
			<form:form modelAttribute="emailAnalyst" method="POST"
				action="/sent-email-analyst-to-analyst?analystId=${emailAnalyst.analyst.analystId}"
				cssClass="text-left border border-light p-5">
				<form:hidden path="admin.adminId"
					value="${emailAnalyst.admin.adminId}" />
				<div class="form-row mb-2">
					<div class="col">
						<form:label path="emailId">Email Number</form:label>
					</div>
					<div class="col">
						<form:input path="emailId" value="${emailAnalyst.emailId}" />
					</div>
				</div>
				<div class="form-row mb-2">
					<div class="col">
						<form:label path="analyst.firstName">Email To : </form:label>
					</div>
					<div class="col">
						<form:input path="analyst.firstName"
							value="${emailAnalyst.analyst.firstName}" />
					</div>
				</div>
				<div class="form-row mb-2">
					<div class="col">
						<form:label path="analyst.analystId">Email To Id : </form:label>
					</div>
					<div class="col">
						<form:input path="analyst.analystId"
							value="${emailAnalyst.analyst.analystId}" />
					</div>
				</div>
				<div class="form-row mb-2">
					<div class="col">
						<form:label path="sentDate">Date : </form:label>
					</div>
					<div class="col">
						<form:input path="sentDate" value="${emailAnalyst.sentDate}" />
					</div>
				</div>
				<div class="form-row mb-2">
					<div class="col">
						<label>Complaint</label>
					</div>
					<div class="col">
						<p>${complaint.description}</p>
					</div>
				</div>
				<div class="form-group shadow-textarea">
					<label for="exampleFormControlTextarea6">Description</label>
					<form:textarea path="description"
						class="form-control z-depth-1 p-4"
						id="exampleFormControlTextarea6" rows="15" cols="150"
						value="${emailAnalyst.description}"></form:textarea>
					<form:errors path="description"></form:errors>
				</div>
				<input type="submit" value="Sent Email" />
			</form:form>

		</div>

	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>