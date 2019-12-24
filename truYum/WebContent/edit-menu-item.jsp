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
	<script type="text/javascript" src="js/script.js">
		
	</script>

	<header>

		<div id="logoname">truYum</div>
		<img id="logo" src="images/truyum-logo-light.png" width="100px"
			height="140px" />
		<div id="menu-text">
			<a href="ShowMenuItemListAdmin">Menu</a>
		</div>

	</header>

	<section>

		<div id="table-align">
			<h1>Edit Menu Items</h1>

			<form name="menuItemForm" onsubmit="return validateMenuItemForm()"
				method="post" action="EditMenuItem?id=${menu.id}">

				<fmt:formatDate type="date" dateStyle="short"
					value="${menu.dateOfLaunch}" var="dateOfLaunch"
					pattern="dd/MM/yyyy" />
				<fmt:formatNumber type="currency" var="price" pattern="#,##,##0.00"
					value="${menu.price}" />

				<table id="edit-menu-table">
				
					<tr>
					<c:if test="${not empty errormsg}">
						<td colspan="5" class="notification bolding">${errormsg}</td>
					</c:if>
				</tr>
				
				<c:if test = "${empty errormsg}">

					<tr>
						<td colspan="4"><label for="user-Name"> Name </label></td>
					</tr>

					<tr>
						<td colspan="4"><input type="text" name="title"
							id="user-Name" value="${menu.name}" size=100></td>
					</tr>

					<tr>
						<td><label for="cost">Price (Rs.) </label></td>
						<td><label for="active">Active </label></td>
						<td><label for="date">Date of Launch </label></td>
						<td><label for="dropList">Category </label></td>
					</tr>

					<tr>
						<td><input type="text" name="price" id="cost"
							value="${price}" size="13"></td>

						<td><input type="radio" name="inStock" value="true"
							id="active" ${menu.active eq true ? 'checked':''}> Yes <input
							type="radio" name="inStock" value="false" id="active"
							${menu.active eq false ? 'checked':''}> No</td>

						<td><input type="text" name="dateOfLaunch" id="date"
							value="${dateOfLaunch}"></td>

						<td><select id="dropList" name="category">
								<option></option>
								<option ${menu.category eq "Starters" ? 'selected':''}>
									Starters</option>
								<option ${menu.category eq "Main Course" ? 'selected':''}>
									Main Course</option>
								<option ${menu.category eq "Dessert" ? 'selected':''}>
									Dessert</option>
								<option ${menu.category eq "Drinks" ? 'selected':''}>
									Drinks</option>
						</select></td>

					</tr>

					<tr>
						<td colspan="4"><input type="checkbox" name="freeDelivery"
							id="delivery" ${menu.freeDelivery eq true ? 'checked':''}>
							&nbsp;&nbsp; <label for="delivery"> Free Delivery </label></td>
					</tr>

					<tr>
						<td colspan="4">
							<button type="submit" id="save" name="submit">Save</button>
						</td>
					</tr>
					</c:if>
				</table>

			</form>

		</div>

	</section>

	<footer>
		<div id="foot-text">Copyright &nbsp;&copy;&nbsp;2019</div>
	</footer>

</body>

</html>