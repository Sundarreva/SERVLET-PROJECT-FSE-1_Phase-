<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<link rel = "stylesheet" type = "text/css" href = "style/style.css">
	</head>

	<body>

		<header>
			<div id = "logoname"> Movie Cruiser </div> 
			<img id = "logo" src = "images/logo.png" alt = "logo" width = "100px" height = "140px"/>
			<div id = "movie-text"><a href = "ShowMovieListAdmin"> Movies </a> </div>
		</header>

		<section>

			<div id = "table-align">
				<h1>Edit Movies Status</h1>
			</div>
			<c:choose>
					<c:when test="${not empty errorMsg}">
				<div class="system-exception bolding">
				<p>
				<br>${errorMsg}</p>
				</div>
					</c:when>
					
					<c:otherwise>
				<br>
				<br>
				<br>
			<div id = "edit-status-text">	
				Movie details saved successfully
			</div>
			</c:otherwise>
			</c:choose>
			
		</section>

		<footer>
			<div id = "foot-text">
			Copyright&nbsp;&copy;&nbsp;2019
			</div>
		</footer>

	</body>

</html>