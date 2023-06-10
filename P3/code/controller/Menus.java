package P3.code.controller;

import java.util.LinkedList;
import java.util.Scanner;

public class Menus {

    protected static final String produtos = null;
    public static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
    public static LinkedList<Empresa> empresas = new LinkedList<Empresa>();

    private static int op, cl, opC, opCA, opADC, opE, opADE;

    public static void menuPrincipal() throws IllegalAccessException {

        Scanner in = new Scanner(System.in);
        System.out.println("___  ___ _____ __  __ __ __");
        System.out.println("|||  ||| ||    ||  || || ||");
        System.out.println("|||\\/||| ||--- ||\\\\|| || ||");
        System.out.println("|||  ||| ||___ || \\\\| ||_||");
        System.out.println("");
        do {
            menuInicial();
            op = in.nextInt();
            if (op == 1) {// CLIENTE
                do {
                    menuCL();
                    cl = in.nextInt();
                    if (cl == 1) {
                        boolean tfc = loginCliente();
                        if (tfc == true) {// Cliente entrou na conta
                            /* aqui estarão todas as opcoes do cliente */
                            do {
                                opcaoCliente();
                                opC = in.nextInt();
                                if (opC == 1) {
                                    // Compra de produtos
                                    compraProduto();
                                } else if (opC == 2) {
                                    // Comprar tokens
                                    compraToken();
                                } else if (opC == 3) {
                                    // Criar um menu novo com as opcoes relaciondas a amigos dentro de cliente
                                    do {
                                        menuClienteAmigo();
                                        opCA = in.nextInt();
                                        if (opCA == 1) {// PRECISA SER FEITO!!!!!
                                            // Cliente e = ;
                                            // adicionar um cliente
                                            // clientes.add(e);
                                            System.out.println("Digite o code de seu amigo");
                                            String codeFriend = in.next();
                                            boolean vf = buscaLoginCode(codeFriend);
                                            if (vf == true) {
                                                for (int i = 0; i < clientes.size(); i++) {
                                                    Cliente aux = clientes.get(i);
                                                    if (aux.getCode().equalsIgnoreCase(codeFriend)) {
                                                        clientes.getFirst().addFriend(codeFriend);
                                                    }
                                                }
                                            }
                                        } else if (opCA == 2) {
                                            // remover um amigo
                                            System.out.println("Digite o code de seu amigo que deseja remover");
                                            String codeFriend = in.next();
                                            boolean vf = buscaLoginCode(codeFriend);
                                            if (vf == true) {
                                                for (int i = 0; i < clientes.size(); i++) {
                                                    Cliente aux = clientes.get(i);
                                                    if (aux.getCode().equalsIgnoreCase(codeFriend)) {
                                                        clientes.getFirst().removeFriend(codeFriend);
                                                    }
                                                }
                                            }

                                        } else if (opCA == 3) {
                                            clientes.getFirst().showFrieds();
                                        }

                                    } while (opCA != 0);
                                } else if (opC == 4) {
                                    // Alterar dados
                                    int dc;
                                    do {
                                        menuAlterarDadosCliente();
                                        System.out.println("Deseja alterar mais dados? ");
                                        System.out.println("[1] para sim, [0] para não: ");
                                        dc = in.nextInt();
                                        while (dc != 0 && dc != 1) {
                                            System.out.println("Opção inválida... digite novamente: ");
                                            dc = in.nextInt();
                                        }
                                    } while (dc != 0);
                                } else if (opC == 5) {
                                    // volta para menu cliente
                                    menuPrincipal();
                                }
                            } while (opC != 0);
                        }
                    } else if (cl == 2) {// opcoes de cadastrar
                        cadastroCliente();
                    } else if (cl == 0) {
                        menuPrincipal();
                    } else {
                        System.out.println("Opção inválida...");
                        throw new IllegalAccessException("");
                    }
                } while (cl != 0);
                break;
            } else if (op == 2) {// EMPRESA
                do {
                    menuCL();
                    cl = in.nextInt();
                    if (cl == 1) {
                        boolean tfe = loginEmpresa();
                        if (tfe == true) {// Empresa entrou na conta
                            /* aqui estarao todas as acoes da empresa */
                            do {
                                opcaoEmpresa();
                                opE = in.nextInt();
                                if (opE == 1) {
                                    // adicionar um produto no catalogo
                                    cadastroProduto();
                                } else if (opE == 2) {
                                    // para alterar seus dados
                                    int dc;
                                    do {
                                        menuAlterarDadosEmpresa();
                                        System.out.println("Deseja alterar mais dados? ");
                                        System.out.println("[1] para sim, [0] para não: ");
                                        dc = in.nextInt();
                                        while (dc != 0 && dc != 1) {
                                            System.out.println("Opção inválida... digite novamente: ");
                                            dc = in.nextInt();
                                        }
                                    } while (dc != 0);
                                } else if (opE == 3) {
                                    // exibir saldo
                                    exibirSaldo();
                                }
                            } while (opE != 0);
                        }
                    } else if (cl == 2) {// Opcoes de cadastrar
                        cadastroEmpresa();
                    } else if (cl == 0) {
                        menuPrincipal();
                    } else {
                        System.out.println("Opção inválida...");
                        throw new IllegalAccessException("");
                    }
                } while (cl != 0);
                break;
            } else if (op == 9) {
                Empresa empresa = new Empresa("teste", "12345678", "12345678901234", 10000, "123");
                Cliente cliente = new Cliente("hugo", "Hugo", "M", "12348765", "12345678901", 100, "123");
                empresas.add(empresa);
                clientes.add(cliente);
            } else if (op == 0) {
                System.out.println("ENCERRANDO...");
            } else {
                System.out.println("Opção inválida...");
                throw new IllegalAccessException("");
            }
        } while (op != 0);
    }

