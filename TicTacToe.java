package apcsa;

import java.util.Scanner;

public class TicTacToe {
	String [] board = {SPACE , SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE, SPACE};
	private Player player1;
	private Player player2;
	private static final String X = "X";
	private static final String O = "O";
	private static final String SPACE = " ";
	private static final String SIGN = "Sign";
	private Player currentPlayer;
	public TicTacToe(Player p1, Player p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.currentPlayer = p1;
	
	}


	public void printBoard() {
		System.out.println("|"+ board[0]+"|" + board[1]+"|" + board[2]+"|");
		System.out.println("|"+ board[3]+"|" + board[4]+"|" + board[5]+"|");
		System.out.println("|"+ board[6]+"|" + board[7]+"|" + board[8]+"|");
	}
	public void resetBoard() {
		for(int i = 0; i < 9; i++) {
			board[i] = SPACE;
		}
	}
	public void makeMove(Scanner s1) {
		String sign;
		boolean validMove = false;
		sign = currentPlayer.getSign();
		while (!validMove) {
			System.out.println(currentPlayer.getName());
			System.out.print("Enter your choice between 0 and 8:");
			String inputString = s1.nextLine();
			int x = Integer.parseInt(inputString);
			if((x < 0 || x > 8) || !board[x].equals(SPACE)) {
				System.out.println("Not a valid choice!");
			}
			else {
				System.out.println("A valid choice!");
				board[x] = sign;
				if(currentPlayer.equals(player2)) {
					currentPlayer = player1;
				}
				else {
					currentPlayer = player2;
				}
				validMove=true;
			}
		}
	}
public void whoWins(String sign) {
	if( sign.equals(player1.getSign()) ) {
		System.out.println( player1.getName() + " wins!");
	}
	else {
		System.out.println( player2.getName() + " wins!");
	}
}
	public static boolean checkGame( TicTacToe a) {
		String[]board = a.board;
		if(board[0].equals(board[1])&& board[1].equals(board[2]) && !(board[0].equals(SPACE))) {
			a.whoWins(board[1]);
			return false;
		}
		else if(board[3].equals(board[4]) && board[4].equals(board[5]) && !(board[3].equals(SPACE))) {
			a.whoWins(board[3]);
			return false;
		}
		else if(board[6].equals(board[7]) && board[7].equals(board[8]) && !(board[6].equals(SPACE))) {
			a.whoWins(board[6]);
			return false;
		}
		else if(board[0].equals(board[3]) && board[3].equals(board[6]) && !(board[0].equals(SPACE))) {
			a.whoWins(board[0]);
			return false;
		}
		else if(board[1].equals(board[4]) && board[4].equals(board[7]) && !(board[1].equals(SPACE))) {
			a.whoWins(board[1]);
			return false;
		}
		else if(board[2].equals(board[5]) && board[5].equals(board[8]) && !(board[2].equals(SPACE))) {
			a.whoWins(board[2]);
			return false;
		}
		else if(board[2].equals(board[4]) && board[4].equals(board[6]) && !(board[2].equals(SPACE))) {
			a.whoWins(board[2]);
			return false;
		}
		else if(board[0].equals(board[4]) && board[4].equals(board[8]) && !(board[0].equals(SPACE))) {
			a.whoWins(board[0]);
			return false;
		}
		for(String b : board) {
			if(b.equals(SPACE)) {
				return true;
			}
			
		}
		return false;
	}
	public static void main(String[]args) {
		Scanner s1 = new Scanner(System.in);
		String name, sign;
		Player[] players = new Player[2];
		for( int i =1; i < 3; i++) {
			System.out.print("Enter player " + i + ", your name:");
			name = s1.nextLine();
			System.out.print("Enter your sign:");
			sign = s1.nextLine();
			players[i - 1] = new Player(name , sign, i);
		}
		TicTacToe b1 = new TicTacToe(players[0] , players[1]);
		while (checkGame(b1)) {
			b1.printBoard();
			b1.makeMove(s1);
			
		}
		b1.printBoard();
		s1.close();
	}
}
