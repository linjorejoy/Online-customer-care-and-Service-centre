<%@ include file="common/header-user.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-div-user">
		<div class="centering">
			<div class="heading-user">
				<h1 class="body-heading-user">User Registration</h1>
			</div>
			<div class="form-div">
				<form:form action="/register-user" modelAttribute="user"
					method="POST" cssClass="form-div-my">
					<div class="form-div-inputs">
						<form:label path="firstName">First Name</form:label>
						<form:input path="firstName" />
						<form:errors path="firstName"></form:errors>
					</div>
					<div class="form-div-inputs">
						<form:label path="lastName">Last Name</form:label>
						<form:input path="lastName" />
						<form:errors path="lastName"></form:errors>
					</div>
					<div class="form-div-inputs">
						<form:label path="phoneNumber">Phone Number</form:label>
						<form:input path="phoneNumber" />
						<form:errors path="phoneNumber"></form:errors>
					</div>
					<div class="form-div-inputs">
						<form:label path="emailId">Email Id</form:label>
						<form:input path="emailId" />
						<form:errors path="emailId"></form:errors>
					</div>
					<div class="form-div-inputs">
						<form:label path="dateOfBirth">Date Of Birth</form:label>
						<form:input path="dateOfBirth" />
						<form:errors path="dateOfBirth"></form:errors>
					</div>
					<div class="form-div-inputs">
						<form:label path="gender">Gender</form:label>
						<form:select path="gender" items="${genderList}"></form:select>
						<form:errors path="gender"></form:errors>
					</div>
					<div class="form-div-inputs">
						<form:label path="password">Password</form:label>
						<form:input path="password" />
						<form:errors path="password"></form:errors>
					</div>
					<div class="form-div-inputs">
						<form:label path="tempPassword">Confirm Password</form:label>
						<form:input type="password" path="tempPassword" />
						<form:errors path="tempPassword"></form:errors>
					</div>
					<div class="form-buttons-div">
						<input type="submit" class="button-my" name="Submit"
							value="Register" /> <input type="reset" class="button-my"
							name="reset" value="Reset" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>
