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
			<div id = "movie-text"> <a href = "ShowMovieListCustomer"> Movies </a> </div>
			<div id = "favorite-text"> <a href = "ShowFavorite"> Favorites </a> </div>
		
		</header>

		<section>

			<div id = "table-align">
				<h1>Movies</h1>
				
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
						<td colspan = "5" class = "notification bolding"> 
						<c:if test="${addFavoriteStatus == 'true'}">
						 Movies added to Favorites Successfully
						</c:if>
						</td>
					</tr>
					
					<tr>
						<th id = "table-left" > <label> Title </label> </th>
						<th> <label> Box Office </label> </th>
						<th id = "table-right" > <label> Genre </label> </th>
						<th> <label> Has Teaser </label> </th>
						<th> <label> Action </label> </th>
					</tr>
					
					<c:forEach items="${movieList}" var="movie">
					
					<fmt:formatNumber type="number" value="${movie.boxOffice}" var="boxOffice" pattern="###,###" />
 					
					<tr>
						<td id = "table-left" > ${movie.title} </td>
						<td> $ ${boxOffice} </td>
						<td id = "table-right" > ${movie.genre} </td>
						<td> ${movie.hasTeaser eq true ? "Yes":"No"} </td>
						<td> <a href = "AddToFavorite?movieId=${movie.id}"> Add to Favorite </a> </td>
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