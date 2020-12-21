<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
	<nav class="navbar navbar-inverse navbar-dark bg-primary">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/roleSelectionPage">Customer Care</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/user-home"><span
						class="glyphicon glyphicon-log-in nav-link text-light">Home</span>
				</a></li>
			</ul>
		</div>
	</nav>
	<div
		class="container text-center d-flex align-items-center justify-content-center">

		<h2 class="display-3">Your User Id is : ${userId }</h2>



	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>