<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>TUT - ADMIN</title>
<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/profilecss.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js">
	
</script>
<link rel="stylesheet" href="css/landing.css" />
</head>
<body>

	<!-- navbar -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-nav mr-auto">
				<form action="home.do" method="GET">
					<button id="home-button" type="submit">
						<span class="glyphicon glyphicon-home"></span> Tütadvisor Home
					</button>
					&nbsp; &nbsp;
				</form>
				<form action="logout.do" method="POST">
					<button id="logout-button" type="submit">
						<span class="glyphicon glyphicon-log-out"></span> Logout
					</button>
				</form>
			</div>
			<div class="navbar-nav ml-auto">
				<span id="logged-in-as"> You are&nbsp; <c:choose>
						<c:when test="${not empty user.username}">
		logged in as ${user.username}&nbsp;&nbsp;&nbsp;&nbsp;
		</c:when>
						<c:otherwise>
		not logged in&nbsp;&nbsp;&nbsp;&nbsp;
		</c:otherwise>
					</c:choose>
				</span>
				<form action="profile.do" method="GET">
					<input id="profile-button" type="submit" value="My Profile">
				</form>
			</div>
		</div>
	</nav>

	<!-- end navbar -->
	<div class="container" style="width: 75%">

		<div id="f">
			<div id="content" class="clearfix">
				<div id="userphoto">
					<img src="${user.pictureURL }" alt="default avatar" width="100">
				</div>
				<h1>${user.firstName }${user.lastName }</h1>

				<nav id="profiletabs">
					<ul class="clearfix">
						<li><a href="#users" class="sel">User Management</a></li>
						<li><a href="#proposals">Proposal Management</a></li>
					</ul>
				</nav>
				<section id="users">
					<div
						style="max-height: 300px; overflow: auto; border: 1px solid #ccc; font: 16px/26px Georgia, Garamond, Serif; overflow: auto;">
						<ol>
							<c:forEach var="user" items="${allUsers }">
								<li>
									<form action="deactivateuser.do" method="POST">
										${user.firstName } ${user.lastName } - ${user.username } 
										<input type="hidden" name="id" value="${user.id }" />
										<input type="submit" name="Deactivate User" value="Deactivate User">
									</form>
								</li>
							</c:forEach>
						</ol>
					</div>


				</section>
				<section id="#proposals" class="hidden">
					<%-- 	<div style="max-height: 300px; overflow: auto; border: 1px solid #ccc; font: 16px/26px Georgia, Garamond, Serif; overflow: auto;">
								<ol>
								<c:forEach var="proposal" items="${allProposals }">
								<li>
								${proposal.teacher.username } is going to teach ${proposal.student.username } 
								</li>									
								</c:forEach>
								</ol>
						</div> --%>
				</section>


			</div>
			<!-- @end #content -->
		</div>
		<!-- @end #w -->
		<script type="text/javascript">
			$(function() {
				$('#profiletabs ul li a').on('click', function(e) {
					e.preventDefault();
					var newcontent = $(this).attr('href');

					$('#profiletabs ul li a').removeClass('sel');
					$(this).addClass('sel');

					$('#content section').each(function() {
						if (!$(this).hasClass('hidden')) {
							$(this).addClass('hidden');
						}
					});

					$(newcontent).removeClass('hidden');
				});
			});
		</script>


	</div>
	<div id="VSBO" class="container">
		<p>© 2019 Vomit Sack Brain Overflow - A Family Company</p>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<!-- modify_profile.do -->