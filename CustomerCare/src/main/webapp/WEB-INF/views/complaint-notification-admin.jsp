<%@ include file="common/header-role-selection.jspf"%>
<div class="container-fluid flex-column">
	<%@ include file="common/nav-bar-role-selection.jspf"%>


	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<div class="centering">
			<div class="heading">
				<h1>Complaint Notifications</h1>
			</div>
			<div class="card text-center">
				<div class="card-header">
					<ul class="nav nav-tabs card-header-tabs">
						<li class="nav-item"><a class="nav-link disabled" href="#">Sort
								by :</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/admin-login/page/${currentPage}?sortBy=complaintId&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Complaint
								Id</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/admin-login/page/${currentPage}?sortBy=dateOfComplaint&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Date</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/admin-login/page/${currentPage}?sortBy=category&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Category</a>
							<!-- <li class="nav-item"><a class="nav-link" href="#">Link</a></li> -->
					</ul>
				</div>
				<div class="card-body">

					<div class="pagination-details">
						<div class="form-row mb-0">
							<div class="col">Total Complaints : ${totalComplaints}</div>
							<div class="col">Page ${currentPage} of ${totalPages}</div>
						</div>
						<nav aria-label="Page navigation example">
							<ul class="pagination pg-blue justify-content-center md-1">
								<c:forEach var="i" begin="1" end="${totalPages}">
									<li class="page-item"><h5>
											<a class="page-link"
												href="/admin-login/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
										</h5></li>
								</c:forEach>
							</ul>
						</nav>
					</div>

					<div
						class="container text-center d-flex align-items-center justify-content-center">
						<form:form action="/admin-login/page/${currentPage}"
							class="text-center border border-light" method="get">

							<div class="form-row mb-4">
								<div class="col">
									<!-- First name -->
									<input type="text" id="defaultRegisterFormFirstName"
										class="form-control" placeholder="Search by Category"
										name="keyword" value="${keyword}">
								</div>
								<input type="hidden" name="sortBy" value="${sortBy}" /> <input
									type="hidden" name="sortDir" value="${reverseSortDir}" /> <input
									type="hidden" name="date" value="${date}" />
							</div>
							<button type="submit" class="btn btn-primary mb-2">Search</button>
						</form:form>

						<form:form action="/admin-login/page/${currentPage}"
							class="text-center border border-light" method="get">

							<div class="form-row mb-4">
								<div class="col">
									<!-- Last name -->
									<input id="txtSearch" type="text" name="date"
										placeholder="YYYY-MM-DD" class="form-control" value="${date}">
								</div>
								<input type="hidden" name="sortBy" value="${sortBy}" /> <input
									type="hidden" name="sortDir" value="${reverseSortDir}" /> <input
									type="hidden" name="keyword" value="${keyword}" />
							</div>
							<button type="submit" class="btn btn-primary mb-2">Search</button>
						</form:form>
					</div>

					<c:forEach var="complaint" items="${complaintListAdmin}">


						<!-- Card content -->
						<div class="card card-body card-body-cascade text-center">

							<!-- Title -->
							<h4 class="card-title">
								<strong>Complaint Id : ${complaint.complaintId}</strong>
							</h4>
							<!-- Subtitle -->
							<h6 class="font-weight-bold indigo-text py-2">Description</h6>
							<!-- Text -->
							<p class="card-text">${complaint.description}</p>
							<div class="span2 text-right">
								<a
									href="/show-user-complaint-admin?complaintId=${complaint.complaintId}"
									class="btn btn-primary">View</a>
								<!-- <a href="#"
									class="btn btn-primary">Go somewhere</a> -->
							</div>
						</div>

					</c:forEach>

					<div class="pagination-details">
						<div class="form-row mb-2">
							<div class="col">Total Complaints : ${totalComplaints}</div>
							<div class="col">Page ${currentPage} of ${totalPages}</div>
						</div>
						<nav aria-label="Page navigation example">
							<ul class="pagination pg-blue justify-content-center">
								<c:forEach var="i" begin="1" end="${totalPages}">
									<li class="page-item"><h5>
											<a class="page-link"
												href="/admin-login/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
										</h5></li>
								</c:forEach>
							</ul>
						</nav>
					</div>


				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-role-selection.jspf"%>
</div>
<%@ include file="common/end-tags-role-selection.jspf"%>