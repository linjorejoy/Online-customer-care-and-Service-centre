<%@ include file="common/header-admin.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div>
		<div class="email-div">
			<form:form modelAttribute="email" method="POST" action="/user-sent-email-to-analyst">
				<form:hidden path="user.userId" value="${email.user.userId}"/>
			
				<form:label path="emailId">Email Number : </form:label>
				<form:hidden path="emailId" value="${email.emailId}"/>
				<form:label path="emailId" value="${email.emailId}">${email.emailId}</form:label><br>
				
				<form:label path="analyst.firstName">Email To : </form:label>
				<form:input path="analyst.firstName" value="${email.analyst.firstName}"/><br>
				
				<form:label path="analyst.analystId">Email To Id : </form:label>
				<form:input path="analyst.analystId" value="${email.analyst.analystId}"/><br>
				
				<form:label path="sentDate">Date : </form:label>
				<form:input path="sentDate" value="${email.sentDate}"/><br>
				
				<label>Complaint</label>
				<p>${complaint.description}</p><br>
				
				<form:label path="description">Description</form:label>
				<form:textarea path="description" value="${email.description}" cols="150" rows="15"/><br>
			
				<input type="submit" value="Sent Email"/>
				
			</form:form>
			
		</div>
			
	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>