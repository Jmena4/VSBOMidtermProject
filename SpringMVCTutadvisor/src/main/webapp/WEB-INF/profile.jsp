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
<title>My Profile</title>
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
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="navbar-nav ml-auto">
				<form>
					<!-- <span class="login-fields"> <label for="username">username
							<input name="username">
					</label> &nbsp; &nbsp; <label for="password">password <input
							name="password">
					</label>&nbsp; &nbsp; <input id="login-button" type="submit" value="Login">
					</span> -->
				</form>
			</div>
		</div>
	</nav>
	<div class="container" style="width: 75%">

		<div id="w">
			<div id="content" class="clearfix">
				<div id="userphoto">
					<img src="${user.pictureURL }" alt="default avatar" width="100">
				</div>
				<h1>${user.firstName }${user.lastName }</h1>

				<nav id="profiletabs">
					<ul class="clearfix">
						<li><a href="#info" class="sel">Your Info</a></li>
						<li><a href="#teachableSkill">Teachable Skills</a></li>
						<li><a href="#activity">Wanted Skills</a></li>

						<li><a href="#friends">Friends</a></li>
					</ul>
				</nav>
				<section id="info">
					<p>Your info:</p>
					<form>
						<p class="setting">
							<span>First Name </span> ${user.firstName }
						</p>
						<p class="setting">
							<span>Last Name </span> ${user.lastName }
						</p>
						<p class="setting">
							<span>Phone Number </span> ${user.phone }
						</p>
						<p class="setting">
							<span>E-mail Address </span> ${user.email }
						</p>
						<p class="setting">
							<span>Street</span> ${user.addressId.address }
						</p>
						<p class="setting">
							<span></span> ${user.addressId.address2 }
						</p>
						<br>
						<p class="setting">
							<span>City</span> ${user.addressId.city }
						</p>
						<p class="setting">
							<span>State</span> ${user.addressId.state }
						</p>
						<p class="setting">
							<span>Zip/Postal code</span> ${user.addressId.postalCode}
						</p>


						<input type="submit" class="btn btn-primary" value="edit" />
					</form>

				</section>
				<section id="teachableSkill" class="hidden">
					<p>Skills you can teach</p>
					<c:if test="${!empty user.teachableSkills}">
						<c:forEach var="TeachableSkill" items="${user.teachableSkills }">
							<p>${TeachableSkill.skill } at a "${TeachableSkill.level}"
								level</p>
						</c:forEach>
					</c:if>
				</section>

				<section id="activity" class="hidden">
					<p>Skills you want to learn</p>
					<c:if test="${!empty user.learnableSkills}">
						<c:forEach var="LearnableSkill" items="${user.learnableSkills }">
							<p>${LearnableSkill.skillName } at a "${LearnableSkill.skillLevel}"
								level</p>
						</c:forEach>
					</c:if>
				</section>

				<section id="friends" class="hidden">
					<p>Friends list:</p>

					<ul id="friendslist" class="clearfix">
						<li><a href="#"><img src="images/avatar.png" width="22"
								height="22"> Username</a></li>
						<li><a href="#"><img src="images/avatar.png" width="22"
								height="22"> SomeGuy123</a></li>
						<li><a href="#"><img src="images/avatar.png" width="22"
								height="22"> PurpleGiraffe</a></li>
					</ul>
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