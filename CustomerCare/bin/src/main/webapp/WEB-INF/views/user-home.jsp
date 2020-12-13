<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="middle-comptainer">
		
		<h2>Login Successful</h2>
		<a href="/create-complaint?userId=${userId}">Create Complaint</a>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>