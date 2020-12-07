<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-user-complaint">
		<div class="heading-complaint-status-user">
			<h1 class="heading-compliant-status-h1">Complaint Successful</h1>
		</div>
		<div class="form-complaint-status-user">
			<div>
				<div>
					<label>Complaint Id : </label>
					<label>${submittedComplaint.complaintId}</label>
				</div>
				<div>
					<label>Uder Id : </label>
					<label>${submittedComplaint.user.userId}</label>
				</div>
				<div>
					<label>Phone Number : </label>
					<label>${submittedComplaint.phoneNumber}</label>
				</div>
				<div>
					<label>Category : </label>
					<label>${submittedComplaint.category}</label>
				</div>
<<<<<<< HEAD
				<div class="form-input-complaint-status-user-1">
					<form:label>Description:</form:label>
					<form:label>${complaint.description}</form:label>
=======
				<div>
					<label>Description : </label>
					<label>${submittedComplaint.description}</label>
>>>>>>> 6ecbaba582f780e03aefa97db6d3d7fb30c4433a
				</div>
				
				<div>
					<button onclick="#">Edit</button>
					<button onclick="#">Go to Home</button>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>