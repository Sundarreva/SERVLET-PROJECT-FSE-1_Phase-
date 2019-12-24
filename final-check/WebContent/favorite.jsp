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
				<h1> Favorites </h1>
				
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
						<td colspan = 4 class = "notification bolding">
						<c:if test="${RemoveFavouriteItemStatus == 'true'}" >
						 Movie removed from Favorites successfully
						</c:if>
						</td>
					</tr>

					<tr>
						<th id = "table-left" > <label> Title </label> </th>
						<th id = "table-right" > <label> Box Office </label> </th>
						<th> <label> Genre </label> </th>
						<th> <label> </label> </th>
					</tr>
					
					<c:forEach items="${favoriteItems}" var="item" >
					
					<fmt:formatNumber type="number" var="boxOffice" pattern="###,###" value="${item.boxOffice}" />
					

					<tr>
						<td id = "table-left" > ${item.title} </td>
						<td id = "table-right" > $ ${boxOffice} </td>
						<td> ${item.genre}  </td>
						<td> <a href = "RemoveFavorite?movieId=${item.id}"> Delete </a> </td>
					</tr>
					
					</c:forEach>
					
					<tr>
					<td colspan = "3"> </td>
					</tr>
					
					<tr class = "bolding">
					<td id = "table-left"> No. of Favorites: ${noOfItems}</td>
					</tr>

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