    public static void menuInicial() {
        System.out.println("Menu");
        System.out.println("Deseja iniciar sessão como cliente ou empresa?");
        System.out.println("[1] para cliente");
        System.out.println("[2] para empresa");
        System.out.println("[0] para encerrar");
        System.out.print("Digite:");
    }

    public static void menuCL() {// Menu cadastro ou login
        System.out.println("");
        System.out.println("Deseja logar ou cadastrar?");
        System.out.println("[1] para logar");
        System.out.println("[2] para cadastrar");
        System.out.println("[0] para voltar");
        System.out.print("Digite:");
    }

    public static void menuClienteAmigo() {
        System.out.println("");
        System.out.println("Menu");
        System.out.println("[1] para adicionar um amigo");
        System.out.println("[2] para remover um amigo");
        System.out.println("[3] para mostrar amigos");
        System.out.println("[0] para Voltar!");
    }

    public static void menuAlterarDadosCliente() {
        Scanner in = new Scanner(System.in);
        int opADC;
        System.out.println("");
        System.out.println("Digite os dados abaixo para alteração de dados do perfil");
        System.out.print("Nome: ");
        String nome = in.next();
        System.out.print("Senha: ");
        String senha = in.next();
        System.out.println("");
        boolean vf = buscaLoginCliente(nome, senha);
        if (vf == true) {
            for (int i = 0; i < clientes.size(); i++) {
                Cliente aux = clientes.get(i);
                if (aux.getNome().equalsIgnoreCase(nome) && aux.getSenha().equals(senha)) {
                    System.out.println("Opções: ");
                    System.out.println("[1] para alterar seu nome");
                    System.out.println("[2] para alterar seu genero");
                    System.out.println("[3] para alterar seu telefone");
                    System.out.println("[4] para alterar seu cpf");
                    System.out.println("[0] para Voltar!");
                    System.out.print("Digite: ");
                    opADC = in.nextInt();
                    if (opADC == 1) {
                        // alterar nome
                        System.out.print("Digite seu novo nome: ");
                        String newNome = in.next();
                        aux.setNome(newNome);
                    } else if (opADC == 2) {
                        // alterar genero
                        System.out.print("Digite seu novo gênero: ");
                        String newGen = in.next();
                        aux.setGenero(newGen);
                    } else if (opADC == 3) {
                        // alterar telefone
                        System.out.print("Digite apenas o DDD: ");
                        String ddd = in.next();
                        while (ddd.length() < 2 || ddd.length() > 3) {
                            System.out.print("DDD inválido digite novamente: ");
                            ddd = in.next();
                        }
                        System.out.print("Digite o seu número de celular: ");
                        String num = in.next();
                        while (num.length() < 8 || num.length() > 10) {
                            System.out.print("Número inválido digite novamente: ");
                            ddd = in.next();
                        }
                        String newNum = "(" + ddd + ")" + num;
                        aux.setTelefone(newNum);
                    } else if (opADC == 4) {
                        // alterar cpf
                        System.out.print("Digite seu novo CPF: ");
                        String newCPF = in.next();
                        while (newCPF.length() != 11) {// CPF tem que ter 11 digitos
                            System.out.print("CPF incorreto, digite novamente (apenas números): ");
                            newCPF = in.next();
                        }
                        aux.setGenero(newCPF);
                    } else {
                        opADC = 0;
                    }
                }
            }
        } else {
            System.out.println("");
            System.out.println("Nome ou senha incorretos... Tente novamente.");
            System.out.println("");
            opADC = 0;
        }
    }

