package VO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
	private int num;
	private String title;
	private String content;
	private Timestamp create_date;
	private Timestamp mod_date;
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
}


