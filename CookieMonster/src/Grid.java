import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Sean Gibbons
 *
 */
public class Grid {
	public ArrayList<ArrayList<Point>> grid;

	public Grid(String s) {
		readIn(s);
	}

	public void readIn(String s) {
		File fileName = new File(s);
		Scanner input = null;
		int rowCounter = 0;
		int colCounter = 0;

		try {
			input = new Scanner(fileName);
		} catch (FileNotFoundException ex) {
			System.out.print("Unable to Open File");
		}
		if (!input.hasNext()) {
			input.close();
			throw new IllegalArgumentException("File is empty");
		}

		while (input.hasNextLine()) {
			ArrayList<Point> curRow = new ArrayList<Point>();
			colCounter = 0;
			String curLine = input.nextLine();
			String[] values = curLine.split("\\w+");
			for (String v : values) {
				if (!v.isEmpty())
					curRow.add(new Point(rowCounter, colCounter++, Integer.parseInt(v)));
			}
			grid.add(curRow);
			rowCounter++;
		}
		input.close();
	}

	public Point getPoint(int row, int col) {
		return grid.get(row).get(col);
	}

	public Point getRight(Point cur) {
		try {
			return grid.get(cur.getRow()).get(cur.getColumn() + 1);
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
	}

	public Point getBelow(Point cur) {
		try {
			return grid.get(cur.getRow() + 1).get(cur.getColumn());
		} catch (IndexOutOfBoundsException ex) {
			return null;
		}
	}

	public int getRows() {
		return grid.size();
	}

	public int getColumns() {
		return grid.get(0).size();
	}

	@Override
	public String toString() {
		String out = "";
		for (ArrayList<Point> r : grid) {
			for (Point p : r) {
				out += p + " ";
			}
			out += "\n";
		}
		return out;
	}

}