    public static void compraProduto() {
        // onde tiver getFirst mudar para uma busca
        Scanner in = new Scanner(System.in);
        boolean vf;
        int op = 0;
        System.out.println("");
        System.out.println("Digite os dados abaixo para realizar uma compra.");
        System.out.print("Nome: ");
        String nome = in.next();
        System.out.print("Senha: ");
        String senha = in.next();
        System.out.println("");
        boolean v = buscaLoginCliente(nome, senha);
        if (v == true) {
            for (int i = 0; i < clientes.size(); i++) {
                Cliente aux = clientes.get(i);
                if (aux.getNome().equalsIgnoreCase(nome) && aux.getSenha().equals(senha)) {
                    do {
                        empresas.getFirst().showProdutos();
                        System.out.println("");
                        System.out.print("Digite o codigo do produto que deseja comprar: ");
                        String code = in.next();
                        vf = buscaProduto(code);
                        if (vf == true) {
                            int t = 0;
                            Produto p = empresas.getFirst().produtos.get(t);
                            for (t = 0; t < Empresa.produtos.size(); t++) {
                                p = Empresa.produtos.get(t);
                                if (p.getCodigo().equalsIgnoreCase(code)) {
                                    break;
                                }
                            }
                            if (aux.getToken() >= p.getPreco()) {
                                Empresa.produtos.getFirst().retirarEstoque(1);
                                aux.setToken(aux.getToken() - p.getPreco());
                                System.out.println("saldo atual: " + aux.getToken());
                            } else {
                                System.out.println("");
                                System.out.println("Saldo insuficiente... deposite tokens para futuras compras.");
                                System.out.println("");
                            }
                        } else {
                            System.out.println("");
                            System.out.println("Código informado inválido... Deseja tentar novamente?");
                            System.out.println("[0] para Não / [1] para Sim.");
                            System.out.print("Digite: ");
                            op = in.nextInt();
                        }

                    } while (op != 0);
                }
            }
        } else {
            System.out.println("");
            System.out.println("Nome ou senha incorretos... deseja tentar novamente?");
            System.out.println("[0] para Não / [1] para Sim.");
            int opc = in.nextInt();
            if (opc == 1) {
                compraProduto();
            } else {
                System.out.println("");
            }
        }
    }

    public static void compraToken() {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Digite os dados abaixo para confirmação de compra de tokens");
        System.out.print("Nome: ");
        String nome = in.next();
        System.out.print("Senha: ");
        String senha = in.next();
        System.out.println("");
        boolean vf = buscaLoginCliente(nome, senha);
        if (vf == true) {
            System.out.print("Informe a quantia que deseja depositar: ");
            int newToken = in.nextInt();
            for (int i = 0; i < clientes.size(); i++) {
                Cliente aux = clientes.get(i);
                if (aux.getNome().equalsIgnoreCase(nome) && aux.getSenha().equals(senha)) {
                    aux.setToken(aux.getToken() + newToken);
                    System.out.print("Saldo de Tokens atual");
                    System.out.print(aux.getToken());
                }
            }
        }
    }

    public static void opcaoEmpresa() {
        System.out.println("");
        System.out.println("Menu");
        System.out.println("[1] para adicionar um novo produto.");
        System.out.println("[2] para alterar seus dados.");
        System.out.println("[3] para exibir saldo.");
        System.out.println("[0] para Sair!");
    }

    public static void exibirSaldo() {
        System.out.println("");
        System.out.println("[ R$" + empresas.getFirst().getSaldo() + " ]");
        System.out.println("");
    }

