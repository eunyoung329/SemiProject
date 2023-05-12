package semi.Project.muktopia.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import static semi.Project.muktopia.common.JDBCTemplate.*;






public class InquiryDAO {

    Statement st;
    PreparedStatement pstmt;
    ResultSet rs;
    Properties prop;
    public InquiryDAO() {
        try {
            prop = new Properties();
            String filePath = InquiryDAO.class.getResource("/semi/Project/muktopia/sql/inquiry-sql.xml").getPath();
            prop.loadFromXML(new FileInputStream (filePath));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int inquiry(int memberNo,Connection conn, String inquiryCategory,  String inquiryTitle,
            String inquiryContent) throws Exception{
        int result=0;
        try {
            String sql=prop.getProperty("inquiry");
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, memberNo);
            pstmt.setString(2, inquiryCategory);
            pstmt.setString(3, inquiryTitle);
            pstmt.setString(4, inquiryContent);
            result = pstmt.executeUpdate();
        }finally {
            close(pstmt);
        }
        return result;
    }
}