<%@ include file="common/header-admin.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div class="center-div-admin">
		<div class="centering">
			<div class="heading-admin">
				<h1 class="heading-admin-h1">Admin Login</h1>
			</div>
			<div class="form-div-admin">
				<form:form action="/admin-login" modelAttribute="admin" method="POST"
					cssClass="form">
					<div class="form-input-div-admin form-group">
						<form:label cssClass="label-form-admin" path="adminId"> Admin Id</form:label>
						<form:input path="adminId" id="adminId" />
						<form:errors path="adminId"></form:errors>
					</div>
					<div class="form-input-div-admin form-group">
						<form:label cssClass="label-form-admin" path="password">Password</form:label>
						<form:input path="password" id="password" />
						<form:errors path="password"></form:errors>
					</div>
					<div class="form-group">
						<a href="/">Forgot User Id</a> 
						<a href="/">Forgot Password</a>
					</div>
					
					<div class="form-buttons-div-admin">
						<input type="Submit" class="button" name="submit" value="Submit" /> 
						<input type="reset" class="button" name="reset" value="Cancel" />

					</div>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>
