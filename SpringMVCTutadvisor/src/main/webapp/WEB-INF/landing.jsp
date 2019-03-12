<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Tütadvisor</title>
<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
				<form action="login.do" method="POST">
					<span class="login-fields"> <label for="username">username
							<input name="login-username">
					</label> &nbsp; &nbsp; <label for="password">password <input
							name="login-password">
					</label>&nbsp; &nbsp; <input id="login-button" type="submit" value="Login">
					</span>
				</form>
			</div>
		</div>
	</nav>
	<div id="carousel-container" class="container" style="width: 65%">
		<c:choose>
			<c:when test="${reg}">
				<!-- carousel -->
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="/images/1.jpg" alt="1" style="width: 100%;">
							<div id="reg-form" class="carousel-caption d-none d-md-block">
								<div id="reg-header">User Registration</div>
								<br>
								<form action="register.do" method="POST">
									<div class="row" style="width: 100%">
										<div class="col">
											Username:<br> <input type="text" name="username"><br>
											Password:<br> <input type="text" name="password"><br>
											First Name:<br> <input type="text" name="firstname"><br>
											Last Name:<br> <input type="text" name="lastname"><br>
											Photo URL:<br> <input type="text" name="url"><br>
											Email:<br> <input type="text" name="email"><br>
										</div>
										<div class="col">
											Phone:<br> <input type="text" name="phone"><br>
											Street Address:<br> <input type="text" name="street"><br>
											Address 2 (optional):<br> <input type="text"
												name="street2"><br> City:<br> <input
												type="text" name="city"><br> State:<br> <input
												type="text" name="state"><br> ZIP code:<br>
											<input type="text" name="zip"><br>
										</div>
									</div>
									<br>
									<div id="reg-submit">
										<input id="submit-button" type="submit" value="Submit" />
									</div>
							</div>
							</form>
						</div>
					</div>
				</div>
				<!-- end carousel -->
			</c:when>
			<c:otherwise>
				<!-- carousel -->
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel" data-slide-to="0" class="active"></li>
						<li data-target="#carousel" data-slide-to="1"></li>
						<li data-target="#carousel" data-slide-to="2"></li>
						<li data-target="#carousel" data-slide-to="3"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="/images/1.jpg" alt="1" style="width: 100%;">
							<div id="carousel-caption"
								class="carousel-caption d-none d-md-block">
								<p>Thousands of Skilled Tutors.</p>
								<div class="join-button">
									<a id="join-button" href="registration.do"
										class="btn btn-light btn-lg"> Join TütAdvisor Now!</a>
								</div>
							</div>
						</div>
						<div class="item">
							<img src="/images/2.jpg" alt="2" style="width: 100%;">
							<div id="carousel-caption"
								class="carousel-caption d-none d-md-block">
								<p>Ready to teach you any subject.</p>
								<div class="join-button">
									<a id="join-button" href="registration.do"
										class="btn btn-light btn-lg"> Join TütAdvisor Now!</a>
								</div>
							</div>
						</div>
						<div class="item">
							<img src="/images/3.jpg" alt="3" style="width: 100%;">
							<div id="carousel-caption"
								class="carousel-caption d-none d-md-block">
								<p>Start learning today!</p>
								<div class="join-button">
									<a id="join-button" href="registration.do"
										class="btn btn-light btn-lg"> Join TütAdvisor Now!</a>
								</div>
							</div>
						</div>
						<div class="item">
							<img src="/images/4.jpg" alt="4" style="width: 100%;">
							<div id="carousel-caption"
								class="carousel-caption d-none d-md-block">
								<p>
									TütAdvisor.<br> We're only in it for the money.
								</p>
							</div>
						</div>
					</div>
					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
				<!-- end carousel -->
			</c:otherwise>
		</c:choose>
	</div>
	<div id="VSBO" class="container">
		<p>© 2019 Vomit Sack Brain Overflow - A Family Company</p>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
