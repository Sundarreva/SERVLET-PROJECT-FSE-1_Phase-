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
			<div id = "movie-text"> <a href = "ShowMovieListAdmin"> Movies </a> </div>
		
		</header>

		<section>

			<div id = "table-align">
				<h2>Movies</h2>
				
				<c:choose>
					<c:when test="${not empty errorMsg}">
				<div class="system-exception bolding">
				<p>
				<br>${errorMsg}</p>
				</div>
					</c:when>
					
					<c:otherwise>
				<table>

					<tr>
						<th id = "table-left" > Title </th>
						<th id = "table-right" > Box Office </th>
						<th> Active </th>
						<th> Date of Launch </th>
						<th> Genre </th>
						<th> Has Teaser </th>
						<th> Action </th>
					</tr>
					
					<c:forEach items="${movieList}" var="movie" >
					
 					<fmt:formatNumber type="number" value="${movie.boxOffice}" var="boxOffice" pattern="###,###" />
 					<fmt:formatDate type="date" dateStyle="short" value="${movie.dateOfLaunch}" var="dateOfLaunch" pattern="dd/MM/yyyy" />
					
					<tr>
						<td id = "table-left" > ${movie.title} </td>
						<td id = "table-right" > $ ${boxOffice} </td>
						<td> ${movie.active == true ? "Yes":"No"} </td>
						<td> ${dateOfLaunch} </td>
						<td> ${movie.genre} </td>
						<td> ${movie.hasTeaser == true ? "Yes":"No"} </td>
						<td> <a href = "ShowEditMovie?MovieId=${movie.id}"> Edit </a> </td>
					</tr>
					
					</c:forEach>
					
				</table>
				</c:otherwise>
				</c:choose>
				
			</div>
			
		</section>

		<footer>
			<div id = "foot-text">
			Copyright&nbsp;&copy;&nbsp;2019
			</div>
		</footer>

	</body>

</html>