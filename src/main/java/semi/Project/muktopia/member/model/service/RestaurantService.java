package semi.Project.muktopia.member.model.service;
import static semi.Project.muktopia.common.JDBCTemplate.*;
import java.util.List;

import java.sql.Connection;


import semi.Project.muktopia.member.model.dao.RestaurantDAO;
import semi.Project.muktopia.member.model.vo.Restaurant;



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

	public int jjim(int itemId, int memberNo) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.jjim(conn, itemId, memberNo);
		
		if(result >0)	commit(conn);
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

	
	
	
	
	
	
	
}
