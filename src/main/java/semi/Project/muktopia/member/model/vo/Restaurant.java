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
public class Restaurant {
	private String rest_id;
	private String rest_name;
	private String rest_Addr;
	private double rest_x;
	private double rest_y;
	private String rest_category;
	private String rest_sns;
	private String rest_tel;
	private String rest_time;
}	
