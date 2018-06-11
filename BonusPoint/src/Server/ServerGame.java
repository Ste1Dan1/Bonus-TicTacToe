package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerGame {

	
	private char[][] gameBoard;

	private char pX = 'X';
	private char pO = 'O';
	
	private boolean busyX = false;
	private boolean busyO = false;
	public char currentPlayer;

	public ServerSocket listener;

	public ServerGame(int port) {
		try {
			listener = new ServerSocket(port);
			System.out.println("Tic Tac Toe Server is Running");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.newGame(listener);

	}

	public char getMark() {
		if (!busyX) {
			busyX = true;
			return pX;
		} else if (!busyO) {
			busyO = true;
			return pO;
		}

	}

	private void newGame(ServerSocket s) {
		while (true) {
			for (int i = 0; i < gameBoard.length; i++) {
				for (int j = 0; j < gameBoard.length; j++) {
					gameBoard[i][j] = 0;
				}
			}

		}
	}

	public boolean hasWon() {

		for (int i = 0; i < 3; i++) {
			if (gameBoard[i][0] != 0 && gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][0] == gameBoard[i][2]) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (gameBoard[0][i] != 0 && gameBoard[0][i] == gameBoard[1][i] && gameBoard[0][i] == gameBoard[2][i]) {
				return true;
			}
		}

		if (gameBoard[0][0] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][2] == currentPlayer) {
			return true;
		}

		if (gameBoard[0][2] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][0] == currentPlayer) {
			return true;
		}

		return false;
	}

	
	
	// no empty squares
	public boolean boardFilledUp() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				if (gameBoard[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	
	
	// thread when player tries a move
	public synchronized boolean legalMove(int x, int y, char player) {
		if (player == currentPlayer && gameBoard[x][y] == 0) {
			gameBoard[x][y] = currentPlayer;
			
			currentPlayer = currentPlayer.opponent;
			currentPlayer.otherPlayerMoved(x, y);
			return true;
		}
		return false;
	}
