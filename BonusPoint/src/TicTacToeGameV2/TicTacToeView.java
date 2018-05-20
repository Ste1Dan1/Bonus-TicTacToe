package TicTacToeGameV2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeView {

	protected TicTacToeModel model;
	protected Stage stage;
	
	
	//GUI Elemente
	protected Label Currentplayer;
	protected Label createportlbl;
	protected Label createlbl;
	protected Label joinlbl;
	protected Label iplbl;
	protected Label joinportlbl;
	
	protected TextField createporttf;
	protected TextField iptf;
	protected TextField joinporttf;
	
	
	protected Button[][] buttons = new Button[3][3];
	protected Button createbtn;
	protected Button joinbtn;
	protected Button againbtn;
	
	public GridPane grid;

	protected TicTacToeView(Stage stage, TicTacToeModel model) {
		this.stage = stage;
		this.model = model;

		Currentplayer = new Label("Current Player: ");
		Currentplayer.setFont(new Font(30));
		
		createportlbl = new Label("Port: ");
		createporttf = new TextField();

		createlbl = new Label("Create a game: ");
		createbtn = new Button("Create");
		
		HBox createbox = new HBox();
		createbox.getChildren().addAll(createlbl, createportlbl, createporttf, createbtn);

		joinlbl = new Label("Join a game: ");
		joinbtn = new Button("Join");
		iplbl = new Label("IP-Adress: ");
		iptf = new TextField();
		joinportlbl = new Label("Port: ");
		joinporttf = new TextField();
		
		HBox joinbox = new HBox();
		joinbox.getChildren().addAll(joinlbl, iplbl, iptf, joinportlbl, joinporttf, joinbtn);

		VBox top = new VBox();

		top.getChildren().addAll(createbox, joinbox, Currentplayer);

		grid = new GridPane();
		grid.setMaxHeight(600);
		grid.setMinHeight(600);
		grid.setMaxWidth(600);
		grid.setMinWidth(600);

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new Button();
				buttons[i][j].setMinSize(200, 200);
				buttons[i][j].setFont(new Font(60));
				grid.add(buttons[i][j], i, j);

			}

		}

		Label winXLbl = new Label("Wins Player X: ");
		Label winOLbl = new Label("Wins Player O: ");
		Label drawLbl = new Label("Draws: ");
		againbtn = new Button("Play Again");
		winXLbl.setFont(new Font(20));
		winOLbl.setFont(new Font(20));
		drawLbl.setFont(new Font(20));

		VBox buttom = new VBox();
		buttom.setAlignment(Pos.CENTER);
		buttom.getChildren().addAll(winXLbl, winOLbl, drawLbl, againbtn);

		BorderPane root = new BorderPane();
		root.setCenter(grid);
		root.setTop(top);
		root.setBottom(buttom);

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