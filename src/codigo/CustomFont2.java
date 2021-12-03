package codigo;

import java.awt.Font;
import java.io.InputStream;

//Lo mismo que CustomFont1
public class CustomFont2{

	private Font font = null;

	//Esta clase CustomFont es para los números
	public CustomFont2() {

		String fontName = "mifuente2.ttf" ;
		try {

			//Intentamos cargar la fuente
			InputStream is =  getClass().getResourceAsStream("/Fuente/Starjedi.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} 
		catch (Exception ex) {
			//Si no se puede cargar la fuente personalizada, se carga la fuente por defecto, CALIBRI.
			System.err.println(fontName + "  No se ha podido cargar.");
			font = new Font("Calibri", Font.BOLD, 50);            
		}
	}

	public Font MyFont( int style, float size){
		Font tfont = font.deriveFont(style, size);
		return tfont;
	}

}