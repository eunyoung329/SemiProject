package semi.Project.muktopia.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static semi.Project.muktopia.common.JDBCTemplate.*;

import semi.Project.muktopia.member.model.vo.Restaurant;

public class RestaurantDAO {
	

		Statement st;
		PreparedStatement pstmt;
		ResultSet rs;
		Properties prop;
		
		public RestaurantDAO() {
			
			try {
				prop = new Properties();
				String filePath = RestaurantDAO.class.getResource("/semi/Project/muktopia/sql/restaurant-sql.xml").getPath();
				prop.loadFromXML(new FileInputStream (filePath));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	/**레스토랑 전체 정보를 가져오는 dao
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public List<Restaurant> loadResList(Connection conn) throws SQLException {
		List<Restaurant> resList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("restaurantList");
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String rest_id = rs.getString("RESTAURANT_ID");
				String rest_name = rs.getString("RESTAURANT_NAME");
				String rest_Addr = rs.getString("RESTAURANT_ADDR");
				String rest_x = rs.getString("RESTAURANT_X");
				String rest_y = rs.getString("RESTAURANT_Y");
				String rest_category=rs.getString("RESTAURANT_CATEGORY");
				String rest_sns=rs.getString("RESTAURANT_SNS");
				String rest_tel=rs.getString("RESTAURANT_TEL");
				String rest_time=rs.getString("RESTAURANT_TIME");
				String rest_img=rs.getString("RESTAURANT_IMG");
				
				Restaurant restaurant = new Restaurant(rest_id, rest_name, rest_Addr, rest_x, rest_y, rest_category, rest_sns, rest_tel, rest_time, rest_img);
			    resList.add(restaurant);
				}

		}finally {
			close(rs);
			close(st);
		}
		
		return resList;
	}


	public Restaurant pickRest(Connection conn, String x, String y) throws Exception {
		Restaurant pick = null;
		try {
			String sql = prop.getProperty("pick");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, x);
			pstmt.setString(2, y);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pick = new Restaurant();
				
				pick.setRest_id(rs.getString(1));
				pick.setRest_name(rs.getString(2));
				pick.setRest_category(rs.getString(3));
				pick.setRest_sns(rs.getString(4));
				pick.setRest_img(rs.getString(5));
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return pick;
	}


	public List<Restaurant> maker(Connection conn) throws Exception {
		List<Restaurant> maker =  new ArrayList<>();
		try {
			String sql = prop.getProperty("maker");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Restaurant make = new Restaurant();
				make.setRest_id( rs.getString("RESTAURANT_ID"));
				make.setRest_name(rs.getString("RESTAURANT_NAME"));
				make.setRest_Addr(rs.getString("RESTAURANT_ADDR"));
				make.setRest_category(rs.getString("RESTAURANT_CATEGORY"));
				make.setRest_sns(rs.getString("RESTAURANT_SNS"));
				make.setRest_tel(rs.getString("RESTAURANT_TEL"));
				make.setRest_time(rs.getString("RESTAURANT_TIME"));
				make.setRest_x(rs.getString("RESTAURANT_X"));
				make.setRest_y(rs.getString("RESTAURANT_Y"));
				make.setRest_img(rs.getString("RESTAURANT_IMG"));
				
				maker.add(make);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return maker;
	}


	public int jjim(Connection conn, int itemId, int memberNo) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("jjim");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemId);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public int jjimDelete(Connection conn, int itemId, int memberNo)throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("jjimDelete");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemId);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}


	public List<Integer> heart(Connection conn, int memberNo) throws Exception{
		List<Integer> restIds =  new ArrayList<>();
		try {
			String sql = prop.getProperty("heart");
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberNo);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int restId = rs.getInt("restaurant_id");
                restIds.add(restId);
            }
		}finally {
			close(rs);
			close(pstmt);
		}
		return restIds;
	}
	
}
