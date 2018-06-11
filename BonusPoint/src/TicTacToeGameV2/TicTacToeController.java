package TicTacToeGameV2;

import Server.ServerGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class TicTacToeController implements EventHandler<ActionEvent> {

	final private TicTacToeModel model;
	final private TicTacToeView view;

	int buttonposx;
	int buttonposy;

	protected TicTacToeController(TicTacToeModel model, TicTacToeView view) {
		this.model = model;
		this.view = view;
		
		//Create the ServerGame
		view.createbtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				ServerGame server = new ServerGame(Integer.parseInt(view.createporttf.getText()));
			}
		});
		
		//Join a ServerGame
				view.joinbtn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						model.connect(view.iptf.getText(), Integer.parseInt(view.joinporttf.getText()));
					}
				});
		
		//Create ActionEvent for all Game Buttons
		for (int i = 0; i < view.buttons.length; i++) {
			for (int j = 0; j < view.buttons.length; j++) {
				view.buttons[i][j].setOnAction(this);
			}
		}

		view.againbtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			//	model.resetGameBoard();
				for (int i = 0; i < view.buttons.length; i++) {
					for (int j = 0; j < view.buttons.length; j++) {
						view.buttons[i][j].setText(null);
					}
				}

			}
		});

	}

	/*
	 * 
	 * view.button
	 * 
	 * 
	 * 
	 * }
	 */
	
	//Set turn value
	@Override
	public void handle(ActionEvent event) {
		Button btn = (Button) event.getSource();
		int gridx = view.grid.getColumnIndex(btn);
		int gridy = view.grid.getRowIndex(btn);
	//	model.setTurnValue(gridy, gridx);
		//btn.setText(String.valueOf(model.getTurnValue(gridy, gridx)));

	}

}
