import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Sean Gibbons
 */
public class PathFinder {
	public Grid g;
	public Stack<Point> checkpoints;
	public Point current;
	public ArrayList<Integer> pathTotals;

	public PathFinder(String s) {
		g = new Grid(s);
		current = g.getPoint(0, 0);
	}

	public int checkNext() {
		int result = 0;
		if ((g.getRight(current) == null || g.getRight(current).getValue() < 0)
				&& (g.getBelow(current) == null || g.getBelow(current).getValue() < 0)) {
			return result;
		}

		if (g.getRight(current) == null || g.getRight(current).getValue() < 0) {
			if (g.getBelow(current).getValue() < 1) {
				result = 1;
			}
		}
		if (g.getBelow(current) == null || g.getBelow(current).getValue() < 0) {
			if (g.getRight(current).getValue() < 1) {
				result = 2;
			}
		}

	}
}
