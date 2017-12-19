import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Grid {
	public ArrayList<ArrayList<Point>> grid;

	public Grid() {
		readIn("cookies.txt");
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
			return;

		}
		if (!input.hasNext()) {
			input.close();
			throw new IllegalArgumentException("File is empty");
		}

		while (input.hasNextLine()) {
			ArrayList<Point> curRow = new ArrayList<Point>();
			String curLine = input.nextLine();
			String[] values = curLine.split("\\w+");
			for (String v : values) {
				if (!v.isEmpty())
					curRow.add(new Point(rowCounter, colCounter, Integer.parseInt(v)));
			}
			grid.add(curRow);
		}
		input.close();
	}

}
