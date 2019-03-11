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
	<div class="container" style="width: 65%">

		<div id="w">
    <div id="content" class="clearfix">
      <div id="userphoto"><img src="${user.pictureURL }" alt="default avatar" width="100"></div>
      <h1>${user.firstName } ${user.lastName } </h1>

      <nav id="profiletabs">
        <ul class="clearfix">
          <li><a href="#bio" class="sel">Bio</a></li>
          <li><a href="#activity">Activity</a></li>
          <li><a href="#friends">Friends</a></li>
          <li><a href="#settings">Settings</a></li>
        </ul>
      </nav>
      
      <section id="bio">
        <p>Various content snippets courtesy of <a href="http://bluthipsum.com/">Bluth Ipsum</a>.</p>
        
        <p>Can't a guy call his mother pretty without it seeming strange? Amen. I think that's one of Mom's little fibs, you know, like I'll sacrifice anything for my children.</p>
        
        <p>She's always got to wedge herself in the middle of us so that she can control everything. Yeah. Mom's awesome. I run a pretty tight ship around here. With a pool table.</p>
      </section>
      
      <section id="activity" class="hidden">
        <p>Most recent actions:</p>
        
        <p class="activity">@10:15PM - Submitted a news article</p>
        
        <p class="activity">@9:50PM - Submitted a news article</p>
        
        <p class="activity">@8:15PM - Posted a comment</p>
        
        <p class="activity">@4:30PM - Added <strong>someusername</strong> as a friend</p>
        
        <p class="activity">@12:30PM - Submitted a news article</p>
      </section>
      
      <section id="friends" class="hidden">
        <p>Friends list:</p>
        
        <ul id="friendslist" class="clearfix">
          <li><a href="#"><img src="images/avatar.png" width="22" height="22"> Username</a></li>
          <li><a href="#"><img src="images/avatar.png" width="22" height="22"> SomeGuy123</a></li>
          <li><a href="#"><img src="images/avatar.png" width="22" height="22"> PurpleGiraffe</a></li>
        </ul>
      </section>
      
      <section id="settings" class="hidden">
        <p>Edit your user settings:</p>
        
        <p class="setting"><span>E-mail Address <img src="images/edit.png" alt="*Edit*" width="20"></span> ${user.email }</p>
        
        <p class="setting"><span>Language <img src="images/edit.png" alt="*Edit*"></span> English(US)</p>
        
        <p class="setting"><span>Profile Status <img src="images/edit.png" alt="*Edit*"></span> Public</p>
        
        <p class="setting"><span>Update Frequency <img src="images/edit.png" alt="*Edit*"></span> Weekly</p>
        
        <p class="setting"><span>Connected Accounts <img src="images/edit.png" alt="*Edit*"></span> None</p>
      </section>
    </div><!-- @end #content -->
  </div><!-- @end #w -->
<script type="text/javascript">
$(function(){
  $('#profiletabs ul li a').on('click', function(e){
    e.preventDefault();
    var newcontent = $(this).attr('href');
    
    $('#profiletabs ul li a').removeClass('sel');
    $(this).addClass('sel');
    
    $('#content section').each(function(){
      if(!$(this).hasClass('hidden')) { $(this).addClass('hidden'); }
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
