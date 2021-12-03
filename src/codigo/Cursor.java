//Autor: Alejandro Rodr�guez P�rez
package codigo;

import acm.graphics.GImage;
import acm.graphics.GRect;

public class Cursor extends GRect{
	//Declaramos una GImage que usaremos para sustituir el GRect del cursor por una imagen.
	GImage fondoCursor ;

	//Constructor
	public Cursor(double x, double y, double width, double height, Arkanoid ark) {
		super(x, y, width, height);
		//Aqu� va la ruta de la imagen que usaremos para el cursor.
		fondoCursor = new GImage("Imagenes/cursor.png");
		fondoCursor.setBounds(x, y - 10, width, height);
	}

	public void muevete(int anchoPantalla, int posX){
		//M�todo con los limites del movimiento del cursor y con la posici�n de la imagen.
		if (posX + getWidth() +30 < anchoPantalla){
			setLocation(posX + 30, getY());
			fondoCursor.setLocation(posX + 30, getY());
		}
	}

}