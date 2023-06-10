package P3.view;

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
import P3.code.controller.Produto;

public class MainFrame extends JFrame {

    private JButton clienteButton;
    private JButton empresaButton;

    public MainFrame() {
        setTitle("Menu Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Painel de botões
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
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

    private void abrirCadastroCliente() {
        JFrame clienteFrame = new JFrame("Cadastro de Cliente");
        clienteFrame.setSize(400, 300);
        clienteFrame.setLocationRelativeTo(null);
        clienteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel clientePanel = new JPanel();
        clientePanel.setLayout(new GridLayout(7, 2, 10, 10));

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
                abrirCompraProduto(cliente);
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
        empresaPanel.setLayout(new GridLayout(7, 2, 10, 10));

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
                abrirCadastroProduto(empresa);
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

    private void abrirCadastroProduto(Empresa empresa) {
        JFrame produtoFrame = new JFrame("Cadastro de Produto");
        produtoFrame.setSize(400, 300);
        produtoFrame.setLocationRelativeTo(null);
        produtoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel produtoPanel = new JPanel();
        produtoPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel precoLabel = new JLabel("Preço:");
        JTextField precoField = new JTextField();

        JLabel codigoLabel = new JLabel("Código:");
        JTextField codigoField = new JTextField();

        JLabel estoqueLabel = new JLabel("Estoque:");
        JTextField estoqueField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                int preco = Integer.parseInt(precoField.getText());
                String codigo = codigoField.getText();
                int estoque = Integer.parseInt(estoqueField.getText());

                final Produto produto = new Produto(codigo, estoque, codigo, estoque);
                empresa.buscarProduto(produto);

                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

                produtoFrame.dispose();
            }
        });

        produtoPanel.add(nomeLabel);
        produtoPanel.add(nomeField);
        produtoPanel.add(precoLabel);
        produtoPanel.add(precoField);
        produtoPanel.add(codigoLabel);
        produtoPanel.add(codigoField);
        produtoPanel.add(estoqueLabel);
        produtoPanel.add(estoqueField);
        produtoPanel.add(cadastrarButton);

        produtoFrame.add(produtoPanel);
        produtoFrame.setVisible(true);
    }

    private void abrirCompraProduto(Cliente cliente) {
        JFrame compraFrame = new JFrame("Compra de Produto");
        compraFrame.setSize(400, 200);
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

                cliente.comprarProduto(codigo, quantidade);

                JOptionPane.showMessageDialog(null, "Compra realizada com sucesso!");

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}