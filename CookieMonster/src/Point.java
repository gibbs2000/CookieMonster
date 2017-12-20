/**
 * 
 * @author Sean Gibbons
 *
 */
public class Point {
	int row, column, value;

	public Point(int r, int c, int v) {
		row = r;
		column = c;
		value = v;

	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int v) {
		value = v;
	}

	@Override
	public String toString() {
		return "" + getValue();
	}
}
