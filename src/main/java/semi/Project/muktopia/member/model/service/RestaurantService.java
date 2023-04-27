package semi.Project.muktopia.member.model.service;
import static semi.Project.muktopia.common.JDBCTemplate.*;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;

import semi.Project.muktopia.member.model.dao.RestaurantDAO;
import semi.Project.muktopia.member.model.vo.Restaurant;
import semi.Project.muktopia.member.model.vo.WishList;



public class RestaurantService {
	
	public RestaurantService() {};
	
	private RestaurantDAO dao = new RestaurantDAO();
	
	Connection conn = getConnection();

	/** 레스토랑 전체 정보를 불러오는 service
	 * @return
	 */
	public List<Restaurant> loadResList() throws Exception {

		Connection conn = getConnection();
		List<Restaurant> resList = dao.loadResList(conn);
		
		return resList;
	}

	public Restaurant pickRest(String x, String y) throws Exception {
		Connection conn = getConnection();
		
		Restaurant pick = dao.pickRest(conn,x,y);
		
		return pick;
	}

	public List<Restaurant> maker() throws Exception{
		Connection conn = getConnection();
		
		List<Restaurant> maker = dao.maker(conn);
		
		return maker;
	}

	/**위시리스트 레스토랑을 로드하는 서비스
	 * @param memberNo 
	 * @return
	 * @throws SQLException 
	 */
	public List<WishList> wishListLoad(int memberNoparam) throws SQLException {
		Connection conn = getConnection();
		List<WishList> wishList = dao.wishListLoad(conn, memberNoparam);
		
		return wishList;

	}


	
	
	
	
	
}
