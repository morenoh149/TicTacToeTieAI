package tttai;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String minimaxVer = s.nextLine();
		String opponentVer = s.nextLine();
		StringBuilder log = new StringBuilder();
		Board board = new Board();
		Player opp, minimax;
		if(minimaxVer.equals("win")){
			minimax = new MinimaxWin();
		}
		else{
			minimax = new MinimaxTie();
		}
		if(opponentVer.equals("simple")){
			opp = new SimplePlayer();
		}
		else{
			opp = new HumanPlayer();
		}
		String currentState,commentary;
		while(!board.isOver()){
			board = minimax.makeMove(board);
			commentary = "----------------\n";
			//commentary += "Player "+minimax.getType()+" adds a X to position ";
			System.out.println(commentary);
			currentState = board.toString();
			System.out.println(currentState);
			if(board.isOver()){
				break;
			}
			System.out.println(commentary);
			log.append(currentState);
			board = opp.makeMove(board);
			currentState = board.toString();
			System.out.println(currentState);
		}
		if(board.isOver())
			System.out.println("is Over!");
		try{
			// Create file
			String playerType1 = minimax.type;
			String playerType2 = opp.type;
			FileWriter fstream = new FileWriter("log_"+playerType1+"_vs_+"+playerType2+".txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(log.toString());
			
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
