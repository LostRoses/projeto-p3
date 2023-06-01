package P3.code.controller;

public class Produto {
    public String nome;
    public int preco;
    public String codigo;
    private int estoque;

    //toString
    @Override
    public String toString(){
        return "Produto "+nome+", preço "+preco+", codigo "+codigo+", estoque "+estoque+".";
    }

    //construtor
    public Produto(String nome, int preco, String codigo, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQtd() {
        return estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void aumetarEstoque(int estoque) {
        this.estoque = estoque;
    }

    // metodos
    public void adicionarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public void retirarEstoque(String codigo, int quantidade) {
        for(int i=0;i!=Empresa.produtos.size();i++){
            Produto aux = Empresa.produtos.get(i);
            if (aux.getCodigo().equalsIgnoreCase(codigo)) {
                if (aux.estoque >= quantidade) {
                    aux.estoque = aux.estoque - quantidade;
                } else {
                    System.out.println("");
                    System.out.println("Estoque indisponivel.");
                    System.out.println("");
                }
            }
        }
    }
}