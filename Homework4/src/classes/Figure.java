package classes;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

/**
 * The Figure is class that contains coordinates of some Figure object
 *
 *
 * @author Yuliia Nechyporuk
 * @version 1.0
 * @since 2017-10-29
 */
public class Figure implements Serializable {

	private static final long serialVersionUID = -8613271923083505875L;
	private int x, y;

	Figure() {

	}

	Figure(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Figures [x=" + getX() + ", y=" + getY() + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		BasicConfigurator.configure();

		List<Figure> f = new ArrayList<Figure>();
		List<Figure> empty = new ArrayList<Figure>();

		Figure f1 = new Figure(4, 5);
		Figure f2 = new Figure(6, 5);
		Figure f3 = new Figure(10, 50);

		f.add(f1);
		f.add(f2);
		f.add(f3);

		SerializationOfObject.writeObject(empty, "result");

		SerializationOfObject.writeObject(f, "result");

		List<Figure> deserializeList = SerializationOfObject.readObject("result.zip");

		if (deserializeList != null) {
			for (Figure fig : deserializeList) {
				System.out.println("Figure coordinates: x => " + fig.getX() + "; y => " + fig.getY());
			}
		}

	}

}
