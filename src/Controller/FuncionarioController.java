package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Model.Funcionario;
import Model.Livro;

public class FuncionarioController 
{
	//ISERT LIVRO
		public void cadastrarFuncionario(Funcionario func) 
		{
			String sql = 
						"INSERT INTO FUNCIONARIO (MAT_FUNC, NOME_FUNC, CPF_FUNC, CARGO_FUNC, STATUS_FUNC, LOGIN, SENHA) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			Connection con = null;
			PreparedStatement pstm = null;
			
			try 
			{
				con = ConexaoMySQL.getConexao();
				pstm = (PreparedStatement) con.prepareStatement(sql);
				pstm.setInt(1, func.getMat_func());
				pstm.setString(2, func.getNome_func());
				pstm.setString(3, func.getCpf_func());
				pstm.setString  (4, func.getCargo_func());
				pstm.setBoolean(5, func.getStatus_func());
				pstm.setString	 (6, func.getLogin_func());
				pstm.setString   (7, func.getSenha_func());
				
				pstm.execute();
				System.out.println("Insert Feito");
				//JOptionPane.showMessageDialog(null, "Funcionario Cadastrado!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try 
				{
					if(pstm != null) 
					{
						pstm.close();
					}
					if(con != null) 
					{
						con.close();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
}
