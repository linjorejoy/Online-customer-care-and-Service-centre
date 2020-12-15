<%@ include file="common/header-analyst.jspf"%>
<div class="container-fluid p-0">
	<nav class="navbar navbar-inverse navbar-dark bg-primary">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/roleSelectionPage">Customer Care</a>
			</div>
		</div>
	</nav>
	<div
		class="container text-center d-flex align-items-center justify-content-center mt-3">
		<!-- Default form login -->
		<div class="card">
			<form:form class="text-center border border-light p-5"
				action="/analyst-login" modelAttribute="analyst" method="post">

				<p class="h2 mb-4">Analyst Sign in</p>

				<!-- Email -->
				<medium id="defaultRegisterFormPhoneHelpBlock"
					class="form-text text-muted text-left mb-0">Analyst Id</medium>
				<form:input path="analystId" type="input" id="defaultLoginFormEmail"
					class="form-control mb-0" placeholder="analyst Id" />
				<small id="defaultRegisterFormPhoneHelpBlock"
					class="form-text text-warning mb-2"><form:errors
						cssClass="mb-4" path="analystId"></form:errors></small>
				<!-- Password -->
				<form:input path="tempPassword" type="password"
					id="defaultLoginFormPassword" class="form-control mb-4"
					placeholder="Password" />
				<small id="defaultRegisterFormPhoneHelpBlock"
					class="form-text text-warning mb-2"><form:errors
						path="tempPassword"></form:errors> </small>

				<div class="d-flex justify-content-around">
					<input class="btn btn-info btn-block md-4 bg-primary" type="Submit"
						name="submit" value="Submit" />
				</div>
				<div class="d-flex justify-content-around p-4">
					<div>
						<!-- Forgot password -->
						<a href="/forgot-id" class="mb-4 p-2">Forgot analyst id?</a>
					</div>
					<div>
						<!-- Forgot password -->
						<a href="/forgot-password-analyst" class="mb-4 p-2">Forgot password?</a>
					</div>
				</div>
				<p>
					You can <a href="/roleSelectionPage">Register</a> Here
				</p>

			</form:form>
			<!-- Default form login -->
		</div>
	</div>
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>
