package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ClienteView extends JFrame 
{
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public ClienteView() 
	{
		setTitle("Tela de cadastro de cliente");
		//setIconImage(Toolkit.getDefaultToolkit().getImage(InicialView.class.getResource("/Imagens/IconeBibliotec.png"))); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(25, 6, 56));
		setContentPane(contentPane);
        
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(7, 7, 83, 23);
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
		
        JLabel lblNewLabel = new JLabel("Cadastro de Cliente");		
        lblNewLabel.setForeground(Color.WHITE);		
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));		
	    lblNewLabel.setBounds(309, 5, 232, 29);		
	    contentPane.add(lblNewLabel);
	    
		DefaultTableModel modelo = (new DefaultTableModel(new Object[][] {{}}, new String[] {
				"Codigo", "CPF", "Nome", "Pendencia", "ISBN (livro asociado)"}));
		modelo.setNumRows(0);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(23, 289, 738, 247);
	    contentPane.add(scrollPane);
	    
	    table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
	    

		
	    JButton btnNewButton = new JButton("Gravar");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    btnNewButton.setBounds(89, 255, 137, 23);
	    contentPane.add(btnNewButton);
	    
	    JButton btnLimparCampos = new JButton("Limpar campos");
	    btnLimparCampos.setBounds(290, 255, 137, 23);
	    contentPane.add(btnLimparCampos);
	    
	    JButton btnMostrarClientes = new JButton("Mostrar clientes");
	    btnMostrarClientes.setBounds(475, 255, 137, 23);
	    contentPane.add(btnMostrarClientes);
	    
	    JLabel lblNewLabel_1 = new JLabel("Codigo");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setBounds(23, 81, 46, 20);
	    contentPane.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("CPF");
	    lblNewLabel_1_1.setForeground(Color.WHITE);
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_1_1.setBounds(23, 114, 46, 20);
	    contentPane.add(lblNewLabel_1_1);
	    
	    JLabel lblNewLabel_1_2 = new JLabel("Nome");
	    lblNewLabel_1_2.setForeground(Color.WHITE);
	    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_1_2.setBounds(23, 150, 46, 20);
	    contentPane.add(lblNewLabel_1_2);
	    
	    textField = new JTextField();
	    textField.setBounds(89, 83, 219, 20);
	    contentPane.add(textField);
	    textField.setColumns(10);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(89, 116, 219, 20);
	    contentPane.add(textField_1);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(89, 147, 219, 20);
	    contentPane.add(textField_2);
	    
	    JLabel lblNewLabel_1_3 = new JLabel("Pendencia");
	    lblNewLabel_1_3.setForeground(Color.WHITE);
	    lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_1_3.setBounds(351, 81, 76, 20);
	    contentPane.add(lblNewLabel_1_3);
	    
	    JLabel lblNewLabel_1_1_1 = new JLabel("ISBN livro associado");
	    lblNewLabel_1_1_1.setForeground(Color.WHITE);
	    lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    lblNewLabel_1_1_1.setBounds(351, 114, 143, 20);
	    contentPane.add(lblNewLabel_1_1_1);
	    
	    textField_3 = new JTextField();
	    textField_3.setColumns(10);
	    textField_3.setBounds(494, 81, 219, 20);
	    contentPane.add(textField_3);
	    
	    textField_4 = new JTextField();
	    textField_4.setColumns(10);
	    textField_4.setBounds(494, 114, 219, 20);
	    contentPane.add(textField_4);
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(312, 198, 202, 22);
	    contentPane.add(comboBox);
	}
}
