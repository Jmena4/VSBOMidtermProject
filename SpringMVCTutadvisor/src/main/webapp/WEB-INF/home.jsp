<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Tütadvisor Home</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js">
	
</script>
<link rel="stylesheet" href="landing.css" />
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
			<div class="navbar-nav mr-auto">
				<form action="home.do" method="GET">
					<button id="home-button" type="submit">
						<span class="glyphicon glyphicon-home"></span> Tütadvisor Home
					</button>
					&nbsp; &nbsp;
				</form>
				<form action="logout.do" method="GET">
					<button id="logout-button" type="submit">
						<span class="glyphicon glyphicon-log-out"></span> Logout
					</button>
				</form>
			</div>
			<div class="navbar-nav ml-auto">
				<form action="profile.do" method="GET">
					<input id="profile-button" type="submit" value="My Profile">
				</form>
			</div>
		</div>
	</nav>
	<span class="float-right">
		<form action="switch_cards.do" method="GET">
			<select id="type" name="type">
				<option value="1">My Suggestions</option>
				<option value="2">My Proposals</option>
				<option value="3">My History</option>
			</select> &nbsp; <input id="show-cards" type="submit" value="Show Cards">
			&nbsp; &nbsp; &nbsp; &nbsp;
		</form>
	</span>
	<br>
	<br>
	<div id="card-container" class="container">
	
	<!-- check for skills -->
	<c:if test="${(empty learnable) and (empty teachable)}">
	<span id="empty-warning">
	You have not picked any skills to learn or teach!<br>
	Edit your profile to receive suggestions.
	</span>
	</c:if>
	
	<!-- learnable suggestion card factory -->
	
	<c:if test="${not empty learnable}">
		<c:forEach var="suggestion" items="${learnable}">
		<form action="suggestion.do" method="GET">
			<button id="card-button" type="submit">
				<div id="suggestion-card" class="card">
					<div class="row">
						<div id="col-photo" class="column">
							<div id="div-photo" class="float-right">
								<img class="card-img-top"
									src=${suggestion.url}>
							</div>
						</div>
						<div id="card-column" class="column">
							<div class="card-title">${suggestion.username} wants to teach you ${suggestion.name}</div>
							<div class="card-text">
								Name: ${suggestion.userfirstname} &nbsp; ${suggestion.userlastname}
								<br>
								Skill: ${suggestion.skillname}
								<br>
								Skill Level: ${suggestion.level}
								<br>
								Location: ${suggestion.location}
								<div class="card-comment">Comment: ${suggestion.comment}</div>
								<input type="hidden" name="id" value="${suggestion.id}" />
							</div>
						</div>
					</div>
				</div>
			</button>
		</form>
		<br>
		</c:forEach>
		</c:if>
		
		<!-- end learnable suggestion card factory -->
		
		
	<!-- teachable suggestion card factory -->
	
	<c:if test="${not empty teachable}">
		<c:forEach var="suggestion" items="${teachable}">
		<form action="suggestion.do" method="GET">
			<button id="card-button" type="submit">
				<div id="suggestion-card" class="card">
					<div class="row">
						<div id="col-photo" class="column">
							<div id="div-photo" class="float-right">
								<img class="card-img-top"
									src=${suggestion.url}>
							</div>
						</div>
						<div id="card-column" class="column">
							<div class="card-title">${suggestion.username} wants to teach you ${suggestion.name}</div>
							<div class="card-text">
								Name: ${suggestion.userfirstname} &nbsp; ${suggestion.userlastname}
								<br>
								Skill: ${suggestion.skillname}
								<br>
								Skill Level: ${suggestion.level}
								<br>
								Location: ${suggestion.location}
								<div class="card-comment">Comment: ${suggestion.comment}</div>
								<input type="hidden" name="id" value="${suggestion.id}" />
							</div>
						</div>
					</div>
				</div>
			</button>
		</form>
		<br>
		</c:forEach>
		</c:if>
		
		<!-- end teachable suggestion card factory -->	
		

	</div>
	<div id="VSBO" class="container">
		<p>© 2019 Vomit Sack Brain Overflow - A Family Company</p>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>