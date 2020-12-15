<%@ include file="common/header-user.jspf"%>
<form:form action="/change-password" method="post">
	<input name="userId" type="hidden" value="${userId}">
	<div>
		<label>New Password</label> <input id="newPwd" type="text"
			name="newPwd" placeholder="New Password"><br> <label>Confirm
			New Password</label> <input id="confirmPwd" type="text" name="confirmPwd"
			placeholder="Confirm Password">
	</div>
	<button type="submit" class="btn btn-primary mb-2">Submit</button>
</form:form>

<%@ include file="common/footer-user.jspf"%>
<%@ include file="common/end-tags-user.jspf"%>