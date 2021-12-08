package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.mysql.cj.jdbc.JdbcPreparedStatement;

import Atxy2k.CustomTextField.RestrictedTextField;
import ConectaBanco.ConectaBD;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class CadastroDentista extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JTextField txtnome;
	private JTextField txtcpf;
	private JTextField txtrg;
	private JTextField txtnasc;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtcro;
	private JTextField txtCep;
	private JTextField txttel;
	private JTextField txtusuario;
	private JLabel lblStatus;
	private JComboBox cbosex;
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDentista frame = new CadastroDentista();
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
	public CadastroDentista() {
		setTitle("Cadastro de Dentista");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CadastroDentista.class.getResource("/guardar/cadeira-de-dentista.png")));
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

		lblNewLabel_1 = new JLabel("Cadastro de Dentista");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(235, 11, 329, 40);
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

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(27, 365, 76, 20);
		contentPane.add(txtBairro);

		JLabel lblNewLabel_3_2 = new JLabel("Cidade:");
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(139, 340, 46, 14);
		contentPane.add(lblNewLabel_3_2);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(139, 365, 86, 20);
		contentPane.add(txtCidade);

		JLabel lblCro = new JLabel("CRO:");
		lblCro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCro.setBounds(459, 156, 46, 14);
		contentPane.add(lblCro);

		txtcro = new JTextField();
		txtcro.setColumns(10);
		txtcro.setBounds(459, 181, 136, 20);
		contentPane.add(txtcro);

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
					String sql = "insert into dentista (nome, cpf, rg, nascimento, genero, cro, telefone, usuario, senha, cep, endereco, bairro, cidade  ) value (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement stmt = conn.prepareStatement(sql);

					stmt.setString(1, txtnome.getText());
					stmt.setString(2, txtcpf.getText());
					stmt.setString(3, txtrg.getText());
					stmt.setString(4, txtnasc.getText());
					stmt.setString(5, (String) cbosex.getSelectedItem());
					stmt.setString(6, txtcro.getText());
					stmt.setString(7, txttel.getText());
					stmt.setString(8, txtusuario.getText());
					stmt.setString(9, new String(txtpassword.getPassword()));
					stmt.setString(10, txtCep.getText());
					stmt.setString(11, txtEndereco.getText());
					stmt.setString(12, txtBairro.getText());
					stmt.setString(13, txtCidade.getText());
				
					
					

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

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsurio.setBounds(215, 213, 56, 14);
		contentPane.add(lblUsurio);

		txtusuario = new JTextField();
		txtusuario.setColumns(10);
		txtusuario.setBounds(215, 238, 120, 20);
		contentPane.add(txtusuario);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSenha.setBounds(414, 214, 56, 14);
		contentPane.add(lblSenha);

		lblStatus = new JLabel("");
		lblStatus.setBounds(127, 296, 20, 20);
		contentPane.add(lblStatus);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
					Connection buscar = ConectaBD.createConnectionToMySQL();
					String sql = "select *from dentista where nome=?";
					PreparedStatement stmt = buscar.prepareStatement(sql);
					stmt.setString(1, txtnome.getText());
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
					txtusuario.setText(rs.getString("usuario"));
					txtpassword.setText(rs.getString("senha"));
					txtnome.setText(rs.getString("nome"));
					txtcpf.setText(rs.getString("cpf"));
					txtEndereco.setText(rs.getString("endereco"));
					txttel.setText(rs.getString("telefone"));
					txtCidade.setText(rs.getString("cidade"));
					txtBairro.setText(rs.getString("bairro"));
					txtcro.setText(rs.getString("cro"));
					txtrg.setText(rs.getString("rg"));
					cbosex.setToolTipText(rs.getString("genero"));
					
					txtCep.setText(rs.getString("cep"));
					txtnasc.setText(rs.getString("nascimento"));
					

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
						String sql = "delete from dentista where  nome=?";
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
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(408, 238, 120, 20);
		contentPane.add(txtpassword);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(Color.RED);
		btnSair.setBounds(219, 405, 97, 23);
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
					
					
					if (element.getQualifiedName().equals("tipo_logradouro")) {
						tipoLogradouro = element.getText();
					}
					if (element.getQualifiedName().equals("logradouro")) {
						logradouro = element.getText();
					}
					if (element.getQualifiedName().equals("resultado")) {
						resultado = element.getText();
						if (resultado.equals("1")) {	
							lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
						} else {
							JOptionPane.showMessageDialog(null, "CEP não encontrado");
						}
					}
				}
				txtEndereco.setText(tipoLogradouro + " " + logradouro);
			} catch (Exception e) {
				System.out.println(e);
			}}

	public void limpar() {
		        txtnome.setText(null);
		        txtcpf.setText(null);
		        txtrg.setText(null);
		        txtnasc.setText(null);
		        cbosex.setSelectedItem(null);
		        txtcro.setText(null);
		        txttel.setText(null);
		        txtusuario.setText(null);
		        txtpassword.setText(null);
		        txtCep.setText(null);
		        txtEndereco.setText(null);
		        txtBairro.setText(null);
		        txtCidade.setText(null);
		      
		        lblStatus.setIcon(null);
	}
	    }
