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


		<div class="form-div-sq-question">
			<div class="heading-div">
				<h1>Security Questions</h1>
			</div>
			<form:form method="get" action="/show-user-id/${userId}">
				<div>
					<table>
						<tr>
							<td><label>What is your Childhood pets Name?</label></td>
							<td><input id="ans1" type="text" name="ans1"
								placeholder="Type Your Answer" value="${ans1}"></td>
						</tr>
						<tr>
							<td><label>What is your mothers maiden name?</label></td>
							<td><input id="ans2" type="text" name="ans2"
								placeholder="Type Your Answer" value="${ans2}"></td>
						</tr>
						<tr>
							<td><label>What is the name of the city you grew up
									on?</label></td>
							<td><input id="ans3" type="text" name="ans3"
								placeholder="Type Your Answer" value="${ans3}"></td>
						</tr>
					</table>

				</div>
				<div>
					<input type="submit" id="submit" value="Submit"
						class="btn btn-success"></input>
				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>