<%@ include file="common/header-analyst.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<form:form action="/change-password-analyst" method="post" cssClass="mt-4">
			<table>
				<tr>
					<td><label>New Password</label></td>
					<td><input id="newPwd" type="password" name="newPwd"
						placeholder="New Password" type="password"></td>
				</tr>
				<tr>
					<td><label>Confirm New Password</label></td>
					<td><input id="confirmPwd" type="password" name="confirmPwd"
						placeholder="Confirm Password" type="password"></td>
				</tr>

			</table>
			<input name="analystId" type="hidden" value="${analystId}">

			<button type="submit" class="btn btn-success mb-2 mt-4">Submit</button>
		</form:form>

	</div>
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>