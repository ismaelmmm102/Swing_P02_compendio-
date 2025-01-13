/**
 * Panel4.java
 * 16 nov 202419:23:02
 * @author Ismael Morales Montesinos
 */
package swing_c_p02_MoralesMontesinosIsmael;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


// TODO: Auto-generated Javadoc
/**
 * The Class Panel4.
 */
public class Panel4 extends JPanel implements ActionListener{
	
	/** El panel habitacion. */
	private JPanel panelCliente, panelHabitacion;
	
	/** El label habitacion. */
	private JLabel labelCliente, labelHabitacion;
	
	/** El btn guardar. */
	private JButton btnImprimir, btnNuevo, btnGuardar;
	
	/** El panel pestanas. */
	private JTabbedPane panelPestanas;
	

	/**
	 *Instancia un nuevo panel 4.
	 */
	public Panel4() {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));

		Toolkit toolkitPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = toolkitPantalla.getScreenSize();
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		//Pestañas -------------------------------
		panelPestanas = new JTabbedPane();
		panelPestanas.setPreferredSize(new Dimension((anchoPantalla / 2), altoPantalla / 2));
		crearCliente();
		crearHabitacion();

		panelPestanas.addTab("Detalles Clientes", panelCliente);
		panelPestanas.addTab("Detalles Habitación", panelHabitacion);

		//Pestañas -------------------------------
		//Imprimir ----------------------------
		btnImprimir = new JButton("IMPRIMIR");
		ImageIcon icono = new ImageIcon(getClass().getResource("recursos/imprimir.png"));
        Image imagen = icono.getImage(); 
        Image imagenEscalada = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada); 
        btnImprimir.setIcon(iconoEscalado);
        btnImprimir.setPreferredSize(new Dimension(anchoPantalla / 5, altoPantalla / 15));
		//Imprimir ----------------------------
		//Nuevo ----------------------------
        btnNuevo = new JButton("NUEVO");
		ImageIcon icono3 = new ImageIcon(getClass().getResource("recursos/alta.png"));
        Image imagen3 = icono3.getImage(); 
        Image imagenEscalada3 = imagen3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado3 = new ImageIcon(imagenEscalada3); 
        btnNuevo.setIcon(iconoEscalado3);
        btnNuevo.setPreferredSize(new Dimension(anchoPantalla / 5, altoPantalla / 15));
		//Nuevo ----------------------------
		//Guardar ----------------------------
        btnGuardar = new JButton("GUARDAR");
		ImageIcon icono2 = new ImageIcon(getClass().getResource("recursos/guardar.png"));
        Image imagen2 = icono2.getImage(); 
        Image imagenEscalada2 = imagen2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado2 = new ImageIcon(imagenEscalada2); 
        btnGuardar.setIcon(iconoEscalado2);
        btnGuardar.setPreferredSize(new Dimension(anchoPantalla / 5, altoPantalla / 15));
		//Guardar ----------------------------
	

        btnImprimir.addActionListener(this);
		btnNuevo.addActionListener(this);
		btnGuardar.addActionListener(this);

		this.add(panelPestanas);
		this.add(btnImprimir);
		this.add(btnNuevo);
		this.add(btnGuardar);
		
	}
	
	/**
	 * Acciones.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		if (evento == btnImprimir) {
			mostrarCliente();
			mostrarHabitacion();
		}
		if (evento == btnNuevo) {
			Panel2.textNombre.setText("");
			Panel2.textApellidos.setText("");
			Panel2.fTextDni.setText("");
			Panel2.fTextTelefono.setText("");
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
			LocalDate fechaActual = LocalDate.now();
			Panel2.fTextEntrada.setText(formato.format(fechaActual));
			LocalDate fechaProxima = fechaActual.plusDays(1);
			Panel2.fTextSalida.setText(formato.format(fechaProxima));
			Panel2.textDias.setText("");

			Panel3.comboHabitacion.setSelectedIndex(0);
			Panel3.spinnerHabitaciones.setValue(1);
			Panel3.cbNinos.setSelected(false);
			Panel3.extraNinos.setVisible(false);
			Panel3.textImporte.setText("");
		}
		if (evento == btnGuardar) {
			String nombre = Panel2.textNombre.getText();
			String apellido = Panel2.textApellidos.getText();
			String dni = Panel2.fTextDni.getText();
			String telefono = Panel2.fTextTelefono.getText();
			String dias = Panel2.textDias.getText();
			String precioTotal = Panel3.textImporte.getText();
			boolean todo = true;
			if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || telefono.isEmpty() || dias.isEmpty()|| precioTotal.isEmpty()) {
				todo = false;
			}
			if (todo) {
				JOptionPane.showMessageDialog(this, "Se ha guardado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
				
				Panel2.textNombre.setText("");
				Panel2.textApellidos.setText("");
				Panel2.fTextDni.setText("");
				Panel2.fTextTelefono.setText("");
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YYYY");
				LocalDate fechaActual = LocalDate.now();
				Panel2.fTextEntrada.setText(formato.format(fechaActual));
				LocalDate fechaProxima = fechaActual.plusDays(1);
				Panel2.fTextSalida.setText(formato.format(fechaProxima));
				Panel2.textDias.setText("");

				Panel3.comboHabitacion.setSelectedIndex(0);
				Panel3.spinnerHabitaciones.setValue(1);
				Panel3.cbNinos.setSelected(false);
				Panel3.extraNinos.setVisible(false);
				Panel3.textImporte.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Faltan campos por llenar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	/**
	 * Crear cliente.
	 */
	public void crearCliente() {
		panelCliente = new JPanel();
		panelCliente.setLayout(new FlowLayout());
		labelCliente = new JLabel("No hay registros");
		labelCliente.setFont(new Font("Courier New", Font.BOLD, 30));
		labelCliente.setPreferredSize(new Dimension(1300, 400));
		labelCliente.setHorizontalAlignment(JTextField.CENTER);
		labelCliente.setVerticalAlignment(JTextField.CENTER);

		panelCliente.add(labelCliente);
	}
	
	/**
	 * Crear habitacion.
	 */
	public void crearHabitacion() {
		panelHabitacion = new JPanel();
		panelHabitacion.setLayout(new FlowLayout());
		labelHabitacion = new JLabel("No hay registros");
		labelHabitacion.setFont(new Font("Courier New", Font.BOLD, 30));
		labelHabitacion.setPreferredSize(new Dimension(1300, 400));
		labelHabitacion.setHorizontalAlignment(JTextField.CENTER);
		labelHabitacion.setVerticalAlignment(JTextField.CENTER);

		panelHabitacion.add(labelHabitacion);
	}
	
	/**
	 * Mostrar cliente.
	 */
	public void mostrarCliente() {
		String nombre = Panel2.textNombre.getText();
		String apellidos = Panel2.textApellidos.getText();
		String dni = Panel2.fTextDni.getText();
		String telefono = Panel2.fTextTelefono.getText();
		String fechaInicio = Panel2.fTextEntrada.getText();
		String fechaFin = Panel2.fTextSalida.getText();
		String diasEstancia = Panel2.textDias.getText();
		String mensajeReporteCliente = "";

		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El nombre esta vacio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} else if (apellidos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El apellido está vacio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} else if (dni.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El DNI esta vacio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} else if (telefono.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El telefono esta vacio", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} else if (diasEstancia.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Los dias estan vacios", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} else {
			mensajeReporteCliente += "<html><body>Nombre: " + nombre + "<br>" + "Apellidos: " + apellidos + "<br>"+ "DNI: " + dni + "<br>" + "Telefono: " + telefono + "<br>" + "Inicio: " + fechaInicio + "<br>"+ "Fin: " + fechaFin + "<br></body></html>";
			labelCliente.setText(mensajeReporteCliente);
		}
	}
	
	/**
	 * Mostrar habitacion.
	 */
	public void mostrarHabitacion() {
	    StringBuilder mensaje = new StringBuilder("<html><body>");
	    String tipo = String.valueOf(Panel3.comboHabitacion.getSelectedItem());
	    mensaje.append("Tipo de habitacion: ").append(tipo).append("<br>");
	    String numeroHab = String.valueOf(Panel3.spinnerHabitaciones.getValue());
	    mensaje.append("Numero de habitaciones: ").append(numeroHab).append("<br>");
	    boolean tieneHijos = Panel3.cbNinos.isSelected();
	    if (tieneHijos) {
	    	mensaje.append("¿Niños?: Sí<br>");
	        String edad = String.valueOf(ExtraNinos.spinnerEdad.getValue());
	        mensaje.append("Edad: ").append(edad).append("<br>");
	        String tipoCama = ExtraNinos.textFExtras.getText();
	        mensaje.append("Tipo de cama: ").append(tipoCama).append("<br>");
	    } else {
	    	mensaje.append("¿Niños?: No<br>");
	    }
	    String precioTotal = Panel3.textImporte.getText();
	    if (precioTotal.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El importe total está vacío", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	    	mensaje.append("PRECIO TOTAL: ").append(precioTotal).append("<br></body></html>");
	        labelHabitacion.setText(mensaje.toString());
	    }
	}
}
