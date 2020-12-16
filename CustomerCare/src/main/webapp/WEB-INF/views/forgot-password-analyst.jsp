<%@ include file="common/header-analyst.jspf"%>
<div>

	<form:form action="/forgot-password-analyst"  method="get">

		<div>
			<label>Analyst Id</label> <input id="analystId" type="text" name="analystId"
				placeholder="Analyst Id" value="${analystId}"><br> <label>Mobile Number</label>
			<input id="mob" type="text" name="mob" placeholder="Mobile Number"
				value="${mob}"><br> <label>Email Id</label> <input
				id="email" type="text" name="email" placeholder="email"
				value="${email}">
		</div>
		<button type="submit" class="btn btn-primary mb-2">Search</button>
	</form:form>
				
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>