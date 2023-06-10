package P3.code.controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import P3.code.controller.Cliente;
import P3.code.controller.Empresa;
import P3.code.controller.Menus;

public class Produto extends JFrame {

    private JButton clienteButton;
    private JButton empresaButton;
    private String nome;
    private int preco;
    private String codigo;
    private int estoque;

    public Produto() {
        setTitle("Menu Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Painel de botões
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        clienteButton = new JButton("Cliente");
        empresaButton = new JButton("Empresa");
        buttonPanel.add(clienteButton);
        buttonPanel.add(empresaButton);

        // Adiciona o painel de botões ao painel principal
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Adiciona o painel principal ao frame
        add(mainPanel);

        // Define os listeners dos botões
        clienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroCliente();
            }
        });

        empresaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroEmpresa();
            }
        });
    }

    public Produto(String nome, int preco, String codigo, int estoque) {
    }

    private void abrirCadastroCliente() {
        JFrame clienteFrame = new JFrame("Cadastro de Cliente");
        clienteFrame.setSize(400, 300);
        clienteFrame.setLocationRelativeTo(null);
        clienteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel clientePanel = new JPanel();
        clientePanel.setLayout(new GridLayout(10, 4, 6, 6));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField();

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField();

        JLabel generoLabel = new JLabel("Gênero:");
        JTextField generoField = new JTextField();

        JLabel codeLabel = new JLabel("Code de Amigos:");
        JTextField codeField = new JTextField();

        JLabel senhaLabel = new JLabel("Senha:");
        JTextField senhaField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String telefone = telefoneField.getText();
                String genero = generoField.getText();
                String code = codeField.getText();
                String senha = senhaField.getText();

                Cliente cliente = new Cliente(code, nome, genero, telefone, cpf, 0, senha);
                Menus.clientes.add(cliente);

                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

                clienteFrame.dispose();
            }
        });

        clientePanel.add(nomeLabel);
        clientePanel.add(nomeField);
        clientePanel.add(cpfLabel);
        clientePanel.add(cpfField);
        clientePanel.add(telefoneLabel);
        clientePanel.add(telefoneField);
        clientePanel.add(generoLabel);
        clientePanel.add(generoField);
        clientePanel.add(codeLabel);
        clientePanel.add(codeField);
        clientePanel.add(senhaLabel);
        clientePanel.add(senhaField);
        clientePanel.add(cadastrarButton);

        clienteFrame.add(clientePanel);
        clienteFrame.setVisible(true);
    }

    private void abrirCadastroEmpresa() {
        JFrame empresaFrame = new JFrame("Cadastro de Empresa");
        empresaFrame.setSize(400, 300);
        empresaFrame.setLocationRelativeTo(null);
        empresaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel empresaPanel = new JPanel();
        empresaPanel.setLayout(new GridLayout(10, 4, 6, 6));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel cnpjLabel = new JLabel("CNPJ:");
        JTextField cnpjField = new JTextField();

        JLabel telefoneLabel = new JLabel("Telefone:");
        JTextField telefoneField = new JTextField();

        JLabel saldoLabel = new JLabel("Saldo:");
        JTextField saldoField = new JTextField();

        JLabel senhaLabel = new JLabel("Senha:");
        JTextField senhaField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cnpj = cnpjField.getText();
                String telefone = telefoneField.getText();
                double saldo = Double.parseDouble(saldoField.getText());
                String senha = senhaField.getText();

                Empresa empresa = new Empresa(nome, telefone, cnpj, saldo, senha);
                Menus.empresas.add(empresa);

                JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!");

                empresaFrame.dispose();
            }
        });

        empresaPanel.add(nomeLabel);
        empresaPanel.add(nomeField);
        empresaPanel.add(cnpjLabel);
        empresaPanel.add(cnpjField);
        empresaPanel.add(telefoneLabel);
        empresaPanel.add(telefoneField);
        empresaPanel.add(saldoLabel);
        empresaPanel.add(saldoField);
        empresaPanel.add(senhaLabel);
        empresaPanel.add(senhaField);
        empresaPanel.add(cadastrarButton);

        empresaFrame.add(empresaPanel);
        empresaFrame.setVisible(true);
    }

    private void abrirCompraProduto(Cliente cliente) {
        JFrame compraFrame = new JFrame("Compra de Produto");
        compraFrame.setSize(400, 300);
        compraFrame.setLocationRelativeTo(null);
        compraFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel compraPanel = new JPanel();
        compraPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel codigoLabel = new JLabel("Código do Produto:");
        JTextField codigoField = new JTextField();

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        JTextField quantidadeField = new JTextField();

        JButton comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());

                boolean produtoEncontrado = false;
                for (Empresa empresa : Menus.empresas) {
                    final Produto produto = empresa.buscarProduto(codigo);
                    if (produto != null) {
                        if (produto.getEstoque() >= quantidade) {
                            produto.retirarEstoque(quantidade);
                            cliente.comprarProduto(produto, quantidade);
                            JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");
                            produtoEncontrado = true;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Estoque indisponível!");
                            produtoEncontrado = true;
                            break;
                        }
                    }
                }

                if (!produtoEncontrado) {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                }

                compraFrame.dispose();
            }
        });

        compraPanel.add(codigoLabel);
        compraPanel.add(codigoField);
        compraPanel.add(quantidadeLabel);
        compraPanel.add(quantidadeField);
        compraPanel.add(comprarButton);

        compraFrame.add(compraPanel);
        compraFrame.setVisible(true);
    }

    public void retirarEstoque(int quantidade) {
    }

    public int getEstoque() {
        return this.estoque;
    }

    public static void main(String[] args) throws IllegalAccessException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Produto frame = new Produto();
                frame.setVisible(true);
            }
        });
    }

    public String getCodigo() {
        return this.codigo;
    }

    public int getPreco() {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }
}