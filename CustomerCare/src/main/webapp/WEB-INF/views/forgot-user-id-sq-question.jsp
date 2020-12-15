<%@ include file="common/header-user.jspf"%>
<div class="container">
	<%@ include file="common/nav-bar-user.jspf"%>
	<div class="center-forgot-user-id">
		<div class="heading-div">
			<h1>Security Questions</h1>
		</div>

		<div class="form-div-sq-question">
			<form:form method="get" action="/show-user-id/${userId}">
				<div>
					<label>What is your Childhood pets Name?</label> <input id="ans1"
						type="text" name="ans1" placeholder="Type Your Answer"
						value="${ans1}"><br> <label>What is your
						mothers maiden name?</label> <input id="ans2" type="text" name="ans2"
						placeholder="Type Your Answer" value="${ans2}"><br> <label>What
						is the name of the city you grew up on?</label> <input id="ans3"
						type="text" name="ans3" placeholder="Type Your Answer"
						value="${ans3}"><br>

				</div>
				<div>
					<input type="submit" id="submit" value="submit"></input>
				</div>
			</form:form>
		</div>
	</div>
	<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>