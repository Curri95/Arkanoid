package codigo;

import java.awt.Font;
import java.io.InputStream;

//Encontré este metodo en internet para cargar fuentes personalizadas
public class CustomFont{

	private Font font = null;

	//Esta clase CustomFont es para el texto
	public CustomFont() {

		String fontName = "mifuente1.ttf" ;
		try {

			//Intentamos cargar la fuente
			InputStream is =  getClass().getResourceAsStream("/Fuente/Arka_solid.ttf");
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