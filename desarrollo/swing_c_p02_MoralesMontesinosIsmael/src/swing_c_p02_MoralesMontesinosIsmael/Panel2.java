/**
 * Panel2.java
 * 16 nov 202419:23:01
 * @author Ismael Morales Montesinos
 */
package swing_c_p02_MoralesMontesinosIsmael;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * La Clase Panel2.
 */
public class Panel2 extends JPanel implements FocusListener{
	
	/** El label dias. */
	private JLabel labelTitulo, labelNombre, labelApellidos, labelDNI, labelTelefono, labelEntrada, labelSalida, labelDias;
	
	/** El text nombre. */
	static JTextField textNombre;
	
	/** El text apellidos. */
	static JTextField textApellidos;
	
	/** El text dias. */
	static JTextField textDias;
	
	/** El text dni. */
	static JFormattedTextField fTextDni;
	
	/** El text telefono. */
	static JFormattedTextField fTextTelefono;
	
	/** El text entrada. */
	static JFormattedTextField fTextEntrada;
	
	/** El text salida. */
	static JFormattedTextField fTextSalida;
	
	/** La mascara. */
	private MaskFormatter mascara;
	
	/** El formatter. */
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

	/**
	 * Instancia un nuevo panel 2.
	 */
	public Panel2() {
	this.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;
	this.setBackground(Color.decode("#9ee9e9"));
	this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
	
	// Titulo --------------------------------------------------
	labelTitulo = new JLabel("Datos Del Cliente");
	labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
	labelTitulo.setHorizontalAlignment(JLabel.CENTER);
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 2;
    this.add(labelTitulo, constraints);
	// Titulo --------------------------------------------------
    //Nombre ---------------------------------------------
	labelNombre = new JLabel("Nombre:");
	textNombre = new JTextField();
    constraints.gridx = 0;
    constraints.gridy = 1;
    this.add(labelNombre, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 2;
    this.add(textNombre, constraints);
    //Nombre ---------------------------------------------
    //Apellidos --------------------------------------------------
    labelApellidos = new JLabel("Apellidos:");
    textApellidos = new JTextField();
    constraints.gridx = 0;
    constraints.gridy = 3;
    this.add(labelApellidos, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 4;
    this.add(textApellidos, constraints);
    //Apellidos --------------------------------------------------
    //DNI ---------------------------------------------
    labelDNI = new JLabel("DNI:(Ej:12345678U)");
    fTextDni = new JFormattedTextField();
	try {
		mascara = new MaskFormatter("########U");
		fTextDni = new JFormattedTextField(mascara);
		fTextDni.setFocusLostBehavior(fTextDni.COMMIT);
    } catch (ParseException e1) {
        e1.printStackTrace();
    }
    constraints.gridx = 0;
    constraints.gridy = 5;
    this.add(labelDNI, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 6;
    this.add(fTextDni, constraints);
    //DNI ---------------------------------------------
    //Telefono -----------------------------------------
    labelTelefono = new JLabel("Telefono:(Ej:999222333)");
    fTextTelefono = new JFormattedTextField();
	try {
		mascara = new MaskFormatter("#########");
		fTextTelefono = new JFormattedTextField(mascara);
		fTextTelefono.setFocusLostBehavior(fTextTelefono.COMMIT);
    } catch (ParseException e1) {
        e1.printStackTrace();
    }
    constraints.gridx = 0;
    constraints.gridy = 7;
    this.add(labelTelefono, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 8;
    this.add(fTextTelefono, constraints);
    //Telefono -----------------------------------------
    //Fecha Entrada ----------------------------------------
    labelEntrada = new JLabel("Fecha de Entrada(01/01/1111)");
    fTextEntrada = new JFormattedTextField();
	try {
		mascara = new MaskFormatter("##/##/####");
		fTextEntrada = new JFormattedTextField(mascara);
		fTextEntrada.setFocusLostBehavior(fTextTelefono.COMMIT);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	LocalDate fechaHoy = LocalDate.now();
	fTextEntrada.setText(formatter.format(fechaHoy));

    constraints.gridx = 0;
    constraints.gridy = 9;
    this.add(labelEntrada, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 10;
    this.add(fTextEntrada, constraints);
    //Fecha Entrada ----------------------------------------
    //Fecha Salida -----------------------------------------
    labelSalida = new JLabel("Fecha de Salida(01/01/1111)");
    fTextSalida = new JFormattedTextField();
	try {
		mascara = new MaskFormatter("##/##/####");
		fTextSalida = new JFormattedTextField(mascara);
		fTextSalida.setFocusLostBehavior(fTextTelefono.COMMIT);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	LocalDate fechaMañana = LocalDate.now().plusDays(1);
	fTextSalida.setText(formatter.format(fechaMañana));
	
    constraints.gridx = 0;
    constraints.gridy = 11;
    this.add(labelSalida, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 12;
    this.add(fTextSalida, constraints);
    //Fecha Salida -----------------------------------------
    //Numero Dias ------------------------------------------
    labelDias = new JLabel("Números de dias");
    textDias = new JTextField();
    textDias.setEditable(false);
    textDias.addFocusListener(this);
	
    constraints.gridx = 0;
    constraints.gridy = 13;
    this.add(labelDias, constraints);
    
    constraints.gridx = 1;
    constraints.gridy = 14;
    this.add(textDias, constraints);
    //Numero Dias ------------------------------------------
	}

	/**
	 * Focus ganado.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		LocalDate fechaEntradaDate = LocalDate.now();
        LocalDate fechaSalidaDate = LocalDate.now().plusDays(1);
        long diasEstancia = ChronoUnit.DAYS.between(fechaEntradaDate, fechaSalidaDate);
        textDias.setText(String.valueOf(diasEstancia));
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
