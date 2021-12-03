//Autor: Alejandro Rodríguez Pérez
package codigo;

import java.awt.Color;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect {
	//Creamos los GLabel correspondientes al texto "puntuación", vidas, fuente personalizada y al marcador que incrementa cuando se rompe un ladrillo.
	GLabel marcadortexto = new GLabel("0");
	GLabel marcador = new GLabel("PUNTUACION");
	GLabel vidasmarcador = new GLabel("VIDAS");
	GLabel vidastexto = new GLabel("3");
	int puntuacion = 0;
	int vida= 3;
	CustomFont fuente = new CustomFont();
	CustomFont2 fuente2 = new CustomFont2();


	public Marcador(double width, double height) {
		//Este metodo define los colores y la fuente del texto del marcador.
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		marcador.setFont(fuente.MyFont(1, 25f));
		marcador.setColor(Color.YELLOW);
		marcadortexto.setFont(fuente2.MyFont(1, 25f));
		marcadortexto.setColor(Color.YELLOW);
		vidasmarcador.setFont(fuente.MyFont(1, 25f));
		vidasmarcador.setColor(Color.YELLOW);
		vidastexto.setFont(fuente2.MyFont(1, 25f));
		vidastexto.setColor(Color.YELLOW);
	}

	//Creamos el método que incrementa la puntuación
	public void incrementaMarcador(int puntos){
		puntuacion = puntuacion + puntos; 
		marcadortexto.setLabel(" " + puntuacion);
	}

	//Creamos el método que reduce en 1 el número de vidas del marcador cuando detecta que han bajado.
	public void pierdeVidas(int vidas){
		vida = vida - vidas;
		vidastexto.setLabel(" " + vida);
	}

	//Este método nos dice cuantas vidas nos quedan.
	public int dimeVidas(){
		return vida;
	}
	
	//Este método nos dice cuanta puntuacion tenemos.
	public int dimePuntuacion(){
		return puntuacion;
	}
	
	public int nuevasVidas(int nuevavidas){
		return vida = nuevavidas;
	}
	public int nuevaPuntuacion(int nuevapuntuacion){
		return puntuacion = nuevapuntuacion;
	}

	//Creamos el método para añadir la puntuacion y el marcador a la pantalla, con su posición X e Y correspondiente.
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(marcador,arkanoid.getWidth() - 250, 250 );
		arkanoid.add(marcadortexto, arkanoid.getWidth() - 250, 275);
		arkanoid.add(vidasmarcador, arkanoid.getWidth() - 250, 350);
		arkanoid.add(vidastexto, arkanoid.getWidth() - 250, 375);
	}

}