<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-div-user">

		<form:form action="/forgot-userID-secretquestions" method="get">
			<div>
				<label>Enter Your Email ID:</label> <input id="email" type="text"
					name="email" placeholder="email" value="${email}">
			</div>
			<div>
				<input type="submit" id="submit" value="submit"></input>
			</div>
		</form:form>


	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>
<%@ include file="common/end-tags-user.jspf"%>