<%@ include file="common/header-analyst.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-analyst.jspf"%>

	<div class="center-forgot-analyst-id">
		<div class="heading-div">
			<h1>Security Questions</h1>
		</div>

		<div class="form-div-sq-question">
			<form:form modelAttribute="analyst" method="GET" action="/">
				<div class="div-security-questions">
					<c:forEach var="secretQuestion" items="${analyst.analystSecretQuestions}">
						<form:label path="secretQuestion.secretQuestions.description">${secretQuestion.secretQuestions.description}</form:label>
						<form:input path="secretQuestion.answer" />
					</c:forEach>
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