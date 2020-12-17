<%@ include file="common/header-role-selection.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-role-selection.jspf"%>
	<div class="container">
		<!-- Material form login -->
		<div class="card">

			<h5 class="card-header info-color white-text text-center py-4">
				<strong>Sign in</strong>
			</h5>

			<!--Card content-->
			<div class="card-body px-lg-5 pt-0">

				<!-- Form -->
				<strong>${SPRING_SECURITY_LAST_EXCEPTION.message}</strong>
				<form method="POST" action="/login"
					class="form-signin">
					<h2 class="form-heading">Log in</h2>

					<div class="form-group ${error != null ? 'has-error' : ''}">
						<span>${msg}</span> <input name="username" type="text"
							class="form-control" placeholder="Username" autofocus="true" /> <input
							name="password" type="password" class="form-control"
							placeholder="Password" /> <span>${errorMsg}</span>

						<button class="btn btn-lg btn-primary btn-block" type="submit">Log
							In</button>
					</div>

				</form>
				<!-- Form -->

			</div>

		</div>
		<!-- Material form login -->
	</div>

	<div
		class="container text-center d-flex align-items-center justify-content-center mt-2">
	</div>
	<%@ include file="common/footer-role-selection.jspf"%>
</div>
<%@ include file="common/end-tags-role-selection.jspf"%>