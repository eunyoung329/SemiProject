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
public class WishList {


		public WishList(int wishlistIdx, String restId, String restName, String restAddr, String restAddr2, String restSns,
			String restSns2, String restTime, String restImg, String restContents) {
		// TODO Auto-generated constructor stub
	}
		private int wishlist_idx;
	    private int memberNo;
	   
	    private String rest_id;
		private String rest_name;
		private String rest_Addr;
		private String rest_category;
		private String rest_sns;
		private String rest_tel;
		private String rest_time;
		private String rest_img;
		private String rest_contents;

}
