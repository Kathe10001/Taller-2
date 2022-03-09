package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorListadoMudanzasPorFecha;

public class VentanaListadoMudanzasPorFecha extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorListadoMudanzasPorFecha controlador = new ControladorListadoMudanzasPorFecha(this);
	private JPanel contentPane;
	private JTextField txtFechaMudanza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaListadoMudanzasPorFecha frame = new VentanaListadoMudanzasPorFecha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaListadoMudanzasPorFecha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFechaMudanza = new JLabel("Fecha de la mudanza dd-mm-yyyy");
		lblFechaMudanza.setBounds(23, 46, 231, 16);
		contentPane.add(lblFechaMudanza);
		
		txtFechaMudanza = new JTextField();
		txtFechaMudanza.setColumns(10);
		txtFechaMudanza.setBounds(266, 41, 157, 26);
		contentPane.add(txtFechaMudanza);

		JLabel lblIngreseUnNuevo = new JLabel("Listado de mudanza por fecha");
		lblIngreseUnNuevo.setBounds(117, 6, 221, 26);
		contentPane.add(lblIngreseUnNuevo);
		
		VentanaListadoMudanzasPorFecha ventana = this;
		
		JButton btnCargarDatos = new JButton("Buscar");
		btnCargarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controlador.listadoMudanzasPorFecha(txtFechaMudanza.getText());		
			}
		});
		btnCargarDatos.setBounds(278, 226, 117, 29);
		contentPane.add(btnCargarDatos);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.dispose();
			}
		});
		btnCancelar.setBounds(70, 226, 117, 29);
		contentPane.add(btnCancelar);
	}
}