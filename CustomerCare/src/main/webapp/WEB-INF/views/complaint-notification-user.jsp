<%@ include file="common/header-role-selection.jspf"%>
<div class="container-fluid flex-column p-0">
	<nav class="navbar navbar-inverse navbar-dark bg-primary">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/roleSelectionPage">Customer Care</a>
			</div>
			<!-- <ul class="nav navbar-nav navbar-right">

				<li><a href="/admin-login"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul> -->
			<div class="dropdown">
				<a class="btn btn-light" href="/user-home">Home</a>
				<button class="btn btn-light dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
					Menu<span class="badge badge-danger ml-2">${emailCount}</span>
				</button>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="dropdownMenuButton">
					<a href="/logout" class="dropdown-item"> Logout</a> <a
						class="dropdown-item" href="#">Mail<span
						class="badge badge-danger ml-2">${emailCount}</span></a> <a
						class="dropdown-item" href="/user-home?userId=${user.userId}">Home</a>
					<a class="dropdown-item" href="#">View Profile</a>
					<!-- <a class="dropdown-item" href="#">Something	else here</a> -->
				</div>
			</div>
		</div>
	</nav>


	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<div class="p-5 text-center bg-image"
			style="background-image: url('https://raw.githubusercontent.com/linjorejoy/host-images-for-projects/b8b24b8c78d7ea2401779f33a04551f895b739e4/svg/undraw_Selection_re_poer.svg'); width: 300px; height: 300px; background-size: contain; background-repeat: no-repeat; position: absolute; right: 2%; top: 50%; transform: translate(10%, -50%);"></div>
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
							href="/user-complaint-list-view/page/${currentPage}?sortBy=complaintId&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Complaint
								Id</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/user-complaint-list-view/page/${currentPage}?sortBy=dateOfComplaint&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Date</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/user-complaint-list-view/page/${currentPage}?sortBy=category&sortDir=${reverseSortDir}&keyword=${keyword}&date=${date}">Category</a>
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
												href="/user-complaint-list-view/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
										</h5></li>
								</c:forEach>
							</ul>
						</nav>
					</div>

					<div
						class="container text-center d-flex align-items-center justify-content-center">
						<form:form action="/user-complaint-list-view/page/${currentPage}"
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

						<form:form action="/user-complaint-list-view/page/${currentPage}"
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
						<form:form action="/user-complaint-list-view/page/${currentPage}"
							class="text-center border border-light" method="get">

							<div class="form-row mb-4">
								<div class="col">
									<!-- First name -->
									<input type="text" id="defaultRegisterFormFirstName"
										class="form-control" placeholder="Search by User Id"
										name="userId" value="${userId}">
								</div>
								<input type="hidden" name="sortBy" value="${sortBy}" /> <input
									type="hidden" name="sortDir" value="${reverseSortDir}" /> <input
									type="hidden" name="date" value="${date}" />
							</div>
							<button type="submit" class="btn btn-primary mb-2">Search</button>
						</form:form>

						<form:form action="/user-complaint-list-view/page/${currentPage}"
							class="text-center border border-light" method="get">

							<div class="form-row mb-4">
								<div class="col">
									<!-- Last name -->
									<input id="txtSearch" type="text" name="complaintId"
										placeholder="Enter complaintId" class="form-control"
										value="${complaintId}" required>
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
							<div class="form-row">
								<div class="col">
									<h6 class="font-weight-bold indigo-text py-2">Description</h6>
								</div>
								Complaint Created By : <strong>${complaint.user.userId}</strong>
								<div class="col">
									Assigned Analyst Id <strong>${complaint.analyst.analystId}</strong>
								</div>
								<div class="col">
									<label class="btn btn-info">${complaint.status}</label>
								</div>
							</div>
							<!-- Text -->
							<p class="card-text">${complaint.description}</p>
							<%-- <div class="span2 text-right">
								<a
									href="/show-user-complaint-user?complaintId=${complaint.complaintId}"
									class="btn btn-primary">View</a>
								<!-- <a href="#"
									class="btn btn-primary">Go somewhere</a> -->
							</div> --%>
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
												href="/user-complaint-list-view/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
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