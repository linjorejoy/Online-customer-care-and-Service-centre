<%@ include file="common/header-user.jspf"%>

<form:form action="/reset-password-user/${userId}"  method="get">

	<div>
		<label>What is your Childhood pets Name?</label> <input id="ans1" type="text" name="ans1"
			placeholder="Type Your Answer" value="${ans1}"><br>	
		<label>What is your mothers maiden name?</label> <input id="ans2" type="text" name="ans2"
			placeholder="Type Your Answer" value="${ans2}"><br>	
		<label>What is the name of the city you grew up on?</label> <input id="ans3" type="text" name="ans3"
			placeholder="Type Your Answer" value="${ans3}"><br>	
				
	</div>
	<button type="submit" class="btn btn-primary mb-2">Submit</button>
</form:form>
<%@ include file="common/footer-user.jspf"%>
</div>
<%@ include file="common/end-tags-user.jspf"%>