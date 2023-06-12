package P3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import P3.code.controller.Empresa;
import P3.code.controller.Menus;
import P3.code.controller.Produto;

public class CadastroProdutoFrame extends JFrame {
    private MainFrame mainFrame;
    private JTextField nomeProdutoField;
    private JTextField precoField;

    public CadastroProdutoFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setTitle("Cadastro de Produto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(mainFrame);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel nomeProdutoLabel = new JLabel("Nome do Produto:");
        JLabel precoLabel = new JLabel("Preço:");

        nomeProdutoField = new JTextField();
        precoField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");

        mainPanel.add(nomeProdutoLabel);
        mainPanel.add(nomeProdutoField);
        mainPanel.add(precoLabel);
        mainPanel.add(precoField);
        mainPanel.add(cadastrarButton);

        add(mainPanel);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });
    }

    private void cadastrarProduto() {
        String nomeProduto = nomeProdutoField.getText();
        double preco = Double.parseDouble(precoField.getText());

        Produto produto = new Produto(nomeProduto, preco);

        for (Empresa empresa : Menus.empresas) {
            empresa.getProdutos().add(produto);
        }

        mainFrame.getProdutosCadastrados().add(rootPane, produto.toString());

        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        dispose();
    }
}
