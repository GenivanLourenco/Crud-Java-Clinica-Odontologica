package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import ConectaBanco.ConectaBD;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class CadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtcpf;
	private JTextField txtrg;
	private JTextField txtnome;
	private JTextField txtnasc;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtconvenio;
	private JTextField txtCep;
	private JTextField txttel;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox cbouf;
	private JComboBox cbosex;
	private JTextField txtamil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPaciente frame = new CadastroPaciente();
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
	public CadastroPaciente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroPaciente.class.getResource("/guardar/cadeira-de-dentista.png")));
		setTitle("Cadastro de Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 490);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 1015, 73);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-108, -11, 266, 126);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(CadastroDentista.class.getResource("/guardar/logo.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Paciente");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(221, 21, 285, 30);
		panel.add(lblNewLabel_1);

		

		JLabel lblnome = new JLabel("Nome:");
		lblnome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblnome.setBounds(27, 101, 46, 14);
		contentPane.add(lblnome);

		txtnome = new JTextField();
		txtnome.setBounds(27, 126, 253, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);

		JLabel lblcpf = new JLabel("CPF:");
		lblcpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblcpf.setBounds(309, 101, 26, 14);
		contentPane.add(lblcpf);

		txtcpf = new JTextField();
		txtcpf.setBounds(310, 126, 113, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblRg.setBounds(459, 101, 46, 14);
		contentPane.add(lblRg);

		txtrg = new JTextField();
		txtrg.setColumns(10);
		txtrg.setBounds(459, 126, 136, 20);
		contentPane.add(txtrg);

		txtnasc = new JTextField();
		txtnasc.setColumns(10);
		txtnasc.setBounds(27, 182, 253, 20);
		contentPane.add(txtnasc);

		JLabel lblnascimento = new JLabel("Data de Nascimento");
		lblnascimento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblnascimento.setBounds(24, 156, 113, 14);
		contentPane.add(lblnascimento);

		JLabel lblsexo = new JLabel("G\u00EAnero:");
		lblsexo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblsexo.setBounds(309, 156, 46, 14);
		contentPane.add(lblsexo);

		cbosex = new JComboBox();
		cbosex.setModel(new DefaultComboBoxModel(new String[] { "-Selecione-", "Masculino", "Feminino",
				"Cisg\u00EAnero", "Transg\u00EAnero", "N\u00E3o-bin\u00E1rio" }));
		cbosex.setBounds(310, 181, 113, 22);
		contentPane.add(cbosex);

		JLabel lblendereco = new JLabel("Endere\u00E7o:");
		lblendereco.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblendereco.setBounds(295, 271, 57, 14);
		contentPane.add(lblendereco);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(295, 296, 300, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Bairro:");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(27, 340, 46, 14);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Cidade:");
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(139, 340, 46, 14);
		contentPane.add(lblNewLabel_3_2);

		JLabel lblCro = new JLabel("Conv\u00EAnio:");
		lblCro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCro.setBounds(459, 156, 76, 14);
		contentPane.add(lblCro);

		txtamil = new JTextField();
		txtamil.setColumns(10);
		txtamil.setBounds(459, 181, 136, 20);
		contentPane.add(txtamil);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(27, 296, 97, 20);
		contentPane.add(txtCep);
		RestrictedTextField validar = new RestrictedTextField(txtCep);
		validar.setOnlyNums(true);
		validar.setLimit(8);

		JLabel lblcep = new JLabel("CEP:");
		lblcep.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblcep.setBounds(27, 271, 26, 14);
		contentPane.add(lblcep);

		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.setForeground(SystemColor.text);
		btnbuscar.setBackground(SystemColor.textHighlight);
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					buscarCep();
				}
			}
		});
		btnbuscar.setBounds(153, 296, 105, 20);
		contentPane.add(btnbuscar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(SystemColor.text);
		btnCadastrar.setBackground(SystemColor.textHighlight);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = ConectaBD.createConnectionToMySQL();
					String sql = "insert into paciente (paciente, cpf, rg, datadenascimento, genero, convenio, telefone,  cep, endereco, bairro, cidade, uf  ) value (?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement stmt = conn.prepareStatement(sql);

					stmt.setString(1, txtnome.getText());
					stmt.setString(2, txtcpf.getText());
					stmt.setString(3, txtrg.getText());
					stmt.setString(4, txtnasc.getText());
					stmt.setString(5, (String) cbosex.getSelectedItem());
					stmt.setString(6, txtamil.getText());
					stmt.setString(7, txttel.getText());
					stmt.setString(8, txtCep.getText());
					stmt.setString(9, txtEndereco.getText());
					stmt.setString(10, txtBairro.getText());
					stmt.setString(11, txtCidade.getText());
					stmt.setString(12, (String) cbouf.getSelectedItem());

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
		btnCadastrar.setBounds(342, 348, 97, 23);
		contentPane.add(btnCadastrar);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblTelefone.setBounds(27, 213, 56, 14);
		contentPane.add(lblTelefone);

		txttel = new JTextField();
		txttel.setColumns(10);
		txttel.setBounds(27, 238, 120, 20);
		contentPane.add(txttel);

	
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
					Connection buscar = ConectaBD.createConnectionToMySQL();
					String sql = "select *from paciente where paciente=?";
					PreparedStatement stmt = buscar.prepareStatement(sql);
					stmt.setString(1, txtnome.getText());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
					
					txtnome.setText(rs.getString("paciente"));
					txtcpf.setText(rs.getString("cpf"));
					txtEndereco.setText(rs.getString("endereco"));
					txttel.setText(rs.getString("telefone"));
					txtCidade.setText(rs.getString("cidade"));
					txtBairro.setText(rs.getString("bairro"));
					txtamil.setText(rs.getString("convenio"));
					txtrg.setText(rs.getString("rg"));
					cbosex.setToolTipText(rs.getString("genero"));
					cbouf.setToolTipText(rs.getString("uf"));
					txtCep.setText(rs.getString("cep"));
					txtnasc.setText(rs.getString("datadenascimento"));
					

							}

							rs.close();
							buscar.close();

						} catch (Exception e1) {
							e1.printStackTrace();
						}

				
			}
		});
		btnBuscar.setForeground(SystemColor.text);
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(480, 348, 97, 23);
		contentPane.add(btnBuscar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Connection conn = ConectaBD.createConnectionToMySQL();
						String sql = "delete from paciente where  paciente=?";
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
		btnExcluir.setForeground(SystemColor.text);
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setBounds(342, 405, 97, 23);
		contentPane.add(btnExcluir);
		
		JButton btnLimpar = new JButton("LImpar");
		btnLimpar.setForeground(SystemColor.text);
		btnLimpar.setBackground(Color.RED);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(480, 405, 97, 23);
		contentPane.add(btnLimpar);
		
		;
		
		cbosex = new JComboBox();
		cbosex.setBounds(309, 181, 114, 22);
		contentPane.add(cbosex);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(295, 296, 273, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(27, 376, 91, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(127, 376, 91, 20);
		contentPane.add(txtCidade);
		
		cbouf = new JComboBox();
		cbouf.setModel(new DefaultComboBoxModel(new String[] {"UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbouf.setBounds(239, 375, 41, 22);
		contentPane.add(cbouf);
		
		txtamil = new JTextField();
		txtamil.setBounds(459, 182, 136, 20);
		contentPane.add(txtamil);
		txtamil.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(221, 405, 97, 23);
		contentPane.add(btnSair);
		

	}

	public void buscarCep() {
			String logradouro = "";
			String tipoLogradouro = "";
			String resultado = null;
			String cep = txtCep.getText();
			try {
				URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
				SAXReader xml = new SAXReader();
				Document documento = xml.read(url);
				Element root = documento.getRootElement();
				for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
					Element element = it.next();
					if (element.getQualifiedName().equals("cidade")) {
						txtCidade.setText(element.getText());
					}
					if (element.getQualifiedName().equals("bairro")) {
						txtBairro.setText(element.getText());
					}
					if (element.getQualifiedName().equals("uf")) {
						cbouf.setSelectedItem(element.getText());
					}
					if (element.getQualifiedName().equals("tipo_logradouro")) {
						tipoLogradouro = element.getText();
					}
					if (element.getQualifiedName().equals("logradouro")) {
						logradouro = element.getText();
					}
					if (element.getQualifiedName().equals("resultado")) {
						resultado = element.getText();
						if (resultado.equals("1")) {	
							
						} else {
							JOptionPane.showMessageDialog(null, "CEP não encontrado");
						}
					}
				}
				txtEndereco.setText(tipoLogradouro + " " + logradouro);
			} catch (Exception e) {
				System.out.println(e);
			}}

	private void limpar() {
		        txtnasc.setText(null);
		        txtcpf.setText(null);
		        txtrg.setText(null);
		        txtnasc.setText(null);
		        cbosex.setSelectedItem(null);
		        txtamil.setText(null);
		        txttel.setText(null);
		        txtnome.setText(null);
		        txtCep.setText(null);
		        txtEndereco.setText(null);
		        txtBairro.setText(null);
		        txtCidade.setText(null);
		        cbouf.setSelectedItem(null);
		       
	}
	    }
