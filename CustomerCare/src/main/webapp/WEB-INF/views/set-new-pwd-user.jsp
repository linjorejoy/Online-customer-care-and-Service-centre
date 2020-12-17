<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<form:form action="/change-password" method="post" cssClass="mt-4">
			<table>
				<tr>
					<td><label>New Password</label></td>
					<td><input id="newPwd" type="text" name="newPwd"
						placeholder="New Password"></td>
				</tr>
				<tr>
					<td><label>Confirm New Password</label></td>
					<td><input id="confirmPwd" type="text" name="confirmPwd"
						placeholder="Confirm Password"></td>
				</tr>

			</table>
			<input name="userId" type="hidden" value="${userId}">

			<button type="submit" class="btn btn-success mb-2 mt-4">Submit</button>
		</form:form>

	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>