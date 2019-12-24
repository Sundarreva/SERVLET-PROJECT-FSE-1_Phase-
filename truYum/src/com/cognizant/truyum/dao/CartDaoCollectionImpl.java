package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static Map<Long, Cart> userCarts = null;
	
	public static Map<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public static void setUserCarts(Map<Long, Cart> userCarts) {
		CartDaoCollectionImpl.userCarts = userCarts;
	}

	public CartDaoCollectionImpl() {

		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}
	}

	public void addCartItem(long userId, long menuItemId) throws SystemException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (!userCarts.containsKey(userId)) {
			userCarts.put(userId, new Cart(new ArrayList<MenuItem>(), 0.0));
		}
		
		if(!userCarts.get(userId).getMenuItemList().contains(menuItem))
		userCarts.get(userId).getMenuItemList().add(menuItem);
	}

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {

		List<MenuItem> list = null;
		if (userCarts.containsKey(userId)) {
			Cart cartobj = userCarts.get(userId);
			list = cartobj.getMenuItemList();
			if (list.isEmpty()) {
				throw new CartEmptyException("Cart Empty.");
			} else {
				double total = 0.0f;
				for (MenuItem t : list) {
					total += t.getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
		}
		else {
			throw new CartEmptyException("Cart Empty.");
		}
		return list;
	}

	public void removeCartItem(long userId, long menuItemId) {

		if (userCarts.containsKey(userId)) {
			Cart cartDao = userCarts.get(userId);
			List<MenuItem> MenuItemList = cartDao.getMenuItemList();

			for (int i = 0; i < MenuItemList.size(); i++) {
				if (menuItemId == MenuItemList.get(i).getId()) {
					MenuItemList.remove(i);
					break;
				}
			}
		}

	}

}
