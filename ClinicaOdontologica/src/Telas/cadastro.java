package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class cadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro frame = new cadastro();
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
	public cadastro() {
		setTitle("Cadastro/Agendamento");
		setIconImage(Toolkit.getDefaultToolkit().getImage(cadastro.class.getResource("/guardar/cadeira-de-dentista.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setForeground(SystemColor.text);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
		
			
		});
		contentPane.setForeground(SystemColor.text);
		contentPane.setFont(new Font("Segoe UI", Font.BOLD, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 185, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(cadastro.class.getResource("/guardar/logo.png")));
		lblNewLabel.setBounds(-104, 84, 312, 114);
		panel.add(lblNewLabel);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setForeground(SystemColor.text);
		btnSair.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnSair.setBackground(new Color(255, 99, 71));
		btnSair.setBounds(209, 211, 215, 23);
		contentPane.add(btnSair);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.setForeground(Color.WHITE);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.setForeground(SystemColor.text);
		menuBar.setBackground(SystemColor.textHighlight);
		menuBar.setBounds(240, 0, 215, 22);
		contentPane.add(menuBar);
		menuBar.setForeground(SystemColor.text);
		JMenu jMenu = new JMenu();
		jMenu.setBackground(SystemColor.text);
		JMenu Cadastrar = new JMenu("Cadastrar");
		Cadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Cadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Cadastrar.setForeground(Color.WHITE);
		menuBar.add(Cadastrar);
		
		JMenu agendar = new JMenu("Agendar Consulta");
		agendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AgendaConsultar().setVisible(true);
				dispose();
			}
			
		});
		agendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AgendaConsultar().setVisible(true);
				
			}
		});
		agendar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agendar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		agendar.setForeground(Color.WHITE);
		menuBar.add(agendar);
		
		JMenuItem dentista = new JMenuItem("Dentista");
		dentista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastroDentista().setVisible(true);
				
			}
		});
        JMenuItem funcionario = new JMenuItem("Funcionário");
        funcionario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new CadastroFuncionario().setVisible(true);
        		
        	}
        });
        JMenuItem paciente = new JMenuItem("Paciente");
        paciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new CadastroPaciente().setVisible(true);
        		
        	}
        });
		Cadastrar.add(dentista);
		Cadastrar.add(funcionario);
		Cadastrar.add(paciente);
        
		
	}
}
