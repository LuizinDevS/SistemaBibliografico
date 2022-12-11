package View;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InicialView extends JFrame 
{
	private JPanel contentPane;
	
	public InicialView() 
	{	
		setTitle("Tela Inicial");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InicialView.class.getResource("/Imagens/Capa_BibliotecTeste.png")));	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(25, 6, 56));
		setContentPane(contentPane);
		
		JLabel capa_bibliotec = new JLabel((new ImageIcon(getClass().getResource("/Imagens/Capa_Bibliotec.png"))));
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuCadastrar = new JMenu("Cadastrar");
		menuCadastrar.setBounds(0, 0, 101, 22);
		menuBar.add(menuCadastrar);
		
		JMenuItem menuItemFuncionario = new JMenuItem("Funcionario");
		menuItemFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FuncionarioView frame = new FuncionarioView();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});
		menuCadastrar.add(menuItemFuncionario);
		
		JMenuItem menuItemCliente = new JMenuItem("Cliente");
		menuItemCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ClienteView cad = new ClienteView();
				cad.setVisible(true);
				cad.setLocationRelativeTo(null);
				dispose();
			}
		});
		menuCadastrar.add(menuItemCliente);

		
		JMenuItem menuItemEditora = new JMenuItem("Editora");
		menuCadastrar.add(menuItemEditora);
		
		JMenuItem menuItemAutor = new JMenuItem("Autor");
		menuCadastrar.add(menuItemAutor);
		
		JMenu menuAcervo = new JMenu("Acervo");
		menuCadastrar.add(menuAcervo);
		
		JMenuItem menuItemLivro = new JMenuItem("Livro");
		menuItemLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				LivroView cad = new LivroView();
				cad.setVisible(true);
				cad.setLocationRelativeTo(null);
				dispose();
			}
		});
		menuAcervo.add(menuItemLivro);
		
		JMenuItem menuItemPeriodico = new JMenuItem("Periodico");
		menuAcervo.add(menuItemPeriodico);
		
		JMenuItem menuItemFolhetoTecnico = new JMenuItem("Folheto Tecnico");
		menuAcervo.add(menuItemFolhetoTecnico);
		
		JMenu menuEmprestimo = new JMenu("Emprestimos");
		menuEmprestimo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				EmprestimoView emprestimo = new EmprestimoView();
				emprestimo.setVisible(true);
				emprestimo.setLocationRelativeTo(null);
				dispose();
			}
		});
		menuBar.add(menuEmprestimo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Livro");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				EmprestimoView emp = new EmprestimoView();
				emp.setVisible(true);
				emp.setLocationRelativeTo(null);
				dispose();
			}
		});
		menuEmprestimo.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Folheto Tecnico");
		menuEmprestimo.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Periodico");
		menuEmprestimo.add(mntmNewMenuItem_2);
		
		JMenu menuDevolucoes = new JMenu("Devolucoes");
		menuBar.add(menuDevolucoes);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Livro");
		menuDevolucoes.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Periodico");
		menuDevolucoes.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Folheto Tecnico");
		menuDevolucoes.add(mntmNewMenuItem_5);
		
		JMenu menuRelatorios = new JMenu("Relatorios");
		menuBar.add(menuRelatorios);
		
		JMenu menuRelatorioCadastro = new JMenu("Cadastros");
		menuRelatorios.add(menuRelatorioCadastro);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Autores");
		menuRelatorioCadastro.add(mntmNewMenuItem_6);
		
		JMenuItem menuRelatorioClientes = new JMenuItem("Clientes");
		menuRelatorioCadastro.add(menuRelatorioClientes);
		
		JMenuItem menuRelatorioFuncionarios = new JMenuItem("Funcionarios");
		menuRelatorioCadastro.add(menuRelatorioFuncionarios);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Editoras");
		menuRelatorioCadastro.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Livros");
		menuRelatorioCadastro.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Folhetos Tecnicos\r\n");
		menuRelatorioCadastro.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Periodicos");
		menuRelatorioCadastro.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu = new JMenu("Emprestimos");
		menuRelatorios.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Livros");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RelatorioView rel = new RelatorioView();
				rel.setVisible(true);
				rel.setLocationRelativeTo(null);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Folhetos Tecnicos");
		mnNewMenu.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Periodicos");
		mnNewMenu.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_1 = new JMenu("Devolucoes");
		menuRelatorios.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Livros");
		mnNewMenu_1.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Folhetos Tecnicos");
		mnNewMenu_1.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Periodicos");
		mnNewMenu_1.add(mntmNewMenuItem_16);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(capa_bibliotec, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(capa_bibliotec, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
					.addGap(4))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
