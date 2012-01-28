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
		Calendar cal = Calendar.getInstance();
		if(minimaxVer.equals("win")){
			minimax = new MinimaxWin();
		}
		else if(minimaxVer.equals("ab")){
			minimax = new AlphaBetaPruning();
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
		System.out.println("type: "+minimax.getType());
		String currentState,commentary;
		while(!board.isOver()){
			board = minimax.makeMove(board);
			commentary = "----------------\n";
			commentary += "Player "+minimax.getType()+" adds a X to position "+minimax.getMove();
			System.out.println(commentary);
			currentState = board.toString();
			System.out.println(currentState);
			log.append(commentary);
			log.append(currentState);
			if(board.isOver()){
				break;
			}
			board = opp.makeMove(board);
			commentary = "----------------\n";
			commentary += "Player "+opp.getType()+" adds a O to position "+opp.getMove();
			System.out.println(commentary);
			currentState = board.toString();
			log.append(commentary);
			log.append(currentState);
			System.out.println(currentState);
		}
		if(board.isOver())
			System.out.println("is Over!");
		try{
			// Create file
			FileWriter fstream = new FileWriter("log_"+minimax.getType()+"_vs_+"+opp.getType()+".txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(log.toString());
			
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
