package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Instanciar e usar em outras classes: Connection nomeConexao = ConexaoMySQL.getConnection(); 
public class ConexaoMySQL 
{

	//Strings finais para efetuar conexão com o MySQL, url/diretorio, usuario e senha de acesso ao servidor local
	private static final String url = "jdbc:mysql://localhost:3306/BIBLIOTEC";
	private static final String usuario = "root";
	private static final String senha = "root";
	
	
	public static Connection getConexao() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, usuario, senha);
		
		return con;
	}
	
	public static void main(String[] args) throws Exception 
	{
		Connection con = getConexao();
		
		if(con != null) 
		{
			System.out.println("Conectado ao banco!");
			con.close();
		}
	}
}
