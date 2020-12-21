<%@ include file="common/header-analyst.jspf"%>
<div class="container-fluid p-0">
	<nav class="navbar navbar-inverse navbar-dark bg-primary">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/roleSelectionPage">Customer Care</a>
			</div>
		</div>
	</nav>
	<div
		class="container text-center d-flex align-items-center justify-content-center">

		<form:form action="/forgot-analyst-id-secret-question" method="get"
			cssClass="text-center border border-light p-5">
			<div>
				<label>Enter Your Email ID:</label> <input id="mail" name="mail"
					value="${mail}"></input><br>
			</div>
			<div>
				<input type="submit" id="submit" value="Submit"
					class="btn btn-success"></input>
			</div>
		</form:form>



	</div>
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>