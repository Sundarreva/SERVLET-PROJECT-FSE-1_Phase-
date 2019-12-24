package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin() throws SystemException {

		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		String query = "SELECT " + "me_id, me_name, " + "me_price, me_active, " + "me_date_of_launch, "
				+ "me_category, " + "me_free_delivery\r\n" + "FROM `truyum`.`menu_item`";

		try {
			Connection conn = ConnectionHandler.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MenuItem menu = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4),
						rs.getDate(5), rs.getString(6), rs.getBoolean(7));
				menuItem.add(menu);
			}
		} catch (SQLException e) {
			throw new SystemException(e.getErrorCode(), e.getLocalizedMessage());
		}

		return menuItem;
	}

	public List<MenuItem> getMenuItemListCustomer() throws SystemException {

		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		String query = "SELECT " + "me_id, " + "me_name, " + "me_price, " + "me_active, " + "me_date_of_launch, "
				+ "me_category, " + "me_free_delivery "
				+ "FROM `truyum`.`menu_item` where me_active='Yes' AND me_date_of_launch <= CURDATE();";

		try {
			Connection conn = ConnectionHandler.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MenuItem menu = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4),
						rs.getDate(5), rs.getString(6), rs.getBoolean(7));
				menuItem.add(menu);
			}
		} catch (SQLException e) {
			throw new SystemException(e.getErrorCode(), e.getLocalizedMessage());
		}

		return menuItem;
	}

	public MenuItem getMenuItem(long menuItemId) throws SystemException {

		MenuItem menu = null;
		String query = "SELECT " + "me_id, " + "me_name, " + "me_price, " + "me_active, " + "me_date_of_launch, "
				+ "me_category, " + "me_free_delivery " + "FROM `truyum`.`menu_item` where me_id =" + menuItemId + ";";
		PreparedStatement pstmt;

		try {
			Connection conn = ConnectionHandler.getConnection();
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				menu = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
			}

		} catch (SQLException e) {
			throw new SystemException(e.getErrorCode(), e.getLocalizedMessage());
		}

		return menu;
	}

	public void modifyMenuItem(MenuItem menuItem) throws SystemException {

		String query = "UPDATE `truyum`.`menu_item`" + " SET " + "`me_id` =" + menuItem.getId() + "," + "`me_name` ='"
				+ menuItem.getName() + "' ," + "`me_price` =" + menuItem.getPrice() + " ," + "`me_active` ="
				+ (menuItem.isActive() == true ? "'Yes'" : "'No'") + "," + "`me_date_of_launch` ='"
				+ new java.sql.Date(menuItem.getDateOfLaunch().getTime()) + "'," + "`me_category` ='"
				+ menuItem.getCategory() + "'," + "`me_free_delivery` ="
				+ (menuItem.isFreeDelivery() == true ? "'" + "Yes" + "'" : "'" + "No'") + " WHERE `me_id`="
				+ menuItem.getId() + ";";

		try {
			Connection conn = ConnectionHandler.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			int row = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SystemException(e.getErrorCode(), e.getLocalizedMessage());
		}

	}
}
