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
						<li><a href="#teachableSkill">Skills You Can Teach</a></li>
						<li><a href="#activity">Skills You Wanted</a></li>
					</ul>
				</nav>
				<section id="info">
					<form action="modify_profile.do" method="POST" name="">
						<p>Your info:</p>
						<p class="setting">
							<span>First Name </span> <input class="text" name="firstName"
								value="${user.firstName }" />
						</p>
						<p class="setting">
							<span>Last Name </span> <input class="text" name="lastName"
								value="${user.lastName }">
						</p>
						<p class="setting">
							<span>Phone Number </span> <input class="text" name="phone"
								value="${user.phone }">
						</p>
						<p class="setting">
							<span>E-mail Address </span> <input class="text" name="email"
								value="${user.email }">
						</p>
						<p class="setting">
							<span>Street</span> <input class="text" name="address"
								value="${user.addressId.address }">
						</p>
						<p class="setting">
							<span>Street 2</span> <input class="text" name="address2"
								value="${user.addressId.address2 }">
						</p>
						<p class="setting">
							<span>City</span> <input class="text" name="city"
								value="${user.addressId.city }">
						</p>
						<p class="setting">
							<span>State</span> <input class="text" name="state"
								value="${user.addressId.state }">
						</p>
						<p class="setting">
							<span>Zip/Postal code</span> <input class="text"
								name="postalCode" value="${user.addressId.postalCode}">
						</p>
						<input type="submit" name="modify_profile.do" value="Save Changes" />
					</form>
					<form action="home.do" method="GET">
						<input type="submit" value="Ruturn Home" />
					</form>

				</section>
				<section id="teachableSkill" class="hidden">
					<p>Skills you can teach</p>
					<form action="updateTeachableSkills.do" method="POST">
						<div
							style="max-height: 300px; overflow: auto; border: 1px solid #ccc; font: 16px/26px Georgia, Garamond, Serif; overflow: auto;">

							<c:if test="${!empty user.teachableSkills}">
								<c:forEach var="TeachableSkill" items="${user.teachableSkills }">
									<c:if test="${TeachableSkill.isActive == true}">
										<p>
											<input type="checkbox" name="teachableSkillsUpdate"
												value="${TeachableSkill.id }" checked>
											${TeachableSkill.skillName.name } at a <select name="level">
												<option value="1"
													<c:if test="${TeachableSkill.skillLevel.id ==1 }"> selected="selected"</c:if>>NoExperience</option>
												<option value="2"
													<c:if test="${TeachableSkill.skillLevel.id ==2 }"> selected="selected"</c:if>>Novice</option>
												<option value="3"
													<c:if test="${TeachableSkill.skillLevel.id ==3 }"> selected="selected"</c:if>>Intermediate</option>
												<option value="4"
													<c:if test="${TeachableSkill.skillLevel.id ==4 }"> selected="selected"</c:if>>Expert</option>
												<option value="5"
													<c:if test="${TeachableSkill.skillLevel.id ==5 }"> selected="selected"</c:if>>Master</option>
											</select> level.
										</p>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
						<br>
						<p>Can you teach any of these skills?</p>
						<div
							style="max-height: 300px; overflow: auto; border: 1px solid #ccc; font: 16px/26px Georgia, Garamond, Serif; overflow: auto;">
							<c:if test="${!empty allTeachableSkills }">
								<c:forEach var="newTeachableSkill"
									items="${allTeachableSkills }">
									<p>
										<input type="checkbox" name="skillToAdd"
											value="${newTeachableSkill.id }">
										${newTeachableSkill.skillName.name } at a <select>
											<option value="1">NoExperience</option>
											<option value="2">Novice</option>
											<option value="3">Intermediate</option>
											<option value="4">Expert</option>
											<option value="5">Master</option>
										</select> level
									</p>
								</c:forEach>
							</c:if>
						</div>
						<br> <input type="submit" value="Update Skills">
					</form>
				</section>

				<section id="activity" class="hidden">
					<p>Skills you want to learn</p>
					<form action="updateLearnableSkills.do" method="POST">
						<div
							style="max-height: 300px; overflow: auto; border: 1px solid #ccc; font: 16px/26px Georgia, Garamond, Serif; overflow: auto;">

							<c:if test="${!empty user.learnableSkills}">

								<c:forEach var="LearnableSkill" items="${user.learnableSkills }">
									<c:if test="${LearnableSkill.isActive == true}">

										<p>
											<input type="checkbox" name="learnableSkillsUpdate"
												value=" ${LearnableSkill.id }" checked>
											${LearnableSkill.skillName.name } at a <select name="level">
												<option value="1"
													<c:if test="${LearnableSkill.skillLevel.id ==1 }"> selected="selected"</c:if>>NoExperience</option>
												<option value="2"
													<c:if test="${LearnableSkill.skillLevel.id ==2 }"> selected="selected"</c:if>>Novice</option>
												<option value="3"
													<c:if test="${LearnableSkill.skillLevel.id ==3 }"> selected="selected"</c:if>>Intermediate</option>
												<option value="4"
													<c:if test="${LearnableSkill.skillLevel.id ==4 }"> selected="selected"</c:if>>Expert</option>
												<option value="5"
													<c:if test="${LearnableSkill.skillLevel.id ==5 }"> selected="selected"</c:if>>Master</option>
											</select> level.
										</p>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
						<br>
						<p>What Skills are do you want to master?</p>
						<div
							style="max-height: 300px; overflow: auto; border: 1px solid #ccc; font: 16px/26px Georgia, Garamond, Serif; overflow: auto;">


							<c:if test="${!empty allLearnableSkills }">
								<c:forEach var="newLearnableSkill"
									items="${allLearnableSkills }">
									<p>
										<input type="checkbox" name="skillToAdd"
											value="${newLearnableSkill.id }">
										${newLearnableSkill.skillName.name } at a <select>
											<option value="1">NoExperience</option>
											<option value="2">Novice</option>
											<option value="3">Intermediate</option>
											<option value="4">Expert</option>
											<option value="5">Master</option>
										</select> level
									</p>
								</c:forEach>
							</c:if>
						</div>
						<br> <input type="submit" value="Update skills to learn">
					</form>
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