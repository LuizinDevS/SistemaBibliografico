package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ConexaoMySQL;
import Controller.FuncionarioController;
import Model.Funcionario;
import Model.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FuncionarioView extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	public FuncionarioView() 
	{
		setTitle("Tela de cadastro de funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(25, 6, 56));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Funcionario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				InicialView frame = new InicialView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("Matricula:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("Cargo:");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_4 = new JLabel("Login:");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_5 = new JLabel("Senha:");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Limpar campos");
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Funcionario func = new Funcionario();
				func.setMat_func(Integer.parseInt(textField.getText()));
				func.setNome_func(textField_1.getText());
				func.setCpf_func(textField_2.getText());
				func.setCargo_func(textField_3.getText());
				func.setStatus_func(true);
				func.setLogin_func(textField_4.getText());
				func.setSenha_func(textField_5.getText());
				
				FuncionarioController fc = new FuncionarioController();
				fc.cadastrarFuncionario(func);;
				JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		DefaultTableModel modelo = (new DefaultTableModel(new Object[][] {{}}, new String[] {
				"MAT_FUNC", "NOME_FUNC", "CPF_FUNC", "CARGO_FUNC", "STATUS_FUNC", "LOGIN", "SENHA"}));
		modelo.setNumRows(0);
		
		JButton btnMostrarFuncionarios = new JButton("Mostrar Funcionarios");
		btnMostrarFuncionarios.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				modelo.setRowCount(0);
				
				try{
					Connection con = ConexaoMySQL.getConexao();
				} catch (Exception e3) {
					// TODO Bloco catch gerado automaticamente
					e3.printStackTrace();
				}
					//Consulta SQL que trás os livros cadastrados
					String sql = "SELECT * FROM FUNCIONARIO ORDER BY NOME_FUNC";
					List<Livro> livros = new ArrayList<Livro>(); 
					Connection conexao = null;
					PreparedStatement pstmt = null;
					ResultSet rset = null;

					try 
					{
						conexao = ConexaoMySQL.getConexao();
						pstmt = conexao.prepareStatement(sql);
						rset = pstmt.executeQuery();
						
						//Enquanto houverem livros cadastrados
						while(rset.next()) 
						{
							//Criar nova instancia da classe livro
							modelo.addRow(new Object[] {rset.getInt("MAT_FUNC"),rset.getString("NOME_FUNC"), rset.getInt("CPF_FUNC"), rset.getString("CARGO_FUNC"), rset.getBoolean("STATUS_FUNC"), rset.getString("LOGIN"), rset.getString("SENHA")});
							//setar todos os atributos do objeto usando o retorno do banco de dados

						}
						
					}catch(Exception e1){
						e1.printStackTrace();
					}finally {
						try 
						{
							if(rset != null) 
							{
								rset.close();
							}
							
							if(pstmt != null) 
							{
								pstmt.close();
							}
							
							if(conexao != null)
							{
								conexao.close();
							}
							
					}catch(Exception e2){
						e2.printStackTrace();
						}
					}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(170)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addGap(208))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnGravar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnMostrarFuncionarios, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_3)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnGravar))
						.addComponent(btnMostrarFuncionarios))
					.addGap(43)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
					.addGap(36))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
