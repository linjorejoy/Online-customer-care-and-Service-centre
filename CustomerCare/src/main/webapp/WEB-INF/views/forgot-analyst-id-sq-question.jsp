<%@ include file="common/header-analyst.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-analyst.jspf"%>

	<div class="center-forgot-analyst-id">
		<div class="heading-div">
			<h1>Security Questions</h1>
		</div>

		<div class="form-div-sq-question">
			<form:form modelAttribute="analyst" method="GET" action="/submit-secret-question/${analystId}">
				<div class="div-security-questions">
					<label>What is your Childhood pets Name?</label><input id="ans1" name="ans1" value="${ans1}"><br>
					<label>What is your mothers maiden name?</label><input id="ans2" name="ans2" value="${ans2}"><br>
					<label>What is the name of the city you grew up on?</label><input id="ans3" name="ans3" value="${ans3}">
				</div>
				<div class="div-security-question-submit">
					<input type="submit" value="Submit">
				</div>
			</form:form>
		</div>
	</div>

	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>