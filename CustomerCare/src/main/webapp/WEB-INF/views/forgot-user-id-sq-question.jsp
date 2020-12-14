<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-forgot-user-id">
		<div class="heading-div">
			<h1>Security Questions</h1>
		</div>

		<div class="form-div-sq-question">
			<form:form modelAttribute="user" method="GET" action="/">
			<div class="div-security-questions">
				<c:forEach var="secretQuestion" items="${user.secretQuestionList}">
					<form:label path="secretQuestion.secretQuestions.description">${secretQuestion.secretQuestions.description}</form:label>
					<form:input path="secretQuestion.answer"/>
				</c:forEach>
             </div> 
             <div class="div-security-question-submit">
                <input type="submit" value="Submit">
             </div>
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>