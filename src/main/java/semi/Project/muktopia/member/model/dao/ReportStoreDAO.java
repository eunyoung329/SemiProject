package semi.Project.muktopia.member.model.dao;

import static semi.Project.muktopia.common.JDBCTemplate.close;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import semi.Project.muktopia.member.model.vo.ReportStore;



public class ReportStoreDAO {

	

	Statement st;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	Properties prop;
	
	public ReportStoreDAO() {
		
		try {
			prop = new Properties();
			String filePath = RestaurantDAO.class.getResource("/semi/Project/muktopia/sql/reportStore-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream (filePath));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	







	public int reportStore(Connection conn, int memberNo, String rest_category, String rest_img, String rest_name,
			String rest_Addr, String report_Content) throws Exception{
		 int result=0;
	        try {
	            String sql=prop.getProperty("reportStore");
	            pstmt=conn.prepareStatement(sql);
	            
	            pstmt.setInt(1, memberNo);
	            pstmt.setString(2, rest_category);
	            pstmt.setString(3, rest_img);
	            pstmt.setString(4, rest_name);
	            pstmt.setString(5, rest_Addr);
	            pstmt.setString(6, report_Content);
	            
	            result = pstmt.executeUpdate();
	        }finally {
	        	
	            close(pstmt);
	        }
	        return result;
	}





}
