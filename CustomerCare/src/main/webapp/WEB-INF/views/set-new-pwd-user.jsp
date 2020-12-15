<%@ include file="common/header-user.jspf"%>
<form:form action="/forgot-password"  method="get">

		<div>
			<label>New Password</label> <input id="newPwd" type="text" name="newPwd"
				placeholder="New Password" ><br> <label>Confirm New Password</label>
			<input id="confirmPwd" type="text" name="confirmPwd" placeholder="Mobile Number"
				>
		</div>
		<button type="submit" class="btn btn-primary mb-2">Submit</button>
	</form:form>

<%@ include file="common/footer-user.jspf"%>
<%@ include file="common/end-tags-user.jspf"%>