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
		</div>
		<br> <br> <br>
		
		<tr>
			<c:if test="${not empty errormsg}">
					<td colspan="5" class="notification bolding">${errormsg}</td>
			</c:if>
			</tr>
		
			<c:if test = "${empty errormsg}">
		
			<div id="empty-cart">
				No items in cart. Use 'Add to Cart' option in <a
					href="ShowMenuItemListCustomer"> Menu Item List</a>.
			</div>
			</c:if>
	</section>

	<footer>
		<div id="foot-text">Copyright &nbsp;&copy;&nbsp;2019</div>
	</footer>

</body>

</html>