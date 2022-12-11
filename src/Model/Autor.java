package Model;

import java.util.Date;

public class Autor 
{
	//ATRIBUTOS AUTOR
	private int cod_autor;
	private String nome_autor;
	private Date nasc_autor;
	private Date falec_autor;

	//GETTERS E SETTERS DOS ATRIBUTOS DO AUTOR
	public int getCod_autor() {
		return cod_autor;
	}
	public void setCod_autor(int cod_autor) {
		this.cod_autor = cod_autor;
	}
	public String getNome_autor() {
		return nome_autor;
	}
	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}
	public Date getNasc_autor() {
		return nasc_autor;
	}
	public void setNasc_autor(Date nasc_autor) {
		this.nasc_autor = nasc_autor;
	}
	public Date getFalec_autor() {
		return falec_autor;
	}
	public void setFalec_autor(Date falec_autor) {
		this.falec_autor = falec_autor;
	}
}
