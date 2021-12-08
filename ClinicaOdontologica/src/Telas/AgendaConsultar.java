package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConectaBanco.ConectaBD;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AgendaConsultar extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtdata;
	private JTextField txthora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaConsultar frame = new AgendaConsultar();
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
	public AgendaConsultar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 672, 73);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Agendar Consulta");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(235, 11, 329, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AgendaConsultar.class.getResource("/guardar/logo.png")));
		lblNewLabel.setBounds(-116, -37, 309, 172);
		panel.add(lblNewLabel);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(35, 109, 253, 20);
		contentPane.add(txtnome);
		
		JLabel lblnome = new JLabel("Nome:");
		lblnome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblnome.setBounds(35, 84, 46, 14);
		contentPane.add(lblnome);
		
		txtdata = new JTextField();
		txtdata.setColumns(10);
		txtdata.setBounds(330, 109, 253, 20);
		contentPane.add(txtdata);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblData.setBounds(330, 84, 46, 14);
		contentPane.add(lblData);
		
		txthora = new JTextField();
		txthora.setColumns(10);
		txthora.setBounds(35, 168, 253, 20);
		contentPane.add(txthora);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHora.setBounds(35, 140, 46, 14);
		contentPane.add(lblHora);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Connection conn = ConectaBD.createConnectionToMySQL();
						String sql = "insert into consultas (paciente, data, horario) value (?,?,?)";
						PreparedStatement stmt = conn.prepareStatement(sql);

					stmt.setString(1, txtnome.getText());
					stmt.setString(2, txtdata.getText());
					stmt.setString(3, txthora.getText());
						
						

						stmt.execute();
						stmt.close();
						conn.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
				  limpar();
				}
			
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(SystemColor.textHighlight);
		btnCadastrar.setBounds(349, 155, 97, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection buscar = ConectaBD.createConnectionToMySQL();
					String sql = "select *from consultas where paciente=?";
					PreparedStatement stmt = buscar.prepareStatement(sql);
					stmt.setString(1, txtnome.getText());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
					txtdata.setText(rs.getString("data"));	
					txtnome.setText(rs.getString("Paciente"));
					txthora.setText(rs.getString("horario"));
				
					

							}

							rs.close();
							buscar.close();

						} catch (Exception e1) {
							e1.printStackTrace();
						}

			}
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(487, 155, 97, 23);
		contentPane.add(btnBuscar);
		
		JButton btnLimpar = new JButton("LImpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setBackground(Color.RED);
		btnLimpar.setBounds(487, 212, 97, 23);
		contentPane.add(btnLimpar);
		
		
				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							try {
								Connection conn = ConectaBD.createConnectionToMySQL();
								String sql = "delete from consultas where  Paciente=?";
								PreparedStatement stmt = conn.prepareStatement(sql);
								stmt.setString(1, txtnome.getText());
								stmt.execute();
								stmt.close();
								conn.close();
								JOptionPane.showMessageDialog(null, "Usuário Excluido !");
								limpar();

							} catch (Exception e1) {
								e1.printStackTrace();
							}
					}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setBounds(349, 212, 97, 23);
		contentPane.add(btnExcluir);
	}
	
	public void limpar() {
        txtnome.setText(null);
        txtdata.setText(null);
        txthora.setText(null);
	}
	
		
	
	}	


