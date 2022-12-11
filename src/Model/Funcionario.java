package Model;

public class Funcionario 
{
	//ATRIBUTOS DO FUNCIONARIO
	private int		mat_func;
	private String 	nome_func;
	private String 	cpf_func;
    private String 	cargo_func;
    private Boolean status_func;
    private String 	login_func;		
    private String 	senha_func;		
	
    //GETTERS E SETTERS DOS ATRIBUTOS DO FUNCIONARIO
    public int getMat_func() {
		return mat_func;
	}

	public void setMat_func(int mat_func) {
		this.mat_func = mat_func;
	}

	public String getNome_func() {
		return nome_func;
	}

	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}

	public String getCpf_func() {
		return cpf_func;
	}

	public void setCpf_func(String cpf_func) {
		this.cpf_func = cpf_func;
	}

	public String getCargo_func() {
		return cargo_func;
	}

	public void setCargo_func(String cargo_func) {
		this.cargo_func = cargo_func;
	}

	public Boolean getStatus_func() {
		return status_func;
	}

	public void setStatus_func(Boolean status_func) {
		this.status_func = status_func;
	}

	public String getLogin_func() {
		return login_func;
	}

	public void setLogin_func(String login_func) {
		this.login_func = login_func;
	}

	public String getSenha_func() {
		return senha_func;
	}

	public void setSenha_func(String senha_func) {
		this.senha_func = senha_func;
		
	}
}