    public static void menuAlterarDadosEmpresa() {
        Scanner in = new Scanner(System.in);
        int opADC;
        System.out.println("");
        System.out.println("Digite os dados abaixo para alteração de dados do perfil");
        System.out.print("CNPJ: ");
        String cnpj = in.next();
        System.out.print("senha: ");
        String senha = in.next();
        System.out.println("");
        boolean vf = buscaLoginEmpresa(cnpj, senha);
        if (vf == true) {
            for (int i = 0; i < empresas.size(); i++) {
                Empresa aux = empresas.get(i);
                if (aux.getCnpj().equalsIgnoreCase(cnpj) && aux.getSenha().equals(senha)) {
                    System.out.println("Opções: ");
                    System.out.println("[1] para alterar seu nome");
                    System.out.println("[2] para alterar seu cnpj");
                    System.out.println("[3] para alterar seu telefone");
                    System.out.println("[0] para Voltar!");
                    System.out.print("Digite: ");
                    opADC = in.nextInt();
                    if (opADC == 1) {
                        // alterar nome
                        System.out.print("Digite seu novo nome: ");
                        String newNome = in.next();
                        aux.setNome(newNome);
                    } else if (opADC == 2) {
                        // alterar genero
                        System.out.print("Digite seu novo cnpj: ");
                        String newCnpj = in.next();
                        aux.setCnpj(newCnpj);
                    } else if (opADC == 3) {
                        // alterar telefone
                        System.out.print("Digite apenas o DDD: ");
                        String ddd = in.next();
                        while (ddd.length() < 2 || ddd.length() > 3) {
                            System.out.print("DDD inválido digite novamente: ");
                            ddd = in.next();
                        }
                        System.out.print("Digite o seu número de celular: ");
                        String num = in.next();
                        while (num.length() < 8 || num.length() > 10) {
                            System.out.print("Número inválido digite novamente: ");
                            ddd = in.next();
                        }
                        String newNum = "(" + ddd + ")" + num;
                        aux.setTelefone(newNum);
                    } else {
                        opADC = 0;
                    }
                }
            }
        } else {
            System.out.println("");
            System.out.println("CNPJ ou senha incorretos... Tente novamente.");
            System.out.println("");
            opADC = 0;
        }
    }

    public static void opcaoCliente() {
        System.out.println("");
        System.out.println("Menu");
        System.out.println("[1] para comprar produtos");
        System.out.println("[2] para comprar Tokens");
        System.out.println("[3] para amigos");// criar um novo menu para as opcoes relacionadas aos amigos
        System.out.println("[4] para alterar seus dados");
        System.out.println("[5] para voltar");
        System.out.println("[0] para Sair!");
        System.out.print("Digite:");
    }

    public static boolean loginCliente() {
        Scanner in = new Scanner(System.in);
        boolean retorno;
        do {
            System.out.println("");
            System.out.println("Digite");
            System.out.print("Nome: ");
            String nome = in.next();
            System.out.print("Senha: ");
            String senha = in.next();
            retorno = buscaLoginCliente(nome, senha);
            if (retorno == false) {// Aqui ele da a escolha para tentar fazer login novamente
                System.out.println("");
                System.out.println("Login inválido... Deseja tentar denovo?");
                System.out.println("Digite [1] para sim,[2] para nÃ£o: ");
                int a = in.nextInt();
                if (a == 2) {
                    break;
                }
            }
        } while (retorno != true);
        return retorno;
    }

    public static void cadastroCliente() {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.print("Informe seu nome: ");
        String nome = in.nextLine();

        System.out.print("Informe seu CPF (apenas números): ");
        String cpf = in.next();
        while (cpf.length() != 11) {// CPF tem que ter 11 digitos
            System.out.print("CPF incorreto, digite novamente (apenas números): ");// CPF 11 DIGITOS PARA TEST
            cpf = in.next();
        }

        System.out.print("Informe seu DDD: ");
        String ddd = in.next();
        while (ddd.length() < 2 || ddd.length() > 3) {
            System.out.print("DDD inválido digite novamente: ");
            ddd = in.next();
        }
        System.out.print("Informe seu númmero de telefone: ");
        String numc = in.next();
        while (numc.length() < 8 || numc.length() > 10) {
            System.out.print("Número inválido digite novamente: ");
            numc = in.next();
        }
        String telefone = "(" + ddd + ")" + numc;

        System.out.print("Informe seu gênero: ");
        String genero = in.next();

        System.out.print("Crie um Code para adicionar amigos: ");
        String code = in.next();

        System.out.print("Informe uma senha: ");
        String senha = in.next();

        System.out.print("Informe a quantia que deseja depositar para compras no App: ");
        int token = in.nextInt();

        boolean cd = verificarCD(cpf, senha);// verificando se jÃ¡ existe conta utilizando esse cpf ou senha
        if (cd == false) {
            Cliente cliente = new Cliente(code, nome, genero, telefone, cpf, token, senha);// Criou novo cliente
            clientes.add(cliente);// adicionou novo cliente a lista
            System.out.println("Conta criada com sucesso! Seja bem-vindo " + nome);
            System.out.println("");
        } else {
            System.out.println("CPF ou Senha já existente. Conta nÃ£o criada...");
            System.out.println("");
        }
    }

