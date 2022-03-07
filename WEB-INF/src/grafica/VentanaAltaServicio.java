package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controladores.ControladorAltaMudanza;
import controladores.ControladorAltaServicio;
import logica.excepciones.ServicioException;

public class VentanaAltaServicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCostoHora;
	private JTextField tfDistanciaKm;
	private JTextField tfCodigoServicio;
	private ControladorAltaServicio controlador = new ControladorAltaServicio(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaAltaServicio frame = new VentanaAltaServicio();
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
	public VentanaAltaServicio() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLosDatos = new JLabel("Alta de servcicos");
		lblIngreseLosDatos.setBounds(166, 7, 157, 28);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblArmadoMuebles = new JLabel("Armado de muebles");
		lblArmadoMuebles.setBounds(11, 50, 135, 16);
		contentPane.add(lblArmadoMuebles);

		JLabel lblHoraInicio = new JLabel("Embalaje");
		lblHoraInicio.setBounds(11, 85, 93, 16);
		contentPane.add(lblHoraInicio);

		JLabel lblCostoHora = new JLabel("Costo por hora");
		lblCostoHora.setBounds(11, 118, 106, 16);
		contentPane.add(lblCostoHora);

		JLabel lblDistanciaKm = new JLabel("Distancia en km");
		lblDistanciaKm.setBounds(11, 150, 118, 16);
		contentPane.add(lblDistanciaKm);

		JLabel lblCodigoServicio = new JLabel("Codigo del servicio");
		lblCodigoServicio.setBounds(11, 184, 135, 16);
		contentPane.add(lblCodigoServicio);

		JRadioButton rdArmadoSi = new JRadioButton(" SI");
		rdArmadoSi.setBackground(SystemColor.activeCaptionBorder);
		rdArmadoSi.setBounds(176, 47, 65, 23);
		contentPane.add(rdArmadoSi);

		JRadioButton rdArmadoNo = new JRadioButton(" NO");
		rdArmadoNo.setBackground(SystemColor.activeCaptionBorder);
		rdArmadoNo.setBounds(259, 46, 64, 23);
		contentPane.add(rdArmadoNo);

		JRadioButton rdEmbalajeNo = new JRadioButton(" NO");
		rdEmbalajeNo.setBackground(SystemColor.activeCaptionBorder);
		rdEmbalajeNo.setBounds(259, 81, 64, 23);
		contentPane.add(rdEmbalajeNo);

		JRadioButton rdEmbalajeSi = new JRadioButton(" SI");
		rdEmbalajeSi.setBackground(SystemColor.activeCaptionBorder);
		rdEmbalajeSi.setBounds(177, 81, 55, 23);
		contentPane.add(rdEmbalajeSi);

		tfCostoHora = new JTextField();
		tfCostoHora.setBounds(162, 116, 105, 20);
		contentPane.add(tfCostoHora);
		tfCostoHora.setColumns(10);

		tfDistanciaKm = new JTextField();
		tfDistanciaKm.setColumns(10);
		tfDistanciaKm.setBounds(162, 148, 105, 20);
		contentPane.add(tfDistanciaKm);

		tfCodigoServicio = new JTextField();
		tfCodigoServicio.setColumns(10);
		tfCodigoServicio.setBounds(162, 182, 105, 20);
		contentPane.add(tfCodigoServicio);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {			
				controlador.nuevoServicio(rdArmadoSi.isSelected(), rdEmbalajeSi.isSelected(), tfCostoHora.getText(), tfDistanciaKm.getText(), tfCodigoServicio.getText());
					
			}
		});
		btnGuardar.setBounds(275, 228, 117, 29);
		contentPane.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Ha cancelado la operacion");
				new VentanaMenu().setVisible(true);
			}
		});
		btnCancelar.setBounds(66, 228, 117, 29);
		contentPane.add(btnCancelar);
	}
}