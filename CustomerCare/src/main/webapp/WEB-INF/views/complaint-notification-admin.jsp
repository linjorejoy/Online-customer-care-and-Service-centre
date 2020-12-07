<%@ include file="common/header-admin.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div class="center-div-complaint-admin">
		<div class="heading">
			<h1>Complaint Notifications</h1>
		</div>
		<div class="div-sorting-complaints-admin">
			<div class="label-sort">Sort By</div>
			<div class="sort-btn">
				<a href="#">Complaint Id</a>
			</div>
			<div class="sort-btn">
				<a href="#">Analyst Id</a>
			</div>
			<div class="sort-btn">
				<a href="#">Date</a>
			</div>
			<div class="sort-btn">
				<a href="#">Category</a>
			</div>
		</div>
		
		<div class="pagination-details">
			<div>Total Complaints : ${totalComplaints}</div>
			<div>Page ${currentPage} of ${totalPages}</div>
			<div>
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a href="/admin-login/page/${i}">${i}</a>
				</c:forEach>
			</div>
		</div>

		<div class="div-complaints-notification-admin">
			<c:forEach var="complaint" items="${complaintListAdmin}">
				<div class="div-complaint-notification">
					<div class="each-complaint-heading">
						<label class="id-heading">Complaint Id : </label> 
						<label class="id-heading">${complaint.complaintId}</label>
					</div>
					<div class="complaint-description-admin">
						<label>Description</label>
						<p>${complaint.description}</p>
					</div>
					<div class="complaint-view-admin-each-submit">
						<input type="submit" id="Submit" value="View" onsubmit="/" />
					</div>
				</div>
			</c:forEach>

		</div>
	</div>

	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>
