package grafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controladores.ControladorMontoRecaudadoRangoFechas;
import logica.excepciones.MudanzaException;

public class VentanaMontoRecaudadoRangoFechas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFin;
	private ControladorMontoRecaudadoRangoFechas controlador = new ControladorMontoRecaudadoRangoFechas(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaMontoRecaudadoRangoFechas frame = new VentanaMontoRecaudadoRangoFechas();
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
	public VentanaMontoRecaudadoRangoFechas() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 452, 238);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFechaInicio = new JLabel("Fecha de inicio");
		lblFechaInicio.setBounds(11, 81, 93, 16);
		contentPane.add(lblFechaInicio);

		txtFechaInicio = new JTextField();
		txtFechaInicio.setColumns(10);
		txtFechaInicio.setBounds(151, 76, 254, 26);
		contentPane.add(txtFechaInicio);

		JLabel lblIngreseLosDatos = new JLabel("Ingrese fecha de inicio y fecha de fin");
		lblIngreseLosDatos.setBounds(10, 3, 416, 45);
		contentPane.add(lblIngreseLosDatos);

		JLabel lblFechaFin = new JLabel("Fecha de finalizacion");
		lblFechaFin.setBounds(11, 112, 130, 16);
		contentPane.add(lblFechaFin);

		txtFechaFin = new JTextField();
		txtFechaFin.setColumns(10);
		txtFechaFin.setBounds(151, 113, 254, 26);
		contentPane.add(txtFechaFin);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.montoRecaudado(txtFechaInicio.getText(), txtFechaFin.getText());
				} catch (RemoteException | MudanzaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				////VER COMO PASAR EL MONTO QUE  CALCULA monto.Recaudado
				JOptionPane.showMessageDialog(null, "El monto recaudado es $");
				new VentanaMenu().setVisible(true);
			}
		});
		btnAceptar.setBounds(272, 161, 117, 29);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Se ha cancelado la operacion");
				new VentanaMenu().setVisible(true);
			}
		});
		btnCancelar.setBounds(63, 161, 117, 29);
		contentPane.add(btnCancelar);

	}
}