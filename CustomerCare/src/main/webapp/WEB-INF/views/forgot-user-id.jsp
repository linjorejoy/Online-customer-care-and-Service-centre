<%@ include file="common/header-user.jspf"%>
<div class="container-fluid p-0">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center">

		<form:form action="/forgot-userID-secretquestions" method="get"  cssClass="text-center border border-light p-5">
			<div>
				<label>Enter Your Email ID:</label> <input id="email" type="text"
					name="email" placeholder="email" value="${email}">
			</div>
			<div>
				<input type="submit" id="submit" value="Submit" class="btn btn-success"/>
			</div>
		</form:form>


	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>
<%@ include file="common/end-tags-user.jspf"%>