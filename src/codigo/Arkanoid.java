//Autor: Alejandro Rodríguez Pérez
package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram{
	//Declaramos unos valores estáticos para los ladrilos y las dimensiones de los ladrillos.
	static final int ANCHO_PANTALLA = 520;
	static final int ANCHO_LADRILLO = 34;
	static final int ALTO_LADRILLO = 12;

	//Declaramos los elementos a los que luego llamaremos, como la bola, el cursor, etc.
	CustomFont fuente= new CustomFont();
	Bola bola1= new Bola(10,10, Color.RED);
	Cursor miCursor= new Cursor(0,390,60,10, this);
	GImage Intro = new GImage("Intro/introstar.gif");
	GImage fondo = new GImage("imagenes/fondobatalla.png");
	GImage GameOver1 = new GImage("imagenes/gameover1.png");
	GImage GameOver2 = new GImage("imagenes/gameover2.png");
	GImage GameOver3 = new GImage("imagenes/gameoverfondo.png");
	GImage Victoria1 = new GImage("imagenes/victoria1.png");
	GImage Victoria2 = new GImage("imagenes/victoria2.png");
	GImage Victoria3 = new GImage("imagenes/victoria3.png");
	GImage fondoMarcador = new GImage("imagenes/fondomarcador.png", 500, 0);
	Marcador miMarcador = new Marcador(20,40);


	public void init(){
		//Añadimos los elementos del juego.
		add(Intro);
		waitForClick();
		remove(Intro);
		add(fondo);
		add(fondoMarcador);
		addMouseListeners();
		add(bola1, 250, 375);
		add(miCursor);
		add(miCursor.fondoCursor, 0, 400);
		setSize(ANCHO_PANTALLA + 300, 500);
	}

	public void run(){
		//Cuando se inicia el pograma, esperamos a que el usuario haga click para crear la piramide y otra vez para empezar a  mover la bola.
		waitForClick();
		creaPiramide();
		miMarcador.addMarcador(this);
		waitForClick();
		while(true){
			bola1.muevete(this);
			pause(5);
			//Si perdemos todas las vidas, se quita todo en pantalla y se añade 3 imagenes de Game Over.
			if(acabaJuego()){
				removeAll();
				setSize(ANCHO_PANTALLA + 300, 500);
				add(GameOver1);
				pause(1200);
				add(GameOver2);
				pause(1200);
				add(GameOver3);
				waitForClick();
				removeAll();
				add(fondo);
				add(fondoMarcador);
				addMouseListeners();
				add(bola1, 250, 375);
				add(miCursor);
				add(miCursor.fondoCursor, 0, 400);
				setSize(ANCHO_PANTALLA + 300, 500);
				waitForClick();
				creaPiramide();
				miMarcador.nuevaPuntuacion(0);
				miMarcador.nuevasVidas(3);
				miMarcador.addMarcador(this);
				waitForClick();
			}
			//Si eliminamos todos los ladrillos, añadimos una pantalla de victoria
			if(ganaJuego()){
				removeAll();
				setSize(ANCHO_PANTALLA + 300, 550);
				add(Victoria1);
				pause(1200);
				add(Victoria2);
				pause(1200);
				add(Victoria3);
				waitForClick();
				removeAll();
				add(fondo);
				add(fondoMarcador);
				addMouseListeners();
				add(bola1, 250, 375);
				add(miCursor);
				add(miCursor.fondoCursor, 0, 400);
				setSize(ANCHO_PANTALLA + 300, 500);
				waitForClick();
				creaPiramide();
				miMarcador.nuevaPuntuacion(0);
				miMarcador.nuevasVidas(3);
				miMarcador.addMarcador(this);
				waitForClick();
			}
		}
	}

	//Este es el método del movimiento del cursor.
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}

	//Este es el método de cómo se crea una piramide.
	public void creaPiramide(){

		int numeroLadrillos = 12;
		int desplazamiento_inicial_X = 50;
		int desplazamiento_inicial_Y = 50;

		for (int j= 0; j < numeroLadrillos; j++){
			for(int i=j; i<numeroLadrillos; i++){
				Ladrillo2 miLadrillo = new Ladrillo2("imagenes/tie.png");
				pause(8);
				add(miLadrillo,ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X ,ALTO_LADRILLO*j + desplazamiento_inicial_Y ); 
			}
		}
	}
	//Este es el método que detecta si la puntuacion es igual al número de ladrillos que se han creao, y si es así, declara el juego ganado.
	public boolean ganaJuego(){
		if(miMarcador.dimePuntuacion()==78){
			return true;
		}
		else{
			return false;
		}
	}
	//Método que detecta si la bola ha passado por debajo del cursor y quita una vida, dando un Game Over si las videas llegan a 0.
	public boolean acabaJuego(){
		if(bola1.getY() > miCursor.getY()+10){
			if(miMarcador.dimeVidas()==0){
				return true;
			}else{
				//Cuando detecta que la bola pasa por debajo del cursor, la quita y espera a que el usuario clickee antes de ponerla en movimiento.
				remove(bola1);
				pause(4);
				add(bola1,250,375);
				waitForClick();
				miMarcador.pierdeVidas(1);
			}
		}
		//Si detecta que no hay más vidas, cambia el boolean a true, lo cual lanza el Game Over.
		if(bola1.getY() > miCursor.getY()+10 && miMarcador.dimeVidas()==0){
			return true;
		}
		return false;
	}

}