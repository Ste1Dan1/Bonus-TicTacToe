package TicTacToeGameV2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TicTacToeModel {

	private static int PORT = 8901;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public void createClient(String serverAddress) throws Exception {

		// Setup networking
		socket = new Socket(serverAddress, PORT);
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);

	}
}
