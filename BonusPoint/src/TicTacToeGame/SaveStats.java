package TicTacToeGame;

import java.io.FileWriter;

public class SaveStats {

	public static void saveGame(String stats) throws Exception {

		String filename = "Statistics.csv";
		FileWriter fw;

		fw = new FileWriter(filename, true);
		fw.write(stats);
		fw.close();

	}

}
