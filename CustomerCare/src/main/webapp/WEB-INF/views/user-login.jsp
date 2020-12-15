<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center mt-3">
		<!-- Default form login -->
		<div class="card">
			<form:form class="text-center border border-light p-5"
				action="/user-login" modelAttribute="user" method="post">

				<p class="h2 mb-4">User Sign in</p>

				<!-- Email -->
				<medium id="defaultRegisterFormPhoneHelpBlock"
					class="form-text text-muted text-left mb-0">User Id</medium>
				<form:input path="userId" type="input" id="defaultLoginFormEmail"
					class="form-control mb-0" placeholder="User Id" />
				<small id="defaultRegisterFormPhoneHelpBlock"
					class="form-text text-warning mb-2"><form:errors
						cssClass="mb-4" path="userId"></form:errors></small>
				<!-- Password -->
				<form:input path="tempPassword" type="password"
					id="defaultLoginFormPassword" class="form-control mb-4"
					placeholder="Password" />
				<small id="defaultRegisterFormPhoneHelpBlock"
					class="form-text text-warning mb-2"><form:errors
						path="tempPassword"></form:errors> </small>

				<div class="d-flex justify-content-around">
					<input class="btn btn-info btn-block my-4 bg-primary text-light" type="Submit"
						name="submit" value="Submit" />	
				</div>
				<div class="d-flex justify-content-around p-4">
					<div>
						<!-- Forgot password -->
						<a href="/forgot-userID-mail" class="mb-4 p-2">Forgot user id?</a>
					</div>
					<div>
						<!-- Forgot password -->
						<a href="/forgot-password" class="mb-4 p-2">Forgot password?</a>
					</div>
				</div>
				<p>
					You can <a href="/roleSelectionPage">Register</a> Here
				</p>

			</form:form>
			<!-- Default form login -->
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>
