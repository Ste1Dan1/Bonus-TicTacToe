package TicTacToeGame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeGame extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	public void start(Stage stage) throws Exception {

		TicTacToe game = new TicTacToe();

		Label Currentplayer = new Label("Current Player: " + game.getCurrentPlayer());
		Currentplayer.setFont(new Font(30));

		Button b1 = new Button();
		b1.setMinSize(200, 200);
		b1.setFont(new Font(60));
		Button b2 = new Button();
		b2.setMinSize(200, 200);
		b2.setFont(new Font(60));
		Button b3 = new Button();
		b3.setMinSize(200, 200);
		b3.setFont(new Font(60));
		Button b4 = new Button();
		b4.setMinSize(200, 200);
		b4.setFont(new Font(60));
		Button b5 = new Button();
		b5.setMinSize(200, 200);
		b5.setFont(new Font(60));
		Button b6 = new Button();
		b6.setMinSize(200, 200);
		b6.setFont(new Font(60));
		Button b7 = new Button();
		b7.setMinSize(200, 200);
		b7.setFont(new Font(60));
		Button b8 = new Button();
		b8.setMinSize(200, 200);
		b8.setFont(new Font(60));
		Button b9 = new Button();
		b9.setMinSize(200, 200);
		b9.setFont(new Font(60));

		GridPane grid = new GridPane();
		grid.setMaxHeight(600);
		grid.setMinHeight(600);
		grid.setMaxWidth(600);
		grid.setMinWidth(600);
		grid.add(b1, 0, 0);
		grid.add(b2, 1, 0);
		grid.add(b3, 2, 0);
		grid.add(b4, 0, 1);
		grid.add(b5, 1, 1);
		grid.add(b6, 2, 1);
		grid.add(b7, 0, 2);
		grid.add(b8, 1, 2);
		grid.add(b9, 2, 2);

		Label winX = new Label("Wins Player X: " + game.getWinsPlayerX());
		Label winO = new Label("Wins Player O: " + game.getWinsPlayerO());
		Label draw = new Label("Draws: " + game.getDraws());
		winX.setFont(new Font(20));
		winO.setFont(new Font(20));
		draw.setFont(new Font(20));
		Button breset = new Button("Reset");
		Button bstats = new Button("Save Statistics");

		VBox stats = new VBox();
		stats.setAlignment(Pos.CENTER);
		stats.getChildren().addAll(winX, winO, draw, breset, bstats);

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
		stage.show();

		b1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(0, 0);
					b1.setText(String.valueOf(game.getTurnValue(0, 0)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(0, 1);
					b2.setText(String.valueOf(game.getTurnValue(0, 1)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(0, 2);
					b3.setText(String.valueOf(game.getTurnValue(0, 2)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {

					game.setTurnValue(1, 0);
					b4.setText(String.valueOf(game.getTurnValue(1, 0)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(1, 1);
					b5.setText(String.valueOf(game.getTurnValue(1, 1)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(1, 2);
					b6.setText(String.valueOf(game.getTurnValue(1, 2)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b7.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(2, 0);
					b7.setText(String.valueOf(game.getTurnValue(2, 0)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b8.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(2, 1);
					b8.setText(String.valueOf(game.getTurnValue(2, 1)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		b9.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (game.getEnd() == 1) {

				} else {
					game.setTurnValue(2, 2);
					b9.setText(String.valueOf(game.getTurnValue(2, 2)));
					Currentplayer.setText("Current Player: " + game.getCurrentPlayer());
					winX.setText("Wins Player X: " + game.getWinsPlayerX());
					winO.setText("Wins Player O: " + game.getWinsPlayerO());
					draw.setText("Draws: " + game.getDraws());
				}
			}
		});

		breset.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				b1.setText("");
				b2.setText("");
				b3.setText("");
				b4.setText("");
				b5.setText("");
				b6.setText("");
				b7.setText("");
				b8.setText("");
				b9.setText("");
				game.resetGameBoard();
				Currentplayer.setText("Current Player: " + game.getCurrentPlayer());

				winX.setText("Wins Player X: " + game.getWinsPlayerX());
				winO.setText("Wins Player O: " + game.getWinsPlayerO());
				draw.setText("Draws: " + game.getDraws());
			}
		});
		bstats.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				try {

					SaveStats.saveGame(game.toString());
					TicTacToeGame.StatsSuccess();

				} catch (Exception e1) {
					TicTacToeGame.StatsError();
				}

			}
		});

	}

	public static void popup(char player) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Congratulation");
		alert.setHeaderText("Player " + player + " wins!");

		alert.show();
	}

	public static void popup() {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Oh Boy...");
		alert.setHeaderText("It's a draw");

		alert.show();

	}

	public static void StatsError() {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Statistics file was not created!");

		alert.show();

	}
	public static void StatsSuccess() {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Success");
		alert.setHeaderText("Statistics file created!");

		alert.show();

	}
}
