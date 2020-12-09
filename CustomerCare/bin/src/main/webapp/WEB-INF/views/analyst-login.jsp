<%@ include file="common/header-analyst.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-analyst">
		<div class="heading-analyst">
			<h1 class="heading-analyst-h1">Analyst Login</h1>
		</div>
		<div class="form-div-analyst">
			<form:form action="/analyst-login" modelAttribute="complaint" method="POST">
				<div class="form-input-div-analyst">
					<form:label path="analyst.analystId"> Analyst Id</form:label>
					<form:input path="analyst.analystId" id="analystId" />
					<form:errors path="analyst.analystId"></form:errors>
				</div>
				<div class="form-input-div-analyst">
					<form:label path="analyst.tempPassword">Password</form:label>
					<form:input path="analyst.tempPassword" id="password" type="password" />
					<form:errors path="analyst.tempPassword"></form:errors>
				</div>
				<div class="form-group">
					<a href="/">Forgot Analyst Id</a> <a href="/">Forgot Password</a>
				</div>
				<div class="form-buttons-div-analyst">
					<input type="Submit" name="submit" value="Submit" /> <input
						type="reset" name="reset" value="Cancel" />

				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>
