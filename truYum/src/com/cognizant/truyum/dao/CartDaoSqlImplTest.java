package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws SystemException {
		// TODO Auto-generated method stub
		testGetAllItems();
		testAddCartItem();
		testRemoveCartItem();
		testGetAllItems();
	}

	public static void testAddCartItem() throws SystemException {
		CartDaoSqlImpl cartSql = new CartDaoSqlImpl();
		cartSql.addCartItem(1, 1);
		System.out.println("Item added to cart successfully");
	}

	public static void testGetAllItems() throws SystemException {
		CartDaoSqlImpl cartSql = new CartDaoSqlImpl();
		try {
			List<MenuItem> cartList = cartSql.getAllCartItems(1);
			for (MenuItem menu : cartList) {

				System.out.printf("%3d %-20s %-12.00f %-12s %-15s %-5s %-5s\n", menu.getId(), menu.getName(),
						menu.getPrice(), menu.getDateOfLaunch(), menu.getCategory(), menu.isActive(),
						menu.isFreeDelivery());
			}
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testRemoveCartItem() throws SystemException {
		CartDaoSqlImpl cartSql = new CartDaoSqlImpl();
		cartSql.removeCartItem(1, 2);
		System.out.println("removed");

	}

}
