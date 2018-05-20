package TicTacToeGameV2;

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

		
		for (int i = 0; i < view.buttons.length; i++) {
			for (int j = 0; j < view.buttons.length; j++) {
				view.buttons[i][j].setOnAction(this);
			}
		}

		
		view.againbtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
					model.resetGameBoard();
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
	@Override
	public void handle(ActionEvent event) {
		Button btn = (Button) event.getSource();
		int gridx = view.grid.getColumnIndex(btn);
		int gridy = view.grid.getRowIndex(btn);
		model.setTurnValue(gridy, gridx);
		btn.setText(String.valueOf(model.getTurnValue(gridy, gridx)));

	}

}
