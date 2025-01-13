/**
 * Panel3.java
 * 16 nov 202419:23:01
 * @author Ismael Morales Montesinos
 */
package swing_c_p02_MoralesMontesinosIsmael;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;




// TODO: Auto-generated Javadoc
/**
 * La Clase Panel3.
 */
public class Panel3 extends JPanel implements ActionListener, FocusListener{
	
	/** Los JLABEL. */
	private JLabel labelTitulo, labelTipo, labelImporte, labelNumero, labelNinos,labelImporteTotal,pintura1, pintura2, pintura3;
	
	/** El combo habitacion. */
	static JComboBox comboHabitacion;
	
	/** El spinner habitaciones. */
	static JSpinner spinnerHabitaciones;
	
	/** El cb ninos. */
	static JCheckBox cbNinos;
	
	/** El extra ninos. */
	static ExtraNinos extraNinos;
	
	/** El text importe. */
	static JTextField textImporte;
	
	/** El image icon 3. */
	private ImageIcon imageIcon1,imageIcon2,imageIcon3;
	
	/** El image 3 escalada. */
	private Image image1, image1Escalada,image2, image2Escalada,image3, image3Escalada;
    


	/**
	 * Instancia un nuevo panel 3.
	 */
	public Panel3() {
		this.setLayout(new GridBagLayout());
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.fill = GridBagConstraints.HORIZONTAL;
		this.setBackground(Color.decode("#b19ee9"));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
		// Titulo --------------------------------------------------
		labelTitulo = new JLabel("Datos De La Habitación");
		labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
		labelTitulo.setHorizontalAlignment(JLabel.CENTER);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
	    this.add(labelTitulo, constraints);
		// Titulo --------------------------------------------------
	    //Importe ---------------------------------------------
	    labelImporte = new JLabel("<html><body>Precio por habitación/día: <br>\r\n"
	    		+ "				Simple -------------------------- 50 €<br>\r\n"
	    		+ "				Doble---------------------------- 75 €<br>\r\n"
	    		+ "				Suit------------------------------ 125€<br>\r\n"
	    		+ "				Cuna o cama supletoria----- 20€</body></html>");
	    labelImporte.setHorizontalAlignment(JLabel.CENTER);

	    
		constraints.gridx = 0;
		constraints.gridy = 1;
	    this.add(labelImporte, constraints);

	    
	    
	    //Importe ---------------------------------------------
	    //Tipo ---------------------------------------------
	    labelTipo = new JLabel("Tipo:");
        String[] opciones = { "Simple", "Doble", "Suite" };
        comboHabitacion = new JComboBox<String>(opciones);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
	    this.add(labelTipo, constraints);
	    
	    constraints.gridx = 0;
		constraints.gridy = 3;
	    this.add(comboHabitacion, constraints);
	    //Tipo ---------------------------------------------
	    //Numero Hab ---------------------------------------------
	    labelNumero = new JLabel("Número de Habitaciones:");
	    spinnerHabitaciones = new JSpinner(new SpinnerNumberModel(1, 0, 50, 1));
		
		constraints.gridx = 0;
		constraints.gridy = 4;
	    this.add(labelNumero, constraints);
	    
	    constraints.gridx = 0;
		constraints.gridy = 5;
	    this.add(spinnerHabitaciones, constraints);
	    //Numero Hab ---------------------------------------------
	  //Ninos ---------------------------------------------
	    labelNinos = new JLabel("¿Niños?");
		cbNinos = new JCheckBox();
		cbNinos.addActionListener(this);
		
		constraints.gridx = 0;
		constraints.gridy = 6;
	    this.add(labelNinos, constraints);
	    
	    constraints.gridx = 0;
		constraints.gridy = 7;
	    this.add(cbNinos, constraints);
	  //Ninos ---------------------------------------------
	  //Extras ------------------------------------
	    extraNinos = new ExtraNinos();
	     extraNinos.setVisible(false);
	    constraints.gridx = 0;
		constraints.gridy = 8;
	    this.add(extraNinos, constraints);
	    
	  //Extras ------------------------------------
	    //Importe Total ---------------------------------------
	    labelImporteTotal = new JLabel("Importe Total:");
	    textImporte = new JTextField();
	    textImporte.addFocusListener(this);
	    
	    constraints.gridx = 0;
		constraints.gridy = 9;
	    this.add(labelImporteTotal, constraints);
		constraints.gridx = 0;
		constraints.gridy = 10;
	    this.add(textImporte, constraints);
	    //Importe Total ---------------------------------------
	    //Imagenes --------------------------------------
	    image1 = new ImageIcon(getClass().getResource("recursos/single.jpg")).getImage();
	     image1Escalada = image1.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	     imageIcon1 = new ImageIcon(image1Escalada);
	     pintura1 = new JLabel(imageIcon1);
			constraints.gridx = 0;
			constraints.gridy = 11;
		    this.add(pintura1, constraints);
		    
	     image2 = new ImageIcon(getClass().getResource("recursos/doble.jpg")).getImage();
	     image2Escalada = image2.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	     imageIcon2 = new ImageIcon(image2Escalada);
	     pintura2 = new JLabel(imageIcon2);
			constraints.gridx = 0;
			constraints.gridy = 12;
		    this.add(pintura2, constraints);
		    
	     image3 = new ImageIcon(getClass().getResource("recursos/suite.jpg")).getImage();
	     image3Escalada = image3.getScaledInstance(100,100,Image.SCALE_SMOOTH);
	     imageIcon3 = new ImageIcon(image3Escalada);
	     pintura3 = new JLabel(imageIcon3);
			constraints.gridx = 0;
			constraints.gridy = 13;
		    this.add(pintura3, constraints);
	  //Imagenes --------------------------------------
	}	
	/**
	 * Accion hecha.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (cbNinos.isSelected()) {
			extraNinos.setVisible(true);
		} else {
			extraNinos.setVisible(false);
		}
	}
	
	/**
	 * Focus ganado.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		String tipo = String.valueOf(comboHabitacion.getSelectedItem());
		int habitacion = 0;
		int dia = Integer.parseInt(Panel2.textDias.getText());
		int nHabitaciones = Integer.parseInt(String.valueOf(spinnerHabitaciones.getValue()));
		boolean ninios = cbNinos.isSelected();
		switch (tipo) {
		case "Simple":
			habitacion += 50;
			break;
		case "Doble":
			habitacion += 75;
			break;
		case "Suite":
			habitacion += 125;
			break;
		default:
			break;
		}
		if (ninios) {
			habitacion += 20;
		}
		textImporte.setText(String.valueOf(habitacion*dia*nHabitaciones));

	}
		
	/**
	 * Focus perdido.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {

	}
}
