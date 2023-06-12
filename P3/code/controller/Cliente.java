package P3.code.controller;

/*
Metodo depositar e sacar token (Cada token sera igual a 1 real)
Metodo trocar informações do perfil do cliente
Metodo para envio de token para amigos
Metodo Desconto para clientes vip(herança do cliente caso ele compre o VIP(custo 100 tokens))
Metodo para exibir o historico de compras
*/

import P3.model.Usuario;
import java.util.LinkedList;

public class Cliente extends Usuario {
	private LinkedList<String> codesFrinds = new LinkedList<String>();
	private String code;
	private String genero;
	private String cpf;
	private static int token;

	public Cliente(String code, String nome, String genero, String telefone, String cpf, int token, String senha) {
		// super(); ainda irei implementar
		this.code = code;
		this.genero = genero;
		this.cpf = cpf;
		this.token = token;

	}

	public Cliente(String nomeCliente, String cpf2, String senha) {
	}

	public Cliente(String nome, String endereco, String telefone, String email) {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public void comprarProduto(Produto produto, int quantidade) {
	}

}