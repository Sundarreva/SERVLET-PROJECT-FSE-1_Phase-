package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String args[]) throws SystemException {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();

	}

	public static void testGetMenuItemListAdmin() throws SystemException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		System.out.println("=======================================================");
		System.out.println("\n\n     Admin List");
		System.out.println("     ==========");

		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println();
			System.out.println("Id : " + menuItemList.get(i).getId());
			System.out.println("Name : " + menuItemList.get(i).getName());
			System.out.println("Price : $" + menuItemList.get(i).getPrice());
			System.out.println("Active : " + menuItemList.get(i).isActive());
			System.out.println("Category : " + menuItemList.get(i).getCategory());
			System.out.println("Date of Launch : " + dateFormat.format(menuItemList.get(i).getDateOfLaunch()));
			System.out.println("Category : " + menuItemList.get(i).isFreeDelivery());
			System.out.println("=====================================================");
		}

	}

	public static void testGetMenuItemListCustomer() throws SystemException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		System.out.println("=======================================================");
		System.out.println("\n\n     Customer List");
		System.out.println("     =============");
		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println();
			System.out.println("Id : " + menuItemList.get(i).getId());
			System.out.println("Name : " + menuItemList.get(i).getName());
			System.out.println("Price : $" + menuItemList.get(i).getPrice());
			System.out.println("Active : " + menuItemList.get(i).isActive());
			System.out.println("Category : " + menuItemList.get(i).getCategory());
			System.out.println("Date of Launch : " + dateFormat.format(menuItemList.get(i).getDateOfLaunch()));
			System.out.println("Category : " + menuItemList.get(i).isFreeDelivery());
			System.out.println("=======================================================");
		}

	}

	public static void testModifyMenuItem() throws SystemException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(
				new MenuItem(1, "Shawarma", 89.00f, true, DateUtil.convertToDate("23/12/2017"), "Main Course", true));
	}

	public static void testGetMenuItem() throws SystemException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println();
			System.out.println("Id : " + menuItemList.get(i).getId());
			System.out.println("Name : " + menuItemList.get(i).getName());
			System.out.println("Price : $" + menuItemList.get(i).getPrice());
			System.out.println("Active : " + menuItemList.get(i).isActive());
			System.out.println("Category : " + menuItemList.get(i).getCategory());
			System.out.println("Date of Launch : " + dateFormat.format(menuItemList.get(i).getDateOfLaunch()));
			System.out.println("Category : " + menuItemList.get(i).isFreeDelivery());
			System.out.println("=======================================================");
		}

	}
}
