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
		System.out.println(resList+"서비스");
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



	public int jjim(int itemId, int memberNo) throws Exception{
		Connection conn = getConnection();
		int result0 = dao.jjimSelect(conn, itemId, memberNo);
		int result = dao.jjim(conn, itemId, memberNo);
		
		if(result >0 && result0 == 0)	commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

	public int jjimDelete(int itemId, int memberNo) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.jjimDelete(conn, itemId, memberNo);
		
		if(result >0)	commit(conn);
		else			rollback(conn);
		close(conn);
		return result;
	}

	public List<Integer> heart(int memberNo) throws Exception {
		Connection conn = getConnection();
		List<Integer> restIds = dao.heart(conn, memberNo);
		
		return restIds;
	}

	public int jjimSelect(int itemId, int memberNo) throws Exception {
		Connection conn = getConnection();
		int result0 = dao.jjimSelect(conn, itemId, memberNo);
		close(conn);
		return result0;
	}

	public int adminRegisterRest(String rest_category, String rest_name, String rest_img, String rest_x, String rest_y,
			String rest_tel, String rest_time, String rest_sns, String rest_Addr, String rest_contents) throws Exception{
		int result = 0;
		Connection conn = getConnection();
		RestaurantDAO dao = new RestaurantDAO();
		result = dao.adminRegisterRest(conn,rest_category,rest_name,rest_img,rest_x,rest_y,rest_tel,rest_time,rest_sns,rest_Addr,rest_contents);
		if(result>0)commit(conn);
		else rollback(conn);
		return result;
	}

	
	

	
	
	
	
	
}
