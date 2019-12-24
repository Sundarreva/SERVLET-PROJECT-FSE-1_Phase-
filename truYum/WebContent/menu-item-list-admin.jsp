<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>

<body>

	<header>

		<div id="logoname">truYum</div>
		<img id="logo" src="images/truyum-logo-light.png" width="100px"
			height="140px" />
		<div id="menu-text">
			<a href="ShowMenuItemListAdmin"> Menu </a>
		</div>

	</header>

	<section>

		<div id="table-align">
			<h2>Menu Items</h2>

			<table>
			
				<tr>
					<c:if test="${not empty errormsg}">
						<td colspan="5" class="notification bolding">${errormsg}</td>
					</c:if>
				</tr>
				
				
				<c:if test = "${empty errormsg}">

				<tr>
					<th id="table-left">Name</th>
					<th id="table-right">Price</th>
					<th>Active</th>
					<th>Date of Launch</th>
					<th>Category</th>
					<th>Free Delivery</th>
					<th>Action</th>
				</tr>

				<c:forEach items="${menuItemList}" var="menuItem">

					<fmt:formatNumber type="number" var="price" pattern="#,##,##0.00"
						value="${menuItem.price}" />

					<c:choose>
						<c:when test="${menuItem.active == true}">
							<c:set var="active" value="yes" />
						</c:when>
						<c:otherwise>
							<c:set var="active" value="No" />
						</c:otherwise>
					</c:choose>

					<fmt:formatDate type="date" dateStyle="short"
						value="${menuItem.dateOfLaunch}" var="dateOfLaunch"
						pattern="dd/MM/yyyy" />

					<c:choose>
						<c:when test="${menuItem.freeDelivery == true}">
							<c:set var="freeDelivery" value="yes" />
						</c:when>
						<c:otherwise>
							<c:set var="freeDelivery" value="No" />
						</c:otherwise>
					</c:choose>

					<tr>
						<td id="table-left"><label> ${menuItem.name} </label></td>
						<td id="table-right"><label>Rs. ${price} </label></td>
						<td><label> ${active} </label></td>
						<td><label> ${dateOfLaunch} </label></td>
						<td><label> ${menuItem.category } </label></td>
						<td><label> ${freeDelivery} </label></td>
						<td><a href="ShowEditMenuItem?menuItemId=${menuItem.id}">
								Edit </a></td>
					</tr>

				</c:forEach>
				</c:if>
			</table>
		</div>
	</section>

	<footer>
		<div id="foot-text">Copyright &nbsp;&copy;&nbsp;2019</div>
	</footer>

</body>

</html>