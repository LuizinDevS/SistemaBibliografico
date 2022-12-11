package View;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Controller.LivroController;
import Model.Livro;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class LivroView extends JFrame 
{
	private JPanel contentPane;
	
	private JTable tblLivro;
	
	private JLabel lblTitulo;
	
	private JLabel lbl_ISBN;
	private JTextField txtField_ISBN;
	
	private JLabel lbl_TITULO;
	private JTextField txtField_TITULO;
	
	private JLabel lbl_COD_AUTOR;
	private JTextField txtField_COD_AUTOR;
	
	private JLabel lbl_CIDADE;
	private JTextField txtField_CIDADE;
	
	private JLabel lbl_NUM_PAG;
	private JTextField txtField_NUM_PAG;
	
	private JLabel lbl_QTD;
	private JTextField txtField_QTD;
	
	private JLabel lbl_COD_EDITORA;
	private JTextField txtField_COD_EDITORA;
	
	private JLabel lbl_ANO_PUB;
	private JTextField txtField_ANO_PUB;

	private JButton btnGravar;
	
	private JButton btnLimparCampos;
	
	private JButton btnVoltar;

	public LivroView() 
	{
		setTitle("Tela de cadastro de livros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(25, 6, 56));
		setContentPane(contentPane);
		
		lblTitulo = new JLabel("Cadastro de Livro");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		DefaultTableModel modelo = (new DefaultTableModel(new Object[][] {{}}, new String[] {
				"ISBN", "TITULO", "COD AUTOR", "CIDADE PUB", "NUM PAG", "QTD", "COD EDITORA", "ANO"}));
		
		modelo.setNumRows(0);
		tblLivro = new JTable();
		tblLivro.setModel(modelo);
		
		//BOTÃO MOSTRAR LIVROS
		JButton btnNewButton = new JButton("Mostrar livros");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				modelo.setRowCount(0);
				LivroController livroControl = new LivroController();
				livroControl.buscarLivros(modelo);
			}
		});
				
		JScrollPane scrollPane = new JScrollPane(tblLivro);
		
		//ISBN
		lbl_ISBN = new JLabel("ISBN");
		lbl_ISBN.setForeground(Color.WHITE);
		
		txtField_ISBN = new JTextField();
		txtField_ISBN.setColumns(10);
		
		//TITULO DO LIVRO
		lbl_TITULO = new JLabel("TITULO");
		lbl_TITULO.setForeground(Color.WHITE);
		
		txtField_TITULO = new JTextField();
		txtField_TITULO.setColumns(10);
		
		//COD AUTOR
		lbl_COD_AUTOR = new JLabel("COD AUTOR");
		lbl_COD_AUTOR.setForeground(Color.WHITE);
		
		txtField_COD_AUTOR = new JTextField();
		txtField_COD_AUTOR.setColumns(10);
		
		//CIDADE
		lbl_CIDADE = new JLabel("CIDADE");
		lbl_CIDADE.setForeground(Color.WHITE);
		
		txtField_CIDADE = new JTextField();
		txtField_CIDADE.setColumns(10);
		
		//NUM PAGINA
		lbl_NUM_PAG = new JLabel("NUM PAGINA");
		lbl_NUM_PAG.setForeground(Color.WHITE);
		
		txtField_NUM_PAG = new JTextField();
		txtField_NUM_PAG.setColumns(10);
		
		//QTD LIVRO
		lbl_QTD = new JLabel("QTD");
		lbl_QTD.setForeground(Color.WHITE);
		
		txtField_QTD = new JTextField();
		txtField_QTD.setColumns(10);
		
		//COD EDITORA
		lbl_COD_EDITORA = new JLabel("COD EDITORA");
		lbl_COD_EDITORA.setForeground(Color.WHITE);
		
		txtField_COD_EDITORA = new JTextField();
		txtField_COD_EDITORA.setColumns(10);
		
		//ANO PUB
		lbl_ANO_PUB = new JLabel("ANO PUB");
		lbl_ANO_PUB.setForeground(Color.WHITE);
		
		txtField_ANO_PUB = new JTextField();
		txtField_ANO_PUB.setColumns(10);
		
		//BOTÃO GRAVAR LIVRO
		btnGravar = new JButton("Gravar livro");
		btnGravar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Criando um objeto Livro e setando os atributos 
				Livro livro = new Livro();
				livro.setISBN(txtField_ISBN.getText());				
				livro.setTITULO_LIVRO(txtField_TITULO.getText());				
				livro.setCOD_AUTOR_FK(Integer.parseInt(txtField_COD_AUTOR.getText()));
				livro.setCIDADE_LIVRO(txtField_CIDADE.getText());
				livro.setNUM_PAGINA_LIVRO(Integer.parseInt(txtField_NUM_PAG.getText()));
				livro.setQTD_LIVRO(Integer.parseInt(txtField_QTD.getText()));
				livro.setCOD_EDITORA_FK(Integer.parseInt(txtField_COD_EDITORA.getText()));
				livro.setANO_LIVRO(Integer.parseInt(txtField_ANO_PUB.getText()));
				
				//Criando um objeto de LivroController e chamando a função cadastrarLivro()
				LivroController lc = new LivroController();
				lc.cadastrarLivro(livro);
				
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso! ");
			}
		});
		
		//BOTÃO LIMPAR CAMPOS
		btnLimparCampos = new JButton("Limpar campos");
		btnLimparCampos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtField_ISBN.setText(null);
				txtField_TITULO.setText(null);
				txtField_COD_AUTOR.setText(null);
				txtField_CIDADE.setText(null);
				txtField_NUM_PAG.setText(null);
				txtField_QTD.setText(null);
				txtField_COD_EDITORA.setText(null);
				txtField_ANO_PUB.setText(null);
			}
		});
		
		//BOTÃO VOLTAR
		btnVoltar = new JButton("Voltar");
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
		
		//ADICIONANDO LAYOUT GROUP AO PAINEL
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(154)
					.addComponent(lblTitulo, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
					.addGap(113))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(lbl_ISBN, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(txtField_ISBN, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(lbl_NUM_PAG, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(txtField_NUM_PAG, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(lbl_TITULO, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(txtField_TITULO, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(lbl_QTD, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(txtField_QTD, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(lbl_COD_AUTOR, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(txtField_COD_AUTOR, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(lbl_COD_EDITORA, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(txtField_COD_EDITORA, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addComponent(lbl_CIDADE, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(txtField_CIDADE, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(lbl_ANO_PUB, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(txtField_ANO_PUB, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(btnGravar, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnLimparCampos, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
					.addGap(7))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnVoltar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_ISBN))
						.addComponent(txtField_ISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_NUM_PAG))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(txtField_NUM_PAG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_TITULO))
						.addComponent(txtField_TITULO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_QTD))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(txtField_QTD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_COD_AUTOR))
						.addComponent(txtField_COD_AUTOR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_COD_EDITORA, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(txtField_COD_EDITORA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_CIDADE))
						.addComponent(txtField_CIDADE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lbl_ANO_PUB))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(txtField_ANO_PUB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGravar)
						.addComponent(btnLimparCampos)
						.addComponent(btnNewButton))
					.addGap(12)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
					.addGap(41))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
