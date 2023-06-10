package P3.code.controller;

import java.util.LinkedList;

public class Empresa {
  public static LinkedList<Produto> produtos = new LinkedList<Produto>();
  private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
  private String nome;
  private String telefone;
  private String cnpj;
  private double saldo;
  private String senha;

  public Empresa(String nome, String telefone, String cnpj, double saldo, String senha) {
    this.nome = nome;
    this.telefone = telefone;
    this.cnpj = cnpj;
    this.saldo = saldo;
    this.senha = senha;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public static void cadastrarProduto(String nome, int preco, String codigo, int estoque) {
    Produto produto = new Produto(nome, preco, codigo, estoque);
    produtos.add(produto);
  }

  public void showProdutos() {
    System.out.println(produtos);
  }

  public int sizeProdutos() {
    return produtos.size();
  }

  public Produto buscarProduto(String codigo) {
    return null;
  }

  public void buscarProduto(P3.code.controller.Produto produto) {
  }
}