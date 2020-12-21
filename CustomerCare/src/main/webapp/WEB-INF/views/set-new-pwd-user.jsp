<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
	<nav class="navbar navbar-inverse navbar-dark bg-primary">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/roleSelectionPage">Customer Care</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/user-home"><span
						class="glyphicon glyphicon-log-in nav-link text-light">Home</span>
				</a></li>
			</ul>
		</div>
	</nav>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<form:form action="/change-password" method="post" cssClass="mt-4">
			<table>
				<tr>
					<td><label>New Password</label></td>
					<td><input id="newPwd" type="password" name="newPwd"
						placeholder="New Password"></td>
				</tr>
				<tr>
					<td><label>Confirm New Password</label></td>
					<td><input id="confirmPwd" type="password" name="confirmPwd"
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