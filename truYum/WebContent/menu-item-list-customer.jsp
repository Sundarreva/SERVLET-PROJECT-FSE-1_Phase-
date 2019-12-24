<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>

<body>

	<header>

		<div id="logoname">truYum</div>
		<img id="logo" src="images/truyum-logo-light.png" width="100px"
			height="140px" />
		<div id="menu-text">
			<a href="ShowMenuItemListCustomer"> Menu </a>
		</div>
		<div id="cart-text">
			<a href="ShowCart"> Cart </a>
		</div>

	</header>

	<section>

		<div id="table-align">
			<h1>Menu Items</h1>

			<table>

				<tr>
					<c:if test="${addCartStatus == true}">
						<td colspan="5" class="notification bolding">Item added to
							Cart Successfully</td>
					</c:if>
				</tr>
				
				<tr>
					<c:if test="${not empty errormsg}">
						<td colspan="5" class="notification bolding">${errormsg}</td>
					</c:if>
				</tr>
				
				
				<c:if test = "${empty errormsg}">
				<tr>
								
					<th id="table-left"><label> Name </label></th>
					<th><label> Free Delivery </label></th>
					<th id="table-right"><label> Price </label></th>
					<th><label> Category </label></th>
					<th><label> Action </label></th>
				</tr>

				<c:forEach items="${menuItemList}" var="menuItem">

					<c:choose>
						<c:when test="${menuItem.freeDelivery == true}">
							<c:set var="freeDelivery" value="Yes" />
						</c:when>
						<c:otherwise>
							<c:set var="freeDelivery" value="No" />
						</c:otherwise>
					</c:choose>

					<fmt:formatNumber type="number" var="price" pattern="#,##,###.00"
						value="${menuItem.price}" />



					<tr>
						<td id="table-left"><label>${menuItem.name} </label></td>
						<td><label>${freeDelivery}</label></td>
						<td id="table-right"><label> Rs. ${price} </label></td>
						<td><label> ${menuItem.category} </label></td>
						<td><a href="AddToCart?menuItemId=${menuItem.id}"> Add to
								Cart </a></td>
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