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
<meta charset="UTF-8">
<title>Suggestions</title>
<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/suggestioncss.css" rel="stylesheet">
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
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-nav ml-auto"></div>
		</div>
	</nav>
	<!-- Suggestion Start-->
	<div class="container" style="width: 75%">
		<div id="w">
			<%-- <h1>${user.firstName }${user.lastName }</h1> --%>
			<h3>Your Suggestion:</h3>
			<div id="content" class="clearfix"></div>
			<section id="info">
				<form action="suggestionPage.do" method="GET">
					<p class="setting">
						<span> </span>

					</p>
					<p class="setting">
						<span>Id: </span> ${id }
					</p>
					<p class="setting">
						<span>Skill Level: </span> ${skilllevel.name}
					</p>
					<p class="setting">
						<span>Teachable Skill: </span> ${teachableSkill }
					</p>
					<p class="setting">
						<span>Learn-able Skill: </span> ${learnableSkill }
					</p>
					<p class="setting">
						<span> Teacher: </span> ${teacherUser }
					</p>
					<p class="setting">
						<span>Student:</span> ${studentUser }
					</p>
					<br>
				</form>
				<form action="home.do" method="GET">
					<input type="submit" value="Ruturn Home" />
				</form>
				<!-- <form action="suggestionPage.do" method="GET" name="">
					<input type="submit" name="suggestionPage.do" value="View Suggestions" />
				</form> -->
			</section>

		</div>
	</div>
	<!-- Suggestion End -->
	<div id="VSBO" class="container">
		<p>© 2019 Vomit Sack Brain Overflow - A Family Company</p>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>