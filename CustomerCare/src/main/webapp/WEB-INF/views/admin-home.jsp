<%@ include file="common/header-admin.jspf"%>
<div class="container-fluid p-0">
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
				<button class="btn btn-primary dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">Menu</button>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="dropdownMenuButton">
					<a href="/logout" class="dropdown-item"> Logout</a> <a
						class="dropdown-item" href="#">Mail</a> <a class="dropdown-item"
						href="/show-all-complaint-admin">Show All Complaints</a> <a class="dropdown-item"
						href="/admin-create-feedback">Create Feedback</a>

				</div>
			</div>

		</div>
	</nav>
	<div class="container mt-3">

		<h2>Welcome ${admin.firstName}</h2>
		<%-- <a href="/create-complaint?userId=${user.userId}">Create Complaint</a> --%>

		<div class="row">
			<%-- <div class="d-inline-block col-sm-6" style="height: 200px;">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Create A Complaint</h5>
						<p class="card-text">Submit Your complaint by clicking here.</p>
						<a href="/create-complaint?userId=${analyst.analystId}" class="btn btn-primary">Something</a>
					</div>
				</div>
			</div> --%>
			<div class="h-25  d-inline-block col-sm-6" style="height: 100px;">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Create FeedBack Survey</h5>
						<p class="card-text">Create A new Feedback Survey for a User</p>
						<a href="/show-all-complaint-admin" class="btn btn-primary">Create FeedBack</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>

<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</body>
</html>