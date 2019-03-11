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
	<div class="container" style="width: 65%">
	
	first name
	last name
	email
	phone 
	username
	Address:
		street
		street2
		city
		state
		zip
		
		
		<div class="folding-wrapper">
        <div class="folding-content">
            <!-- Profile Junk -->
            <div>
                <ul class="social">
                
                </ul>
            </div>
            <div class="profile">
                &nbsp;
       <img src="${user.pictureURL }" class="profile-photo">
                <p>${user.firstName } ${user.lastName }</p>
                <p class="job"></p>
                <p class="phone"></p>
            </div>

            <div class="contact-form-container">
                <form action="#" class="contact-form">
                    <div>
                        <label for="Name">
                            <span class="entypo-user"></span>
                        </label>
                        <input type="text" name="Name" placeholder="Name" />
                    </div>

                    <div>
                        <label for="Name">
                            <span class="entypo-mail"></span>
                        </label>
                        <input type="email" name="Email" placeholder="Email" />
                    </div>

                    <div>
                        <label for="Name">
                            <span class="entypo-phone"></span>
                        </label>
                        <input type="phone" name="Phone" placeholder="Phone Number" />
                    </div>

                    <div>
                        <label for="message" class="textarea-label">
                            <span class="entypo-pencil"></span>
                        </label>
                        <textarea name="Message" placeholder="Your Message"></textarea>
                    </div>
                    <div id="send">
                        <span class="entypo-paper-plane"></span>
                    </div>
                </form>
            </div>
        </div>
        <!-- /Wrapper -->
    </div>
	
		
	
		<!-- <div id="myCarousel" class="carousel slide" data-ride="carousel">
			Indicators
			<ol class="carousel-indicators">
				<li data-target="#carousel" data-slide-to="0" class="active"></li>
				<li data-target="#carousel" data-slide-to="1"></li>
				<li data-target="#carousel" data-slide-to="2"></li>
				<li data-target="#carousel" data-slide-to="3"></li>
			</ol>
			Wrapper for slides
			<div class="carousel-inner">
				<div class="item active">
					<img src="/images/1.jpg" alt="1" style="width: 100%;">
					<div class="carousel-caption d-none d-md-block">
						<p>Thousands of Skilled Tutors.</p>
						<div class="join-button">
							<a id="join-button" href="register.do"
								class="btn btn-light btn-lg"> Join TütAdvisor Now!</a>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="/images/2.jpg" alt="2" style="width: 100%;">
					<div class="carousel-caption d-none d-md-block">
						<p>Ready to teach you any subject.</p>
						<div class="join-button">
							<a id="join-button" href="register.do"
								class="btn btn-light btn-lg"> Join TütAdvisor Now!</a>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="/images/3.jpg" alt="3" style="width: 100%;">
					<div class="carousel-caption d-none d-md-block">
						<p>Start learning today!</p>
						<div class="join-button">
							<a id="join-button" href="register.do"
								class="btn btn-light btn-lg"> Join TütAdvisor Now!</a>
						</div>
					</div>
				</div>
				<div class="item">
					<img src="/images/4.jpg" alt="4" style="width: 100%;">
					<div class="carousel-caption d-none d-md-block">
						<p>
							TütAdvisor.<br> We're only in it for the money.
						</p>
					</div>
				</div>
			</div>
			Left and right controls
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div> -->
	</div>
	<div id="VSBO" class="container">
		<p>© 2019 Vomit Sack Brain Overflow - A Family Company</p>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
