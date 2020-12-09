<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	<%@ include file="styles/styles-analyst.css" %>
</style>
<link
	href="https://fonts.googleapis.com/css2?family=Righteous&display=swap"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Care</title>
</head>
<body>
<div class="container-my">
	<%@ include file="common/nav-bar-analyst.jspf"%>
	<div class="center-div-complaint-analyst">
		<div class="centering-my">
			<div class="heading">
				<h1>Complaint Notifications</h1>
			</div>
			<div class="div-sorting-complaints-analyst">
				<div class="label-sort">Sort By</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=complaintId&sortDir=${reverseSortDir}">Complaint
						Id</a>
				</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=analyst.analystId&sortDir=${reverseSortDir}">Analyst
						Id</a>
				</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=dateOfComplaint&sortDir=${reverseSortDir}">Date</a>
				</div>
				<div class="sort-btn">
					<a
						href="/analyst-login/page/${currentPage}?analystId=${analystId}&sortBy=category&sortDir=${reverseSortDir}">Category</a>
				</div>
			</div>

			<div class="pagination-details">
				<div>Total Complaints : ${totalComplaints}</div>
				<div>Page ${currentPage} of ${totalPages}</div>
				<div>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<a
							href="/analyst-login/page/${i}?analystId=${analystId}&sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
					</c:forEach>
				</div>
			</div>

			<div class="div-complaints-notification-analyst">
				<c:forEach var="complaint" items="${complaintListAnalyst}">
					<div class="div-complaint-notification">
						<div class="each-complaint-heading">
							<label class="id-heading">Complaint Id : </label> <label
								class="id-heading">${complaint.complaintId}</label>
						</div>
						<div class="complaint-description-analyst">
							<label>Description</label>
							<p>${complaint.description}</p>
						</div>
						<div class="complaint-view-analyst-each-submit">
							<input type="submit" id="Submit" value="View" onsubmit="/" />
						</div>
					</div>
				</c:forEach>

			</div>

			<div class="pagination-details">
				<div>Total Complaints : ${totalComplaints}</div>
				<div>Page ${currentPage} of ${totalPages}</div>
				<div>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<a
							href="/analyst-login/page/${i}?analystId=${analystId}&sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="common/footer-analyst.jspf"%>
</div>

	<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
		<script
	src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
</body>
</html>
