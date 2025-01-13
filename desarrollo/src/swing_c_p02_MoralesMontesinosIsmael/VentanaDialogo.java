/**
 * VentanaDialogo.java
 * 14 nov 20249:37:26
 * @author Ismael Morales Montesinos
 */
package swing_c_p02_MoralesMontesinosIsmael;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

// TODO: Auto-generated Javadoc
/**
 * La Clase VentanaDialogo.
 */
public class VentanaDialogo extends JDialog {
	
	/** El p 1. */
	private Panel1 p1;
	
	/** El p 2. */
	private Panel2 p2;
	
	/** El p 3. */
	private Panel3 p3;
	
	/** El p 4. */
	private Panel4 p4;
    
    /**
     * Instacia una nueva ventana dialogo.
     *
     * @param parent the parent
     */
    public VentanaDialogo(VentanaPrincipal parent) {
        super(parent, "Alta Reservas", true);
        
        this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		//Tamaño ventana ---------------------------------------------------------------------------
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		
		int altoPantalla=tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		
		this.setSize(anchoPantalla,altoPantalla);
		this.setLocation(0,0);
		//Tamaño ventana ---------------------------------------------------------------------------
		//Icono de aplicacion -------------------------------------------------------------------
				ImageIcon miIcono = new ImageIcon(getClass().getResource("recursos/mc.png"));
				this.setIconImage(miIcono.getImage());
		//Icono de aplicacion -------------------------------------------------------------------

		//Paneles ----------------------------------------------------------------
		p1 = new Panel1();
		p2 = new Panel2();
		p3 = new Panel3();
		p4 = new Panel4();
		
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.WEST);
		this.add(p3, BorderLayout.EAST);
		this.add(p4,BorderLayout.CENTER);
		//Paneles ----------------------------------------------------------------
        this.setVisible(true);
    }
}