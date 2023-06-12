package P3.code.controller;

import java.awt.Container;
import java.util.LinkedList;
import java.util.List;

import P3.model.Usuario;

public class Empresa extends Usuario {

  public static LinkedList<Produto> produtos = new LinkedList<Produto>();
  private LinkedList<Cliente> clientes = new LinkedList<Cliente>();
  private String cnpj;

  public Empresa(String nome, String telefone, String cnpj, double saldo, String senha) {

    this.cnpj = cnpj;
  }

  public Empresa(String nomeEmpresa, String cnpj2) {
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

  public List<Produto> getProdutos() {
    return null;
  }

  public void cadastrarProduto(String nome, double preco) {
  }
}