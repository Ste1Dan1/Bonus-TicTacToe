package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player extends Thread {

		char mark;
		Player opponent;
		Socket socket;
		BufferedReader input;
		PrintWriter output;

		// thread handler to initialize stream fields
		public Player(Socket socket, char mark) {
			this.socket = socket;
			this.mark = mark;
			try {
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintWriter(socket.getOutputStream(), true);
				output.println("WELCOME " + mark);
				output.println("MESSAGE Waiting for opponent to connect");
			} catch (IOException e) {
				System.out.println("Player died: " + e);
			}
		}

		// Accepts notification of who the opponent is.
		public void setOpponent(Player opponent) {
			this.opponent = opponent;
		}

		// Handles the otherPlayerMoved message.
		public void otherPlayerMoved(int x, int y) {
			
			
			output.println(hasWon() ? "DEFEAT" : boardFilledUp() ? "TIE" : "");
		}

		public void run() {
			try {
				// The thread is only started after everyone connects.
				output.println("MESSAGE All players connected");

				// Tell the first player that it is his/her turn.
				if (mark == 'X') {
					output.println("MESSAGE Your move");
				}

				// Repeatedly get commands from the client and process them.
				while (true) {
					String command = input.readLine();
					if (command.startsWith("MOVE")) {
						int location = Integer.parseInt(command.substring(5));
						if (legalMove(x, y, this)) {
							output.println("VALID_MOVE");
							output.println(hasWon() ? "VICTORY" : boardFilledUp() ? "TIE" : "");
						} else {
							output.println("MESSAGE ?");
						}
					} else if (command.startsWith("QUIT")) {
						return;
					}
				}
			} catch (IOException e) {
				System.out.println("Player died: " + e);
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	
}
