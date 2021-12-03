//Autor: Alejandro Rodríguez Pérez
package codigo;

import java.awt.Color;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval {

	int dx = 1; //Velocidad en eje X.
	int dy = 1;  //Velocidad en el eje Y.
	

	public Bola(double width, double height) {
		super(width, height);	
	}

	public Bola(double width, double height, Color c) {
		//Constructor.
		super(width, height);
		this.setFillColor(c);
		this.setFilled(true);
	}
	//Método para movimiento de la bola.
	public void muevete(Arkanoid ark){
		
		//Rebote con el suelo y con el techo.
		if (getY() > ark.getHeight()  || getY() < 34){
			dy = dy * -1;
		}
		
		//Rebote con pared derecha y  rebote con pared izquierda
		if (getX()+getWidth() > ark.ANCHO_PANTALLA - 50 || getX() < 35){
			dx = dx * -1;
		}



		if (chequeaColision(getX(),	getY(), ark) ){
			if (chequeaColision(getX() + getWidth(), getY(), ark) ){
				if (chequeaColision(getX(),	getY()+getHeight(), ark) ){
					if (chequeaColision(getX()+getWidth(), getY()+getHeight(), ark) ){
					}
				}
			}
		}
		//La bola se mueve en la direccion correcta.
		this.move(dx,dy);
	}

	//Este método detecta las colisiones de la bola.
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;
		Cursor cursor;

		auxiliar = ark.getElementAt(posx, posy);

		if (auxiliar == ark.miCursor){ 
			cursor=(Cursor)auxiliar;
			if(posx>=cursor.getX() + cursor.getWidth()/2 && posx<=cursor.getX() + cursor.getWidth()){
				if(dx<0){
					dx=dx*-1;
				}
			}
			if(posx>=cursor.getX()&& posx<=cursor.getX() + cursor.getWidth()/2){
				if(dx>0){
					dx=dx*-1;
				}
			}
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){ 

		}else if (auxiliar instanceof Ladrillo2){ 
			//Aseguramos que ha chocado contra un ladrillo y no la pared o el techo.
			if (auxiliar.getX() + getWidth() >= posx || auxiliar.getX() <= posx){
				dx = dx * -1;
			}
			if (auxiliar.getY() + getHeight() >= posy || auxiliar.getY() <= posy){
				dy = dy * -1;
			}
			//Cuando la bola toca el ladrillo, incrementamos la puntuación en 1 y borramos ese ladrillo.
			ark.miMarcador.incrementaMarcador(1); 
			ark.remove(auxiliar);
			noHaChocado = false;
		}

		return noHaChocado;
	}


}