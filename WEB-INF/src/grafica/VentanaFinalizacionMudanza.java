package grafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controladores.ControladorFinalizacionMudanza;

public class VentanaFinalizacionMudanza extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorFinalizacionMudanza controlador = new ControladorFinalizacionMudanza(this);
	private JPanel contentPane;
	private JTextField tfCodigoMudanza;
	private JTextField tfDuracion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaFinalizacionMudanza frame = new VentanaFinalizacionMudanza();
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
	public VentanaFinalizacionMudanza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 334);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIngreseUnNuevo = new JLabel("Finalizacion de mudanza");
		lblIngreseUnNuevo.setBounds(143, 19, 221, 26);
		contentPane.add(lblIngreseUnNuevo);
		
		JLabel lblCodigoMudanza = new JLabel("Codigo de mudanza");
		lblCodigoMudanza.setBounds(40, 95, 134, 16);
		contentPane.add(lblCodigoMudanza);

		tfCodigoMudanza = new JTextField();
		tfCodigoMudanza.setColumns(10);
		tfCodigoMudanza.setBounds(211, 90, 145, 26);
		contentPane.add(tfCodigoMudanza);

		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(40, 131, 61, 16);
		contentPane.add(lblDuracion);

		tfDuracion = new JTextField();
		tfDuracion.setColumns(10);
		tfDuracion.setBounds(211, 126, 145, 26);
		contentPane.add(tfDuracion);
		
		VentanaFinalizacionMudanza ventana = this;
		
		JButton btnFinalizar = new JButton("Finalizar mudanza");
		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				controlador.finalizacionMudanza(tfCodigoMudanza.getText(), tfDuracion.getText());
				ventana.dispose();
			}
		});
		btnFinalizar.setBounds(261, 226, 145, 29);
		contentPane.add(btnFinalizar);
		
		JButton btnCancelar = new JButton("Cerrar");
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