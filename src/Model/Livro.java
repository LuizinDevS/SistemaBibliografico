package Model;

public class Livro 
{
	//ATRIBUTOS DO LIVRO
	private String ISBN;
    private String TITULO_LIVRO;
    private int COD_AUTOR_FK;	
    private String CIDADE_LIVRO;
    private int NUM_PAGINA_LIVRO;
    private int QTD_LIVRO;
    private int COD_EDITORA_FK;
    private int ANO_LIVRO;
    
    //GETTERS E SETTERS DO LIVRO
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTITULO_LIVRO() {
		return TITULO_LIVRO;
	}
	public void setTITULO_LIVRO(String tITULO_LIVRO) {
		TITULO_LIVRO = tITULO_LIVRO;
	}
	public int getCOD_AUTOR_FK() {
		return COD_AUTOR_FK;
	}
	public void setCOD_AUTOR_FK(int cOD_AUTOR_FK) {
		COD_AUTOR_FK = cOD_AUTOR_FK;
	}
	public String getCIDADE_LIVRO() {
		return CIDADE_LIVRO;
	}
	public void setCIDADE_LIVRO(String cIDADE_LIVRO) {
		CIDADE_LIVRO = cIDADE_LIVRO;
	}
	public int getNUM_PAGINA_LIVRO() {
		return NUM_PAGINA_LIVRO;
	}
	public void setNUM_PAGINA_LIVRO(int nUM_PAGINA_LIVRO) {
		NUM_PAGINA_LIVRO = nUM_PAGINA_LIVRO;
	}
	public int getQTD_LIVRO() {
		return QTD_LIVRO;
	}
	public void setQTD_LIVRO(int qTD_LIVRO) {
		QTD_LIVRO = qTD_LIVRO;
	}
	public int getCOD_EDITORA_FK() {
		return COD_EDITORA_FK;
	}
	public void setCOD_EDITORA_FK(int cOD_EDITORA_FK) {
		COD_EDITORA_FK = cOD_EDITORA_FK;
	}
	public int getANO_LIVRO() {
		return ANO_LIVRO;
	}
	public void setANO_LIVRO(int aNO_LIVRO) {
		ANO_LIVRO = aNO_LIVRO;
	}
}
