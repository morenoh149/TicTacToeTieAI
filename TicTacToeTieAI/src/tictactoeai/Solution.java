package tictactoeai;
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		State init = new State(weights, dummy, true);
		State goal = new State(dummy, weights, false);
		BFS bfs = new BFS(init, goal);
	}
}
