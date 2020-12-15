<%@ include file="common/header-user.jspf"%>
<div>

	<form:form action="/forgot-password"  method="get">

		<div>
			<label>User Id</label> <input id="userId" type="text" name="userId"
				placeholder="User Id" value="${userId}"><br> <label>Mobile Number</label>
			<input id="mob" type="text" name="mob" placeholder="Mobile Number"
				value="${mob}"><br> <label>Email Id</label> <input
				id="email" type="text" name="email" placeholder="email"
				value="${email}">
		</div>
		<button type="submit" class="btn btn-primary mb-2">Search</button>
	</form:form>
				
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>