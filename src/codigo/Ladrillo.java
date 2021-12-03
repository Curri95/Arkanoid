package codigo;

import java.awt.Color;
import acm.graphics.GRect;

//Clase de los ladrillos.
public class Ladrillo extends GRect {

	//Constructor.
	public Ladrillo(double x, double y, double width, double height, Color c) {
		super(x, y, width, height);
		this.setFillColor(c);
		this.setFilled(true);
	}

}