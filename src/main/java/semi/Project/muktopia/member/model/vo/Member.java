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
public class Member {
	private int memberNo;
	private String memberEmail;
	private String memberPw;
	private String memberNick;
	private String memberBirth;
	private String memberTel;
	private String memberAddress;
	private String kakaoMem;
	private String profileImage;
	private String enrollDate;
	private String secessionFlag;
	private String memberBlack;
	private String isAdmin;
}
