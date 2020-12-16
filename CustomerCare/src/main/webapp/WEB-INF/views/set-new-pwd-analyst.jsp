<%@ include file="common/header-analyst.jspf"%>
<form:form action="/forgot-password"  method="get">

		<div>
			<label>New Password</label> <input id="newPwd" type="text" name="newPwd"
				placeholder="New Password" ><br> <label>Confirm New Password</label>
			<input id="confirmPwd" type="text" name="confirmPwd" placeholder="Confirm Password"
				>
		</div>
		<button type="submit" class="btn btn-primary mb-2">Submit</button>
	</form:form>

	<%@ include file="common/footer-analyst.jspf"%>

<%@ include file="common/end-tags-analyst.jspf"%>