    public static boolean buscaLoginCliente(String nome, String senha) {
        // Metodo para buscar na lista de cliente para fazer login
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = clientes.get(i);
            if (aux.getNome().equalsIgnoreCase(nome) && aux.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public static boolean buscaProduto(String codigo) {
        // Metodo para buscar na lista de cliente para fazer login
        for (int i = 0; i < Empresa.produtos.size(); i++) {
            Produto aux = Empresa.produtos.get(i);
            if (aux.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarCD(String cpf, String senha) {

        // Metodo para buscar cliente ja existente
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = clientes.get(i);
            if (aux.getCpf().equals(cpf) && aux.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public static void cadastroProduto() {

        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.print("Informe o nome do produto que deseja vender: ");
        String nome = in.next();

        System.out.print("Informe a quantidade de produto que deseja vender: ");
        int estoque = in.nextInt();

        System.out.print("Informe o preço do produto que deseja vender: ");
        int preco = in.nextInt();

        System.out.print("digite o codigo para o produto: ");
        String codigo = in.next();
        // Criou um novo produto
        Empresa.cadastrarProduto(nome, preco, codigo, estoque);
        System.out.println("");
        System.out.println("Produto Cadastrado Com Sucesso!");

    }

    public static boolean loginEmpresa() {
        Scanner in = new Scanner(System.in);
        boolean retorno;
        do {
            System.out.println("");
            System.out.println("Digite");
            System.out.print("CNPJ: ");
            String cnpj = in.next();
            System.out.print("Senha: ");
            String senha = in.next();
            retorno = buscaLoginEmpresa(cnpj, senha);
            if (retorno == false) {// Aqui ele da a escolha para tentar fazer login novamente
                System.out.println("");
                System.out.println("Login inválido... Deseja tentar denovo?");
                System.out.println("Digite [1] para sim,[2] para nÃ£o: ");
                int a = in.nextInt();
                if (a == 2) {
                    break;
                }
            }
        } while (retorno != true);
        return retorno;
    }

    public static void cadastroEmpresa() {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.print("Informe o nome da empresa: ");
        String nome = in.next();

        System.out.print("Informe o CNPJ da empresa (apenas números): ");
        String cnpj = in.next();
        while (cnpj.length() != 14) {// CNPJ tem que ter 14 digitos
            System.out.print("CNPJ incorreto, digite novamente (apenas nÃºmeros, 14 numeros): ");
            cnpj = in.next();
        }

        System.out.print("Informe o DDD: ");
        String ddd = in.next();
        System.out.print("Informe o número de telefone: ");
        String numc = in.next();
        String telefone = "(" + ddd + ")" + numc;

        System.out.print("Informe o saldo da empresa: ");
        double saldo = in.nextDouble();

        System.out.print("Informe uma senha: ");
        String senha = in.next();

        Empresa empresa = new Empresa(nome, telefone, cnpj, saldo, senha);// Criou nova empresa
        empresas.add(empresa);// Adiciona a lista de empresas
        System.out.println("");
        System.out.println("Empresa cadastrada com sucesso!");

    }

    public static boolean buscaLoginEmpresa(String cnpj, String senha) {
        /*
         * Metodo para buscar na lista de empresa para fazer login
         * (Apesar de apenas ter uma empresa criando a lista facilita)
         */
        for (int i = 0; i < empresas.size(); i++) {
            Empresa aux = empresas.get(i);
            if (aux.getCnpj().equals(cnpj) && aux.getSenha().equals(senha)) {
                return true;
            }
        }
        return true;
    }

    public static boolean buscaLoginCode(String code) {
        // Metodo para buscar na lista de cliente para fazer login
        for (int i = 0; i < clientes.size(); i++) {
            Cliente aux = clientes.get(i);
            if (aux.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}