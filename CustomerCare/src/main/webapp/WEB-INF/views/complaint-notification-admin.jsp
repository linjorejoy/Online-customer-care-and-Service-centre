<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	<%@ include file="styles/styles-admin.css" %>
</style>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Righteous&display=swap"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Care</title>
</head>
<body>
<div class="container-my">
	<%@ include file="common/nav-bar-admin.jspf"%>
	<div class="center-div-complaint-admin">
		<div class="centering-">
			<div class="heading">
				<h1>Complaint Notifications</h1>
			</div>
			<div class="div-sorting-complaints-admin">
				<div class="label-sort">Sort By</div>
				<div class="sort-btn">
					<a
						href="/admin-login/page/${currentPage}?sortBy=complaintId&sortDir=${reverseSortDir}">Complaint
						Id</a>
				</div>
				<div class="sort-btn">
					<a
						href="/admin-login/page/${currentPage}?sortBy=dateOfComplaint&sortDir=${reverseSortDir}">Date</a>
				</div>
				<div class="sort-btn">
					<a
						href="/admin-login/page/${currentPage}?sortBy=category&sortDir=${reverseSortDir}">Category</a>
				</div>
			</div>
			
			<div class="div-filter-complaints-admin">
				<div class="div-filter-complaints-admin-sub">
					<form action="/admin-view-filter-category" method="get">
						<input id="txtSearch" type="text" name="keyword"
							placeholder="Enter category">
						<button type="submit">Search</button>
					</form>
				</div>
				<div class="div-filter-complaints-admin-sub">
					<form action="/admin-view-filter-date" method="get">
						<input id="txtSearch" type="text" name="date"
							placeholder="YYYY-MM-DD" required>
						<button type="submit">Search</button>
					</form>
				</div>
			</div>

			<div class="pagination-details">
				<div>Total Complaints : ${totalComplaints}</div>
				<div>Page ${currentPage} of ${totalPages}</div>
				<div>
					<c:forEach var="i" begin="1" end="${totalPages}">
						<a
							href="/admin-login/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
					</c:forEach>
				</div>
			</div>

			<div class="div-complaints-notification-admin">
				<c:forEach var="complaint" items="${complaintListAdmin}">
					<div class="div-complaint-notification">
						<div class="each-complaint-heading">
							<label class="id-heading">Complaint Id : </label> <label
								class="id-heading">${complaint.complaintId}</label>
						</div>
						<div class="complaint-description-admin">
							<label>Description</label>
							<p>${complaint.description}</p>
						</div>
						<div class="complaint-view-admin-each-submit">
							<a href="/show-user-complaint-analyst?complaintId=${complaint.complaintId}">View</a>
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
							href="/admin-login/page/${i}?sortBy=${sortBy}&sortDir=${sortDir}">${i}</a>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="common/footer-admin.jspf"%>
</div>
<%@ include file="common/end-tags-admin.jspf"%>
