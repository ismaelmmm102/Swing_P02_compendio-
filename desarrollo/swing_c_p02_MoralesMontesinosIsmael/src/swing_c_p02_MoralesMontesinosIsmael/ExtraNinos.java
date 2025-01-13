/**
 * ExtraNinos.java
 * 16 nov 202419:23:03
 * @author Ismael Morales Montesinos
 */
package swing_c_p02_MoralesMontesinosIsmael;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

// TODO: Auto-generated Javadoc
/**
 * La Clase ExtraNinos.
 */
public class ExtraNinos extends JPanel implements FocusListener{
	
	/** El label edad. */
	private JLabel labelEdad;
	
	/** El spinner edad. */
	static JSpinner spinnerEdad;
	
	/** El textField extras. */
	static JTextField textFExtras;
	
	/**
	 * Instancia una nueva extra ninos.
	 */
	public ExtraNinos() {
		this.setLayout(new GridBagLayout());
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.fill = GridBagConstraints.HORIZONTAL;
		this.setBackground(Color.decode("#b19ee9"));
		//Titulo ------------------------------------
		labelEdad = new JLabel("Edad:");
		
		labelEdad.setHorizontalAlignment(JLabel.CENTER);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
	    this.add(labelEdad, constraints);
		//Titulo ------------------------------------
	  //Edad ------------------------------------
	    spinnerEdad = new JSpinner(new SpinnerNumberModel(1, 0, 14, 1));
		constraints.gridx = 0;
		constraints.gridy = 1;
	    this.add(spinnerEdad, constraints);
	  //Edad ------------------------------------
	    //Extras ------------------------------------
	    textFExtras = new JTextField(10);
	    textFExtras.setHorizontalAlignment(JTextField.CENTER);
		constraints.gridx = 0;
		constraints.gridy = 2;
	    this.add(textFExtras, constraints);
	    textFExtras.addFocusListener(this);
	    //Extras ------------------------------------
	}
	
	/**
	 * Gana Focus.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		int edad = (int) spinnerEdad.getValue();
		if (edad >= 0 && edad <= 3) {
			textFExtras.setText("Cuna");
		} else if (edad >= 4 && edad <= 10) {
			textFExtras.setText("Cama supletoria pequeña");
		} else if (edad >= 11 && edad <= 14) {
			textFExtras.setText("Cama supletoria normal");
		}
	}

	/**
	 * Focus perdido.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}