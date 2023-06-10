package P3.code.controller;

/*
Metodo depositar e sacar token (Cada token sera igual a 1 real)
Metodo trocar informações do perfil do cliente
Metodo para envio de token para amigos
Metodo Desconto para clientes vip(herança do cliente caso ele compre o VIP(custo 100 tokens))
Metodo para exibir o historico de compras
*/
import java.util.LinkedList;

public class Cliente {
	private LinkedList<String> codesFrinds = new LinkedList<String>();
	private String code;
	private String nome;
	private String genero;
	private String telefone;
	private String cpf;
	private static int token;
	private String senha;

	public Cliente(String code, String nome, String genero, String telefone, String cpf, int token, String senha) {
		// super(); ainda irei implementar
		this.code = code;
		this.nome = nome;
		this.genero = genero;
		this.telefone = telefone;
		this.cpf = cpf;
		this.token = token;
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public void addFriend(String codeFriend) {
		codesFrinds.add(codeFriend);
	}

	public void removeFriend(String codeFriend) {
		codesFrinds.remove(codeFriend);
	}

	public void showFrieds() {
		System.out.println("Amigos:" + codesFrinds);
	}

	@Override
	public String toString() {
		return "Cliente [code=" + code + ", codesFrinds=" + codesFrinds + ", cpf=" + cpf + ", genero=" + genero
				+ ", nome="
				+ nome + ", senha=" + senha + ", telefone=" + telefone + "]";
	}

	public void comprarProduto(String codigo, int quantidade) {
	}

	public void comprarProduto(P3.code.controller.Produto produto, int quantidade) {
	}

}