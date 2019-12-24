package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException, SystemException {

		List<MenuItem> item = new ArrayList<MenuItem>();
		Cart cart = new Cart(item, 0.0);
		MenuItem menu = null;
		String query = "SELECT " + " `menu_item`.`me_id`," + " `menu_item`.`me_name`," + " `menu_item`.`me_price`,"
				+ " `menu_item`.`me_active`," + " `menu_item`.`me_date_of_launch`," + " `menu_item`.`me_category`,"
				+ " `menu_item`.`me_free_delivery`" + " FROM `truyum`.`menu_item`" + " JOIN `truyum`.`cart` c "
				+ " WHERE c.ct_pr_id =`menu_item`.`me_id`" + " AND c.ct_us_id =" + userId + ";";

		try {
			Connection conn = ConnectionHandler.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				menu = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
				item.add(menu);
			}

			if (item.isEmpty()) {
				throw new CartEmptyException("Cart is Empty");
			}
			cart.setMenuItemList(item);
		} catch (SQLException e) {
			throw new SystemException(e.getErrorCode(), e.getLocalizedMessage());
		}
		
		return item;
	}

	public void addCartItem(long userId, long MenuItemId) throws SystemException {
		
		String query = "INSERT INTO `truyum`.`cart` " + "(`ct_us_id`," + "`ct_pr_id`)" + " VALUES " + "(" + userId + ","
				+ MenuItemId + ");";
		
		try {
			Connection conn = ConnectionHandler.getConnection();
			PreparedStatement pstmt;
			{
				pstmt = conn.prepareStatement(query);
				int row = pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			throw new SystemException(e.getErrorCode(), e.getLocalizedMessage());
		}
	}

	public void removeCartItem(long userId, long menuItemId) throws SystemException {

		String query = "DELETE FROM `truyum`.`cart`" + "WHERE `ct_us_id`=" + userId + " AND `ct_pr_id`=" + menuItemId
				+ " limit 1;";
		try {
			Connection conn = ConnectionHandler.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			int row = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SystemException(e.getErrorCode(), e.getLocalizedMessage());
		}
	}
}
