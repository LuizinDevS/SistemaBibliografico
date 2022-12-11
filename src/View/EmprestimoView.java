package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class EmprestimoView extends JFrame 
{
	private JPanel contentPane;

	public EmprestimoView() 
	{
		setTitle("Tela de emprestimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(25, 6, 56));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Emprestimo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(285, 27, 154, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(7, 7, 75, 23);
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
		contentPane.setLayout(null);
		contentPane.add(btnVoltar);
	}

}
