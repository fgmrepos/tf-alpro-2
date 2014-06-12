package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;

import utils.CategoriaCliente;
import controller.SimuladorController;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aplicacao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacao frame = new Aplicacao();
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
	public Aplicacao() {
		setFont(new Font("Arial", Font.PLAIN, 14));
		setResizable(false);
		setTitle("Simula Emula - Simulador de Atendimentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][][grow]"));
		
		JLabel lblTitulo = new JLabel("Selecione o cliente:");
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblTitulo, "cell 0 0");
		
		final JComboBox cmbTipoCliente = new JComboBox();
		cmbTipoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoriaCliente x = (CategoriaCliente)cmbTipoCliente.getSelectedItem();
				SimuladorController simulador = new SimuladorController((CategoriaCliente)cmbTipoCliente.getSelectedItem());
			}
		});
		cmbTipoCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		cmbTipoCliente.setModel(new DefaultComboBoxModel(CategoriaCliente.values()));
		contentPane.add(cmbTipoCliente, "cell 0 1,growx");
		
		JLabel lblResultados = new JLabel("Resultados da Simula\u00E7\u00E3o:");
		lblResultados.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblResultados, "cell 0 2");
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(textPane, "cell 0 3,grow");
	}

}
