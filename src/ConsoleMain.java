import java.util.Scanner;

public class ConsoleMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TicTacToe match = new TicTacToe();
		match.initializeEmptyGrid();
		System.out.println("Lets Play!");
		do {
			System.out.println("Current grid format:");
			match.createGrid();
			int row;
			int column;
			do {
				System.out.println("Player " + match.getCurrentPlayerNum() + ", Insert row # and coulmn #");
				row = scanner.nextInt() - 1;
				column = scanner.nextInt() - 1;
			} while (!match.markAtCell(row, column));
			match.changeP();
		} while (!match.checkWin() && !match.isGridFull());
		if (match.isGridFull() && !match.checkWin()) {
			System.out.println("Tie!");
		} else {
			System.out.println("Final grid:");
			match.createGrid();
			match.changeP();
			System.out.println("Player" + " " + match.getCurrentPlayerNum().toUpperCase() + " Wins!");
		}

	}
}
