<%@ include file="common/header-analyst.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-analyst-all-emails">

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Email Number</th>
					<th>Date</th>
					<th>Description</th>
					<th></th>
				</tr>
			</thead>
			<!-- forEach -->
			<c:forEach var="email" items="${analyst.emailList}">


				<tr>
					<td><div class="overflow-hidden">${email.emailId}</div></td>
					<td><div class="overflow-hidden">${email.sentDate}</div></td>
					<td><div>${fn:substring(email.description,0, 80)}...............</div></td>
					<td><a href="/view-email-analyst?emailId=${email.emailId}&analystId=${analyst.analystId}">View</a></td>
				</tr>
				<!-- end -->
			</c:forEach>
		</table>

	</div>
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>