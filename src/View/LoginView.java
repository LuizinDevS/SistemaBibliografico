package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controller.ConexaoMySQL;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;



public class LoginView extends JFrame 
{
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	public LoginView() throws Exception 
	{
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(25, 6, 56));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
	
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Connection con;
				try 
				{
					try 
					{
						con = Controller.ConexaoMySQL.getConexao();
						String select = "SELECT * FROM FUNCIONARIO WHERE LOGIN = ? AND SENHA = ?";
						PreparedStatement stmt = con.prepareStatement(select);
						stmt.setString(1, textField.getText());
						stmt.setString(2, new String (passwordField.getPassword()));
						ResultSet resultSelect = stmt.executeQuery();
						if(resultSelect.next()) //Se a consulta tem resutado
						{
							JOptionPane.showMessageDialog(null, "Usuário encontrado!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
							InicialView inicial = new InicialView();
							inicial.setLocationRelativeTo(null);
							inicial.setVisible(true);
							dispose();
						}
						else if(textField.getText().isBlank() || !resultSelect.next())
						{
							JOptionPane.showMessageDialog(null, "Usuário nao encontrado ou inválido!", "Atenção!", JOptionPane.WARNING_MESSAGE);
						}
						stmt.close();
						con.close();
					} catch (Exception e1) {
						// TODO Bloco catch gerado automaticamente
						e1.printStackTrace();
					}
					
				} catch (Exception e1) 
				{
					e1.printStackTrace();
				}
			}
		});
				
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(332)
					.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(376))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(215)
					.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addGap(183))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(215)
					.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addGap(183))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(301)
					.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
					.addGap(183))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblLogin)
							.addGap(151)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(189)
							.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btnEntrar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addGap(1))
		);
		contentPane.setLayout(gl_contentPane);

	}	
}

