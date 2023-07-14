package bot;

import java.util.Scanner;

public class Bot {
	public static int[][] floor;
	public static int currentRow;
	public static int currentCol;
	public static boolean penDown;
	public static String direction;
	public static int size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.print("Enter the size
//        size = sc.nextInt();dkfgfefgfdfdgffgfdgdgdf
//        initializeSystem(size);

//        boolean programRunning = true;

		System.out.println("Valid input options:");
		System.out.println("[U|u] Pen up");
		System.out.println("[D|d] Pen down");
		System.out.println("[R|r] Turn right");
		System.out.println("[L|l] Turn left");
		System.out.println("[M s|m s] Move forward s spaces");
		System.out.println("[P|p] Print the N by N array and display the indices");
		System.out.println("[C|c] Print current position of the pen");
		System.out.println("[Q|q] Stop the program");
		System.out.println("[I n|i n] Initialize the system");

		while (true) {
			System.out.print("Enter a instruction: ");
			String instruction = sc.nextLine();

			processInput(instruction);
		}

//        sc.close();
	}

	public static void initializeSystem(int size) {
		floor = new int[size][size];

		currentRow = 0;
		currentCol = 0;
		penDown = false;
		direction = "N";
		System.out.println("System initialized with size " + size);
	}

	public static boolean processInput(String instruction) {

		if (instruction == null) {
			throw new NullPointerException("null command is invalid");
		}

		if (instruction.length() == 0) {
			throw new IllegalArgumentException("Enter valid command");
		}

		if (instruction.trim().length() == 0) {
			throw new IllegalArgumentException("Blank space is invalid command");
		}
		char input = instruction.charAt(0);

		if (input != 'U' && input != 'u' && input != 'D' && input != 'd' && input != 'L' && input != 'l' && input != 'R'
				&& input != 'r' && input != 'P' && input != 'p' && input != 'C' && input != 'c' && input != 'Q'
				&& input != 'q' && input != 'I' && input != 'i' && input != 'M' && input != 'm') {
			throw new IllegalArgumentException("Entered command is invalid");
		}
		// if((input=='M'||input=='m'||input=='I'||input=='i')&&m()) {}

		switch (input) {
		case 'U':
		case 'u':
			penUp();
			break;
		case 'D':
		case 'd':
			penDown();
			break;
		case 'R':
		case 'r':
			turnRight();
			break;
		case 'L':
		case 'l':
			turnLeft();
			break;
		case 'P':
		case 'p':
			printMatrix();
			break;
		case 'C':
		case 'c':
			printCurrentStatus();
			break;
		case 'Q':
		case 'q':
			return false;
		case 'I':
		case 'i':

			try {
				size = Integer.parseInt(instruction.substring(1).trim());
				initializeSystem(size);
				if (size <= 0) {
					throw new IllegalArgumentException("Invalid steps!! Provide integer value for steps.");
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a integer number.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 'M':
		case 'm':
			try {
				// System.out.println(instruction.substring(1).trim());
				// System.out.println("zzzzzzzz");
				int spaces = Integer.parseInt(instruction.substring(1).trim());
				if (spaces <= 0) {
					throw new IllegalArgumentException("Invalid steps! Please enter positive value");
				}
				moveForward(spaces);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a integer number.");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			// if (instruction.matches("M\\d+")) {
			// int spaces = Integer.parseInt(instruction.substring(1));
			// moveForward(spaces);
			// } else {
			System.out.println("Invalid instruction!");
			// }
			break;
		}
		return true;
	}

	public static void penUp() {
		penDown = false;
		System.out.println("Pen is up.");
	}

	public static void penDown() {
		penDown = true;
		System.out.println("Pen is down.");
	}

	public static void turnRight() {
		switch (direction) {
		case "N":
			direction = "E";
			break;
		case "E":
			direction = "S";
			break;
		case "S":
			direction = "W";
			break;
		case "W":
			direction = "N";
			break;
		}
		System.out.println("Turned right. Direction: " + direction);
	}

	public static void turnLeft() {
		switch (direction) {
		case "N":
			direction = "W";
			break;
		case "W":
			direction = "S";
			break;
		case "S":
			direction = "E";
			break;
		case "E":
			direction = "N";
			break;
		}
		System.out.println("Turned left. Direction: " + direction);
	}

	public static void moveForward(int spaces) {
		int newRow = currentRow;
		int newCol = currentCol;
		switch (direction) {
		case "S":
			newRow -= spaces;
			break;
		case "E":
			newCol += spaces;
			break;
		case "N":
			newRow += spaces;
			break;
		case "W":
			newCol -= spaces;
			break;
		}

		if (newRow < 0 || newRow >= floor.length || newCol < 0 || newCol >= floor.length) {
			System.out.println("Invalid move! Out of bounds.");
		} else {
			if (penDown) {
				drawPath(currentRow, currentCol, newRow, newCol);
			}
			currentRow = newRow;
			currentCol = newCol;
			System.out.println(
					"Moved forward " + spaces + " spaces. New position: [" + currentRow + ", " + currentCol + "]");
		}
	}

	public static void drawPath(int row1, int col1, int row2, int col2) {
		int minRow = Math.min(row1, row2);
		int maxRow = Math.max(row1, row2);
		int minCol = Math.min(col1, col2);
		int maxCol = Math.max(col1, col2);

		for (int i = minRow; i <= maxRow; i++) {
			for (int j = minCol; j <= maxCol; j++) {
				floor[i][j] = 1;
			}
		}
	}

	public static void printMatrix() {
		System.out.println("Floor:");
		for (int i = size - 1; i >= 0; i--) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				if (floor[i][j] == 0)
					System.out.print("  ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.print(" ");
		for (int i = 0; i < size; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	public static void printCurrentStatus() {
		String penStatus = penDown ? "down" : "up";
		System.out.println("Current position: [" + currentRow + ", " + currentCol + "]");
		System.out.println("Pen status: " + penStatus);
		System.out.println("Direction: " + direction);
	}
}
