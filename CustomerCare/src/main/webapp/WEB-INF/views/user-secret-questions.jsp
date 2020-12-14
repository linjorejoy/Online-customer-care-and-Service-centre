<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center mt-3">
		
		<h2>Secret Questions for Password Recovery</h2>
		
		<form:form action="/user-home?userId=${userId}" modelAttribute="userSecretQuestion" method="POST">
			
		
		</form:form>
		
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>
