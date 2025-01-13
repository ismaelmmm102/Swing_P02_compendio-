/**
 * VentanaPrincipal.java
 * 13 nov 20249:29:30
 * @author Ismael Morales Montesinos
 */
package swing_c_p02_MoralesMontesinosIsmael;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

// TODO: Auto-generated Javadoc
/**
 * La Clase VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
	
	/** El btn alta. */
	private JButton btnBaja, btnAlta;
	
	/** El menu bar. */
	private JMenuBar menuBar;
	
	/** El menu ayuda. */
	private JMenu archivoMenu, registroMenu, ayudaMenu;
	
	/** El menu item acerca de. */
	private JMenuItem salirMenuItem, altaReservasMenuItem, bajaReservasMenuItem, acercaDeMenuItem; 
	
	/** El icono escalado 2. */
	private ImageIcon icono, iconoEscalado, icono2, iconoEscalado2;
	
	/** El imagen escalada 2. */
	private Image imagen, imagenEscalada, imagen2, imagenEscalada2;
	
	/**
	 * Instancia una nueva ventana principal.
	 */
	public VentanaPrincipal() {
		super("Gestión Hotel Monte Casinos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout());
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		//Centrar ventana ---------------------------------------------------------------------------
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		
		int altoPantalla=tamanoPantalla.height;
		int anchoPantalla=tamanoPantalla.width;
		
		this.setSize(anchoPantalla/2,altoPantalla/2);
		this.setLocation(anchoPantalla/4,altoPantalla/4);
		//Centrar ventana ---------------------------------------------------------------------------
		
		//Icono de aplicacion -------------------------------------------------------------------
		ImageIcon miIcono = new ImageIcon(getClass().getResource("recursos/mc.png"));
		this.setIconImage(miIcono.getImage());
		//Icono de aplicacion -------------------------------------------------------------------
		
		//Menu -------------------------------------------------------------------------------------
		menuBar = new JMenuBar();

        archivoMenu = new JMenu("Archivo");
        
        salirMenuItem = new JMenuItem("Salir");
        salirMenuItem.addActionListener(e -> System.exit(0));
        
        archivoMenu.add(salirMenuItem);
        menuBar.add(archivoMenu);
        
        registroMenu = new JMenu("Registro");
        registroMenu.setMnemonic(KeyEvent.VK_R);

        altaReservasMenuItem = new JMenuItem("Alta Reservas");
        altaReservasMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        altaReservasMenuItem.addActionListener(this);
        registroMenu.add(altaReservasMenuItem);
        
        bajaReservasMenuItem = new JMenuItem("Baja Reservas");
        bajaReservasMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        bajaReservasMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Opción no desarrollada"));
        registroMenu.add(bajaReservasMenuItem);
        
        menuBar.add(registroMenu);

        ayudaMenu = new JMenu("Ayuda");
        
        acercaDeMenuItem = new JMenuItem("Acerca de...");
        acercaDeMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Información de la aplicación\nNombre de la empresa: Gestión Hotel Monte Casinos\nCreada por: Ismael Morales Montesinos"));
        ayudaMenu.add(acercaDeMenuItem);
        
        menuBar.add(ayudaMenu);
        
        this.setJMenuBar(menuBar);
      //Menu -------------------------------------------------------------------------------------
        
      //Alta Reservas ------------------------------------------------------------------------------
        btnAlta = new JButton("Alta Reservas");
        icono = new ImageIcon(getClass().getResource("recursos/alta.png"));
        imagen = icono.getImage(); 
        imagenEscalada = imagen.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconoEscalado = new ImageIcon(imagenEscalada);

        btnAlta.setIcon(iconoEscalado);
        
        btnAlta.addActionListener(this);
        this.add(btnAlta);
      //Alta Reservas ------------------------------------------------------------------------------
        
      //Baja Reservas ------------------------------------------------------------------------------
        btnBaja = new JButton("Baja Reservas");
        icono2 = new ImageIcon(getClass().getResource("recursos/baja.png"));
        imagen2 = icono2.getImage(); 
        imagenEscalada2 = imagen2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconoEscalado2 = new ImageIcon(imagenEscalada2);

        btnBaja.setIcon(iconoEscalado2);
        
        btnBaja.addActionListener(e -> JOptionPane.showMessageDialog(null, "Opción no desarrollada"));
        this.add(btnBaja);
      //Baja Reservas ------------------------------------------------------------------------------
		this.setVisible(true);
	}
	 
 	/**
 	 * Action hecha.
 	 *
 	 * @param e the e
 	 */
 	@Override
	 public void actionPerformed(ActionEvent e) {
	 if (e.getSource() == btnAlta || e.getSource() == altaReservasMenuItem) {
		 VentanaDialogo VentanaDialogo = new VentanaDialogo(this);
	 }
	 }
}
