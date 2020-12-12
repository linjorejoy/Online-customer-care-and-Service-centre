<%@ include file="common/header-role-selection.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-role-selection.jspf"%>


	<div
		class="container text-center d-flex align-items-center justify-content-center mt-2">
		<div>
			<c:set var="isUser" value="${userActive}"></c:set>
			<c:set var="isAnalyst" value="${analystActive}"></c:set>
			<c:set var="isAdmin" value="${adminActive}"></c:set>

			<div
				class="container text-center d-flex align-items-center justify-content-center">
				<ul class="nav nav-pills mb-1" id="pills-tab" role="tablist">
					<li class="nav-item"><a
						class='nav-link <c:if test="${isUser}">active</c:if>'
						id="pills-user-tab" data-toggle="pill" href="#pills-user"
						role="tab" aria-controls="pills-user" aria-selected="true"><h3>User</h3></a></li>
					<li class="nav-item"><a
						class='nav-link <c:if test="${isAnalyst}">active</c:if>'
						id="pills-analyst-tab" data-toggle="pill" href="#pills-analyst"
						role="tab" aria-controls="pills-analyst" aria-selected="false"><h3>Analyst</h3></a></li>
					<li class="nav-item"><a
						class='nav-link <c:if test="${isAdmin}">active</c:if>'
						id="pills-admin-tab" data-toggle="pill" href="#pills-admin"
						role="tab" aria-controls="pills-admin" aria-selected="false"><h3>Admin</h3></a></li>
				</ul>
			</div>
			<div class="tab-content pt-2 pl-1" id="pills-tabContent">
				<div class='tab-pane fade <c:if test="${isUser}">active show</c:if>'
					id="pills-user" role="tabpanel" aria-labelledby="pills-user-tab">
					<form:form action="/register-user" modelAttribute="user"
						method="POST" cssClass="text-center border border-light p-5">

						<div class="form-row mb-2">
							<div class="col">
								<!-- First name -->
								<form:input class="form-control" placeholder="First name"
									path="firstName" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="firstName"></form:errors></small>
							</div>
							<div class="col">
								<!-- Last name -->
								<form:input class="form-control" placeholder="Last name"
									path="lastName" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="lastName"></form:errors></small>
							</div>
						</div>
						<div class="form-row mb-1">
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-0"> Phone Number </small>
								<form:input path="phoneNumber" class="form-control"
									placeholder="Phone number"
									aria-describedby="defaultRegisterFormPhoneHelpBlock" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-0"> <form:errors
										class="form-text text-warning mb-0" path="phoneNumber"></form:errors></small>
							</div>
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-0"> Email </small>
								<form:input class="form-control mb-2" placeholder="E-mail"
									path="emailId" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="emailId"></form:errors></small>
							</div>
						</div>


						<div class="form-row mb-1">
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-1"> Date Of Birth </small>
								<form:input path="dateOfBirth" class="form-control mb-2"
									placeholder="Date Of Birth" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="dateOfBirth"></form:errors></small>

							</div>
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-1"> Gender </small>
								<form:select class="form-control mb-2" path="gender"
									items="${genderList}"></form:select>
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="gender"></form:errors></small>
							</div>
						</div>
						<div class="form-row mb-2">
							<div class="col">
								<form:input class="form-control mb-1" placeholder="Password"
									type="password" path="password" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="password"></form:errors></small>

							</div>
							<div class="col">
								<form:input class="form-control mb-1"
									placeholder="Confirm Password" type="password"
									path="tempPassword" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="tempPassword"></form:errors></small>
							</div>
						</div>
						<div class="form-buttons-div">
							<input type="submit" class="btn btn-info my-4 btn-block bg-primary text-light"
								name="Submit" value="Register" /> OR<a
								class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect bg-success text-light"
								href="/user-login">Login</a> 
						</div>
					</form:form>
				</div>

				<!--  -->
				<!--  -->
				<!--  -->
				<!--  -->
				<!--  -->
				<!--  -->
				<div
					class='tab-pane fade <c:if test="${isAnalyst}">active show</c:if>'
					id="pills-analyst" role="tabpanel"
					aria-labelledby="pills-analyst-tab">

					<form:form action="/register-analyst" modelAttribute="analyst"
						method="POST" cssClass="form-div-my">

						<div class="form-row mb-2">
							<div class="col">
								<!-- First name -->
								<form:input class="form-control" placeholder="First name"
									path="firstName" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-1"><form:errors
										path="firstName"></form:errors></small>
							</div>
							<div class="col">
								<!-- Last name -->
								<form:input class="form-control" placeholder="Last name"
									path="lastName" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-1"><form:errors
										path="lastName"></form:errors></small>
							</div>
						</div>
						<div class="form-row mb-1">
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-0"> Phone Number </small>
								<form:input path="phoneNumber" class="form-control"
									placeholder="Phone number"
									aria-describedby="defaultRegisterFormPhoneHelpBlock" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-0"> <form:errors
										class="form-text text-warning mb-0" path="phoneNumber"></form:errors></small>
							</div>
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-0"> Email </small>
								<form:input class="form-control mb-2" placeholder="E-mail"
									path="emailId" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-0"><form:errors
										path="emailId"></form:errors></small>
							</div>
						</div>

						<div class="form-row mb-1">
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-1"> Date Of Birth </small>
								<form:input path="dateOfBirth" class="form-control mb-2"
									placeholder="Date Of Birth" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-1"><form:errors
										path="dateOfBirth"></form:errors></small>

							</div>
							<div class="col">
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-muted mb-1"> Gender </small>
								<form:select class="form-control mb-2" path="gender"
									items="${genderList}"></form:select>
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-1"><form:errors
										path="gender"></form:errors></small>
							</div>
						</div>

						<div class="form-row mb-2">
							<small id="defaultRegisterFormPhoneHelpBlock"
								class="form-text text-muted mb-1"> Support Level </small>
							<form:select class="form-control mb-2" path="supportLevel"
								items="${supportLevel}"></form:select>
							<small id="defaultRegisterFormPhoneHelpBlock"
								class="form-text text-warning mb-1"><form:errors
									path="supportLevel"></form:errors></small>
						</div>
						<%-- <div class="form-div-inputs">
							<form:label path="supportLevel">Support Level</form:label>
							<form:select path="supportLevel" id="supportLevel"
								items="${supportLevel}" />
							<form:errors path="supportLevel"></form:errors>
						</div> --%>
						<div class="form-row mb-2">
							<div class="col">
								<form:input class="form-control mb-1" placeholder="Password"
									type="password" path="password" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-1"><form:errors
										path="password"></form:errors></small>

							</div>
							<div class="col">
								<form:input class="form-control mb-1"
									placeholder="Confirm Password" type="password"
									path="tempPassword" />
								<small id="defaultRegisterFormPhoneHelpBlock"
									class="form-text text-warning mb-1"><form:errors
										path="tempPassword"></form:errors></small>
							</div>
						</div>
						<div class="form-buttons-div">
							<input type="submit" class="btn btn-info my-4 btn-block bg-primary text-light"
								name="Submit" value="Register" />OR <a
								class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect bg-success text-light"
								href="/analyst-login">Login</a> 
						</div>
					</form:form>
				</div>

				<!--  -->
				<!--  -->
				<!--  -->
				<!--  -->
				<!--  -->
				<!--  -->

				<div
					class='tab-pane fade <c:if test="${isAdmin}">show active</c:if>'
					id="pills-admin" role="tabpanel" aria-labelledby="pills-admin-tab">
					<form:form action="/admin-login" modelAttribute="admin"
						method="POST" cssClass="form">
						<div class="form-row mb-2">
							<small id="defaultRegisterFormPhoneHelpBlock"
								class="form-text text-muted mb-1"> Admin Id </small>
							<form:input class="form-control mb-4" placeholder="Admin Id"
								path="adminId" id="adminId" />
							<small id="defaultRegisterFormPhoneHelpBlock"
								class="form-text text-warning mb-1"><form:errors
									path="adminId"></form:errors></small>
						</div>
						<div class="form-row mb-2">
							<form:input class="form-control mb-2" placeholder="Password"
								path="tempPassword" type="password" id="password" />
							<br> <small id="defaultRegisterFormPhoneHelpBlock"
								class="form-text text-warning mb-1"><form:errors
									cssClass="text-warning" path="tempPassword"></form:errors></small>
						</div>
						<div class="d-flex justify-content-around form-row mb-2">
							<div>
								<!-- Forgot password -->
								<a href="">Forgot User Id?</a>
							</div>
							<div>
								<!-- Forgot password -->
								<a href="">Forgot password?</a>
							</div>
						</div>

						<div class="form-buttons-div">
							<input type="submit" class="btn btn-info my-4 btn-block bg-primary text-light"
								name="Submit" value="Login" />
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer-role-selection.jspf"%>
</div>
<%@ include file="common/end-tags-role-selection.jspf"%>
