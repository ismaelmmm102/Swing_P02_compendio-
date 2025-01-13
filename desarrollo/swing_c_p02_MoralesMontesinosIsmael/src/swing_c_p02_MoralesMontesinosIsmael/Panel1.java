/**
 * Panel1.java
 * 16 nov 202418:29:40
 * @author Ismael Morales Montesinos
 */
package swing_c_p02_MoralesMontesinosIsmael;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * La Clase Panel1.
 */
public class Panel1 extends JPanel{
	
	/** La pintura 1. */
	private JLabel labelTitulo, pintura1;
	
	/** La image icon 1. */
	private ImageIcon imageIcon1;
	
	/** La image 1 escalada. */
	private Image image1, image1Escalada;
	
	/**
	 * Instancia un nuevo panel 1.
	 */
	public Panel1() {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		labelTitulo = new JLabel("Hotel Monte Casinos");
		labelTitulo.setFont(new Font("Courier New", Font.BOLD, 70));
		labelTitulo.setForeground(Color.WHITE);
        image1 = new ImageIcon(getClass().getResource("recursos/mc.png")).getImage();
        image1Escalada = image1.getScaledInstance(170,120,Image.SCALE_SMOOTH);
        imageIcon1 = new ImageIcon(image1Escalada);
        pintura1 = new JLabel(imageIcon1);

        
       
		this.add(labelTitulo);
		this.add(pintura1);
}
}
