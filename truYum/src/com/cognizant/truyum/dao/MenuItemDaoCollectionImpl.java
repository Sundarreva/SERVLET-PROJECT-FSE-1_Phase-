package com.cognizant.truyum.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(1, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(3, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true));
		}
	}

	public static List<MenuItem> getMenuItemList() {

		return menuItemList;
	}

	public static void setMenuItemList(List<MenuItem> menuItemList) {
		MenuItemDaoCollectionImpl.menuItemList = menuItemList;
	}

	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {

		DateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY");
		ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
		Date date = new Date();

		for (int i = 0; i < menuItemList.size(); i++) {
			if ((DateUtil.convertToDate(formatDate.format(date)).compareTo(menuItemList.get(i).getDateOfLaunch()) >= 0)
					&& menuItemList.get(i).isActive() == true) {
				menuItem.add(menuItemList.get(i));
			}
		}

		return menuItem;
	}

	public void modifyMenuItem(MenuItem menuItem) {

		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItem.getId()) {
				menuItemList.set(i, menuItem);
				break;
			}
		}

	}

	public MenuItem getMenuItem(long menuItemId) {
		boolean menuIdMatch = false;
		int i;

		for (i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuIdMatch = true;
				break;
			}
		}
		if (menuIdMatch == true)
			return menuItemList.get(i);
		return null;
	}

}
