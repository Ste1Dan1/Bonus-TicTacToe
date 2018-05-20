package TicTacToeGameV2;

import javafx.application.Application;
import javafx.stage.Stage;

public class TicTacToeGame extends Application {

	private TicTacToeView view;
	private TicTacToeController controller;
	private TicTacToeModel model;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		model = new TicTacToeModel();
		view = new TicTacToeView(primaryStage, model);
		controller = new TicTacToeController(model, view);
		view.start();
		
	}

	@Override
	public void stop() {
		if (view != null)
			view.stop();

	}

}
