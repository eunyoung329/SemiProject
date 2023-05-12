package semi.Project.muktopia.member.model.service;
import static semi.Project.muktopia.common.JDBCTemplate.*;
import java.sql.Connection;
import semi.Project.muktopia.member.model.dao.InquiryDAO;
public class InquiryService {
    private InquiryDAO dao = new InquiryDAO();

    Connection conn = getConnection();
    
    public int inquiry(int memberNo,String inquiryCategory, String inquiryTitle, String inquiryContent) throws Exception{
        Connection conn=getConnection();
        int result=dao.inquiry(memberNo,conn,inquiryCategory,inquiryTitle,inquiryContent);
        if(result>0) commit(conn);
        else rollback(conn);
        close(conn);
        return result;
    
    }

}