package TicTacToeGame;

public class TicTacToe {

	private char currentPlayer;
	private char[][] gameBoard;
	private int gamesPlayed;
	private int turns;
	private int winsPlayerX;
	private int winsPlayerO;
	private int draws;
	private int end;

	public TicTacToe() {
		resetGameBoard();
	}

	public void resetGameBoard() {
		gameBoard = new char[3][3];
		currentPlayer = 'X';
		turns = 0;
		end = 0;
		setGamesPlayed();
	}

	private void setGamesPlayed() {
		gamesPlayed++;

	}

	public int getWinsPlayerX() {
		return winsPlayerX;
	}
	
	public void setWinsPlayerX() {
		winsPlayerX++;
	}

	public int getWinsPlayerO() {
		return winsPlayerO;
	}
	
	public void setWinsPlayerO() {
		winsPlayerO++;
	}
	public char getCurrentPlayer() {
		return currentPlayer;
	}

	public void changeCurrentPlayer(char cP) {

		if (cP == 'X') {
			currentPlayer = 'O';
		} else {
			currentPlayer = 'X';
		}
	}

	public void setTurnValue(int row, int col) {
		if (gameBoard[row][col] == 0) {
			gameBoard[row][col] = getCurrentPlayer();
			countTurns();

			if (this.checkIfWon()) {

				if (getCurrentPlayer() == 'X') {
					setWinsPlayerX();
					TicTacToeGame.popup(this.getCurrentPlayer());
					setEnd();
				}
				if (getCurrentPlayer() == 'O') {
					setWinsPlayerO();
					TicTacToeGame.popup(this.getCurrentPlayer());
					setEnd();
				}
			}
			if (!checkIfWon() && turns == 9) {
				TicTacToeGame.popup();
				setDraws();
				setEnd();

			} else {
				changeCurrentPlayer(currentPlayer);
			}

		}
	}

	public char getTurnValue(int row, int col) {
		return gameBoard[row][col];

	}

	public boolean checkIfWon() {

		for (int i = 0; i < 3; i++) {
			if (gameBoard[i][0] == this.currentPlayer && gameBoard[i][1] == currentPlayer
					&& gameBoard[i][2] == currentPlayer) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (gameBoard[0][i] == currentPlayer && gameBoard[1][i] == currentPlayer
					&& gameBoard[2][i] == currentPlayer) {
				return true;
			}
		}

		if (gameBoard[0][0] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][2] == currentPlayer) {
			return true;
		}

		if (gameBoard[0][2] == currentPlayer && gameBoard[1][1] == currentPlayer && gameBoard[2][0] == currentPlayer) {
			return true;
		}

		return false;
	}

	public int countTurns() {
		turns++;
		return turns;

	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws() {
		draws++;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd() {
		end = 1;
	}
	
	public String toString(){
		return "Games played: "+ getGamesPlayed()+"," + "Player X: " + getWinsPlayerX()+","+ "Player O: "+ 
				getWinsPlayerO()+"," + "Draws: " + getDraws()+"\n";
	}
}
