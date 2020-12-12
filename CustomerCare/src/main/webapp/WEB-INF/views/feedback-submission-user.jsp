<%@ include file="common/header-admin.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
		<div class="center-feedback-user">
		   <div class="heading-feedback">
		      <h1>Feedback Form</h1>
		   </div>
		   <div class="div-from-feedback">
		      <form:form action="/" modelAttribute="complaint" method="get">
		          <div class="div-feedback-question">
		                <c:forEach var="feedback"  items="${complaint.feedBackList}">
		                   <form:label path="feedback.feedBackQuestion.description">${feedback.feedBackQuestion.description}</form:label>
		                   <form:input path="feedBack.answer"/>
		                </c:forEach>
		          </div>
		          <div class="div-btn-submit-feedback">
		             <input type="submit" class="button" value="Submit">
		          </div>
		      </form:form>
		   </div>
		</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%> 