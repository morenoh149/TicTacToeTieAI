package tictactoeai;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String minimaxVer = s.nextLine();
		String opponentVer = s.nextLine();
		StringBuilder log = new StringBuilder();
		
		if(minimaxVer=="win"){
			Player minimax = new Minimax(true);
		}
		else{
			Player minimax = new Minimax(false);
		}
		if(opponentVer=="simple"){
			Player opp = new Opponent(true);
		}
		else{
			Player opp = new Opponent(false);
		}
		System.out.println(minimax.getType()+" vs "+opp.getType());
		Board game = new Board();
		String state;
		while(!game.isOver()){
			minimax.makeMove();
			state = game.toString();
			System.out.println(state);
			log.append(state);
			opp.makeMove();
			state = game.toString();
			System.out.println(state);
		}
		try{
			// Create file
			String playerType1 = minimax.getType();
			String playerType2 = opp.getType();
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
