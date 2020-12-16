<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-div-complaint-user">
		<div class="complaints-heading-user">
			<h1>Complaint Notifications</h1>
		</div>
		<div class="div-sorting-complaints-user">
			Sort By:
			<div class="div-drop-down"></div>
		</div>

		<div class="div-complaints-notification-user">
			<c:forEach var="complaint" items="${complaintListUser}">

				<div class="div-complaint-notification">
					${complaint.complaintId}
					<div class="complaint-description-user">
						${complaint.description}
						<div class="complaint-view-user">
							<input type="submit" id="Submit" value="View" onsubmit="/" />
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>