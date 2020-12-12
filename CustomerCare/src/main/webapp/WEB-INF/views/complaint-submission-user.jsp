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
					<label>User Id : </label>
					<label>${user.userId}</label>
				</div>
				<div>
					<label>Phone Number : </label>
					<label>${submittedComplaint.phoneNumber}</label>
				</div>
				<div>
					<label>Category : </label>
					<label>${submittedComplaint.category}</label>
				</div>
				<div>
					<label>Description : </label>
					<label>${submittedComplaint.description}</label>
				</div>
				
				<div>
					<a href="#">Edit</a>					
					<a href="/user-home?userId=${user.userId}">Go To Home</a>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>