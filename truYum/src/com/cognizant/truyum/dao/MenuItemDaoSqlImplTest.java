package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String args[]) throws SystemException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testGetMenuItem();
		testModifyMenuItem();
	}

	public static void testGetMenuItemListAdmin() throws SystemException {
		System.out.println("----------------ADMIN-------------------");
		MenuItemDaoSqlImpl menuSql = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItem = menuSql.getMenuItemListAdmin();
		for (MenuItem menu : menuItem) {
			System.out.printf("%3d %-20s %-12f %-12s %-15s %-5s %-5s\n", menu.getId(), menu.getName(), menu.getPrice(),
					menu.getDateOfLaunch(), menu.getCategory(), menu.isActive(), menu.isFreeDelivery());
		}
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out
				.println("------------------------------------------------------------------------------------------");
	}

	public static void testGetMenuItemListCustomer() throws SystemException {
		System.out.println("-----------------------CUSTOMER-------------------------");
		MenuItemDaoSqlImpl menuSql = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItem = menuSql.getMenuItemListCustomer();
		for (MenuItem menu : menuItem) {
			System.out.printf("%3d %-20s %-12f %-12s %-15s %-5s %-5s\n", menu.getId(), menu.getName(), menu.getPrice(),
					menu.getDateOfLaunch(), menu.getCategory(), menu.isActive(), menu.isFreeDelivery());
		}
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out
				.println("------------------------------------------------------------------------------------------");
	}

	public static void testModifyMenuItem() throws SystemException {
		System.out.println("------------------------MODIFY----------------------");
		MenuItemDaoSqlImpl menuSql = new MenuItemDaoSqlImpl();
		MenuItem item = new MenuItem(1, "Sandwich", 89.00f, true, DateUtil.convertToDate("20/12/2017"), "Main Course",
				true);
		menuSql.modifyMenuItem(item);
		List<MenuItem> menuItem = menuSql.getMenuItemListAdmin();
		for (MenuItem menu : menuItem) {

			System.out.printf("%3d %-20s %-12f %-12s %-15s %-5s %-5s\n", menu.getId(), menu.getName(), menu.getPrice(),
					menu.getDateOfLaunch(), menu.getCategory(), menu.isActive(), menu.isFreeDelivery());
		}
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out
				.println("------------------------------------------------------------------------------------------");
	}

	public static void testGetMenuItem() throws SystemException {
		System.out.println("----------------------GETMENUITEM--------------------------");
		MenuItemDaoSqlImpl menuSql = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuSql.getMenuItem(2);
		System.out.println(menuItem);
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out
				.println("------------------------------------------------------------------------------------------");
	}

}
