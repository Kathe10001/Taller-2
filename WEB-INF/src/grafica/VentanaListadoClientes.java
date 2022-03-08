package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controladores.ControladorListadoClientes;

public class VentanaListadoClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorListadoClientes controlador = new ControladorListadoClientes(this);
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaListadoClientes frame = new VentanaListadoClientes();
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
	public VentanaListadoClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseUnNuevo = new JLabel("Listado de clientes");
		lblIngreseUnNuevo.setBounds(143, 19, 221, 26);
		contentPane.add(lblIngreseUnNuevo);
		
		JButton btnCargarDatos = new JButton("Cargar datos");
		btnCargarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controlador.listadoClientes();		
			}
		});
		btnCargarDatos.setBounds(278, 226, 117, 29);
		contentPane.add(btnCargarDatos);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha cancelado la operación");
				new VentanaMenu().setVisible(true);
			}
		});
		btnCancelar.setBounds(70, 226, 117, 29);
		contentPane.add(btnCancelar);
	}
}