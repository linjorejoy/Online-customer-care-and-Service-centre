<%@ include file="common/header-analyst.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-complaint-analyst">
		<div class="centering-">
			<div class="heading">
				<h1>Complaint Notifications</h1>
			</div>
			<div class="div-sorting-complaints-analyst">
				<div class="label-sort">Sort By</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=complaintId&sortDir=${reverseSortDir}">Complaint
						Id</a>
				</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=analyst.analystId&sortDir=${reverseSortDir}">Analyst
						Id</a>
				</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=dateOfComplaint&sortDir=${reverseSortDir}">Date</a>
				</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=category&sortDir=${reverseSortDir}">Category</a>
				</div>
			</div>

			<div class="pagination-details">
				<div>Total Complaints : ${totalComplaints}</div>
				<div>Page ${currentPage} of ${totalPages}</div>
				<div>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<a
							href="/analyst-login/page/${i}?analystId=${analystId}&sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
					</c:forEach>
				</div>
			</div>

			<div class="div-complaints-notification-analyst">
				<c:forEach var="complaint" items="${complaintListAnalyst}">
					<div class="div-complaint-notification">
						<div class="each-complaint-heading">
							<label class="id-heading">Complaint Id : </label> <label
								class="id-heading">${complaint.complaintId}</label>
						</div>
						<div class="complaint-description-analyst">
							<label>Description</label>
							<p>${complaint.description}</p>
						</div>
						<div class="complaint-view-analyst-each-submit">
							<input type="submit" id="Submit" value="View" onsubmit="/" />
						</div>
					</div>
				</c:forEach>

			</div>

			<div class="pagination-details">
				<div>Total Complaints : ${totalComplaints}</div>
				<div>Page ${currentPage} of ${totalPages}</div>
				<div>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<a
							href="/analyst-login/page/${i}?analystId=${analystId}&sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>
