package P3.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import P3.code.controller.Cliente;
import P3.code.controller.Empresa;
import P3.code.controller.Menus;

public class MainFrame extends JFrame {

    private JButton cadastrarEmpresaButton;
    private JButton cadastrarClienteButton;
    private JButton cadastrarProdutoButton;
    private JButton comprarProdutoButton;
    private JButton voltarMenuPrincipalButton;

    private List<String> produtosCadastrados;
    private List<String> produtosComprados;

    public MainFrame() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        produtosCadastrados = new ArrayList<String>();
        produtosComprados = new ArrayList<String>();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));

        cadastrarEmpresaButton = new JButton("Cadastrar Empresa");
        cadastrarClienteButton = new JButton("Cadastrar Cliente");
        cadastrarProdutoButton = new JButton("Cadastrar Produto");
        comprarProdutoButton = new JButton("Comprar Produto");
        voltarMenuPrincipalButton = new JButton("Voltar para o Menu Principal");

        mainPanel.add(cadastrarEmpresaButton);
        mainPanel.add(cadastrarClienteButton);
        mainPanel.add(cadastrarProdutoButton);
        mainPanel.add(comprarProdutoButton);
        mainPanel.add(voltarMenuPrincipalButton);

        add(mainPanel);

        cadastrarEmpresaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroEmpresa();
            }
        });

        cadastrarClienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroCliente();
            }
        });

        cadastrarProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirCadastroProduto();
            }
        });

        comprarProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarProduto();
            }
        });

        voltarMenuPrincipalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarMenuPrincipal();
            }
        });
    }

    private void abrirCadastroEmpresa() {
        JFrame cadastroEmpresaFrame = new JFrame("Cadastro de Empresa");
        cadastroEmpresaFrame.setSize(400, 300);
        cadastroEmpresaFrame.setLocationRelativeTo(null);
        cadastroEmpresaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastroEmpresaPanel = new JPanel();
        cadastroEmpresaPanel.setLayout(new GridLayout(5, 2, 10, 10));

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

                cadastroEmpresaFrame.dispose();
            }
        });

        cadastroEmpresaPanel.add(nomeLabel);
        cadastroEmpresaPanel.add(nomeField);
        cadastroEmpresaPanel.add(cnpjLabel);
        cadastroEmpresaPanel.add(cnpjField);
        cadastroEmpresaPanel.add(telefoneLabel);
        cadastroEmpresaPanel.add(telefoneField);
        cadastroEmpresaPanel.add(saldoLabel);
        cadastroEmpresaPanel.add(saldoField);
        cadastroEmpresaPanel.add(senhaLabel);
        cadastroEmpresaPanel.add(senhaField);
        cadastroEmpresaPanel.add(cadastrarButton);

        cadastroEmpresaFrame.add(cadastroEmpresaPanel);
        cadastroEmpresaFrame.setVisible(true);
    }

    private void abrirCadastroCliente() {
        JFrame cadastroClienteFrame = new JFrame("Cadastro de Cliente");
        cadastroClienteFrame.setSize(400, 300);
        cadastroClienteFrame.setLocationRelativeTo(null);
        cadastroClienteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastroClientePanel = new JPanel();
        cadastroClientePanel.setLayout(new GridLayout(6, 2, 10, 10));

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

                cadastroClienteFrame.dispose();
            }
        });

        cadastroClientePanel.add(nomeLabel);
        cadastroClientePanel.add(nomeField);
        cadastroClientePanel.add(cpfLabel);
        cadastroClientePanel.add(cpfField);
        cadastroClientePanel.add(telefoneLabel);
        cadastroClientePanel.add(telefoneField);
        cadastroClientePanel.add(generoLabel);
        cadastroClientePanel.add(generoField);
        cadastroClientePanel.add(codeLabel);
        cadastroClientePanel.add(codeField);
        cadastroClientePanel.add(senhaLabel);
        cadastroClientePanel.add(senhaField);
        cadastroClientePanel.add(cadastrarButton);

        cadastroClienteFrame.add(cadastroClientePanel);
        cadastroClienteFrame.setVisible(true);
    }

    private void abrirCadastroProduto() {
        JFrame cadastroProdutoFrame = new JFrame("Cadastro de Produto");
        cadastroProdutoFrame.setSize(400, 300);
        cadastroProdutoFrame.setLocationRelativeTo(null);
        cadastroProdutoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel cadastroProdutoPanel = new JPanel();
        cadastroProdutoPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();

        JLabel precoLabel = new JLabel("Preço:");
        JTextField precoField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                double preco = Double.parseDouble(precoField.getText());

                produtosCadastrados.add(nome);

                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

                cadastroProdutoFrame.dispose();
            }
        });

        cadastroProdutoPanel.add(nomeLabel);
        cadastroProdutoPanel.add(nomeField);
        cadastroProdutoPanel.add(precoLabel);
        cadastroProdutoPanel.add(precoField);
        cadastroProdutoPanel.add(cadastrarButton);

        cadastroProdutoFrame.add(cadastroProdutoPanel);
        cadastroProdutoFrame.setVisible(true);
    }

    private void comprarProduto() {
        JFrame comprarProdutoFrame = new JFrame("Comprar Produto");
        comprarProdutoFrame.setSize(400, 300);
        comprarProdutoFrame.setLocationRelativeTo(null);
        comprarProdutoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel comprarProdutoPanel = new JPanel();
        comprarProdutoPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel nomeLabel = new JLabel("Nome do Produto:");
        JTextField nomeField = new JTextField();

        JLabel quantidadeLabel = new JLabel("Quantidade:");
        JTextField quantidadeField = new JTextField();

        JButton comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                int quantidade = Integer.parseInt(quantidadeField.getText());

                produtosComprados.add(nome);

                JOptionPane.showMessageDialog(null, quantidade + " unidades do produto compradas com sucesso!");

                comprarProdutoFrame.dispose();
            }
        });

        comprarProdutoPanel.add(nomeLabel);
        comprarProdutoPanel.add(nomeField);
        comprarProdutoPanel.add(quantidadeLabel);
        comprarProdutoPanel.add(quantidadeField);
        comprarProdutoPanel.add(comprarButton);

        comprarProdutoFrame.add(comprarProdutoPanel);
        comprarProdutoFrame.setVisible(true);
    }

    private void voltarMenuPrincipal() {
        this.dispose();
        try {
            Menus.menuPrincipal();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            }
        });
    }
}
