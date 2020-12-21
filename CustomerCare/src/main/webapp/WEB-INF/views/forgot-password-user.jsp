<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
<nav class="navbar navbar-inverse navbar-dark bg-primary">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/roleSelectionPage">Customer Care</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="/user-home"><span class="glyphicon glyphicon-log-in nav-link text-light">Home</span> </a></li>
    </ul>
  </div>
</nav>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
		<form:form action="/forgot-password" method="get" cssClass="mt-4">

			<table>
				<tr>
					<td><label>User Id</label></td>
					<td><input id="userId" type="text" name="userId"
						placeholder="User Id" value="${userId}"></td>
				</tr>
				<tr>
					<td><label>Mobile Number</label></td>
					<td><input id="mob" type="text" name="mob"
						placeholder="Mobile Number" value="${mob}"></td>
				</tr>
				<tr>
					<td><label>Email Id</label></td>
					<td><input id="email" type="text" name="email"
						placeholder="email" value="${email}"></td>
				</tr>

			</table>

			<button type="submit" class="btn btn-success mb-2 mt-4">Search</button>
		</form:form>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>