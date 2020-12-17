<%@ include file="common/header-analyst.jspf"%>
<div class="container-fluid p-0">
<%@ include file="common/nav-bar-analyst.jspf"%>
	<div
		class="container text-center d-flex align-items-center justify-content-center">
<form:form action="/reset-password-analyst/${analystId}"  method="get" cssClass="mt-5">

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
			<button type="submit" class="btn btn-success mb-2">Submit</button>
		</form:form>
	</div>
	<%@ include file="common/footer-analyst.jspf"%>
</div>
<%@ include file="common/end-tags-analyst.jspf"%>