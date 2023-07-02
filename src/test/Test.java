package test;

import java.util.ArrayList;

import VO.Board;
import controller.BoardDAO;

public class Test {
	public static void main(String[] args) {
		BoardDAO bd = new BoardDAO();
		
		
		ArrayList<Board> blist = bd.showAll();
		
		for (Board board : blist) {
			System.out.println(board);
		}
	}
}
