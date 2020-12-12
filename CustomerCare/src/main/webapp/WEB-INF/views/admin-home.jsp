<%@ include file="common/header-admin.jspf"%>
<div class="container-fluid">
	<nav class="navbar navbar-inverse nav-div-my">
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
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
					<a href="/roleSelectionPage" class="dropdown-item"> Logout</a> 
					<a class="dropdown-item" href="#">Mail</a> 
					<a class="dropdown-item" href="#">Show All Complaints</a> 
				 	<a class="dropdown-item" href="/admin-create-feedback">Create Feedback</a> 
				 	
				</div>
			</div>
			
		</div>
	</nav>
	<div>
		<a href="/admin-create-feedback">Create FeedBack</a>
	
	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>