<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>

	<div class="centering-">
		<div class="heading">
			<h1>Complaint Notifications</h1>
		</div>
		<div class="div-sorting-complaints-admin">
			<div class="label-sort">Sort By</div>
			<div class="sort-btn">
				<a
					href="/user-complaint-list-view/page/${currentPage}?sortBy=complaintId&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Complaint
					Id</a>
			</div>
			<div class="sort-btn">
				<a
					href="/user-complaint-list-view/page/${currentPage}?sortBy=dateOfComplaint&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Date</a>
			</div>
			<div class="sort-btn">
				<a
					href="/user-complaint-list-view/page/${currentPage}?sortBy=category&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Category</a>
			</div>
		</div>

		<div class="div-filter-complaints-admin">
			<div class="div-filter-complaints-admin-sub">
				<form:form action="/user-complaint-list-view/page/${currentPage}" method="get">
					<input id="txtSearch" type="text" name="keyword"
						placeholder="Enter category">
					<input type="hidden" name="sortBy" value="${sortBy}" />
					<input type="hidden" name="sortDir" value="${reverseSortDir}" />
					<input type="hidden" name="date" value="${date}" />
					<input type="submit" value="Search" />
					<!-- <button type="submit">Search</button> -->
				</form:form>
			</div>
			<div class="div-filter-complaints-admin-sub">
				<form:form action="/user-complaint-list-view/page/${currentPage}" method="get">
					<input id="txtSearch" type="text" name="date"
						placeholder="YYYY-MM-DD" required>
					<input type="hidden" name="sortBy" value="${sortBy}" />
					<input type="hidden" name="sortDir" value="${reverseSortDir}" />
					<input type="hidden" name="keyword" value="${keyword}" />
					<button type="submit">Search</button>
				</form:form>
			</div>
			
		</div>
		<div class="div-filter-complaints-admin-sub">
				<form:form action="/user-complaint-list-view/page/${currentPage}" method="get">
					<input id="txtSearch" type="text" name="userId"
						placeholder="Enter UserId" required>
					<input type="hidden" name="sortBy" value="${sortBy}" />
					<input type="hidden" name="sortDir" value="${reverseSortDir}" />
					<input type="hidden" name="userId" value="${userId}" />
					<button type="submit">Search</button>
				</form:form>
			</div>
			<div class="div-filter-complaints-admin-sub">
				<form:form action="/user-complaint-list-view/page/${currentPage}" method="get">
					<input id="txtSearch" type="text" name="complaintId"
						placeholder="Enter complaintId" required>
					<input type="hidden" name="sortBy" value="${sortBy}" />
					<input type="hidden" name="sortDir" value="${reverseSortDir}" />
					<input type="hidden" name="complaintId" value="${complaintId}" />
					<button type="submit">Search</button>
				</form:form>
			</div>
		</div>
		

		<div class="pagination-details">
			<div>Total Complaints : ${totalComplaints}</div>
			<div>Page ${currentPage} of ${totalPages}</div>
			<div>
				<c:forEach var="i" begin="1" end="${totalPages}">
					<a
						href="/user-complaint-list-view/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
				</c:forEach>
			</div>
		</div>

		<div class="div-complaints-notification-admin">
			<c:forEach var="complaint" items="${complaintListAdmin}">
				<div class="div-complaint-notification">
					<div class="each-complaint-heading">
						<label class="id-heading">Complaint Id : </label> <label
							class="id-heading">${complaint.complaintId}</label>
					</div>
					<div class="complaint-description-admin">
						<label>Description</label>
						<p>${complaint.description}</p>
					</div>
					<div class="complaint-view-admin-each-submit">
						<a
							href="/show-user-complaint?complaintId=${complaint.complaintId}">View</a>
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
						href="/user-complaint-list-view/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
				</c:forEach>
			</div>
		</div>
	</div>
</div>


<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>