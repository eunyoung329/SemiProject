package semi.Project.muktopia.member.model.service;

import static semi.Project.muktopia.common.JDBCTemplate.close;

import static semi.Project.muktopia.common.JDBCTemplate.commit;
import static semi.Project.muktopia.common.JDBCTemplate.getConnection;
import static semi.Project.muktopia.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.Part;



import semi.Project.muktopia.member.model.dao.ReportStoreDAO;
import semi.Project.muktopia.member.model.vo.ReportStore;

public class ReportStoreService {

	
	
	private ReportStoreDAO dao = new ReportStoreDAO();

    Connection conn = getConnection();
	
	





	public int reportStore(int memberNo,String rest_category,String rest_img, String rest_name, String rest_Addr,
			String report_Content)throws Exception {
		Connection conn=getConnection();
        int result=dao.reportStore(conn,memberNo,rest_category,rest_img,rest_name,rest_Addr,report_Content);
        if(result>0) commit(conn);
        else rollback(conn);
        close(conn);
        return result;
	}









}
