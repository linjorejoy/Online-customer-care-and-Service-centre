<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-div-user">
		<div class="heading-user">
			<h1 class="heading-user-h1">User Login</h1>
		</div>
		<div class="form-div-user">
			<form:form action="/user-login" modelAttribute="complaint" method="post">
				<div class="form-input-div-user">
					<form:label path="user.userId"> User Id</form:label>
					<form:input path="user.userId" id="user-userid" />
					<form:errors path="user.userId"></form:errors>
				</div>
				<div class="form-input-div-user">
					<form:label path="user.tempPassword">Password</form:label>
					<form:input path="user.tempPassword" id="tempPassword" type="password" />
					<form:errors path="user.tempPassword"></form:errors>
				</div>
				<div class="form-group">
					<a href="/">Forgot User Id</a> <a href="/">Forgot Password</a>
				</div>

				<div class="form-buttons-div-user">
					<input type="Submit" name="submit" value="Submit" /> <input
						type="reset" name="reset" value="Cancel" />

				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>
