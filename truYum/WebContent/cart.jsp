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
			<h1>Cart</h1>

			<table>
				
				<tr>
					<c:if test="${not empty errormsg}">
						<td colspan="5" class="notification bolding">${errormsg}</td>
					</c:if>
				</tr>
				
				<c:if test = "${empty errormsg}">
				
				<tr>
					<td colspan="4" class="notification bolding">
					<c:if test="${removeCartItemStatus == true}"> 
					Item removed from Cart successfully
					</c:if>
				</tr>

				<tr>
					<th id="table-left"><label> Name </label></th>
					<th id="table-left-only"><label> Free Delivery </label></th>
					<th id="table-right"><label> Price </label></th>
					<th><label> </label></th>
				</tr>

				<c:forEach items="${cartItems}" var="item">

					<c:choose>
						<c:when test="${item.freeDelivery == true}">
							<c:set var="freeDelivery" value="yes" />
						</c:when>
						<c:otherwise>
							<c:set var="freeDelivery" value="No" />
						</c:otherwise>
					</c:choose>

					<fmt:formatNumber type="number" var="price" pattern="#,##,##0.00"
						value="${item.price}" />

					<tr>
						<td id="table-left">${item.name}</td>
						<td id="table-left-only">${freeDelivery}</td>
						<td id="table-right">Rs. ${price}</td>
						<td><a href="RemoveCart?menuItemId=${item.id}"> Delete </a></td>
					</tr>

				</c:forEach>

				<tr class="bolding">
					<td></td>
					<td id="table-left-only">Total</td>
					<td id="table-right">Rs. ${total}</td>
					<td></td>
				</tr>
				</c:if>
			</table>
		</div>
	</section>

	<footer>
		<div id="foot-text">Copyright &nbsp;&copy;&nbsp;2019</div>
	</footer>

</body>

</html>