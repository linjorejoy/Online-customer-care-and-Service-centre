<%@ include file="common/header-analyst.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-analyst">
		<div class="heading-analyst">
			<h1 class="body-heading-analyst">Analyst Registration</h1>
		</div>

		<div class="form-div">
			<form:form action="/register-analyst" modelAttribute="analyst"
				method="POST">
				<div class="form-input-div">
					<div class="form-div-inputs">
						<form:label path="firstName">First Name</form:label>
						<form:input path="firstName" id="firstName" />
						<form:errors path="firstName"></form:errors>
					</div>
				</div>
				<div class="form-div-inputs">
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName" id="lastName" />
					<form:errors path="lastName"></form:errors>
				</div>
				<div class="form-div-inputs">
					<form:label path="phoneNumber">Phone Number</form:label>
					<form:input path="phoneNumber" id="phoneNumber" />
					<form:errors path="phoneNumber"></form:errors>
				</div>
				<div class="form-div-inputs">
					<form:label path="emailId">Email ID</form:label>
					<form:input path="emailId" id="emailId" />
					<form:errors path="emailId"></form:errors>
				</div>
				<div class="form-div-inputs">
					<form:label path="dateOfBirth">Date Of Birth</form:label>
					<form:input path="dateOfBirth" id="dateOfBirth" />
					<form:errors path="dateOfBirth"></form:errors>
				</div>

				<div class="form-div-inputs">
					<form:label path="gender">Gender</form:label>
					<form:select path="gender" id="gender">
						<form:options items="${genderList}" />
					</form:select>
					<form:errors path="gender"></form:errors>
				</div>
				<div class="form-div-inputs">
					<form:label path="supportLevel">Support Level</form:label>
					<form:select path="supportLevel" id="supportLevel">
						<form:options items="${supportLevel}" />
					</form:select>
					<form:errors path="supportLevel"></form:errors>
				</div>

				<div class="form-div-inputs">
					<form:label path="password">Password</form:label>
					<form:input path="password" id="password" />
					<form:errors path="password"></form:errors>
				</div>
				<div class="form-div-inputs">
					<form:label path="tempPassword">Confirm Password</form:label>
					<form:input path="tempPassword" id="tempPassword" />
					<form:errors path="tempPassword"></form:errors>
				</div>

				<div class="form-buttons-div">

					<input type="Submit" name="submit" value="Register" /> <input
						type="reset" name="reset" value="Reset" />

				</div>
			</form:form>

		</div>
	</div>

	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>
