package TicTacToeGameV2;

public class TicTacToeController {

	final private TicTacToeModel model;
	final private TicTacToeView view;

	protected TicTacToeController(TicTacToeModel model, TicTacToeView view) {
		this.model = model;
		this.view = view;

	}

}
