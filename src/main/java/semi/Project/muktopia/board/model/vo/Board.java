package semi.Project.muktopia.board.model.vo;

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
public class Board {
	private int boardNo;
	private int memberNo;
	private String title;
	private String tagValue;
	private String inputArea;
	private String boardImage;
	private String boardTime;
}
