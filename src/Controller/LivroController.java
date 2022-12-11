package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Livro;

public class LivroController 
{
	/*	C - CREATE
	  	R - READ
	  	U - UPDATE
	  	D - DELETE	*/

	//ISERT LIVRO
	public void cadastrarLivro(Livro livro) 
	{
		String sql = "INSERT INTO LIVRO(ISBN, TITULO_LIVRO, COD_AUTOR_FK, CIDADE_LIVRO, NUM_PAGINA_LIVRO, QTD_LIVRO, COD_EDITORA_FK, ANO_LIVRO) "
					+"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstm = null;
		
		try 
		{
			con = ConexaoMySQL.getConexao();
			pstm = (PreparedStatement) con.prepareStatement(sql);
			pstm.setString(1, livro.getISBN());
			pstm.setString(2, livro.getTITULO_LIVRO());
			pstm.setInt	  (3, livro.getCOD_AUTOR_FK());
			pstm.setString(4, livro.getCIDADE_LIVRO());
			pstm.setInt	  (5, livro.getNUM_PAGINA_LIVRO());
			pstm.setInt   (6, livro.getQTD_LIVRO());
			pstm.setInt   (7, livro.getCOD_EDITORA_FK());
			pstm.setInt   (8, livro.getANO_LIVRO());
			
			pstm.execute();
			System.out.println("Insert feito!");
		
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
	
	//Consulta SQL que trás os livros cadastrados
	public List<Livro> buscarLivros(DefaultTableModel modelo)
	{
		String sql = "SELECT * FROM LIVRO ORDER BY TITULO_LIVRO";
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
	            modelo.addRow(new Object[] {rset.getString("ISBN"),rset.getString("TITULO_LIVRO"), rset.getInt("COD_AUTOR_FK"), rset.getString("CIDADE_LIVRO"), rset.getInt("NUM_PAGINA_LIVRO"), rset.getInt("QTD_LIVRO"), rset.getInt("COD_EDITORA_FK"), rset.getInt("ANO_LIVRO")});

			}
			
		}catch(Exception e){
			e.printStackTrace();
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
				
		}catch(Exception e){
			e.printStackTrace();
			}
		}
		
		return livros;	
	}
}
