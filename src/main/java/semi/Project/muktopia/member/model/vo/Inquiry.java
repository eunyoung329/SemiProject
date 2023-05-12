package semi.Project.muktopia.member.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Inquiry {
     private  String inquiryCategory;
     private  String memberNo;
     private  String inquiryTitle;
     private  String inquiryContent;
     private String inquiryDate;
    
}