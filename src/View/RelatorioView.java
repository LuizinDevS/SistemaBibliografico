package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatorioView extends JFrame 
{
	private JPanel contentPane;

	public RelatorioView() 
	{
		setTitle("Tela de relatorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();

		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(25, 6, 56));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 93, 660, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome cliente");
		lblNewLabel.setBounds(10, 5, 73, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.BLACK);
		panel.add(lblNewLabel);
		
		JLabel lblIdLivro = new JLabel("ID Livro");
		lblIdLivro.setForeground(Color.BLACK);
		lblIdLivro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdLivro.setBounds(119, 5, 44, 14);
		panel.add(lblIdLivro);
		
		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setForeground(Color.BLACK);
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdCliente.setBounds(198, 5, 55, 14);
		panel.add(lblIdCliente);
		
		JLabel lblNomeLivro = new JLabel("Nome Livro");
		lblNomeLivro.setForeground(Color.BLACK);
		lblNomeLivro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeLivro.setBounds(302, 5, 63, 14);
		panel.add(lblNomeLivro);
		
		JLabel lblDataEmprestimo = new JLabel("Data Emprestimo");
		lblDataEmprestimo.setForeground(Color.BLACK);
		lblDataEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataEmprestimo.setBounds(428, 5, 98, 14);
		panel.add(lblDataEmprestimo);
		
		JLabel lblDataDevoluo = new JLabel("Data Devolu\u00E7\u00E3o");
		lblDataDevoluo.setForeground(Color.BLACK);
		lblDataDevoluo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDevoluo.setBounds(561, 5, 89, 14);
		panel.add(lblDataDevoluo);
		
		JLabel lblRelatorioEmprestimo = new JLabel("Relatorio de Emprestimos");
		lblRelatorioEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRelatorioEmprestimo.setForeground(Color.WHITE);
		lblRelatorioEmprestimo.setBounds(207, 3, 308, 29);
		contentPane.add(lblRelatorioEmprestimo);
		
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
		btnVoltar.setBounds(7, 5, 91, 23);
		contentPane.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Salvar Relat\u00F3rio");
		btnNewButton.setBounds(428, 515, 127, 23);
		contentPane.add(btnNewButton);
		
		JButton btnImprimirRelatrio = new JButton("Imprimir Relat\u00F3rio");
		btnImprimirRelatrio.setBounds(589, 515, 127, 23);
		contentPane.add(btnImprimirRelatrio);
		btnImprimirRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
}
