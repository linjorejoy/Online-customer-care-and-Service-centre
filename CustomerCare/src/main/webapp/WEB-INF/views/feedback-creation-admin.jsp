<%@ include file="common/header-admin.jspf"%>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div class="container">
		<div class="centering">
			<div class="heading-feedback">
				<h1>Complaint Feedback Questionnaire</h1>
			</div>
			<div class="form-div-feedback-admin">
				<form:form action="/" modelAttribute="feedbackQuestions"
					method="get">
					<div class="form-input-feedback-admin">
						<form:label path="description">Question Description</form:label>
						<br>
						<form:textarea path="description"
							class="form-control z-depth-1 p-4"
							id="exampleFormControlTextarea6" rows="3"
							placeholder="Write your Complaint here..."></form:textarea>
					</div>
					<div class="form-buttons-complaint-user">
						<input type="Submit" class="button" value="Add New" />
					</div>

				</form:form>
			</div>


		</div>
	</div>



	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>