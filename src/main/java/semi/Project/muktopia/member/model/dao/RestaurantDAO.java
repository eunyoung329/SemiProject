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
import semi.Project.muktopia.member.model.vo.WishList;

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
				
			    resList.add(make);
				}

		}finally {
			close(rs);
			close(pstmt);
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



	/**위시리스트 레스토랑을 로드하는 DAO
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public List<WishList> wishListLoad(Connection conn, int memberNoparam) throws SQLException {
		
		System.out.println("DAO memberNoparam::"+memberNoparam);
		 List<WishList> wishList = new ArrayList<>();

	    try {
	        String sql = prop.getProperty("wishListLoad");
	        pstmt=conn.prepareStatement(sql);
	        pstmt.setInt(1, memberNoparam); // 파라미터 바인딩
	        rs = pstmt.executeQuery();

	        while(rs.next()) {
	        	
	            int wishlistIdx = rs.getInt("WISHLIST_IDX");
	            String restId = rs.getString("RESTAURANT_ID");
	            String restName = rs.getString("RESTAURANT_NAME");
	            String restAddr = rs.getString("RESTAURANT_ADDR");
	            String restCategory = rs.getString("RESTAURANT_CATEGORY");
	            String restSns = rs.getString("RESTAURANT_SNS");
	            String restTel = rs.getString("RESTAURANT_TEL");
	            String restTime = rs.getString("RESTAURANT_TIME");
	            String restImg = rs.getString("RESTAURANT_IMG");
	            String restContents = rs.getString("RESTAURANT_CONTENTS");
	            
	         // WishList 객체 생성 및 값을 설정
	            WishList wish = new WishList();
	            wish.setWishlist_idx(wishlistIdx);
	            wish.setRest_id(restId);
	            wish.setRest_name(restName);
	            wish.setRest_Addr(restAddr);
	            wish.setRest_category(restCategory);
	            wish.setRest_sns(restSns);
	            wish.setRest_tel(restTel);
	            wish.setRest_time(restTime);
	            wish.setRest_img(restImg);
	            wish.setRest_contents(restContents);
	            
	            // 생성한 WishList 객체를 리스트에 추가
	            wishList.add(wish);

	            
	        }

	    } finally {
	        close(rs);
	        close(pstmt);
	    }

	    return wishList;
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


	public int jjimSelect(Connection conn, int itemId, int memberNo) throws Exception {
		int result0 = 0;
		try {
			String sql = prop.getProperty("jjimSelect");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemId);
			pstmt.setInt(2, memberNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result0 = rs.getInt(1);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return result0;
	}

}






