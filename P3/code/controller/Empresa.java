package P3.code.controller;

import java.util.LinkedList;
import P3.model.Usuario;

public class Empresa extends Usuario {

  public static LinkedList<Produto> produtos = new LinkedList<Produto>();
  private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
  private String cnpj;

  public Empresa(String nome, String telefone, String cnpj, double saldo, String senha) {

    this.cnpj = cnpj;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
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