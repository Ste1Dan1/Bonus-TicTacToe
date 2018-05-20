package TicTacToeGameV2;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeView {

	private TicTacToeModel model;
	private Stage stage;

	protected TicTacToeView(Stage stage, TicTacToeModel model) {
		this.stage = stage;
		this.model = model;

		/*
		 * Parent root; try { root =
		 * FXMLLoader.load(getClass().getResource("TicTacToe.fxml")); Scene
		 * scene = new Scene(root); stage.setScene(scene);
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		Label Currentplayer = new Label("Current Player: ");
		Currentplayer.setFont(new Font(30));
		
		GridPane grid = new GridPane();
		grid.setMaxHeight(600);
		grid.setMinHeight(600);
		grid.setMaxWidth(600);
		grid.setMinWidth(600);

		Button[][] buttons = new Button[3][3];

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new Button(i+" "+j);
				buttons[i][j].setMinSize(200, 200);
				buttons[i][j].setFont(new Font(60));
				grid.add(buttons[i][j], i, j);
			}

		}
		
		Label winXLbl = new Label("Wins Player X: ");
		Label winOLbl = new Label("Wins Player O: ");
		Label drawLbl = new Label("Draws: ");
		winXLbl.setFont(new Font(20));
		winOLbl.setFont(new Font(20));
		drawLbl.setFont(new Font(20));
		
		VBox stats = new VBox();
		stats.setAlignment(Pos.CENTER);
		stats.getChildren().addAll(winXLbl, winOLbl, drawLbl);
		
		BorderPane root = new BorderPane();
		BorderPane.setAlignment(Currentplayer, Pos.CENTER);
		root.setCenter(grid);
		root.setTop(Currentplayer);
		root.setBottom(stats);

		
		
		Scene scene = new Scene(root);

		stage.setTitle("Tic Tac Toe");
		stage.centerOnScreen();
		stage.setMinHeight(700);
		stage.setMinWidth(700);
		stage.setScene(scene);

	}

	public void start() {
		stage.show();
	}

	/**
	 * Stopping the view - just make it invisible
	 */
	public void stop() {
		stage.hide();
	}

	/**
	 * Getter for the stage, so that the controller can access window events
	 */
	public Stage getStage() {
		return stage;

	}

}