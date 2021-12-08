package Telas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import ConectaBanco.ConectaBD;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtlogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/guardar/cadeira-de-dentista.png")));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 366);
		contentPane = new JPanel();
		contentPane.setFont(new Font("DeVinne Txt BT", Font.BOLD, 20));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel usuario = new JLabel("Usu\u00E1rio");
		usuario.setBackground(SystemColor.windowBorder);
		usuario.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		usuario.setBounds(313, 28, 145, 27);
		contentPane.add(usuario);
		
		txtuser = new JTextField();
		txtuser.setBounds(250, 66, 215, 27);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel login_ = new JLabel("Senha");
		login_.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		login_.setBounds(322, 104, 69, 27);
		contentPane.add(login_);
		RestrictedTextField validar = new RestrictedTextField (txtuser);
		 validar.setOnlyText(true);
		 validar.setLimit(30);
		  
		
		txtlogin = new JPasswordField();
		txtlogin.setBounds(251, 142, 215, 27);
		contentPane.add(txtlogin);
		RestrictedTextField valida = new RestrictedTextField (txtlogin);
		 valida.setOnlyNums(true);
		 valida.setLimit(8);
		
		JButton btnentrar = new JButton("Entrar");
		btnentrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnentrar.setForeground(SystemColor.text);
		btnentrar.setBackground(SystemColor.textHighlight);
		btnentrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtuser.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Usuário ou Senha não Encontrado!");
					txtuser.requestFocus();
				}
				try {
					Connection conn = ConectaBD.createConnectionToMySQL();
					String sql = "select *from adm where usuario=? and senha=?";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, txtuser.getText());
					stmt.setString(2, new String (txtlogin.getPassword()));
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Acesso Liberado");
						new cadastro().setVisible(true);
						dispose();
						
						

					}
				stmt.close();
				conn.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
						
					

	
			}}
		);
		btnentrar.setBounds(250, 202, 215, 23);
		contentPane.add(btnentrar);
	
		JButton btnSair = new JButton("Sair");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(SystemColor.text);
		btnSair.setBackground(new Color(255, 99, 71));
		btnSair.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnSair.setBounds(251, 262, 215, 23);
		contentPane.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 200, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/guardar/logo500.png")));
		lblNewLabel.setBounds(-142, 117, 355, 128);
		panel.add(lblNewLabel);
	}

			
	
	 private void limpar(){
		  txtuser.setText("");        
		  txtlogin.setText("");
		  txtuser.requestFocus();
		  }
	private void sair(){
		  System.exit(0);
		  
		
		 
		  
		  
		  
		  }
}
