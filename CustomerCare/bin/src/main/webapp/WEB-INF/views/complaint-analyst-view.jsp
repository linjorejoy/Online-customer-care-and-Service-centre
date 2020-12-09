<%@ include file="common/header-analyst.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-analyst">
		<div class="complaints-analyst-view-heading">
			<h1>Complaint Details</h1>
		</div>
		<div class="form-complaint-status-user">
		<form:form action="/" modelAttribute="complaint" method="get">
			<div>
				<div>
					<label>Complaint Id : </label> <label>${complaint.complaintId}</label>
				</div>
				<div>
					<label>User Id : </label>
					<label>${complaint.user.userId}</label>
				</div>
				<div>
					<label>Phone Number : </label>
					<label>${complaint.phoneNumber}</label>
				</div>
				<div>
					<label>Category : </label>
					<label>${complaint.category}</label>
				</div>
				<div>
					<form:label path="status">Status:</form:label>
					<form:select path="status" id="status" items="${status}" />
				</div>
				<div>
					<form:label path="">Assigned Analyst:</form:label>
					<form:select path="" id="" items="${supportLevel}"/>
				</div>
				<div>
					<label>Description : </label>
					<label>${complaint.description}</label>
				</div>
				<div>
					<button onclick="#">Submit</button>
				</div>
				



			</div>
			</form:form>

		</div>

	</div>

	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>