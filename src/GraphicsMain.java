import processing.core.PApplet;

public class GraphicsMain extends PApplet {

	final int SIZE = 150;
	TicTacToe grid = new TicTacToe();

	public static void main(String[] args) {
		PApplet.main("GraphicsMain");
	}

	@Override
	public void settings() {
		size(450, 450);

	}

	public void drawGrid(char[][] grid) {

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if ((r + c) % 2 == 0) {
					fill(255, 255, 0);
				} else {
					fill(102, 255, 102);
				}

				rect(c * SIZE, r * SIZE, SIZE, SIZE);
				fill(255);

				fill(0);

				if (grid[r][c] == 'X') {
					textSize(50);
					text("X", c * 135 + (100), r * 120 + 110);
				}
				fill(0);
				if (grid[r][c] == 'O') {
					textSize(50);
					text("O", c * 135 + (100), r * 120 + 110);
				}
			}
		}
	}

	@Override
	public void setup() {
		grid.createGrid();
		grid.checkWin();
	}

	@Override
	public void draw() {
		drawGrid(grid.getGrid());
		drawGameStatus();
	}

	@Override
	public void mousePressed() {
		if ((grid.isGridFull()) || (grid.checkWin())) {
			System.out.println("Game over, please start a new game.");
			clear();
			grid = new TicTacToe();
			setup();
			return;
		}

		fill(0);
		textSize(30);
		int r = mouseY / 150;
		int c = mouseX / 150;

		boolean markPlaced = grid.markAtCell(r, c);

		if (getGameStatus() != null) {
			displayGameStatus();
		} else if (markPlaced) {
			grid.changeP();
		}

	}

	private String getGameStatus() {
		String status = null;
		if (grid.checkWin() && grid.getCurrentPlayer() == 'X') {
			status = "Player 1 Wins!";
		} else if (grid.checkWin() && grid.getCurrentPlayer() == 'O') {
			status = "Player 2 Wins!";
		} else if (grid.isGridFull()) {
			status = "Draw";

		}
		return status;
	}

	private void displayGameStatus() {
		System.out.println(getGameStatus());
	}

	private void drawGameStatus() {
		if (getGameStatus() != null) {
			textSize(50);
			text(getGameStatus(), 50, 50);
		}
	}

}
