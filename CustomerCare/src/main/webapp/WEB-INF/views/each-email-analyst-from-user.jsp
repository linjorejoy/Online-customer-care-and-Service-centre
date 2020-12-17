<%@ include file="common/header-analyst.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-analyst">
		<div class="email-div">
			<div class="info">
				<label for="" class="label-email">Sent By : </label>
				<label for="" class="output-email"></label>
			</div>
			<div class="info">

				<label for="" class="label-email">Recipient : </label>
				<label for="" class="output-email">${email.analyst.lastName}, ${email.analyst.firstName}</label>
			</div>
			<div class="info">

				<label for="" class="label-email">Date : </label>
				<label for="" class="output-email">${email.sentDate}</label>
			</div>
			<div class="info">

				<label for="" class="label-email">Description</label>
				<p>${email.description}</p>
			</div>
			<div class="info">
				<a href="/mark-email-user-received?emailId=${email.emailId}" class="btn btn-success">Mark as Received</a>
			</div>
		</div>



	</div>
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>