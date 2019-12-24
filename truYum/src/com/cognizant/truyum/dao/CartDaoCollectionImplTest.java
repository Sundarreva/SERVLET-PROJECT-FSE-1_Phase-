package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws SystemException {
		testAddCartItem();
		testRemoveCartItem();
	}

	public static void testAddCartItem() throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 2);
		cartDao.addCartItem(1, 1);
		List<MenuItem> menuItemList = null;
		try {
			menuItemList = cartDao.getAllCartItems(1);
			for (int i = 0; i < menuItemList.size(); i++) {

				System.out.println("Id : " + menuItemList.get(i).getId());
				System.out.println("Name : " + menuItemList.get(i).getName());
				System.out.println("Price : " + menuItemList.get(i).getPrice());
				System.out.println("Active : " + menuItemList.get(i).isActive());
				System.out.println("Date Of Lunch : " + sdf.format(menuItemList.get(i).getDateOfLaunch()));
				System.out.println("Category : " + menuItemList.get(i).getCategory());
				System.out.println("Free Delivery : " + menuItemList.get(i).isFreeDelivery());
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testGetAllCartItems() throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemList = null;
		try {
			menuItemList = cartDao.getAllCartItems(1);
			for (int i = 0; i < menuItemList.size(); i++) {

				System.out.println("Id : " + menuItemList.get(i).getId());
				System.out.println("Name : " + menuItemList.get(i).getName());
				System.out.println("Price : " + menuItemList.get(i).getPrice());
				System.out.println("Active : " + menuItemList.get(i).isActive());
				System.out.println("Date Of Lunch : " + sdf.format(menuItemList.get(i).getDateOfLaunch()));
				System.out.println("Category : " + menuItemList.get(i).getCategory());
				System.out.println("Free Delivery : " + menuItemList.get(i).isFreeDelivery());

			}
		} catch (CartEmptyException e) {

			System.out.println(e.getMessage());
		}

	}

	public static void testRemoveCartItem() throws SystemException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 2);
		cartDao.removeCartItem(1, 1);
		List<MenuItem> menuItemList = null;
		try {
			menuItemList = cartDao.getAllCartItems(1);
			for (int i = 0; i < menuItemList.size(); i++) {

				System.out.println("Id : " + menuItemList.get(i).getId());
				System.out.println("Name : " + menuItemList.get(i).getName());
				System.out.println("Price : " + menuItemList.get(i).getPrice());
				System.out.println("Active : " + menuItemList.get(i).isActive());
				System.out.println("Date Of Lunch : " + sdf.format(menuItemList.get(i).getDateOfLaunch()));
				System.out.println("Category : " + menuItemList.get(i).getCategory());
				System.out.println("Free Delivery : " + menuItemList.get(i).isFreeDelivery());
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
