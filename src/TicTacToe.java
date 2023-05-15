public class TicTacToe {

	private final char[][] TTTGrid;
	private char currentPlayer;
	private String X;
	private String Y;

	/**
	 * Initializes the empty grid
	 */
	public TicTacToe() {
		TTTGrid = new char[3][3];
		currentPlayer = 'X';
		initializeEmptyGrid();
	}

	/**
	 * @return TTTgrid - the tictactoe grid
	 */

	public char[][] getGrid() {
		return TTTGrid;
	}

	/**
	 * Return who the current player is
	 * 
	 * @return X - current player
	 */
	public String getCurrentPlayerNum() {
		if (currentPlayer == 'X') {
			X = "One";
		}
		if (currentPlayer == 'O') {
			X = "Two";
		}
		return X;

	}

	/**
	 * This method sets/resets the grid back to its empty values
	 */

	public void initializeEmptyGrid() {

		for (int row = 0; row < TTTGrid.length; row++) {
			for (int column = 0; column < TTTGrid[row].length; column++) {
				TTTGrid[row][column] = ' ';
			}
		}
	}

	/**
	 * This method creates the grid
	 */

	public void createGrid() {
		System.out.println("------------");

		for (int row = 0; row < TTTGrid.length; row++) {
			System.out.print("| ");
			for (int column = 0; column < TTTGrid[row].length; column++) {
				System.out.print(TTTGrid[row][column] + " | ");
			}
			System.out.println();
			System.out.println("------------");
		}
	}

	/**
	 * This method returns true if there is a win, and false if there is no win This
	 * method calls other check win functions to check entire grid
	 */

	public boolean checkWin() {
		return (checkColumnsForWin() || checkRowsForWin() || checkDiagonalsForWin());
	}

	/**
	 * This method loops through columns to check if there are any winners
	 * 
	 * @return true or false
	 */

	public boolean checkColumnsForWin() {
		for (int column = 0; column < TTTGrid.length; column++) {
			if (checkIfAllThreeLettersSame(TTTGrid[0][column], TTTGrid[1][column], TTTGrid[2][column])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method loops through rows to check for any winners
	 * 
	 * @return
	 */
	public boolean checkRowsForWin() {
		for (int row = 0; row < TTTGrid.length; row++) {
			if (checkIfAllThreeLettersSame(TTTGrid[row][0], TTTGrid[row][1], TTTGrid[row][2])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks the two diagonals to check for a win.
	 * 
	 * @return
	 */
	public boolean checkDiagonalsForWin() {
		return ((checkIfAllThreeLettersSame(TTTGrid[0][0], TTTGrid[1][1], TTTGrid[2][2]))
				|| (checkIfAllThreeLettersSame(TTTGrid[0][2], TTTGrid[1][1], TTTGrid[2][0])));
	}

	/**
	 * Checks to see if the 3 values are the same or empty indicating a win
	 */
	public boolean checkIfAllThreeLettersSame(char T1, char T2, char T3) {
		return ((T1 != ' ') && (T1 == T2) && (T2 == T3));
	}

	/**
	 * This method checks if the grid is full and returns a boolean
	 * 
	 * @return
	 */
	public boolean isGridFull() {
		boolean isGridFull = true;

		for (int row = 0; row < TTTGrid.length; row++) {
			for (int column = 0; column < TTTGrid[row].length; column++) {
				if (TTTGrid[row][column] == ' ') {
					isGridFull = false;
				}
			}
		}

		return isGridFull;
	}

	/**
	 * This method changes the player marks depending on the current player
	 */

	public void changeP() {
		if (currentPlayer == 'X') {
			currentPlayer = 'O';
		} else {
			currentPlayer = 'X';
		}
	}

	/**
	 * This method allows us to acces the currentp
	 * 
	 * @return
	 */
	public char getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * This method prints the actual grid
	 */
	private void printGrid() {
		for (int row = 0; row < getGrid().length; row++) {
			for (int column = 0; column < getGrid()[0].length; column++) {
				System.out.print(getGrid()[row][column]);
			}
			System.out.println();
		}
	}

	/**
	 * Places a mark at the cell specified by row and col with the mark of the
	 * current player.
	 */

	public boolean markAtCell(int row, int col) {

		if ((row >= 0) && (row < TTTGrid.length)) {
			if ((col >= 0) && (col < TTTGrid.length)) {
				if (TTTGrid[row][col] == ' ') {
					TTTGrid[row][col] = currentPlayer;
					printGrid();
					return true;
				}
				if (TTTGrid[row][col] == TTTGrid[row][col]) {
					System.out.println("This spot is already marked, please mark another spot");
				}
			}
		}
		return false;
	}

}
