package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import VO.Board;
import dbCon.DBcon;

public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	public BoardDAO() {
		conn = DBcon.getConnection();
	}
	
	public ArrayList<Board> showAll() {
		String sql = "SELECT * FROM tbl_board";
		ArrayList<Board> blist = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp create_date = rs.getTimestamp("create_date");
				Timestamp mod_date = rs.getTimestamp("mod_date");
				Board b = new Board(num, title, content, create_date, mod_date);
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}
	
	public int regist(Board b) {
		int res = -1;
		String sql = "INSERT INTO tbl_board (title, content) VALUES (?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getContent());
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("regist() SQL Error");
			e.printStackTrace();
		}
		
		return res;
	}
	
	public void close() {
		try {
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	};
	
	
}
