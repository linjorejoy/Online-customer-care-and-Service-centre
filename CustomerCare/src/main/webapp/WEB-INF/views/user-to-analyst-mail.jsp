<%@ include file="common/header-admin.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div>
		<div class="email-div">
			<form:form modelAttribute="emailAnalyst" method="POST" action="/user-sent-email-to-analyst">
				<form:hidden path="admin.adminId" value="${emailAnalyst.admin.adminId}"/>
			
				<form:label path="emailId">Email Number</form:label>
				<form:input path="emailId" value="${emailAnalyst.emailId}"/><br>
				
				<form:label path="analyst.firstName">Email To : </form:label>
				<form:input path="analyst.firstName" value="${emailAnalyst.analyst.firstName}"/><br>
				
				<form:label path="analyst.analystId">Email To Id : </form:label>
				<form:input path="analyst.analystId" value="${emailAnalyst.analyst.analystId}"/><br>
				
				<form:label path="sentDate">Date : </form:label>
				<form:input path="sentDate" value="${emailAnalyst.sentDate}"/><br>
				
				<label>Complaint</label>
				<p>${complaint.description}</p><br>
				
				<form:label path="description">Description</form:label>
				<form:textarea path="description" value="${emailAnalyst.description}" cols="150" rows="15"/><br>
			
				<input type="submit" value="Sent Email"/>
				
			</form:form>
			
		</div>
			
	</div>
	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>