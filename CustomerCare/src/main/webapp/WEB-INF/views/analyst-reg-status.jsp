<%@ include file="common/header-analyst.jspf"%>
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
				<a href="/analyst-home" class="btn btn-light" >Login</a>
			</div>
		</div>
	</nav>
	<div class="center-div-analyst">
		<div class="heading-analyst">
			<h1>User Registration Successful</h1>
		</div>
		<div class="heading-analyst">
			<label class="text-success"><h1>Your Analyst Id is
					${analystId}</h1></label>
		</div>

	</div>

	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>
