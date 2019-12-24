<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<link rel = "stylesheet" type = "text/css" href = "style/style.css">
		<script src ="js/script.js" type = "text/javascript">	</script>
	</head>

	<body>
		

		<header>
		
			<div id = "logoname">Movie Cruiser</div> 
			<img id = "logo" src = "images/logo.png" alt = "logo" width = "100px" height = "140px"/>
			<div id = "movie-text"><a href = "ShowMovieListAdmin">Movies</a></div>
		
		</header>

		<section>

			<div id = "table-align">
				<h1>Edit Movies</h1>
				
				<c:choose>
					<c:when test="${not empty errorMsg}">
				<div class="system-exception bolding">
				<p>
				<br>${errorMsg}</p>
				</div>
					</c:when>
					
					<c:otherwise>
				
				<form name="MovieForm" action="EditMovie?MovieId=${movie.id}" onsubmit="return checkValidate();" method="post">

				<table id = "edit-movie-table">
					
					<fmt:formatNumber type="number" var="boxOffice" pattern="###,###" value="${movie.boxOffice}" />
					<fmt:formatDate type="date" value="${movie.dateOfLaunch}" var="dateOfLaunch" dateStyle="short" pattern="dd/MM/yyyy"/>
					
					<tr>
						<td colspan = "4"> <label for = "user-name"> Title </label> </td>
					</tr>
					
					<tr>
						<td colspan = "4" > <input type = "text" name = "title" id = "user-name" value = "${movie.title}" size = 100 placeholder = "Title of the movie"> </td>
					</tr>
					
					<tr>
						<td colspan = "4" id = "titleError" ></td>
					</tr>

					<tr>
						<td> <label for = "amount"> Gross ($) </label> </td>
						<td> <label for = "active"> Active </label> </td>
						<td> <label for = "launchdate"> Date of Launch </label> </td>
						<td> <label for = "dropList"> Genre </label> </td>
					</tr>

					<tr>
						<td>
							<input type = "text" name = "boxOffice" id = "amount" value =  "${boxOffice}" size = "13" placeholder = "collection">
						</td>
						
						<td>	
							<input type  =  "radio" name  =  "inStock" id  =  "active" value="true" ${ movie.active == true ? 'checked':'' }> Yes 
							<input type  =  "radio" name  =  "inStock" id  =  "active" value="false" ${ movie.active == false ? 'checked':'' } > No
						</td>
						
						<td>
						<input type = "text" name = "dateOfLaunch" id = "launchdate" value = "${dateOfLaunch}" placeholder = "DD/MM/YYYY">
						</td>
						
						<td>
							<select id = "dropList"  name = "genre">
								<option></option>	
								<option ${ movie.genre eq "ScienceFiction"? 'selected':'' }   > ScienceFiction </option>
								<option ${ movie.genre eq "Superhero"? 'selected':'' }> Superhero </option>
								<option ${ movie.genre eq "Romance"? 'selected':'' } > Romance </option>
								<option ${ movie.genre eq "Comedy"? 'selected':'' } > Comedy </option>
								<option ${ movie.genre eq "Adventure"? 'selected':'' } > Adventure </option>
								<option ${ movie.genre eq "Thriller"? 'selected':'' }> Thriller </option>
							</select>
						</td>
						
					</tr>
					
					<tr>
						<td id = "grossError" style = "color: red" ></td>
						<td></td>
						<td id = "dateError" style = "color: red" ></td>
						<td id = "genreError" style = "color: red" ></td>
					</tr>
					
					<tr>
						<td colspan = "4">
							<input type = "checkbox" name = "hasTeaser" id = "teaser" checked> &nbsp;&nbsp; <label for = "teaser" > Has Teaser </label>
						</td>
					</tr>
					
					<tr>
						<td colspan = "4">
							<button type = "submit" id = "save" name = "submit" > Save </button>
						</td>
					</tr>

				</table>
				
				</form>
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