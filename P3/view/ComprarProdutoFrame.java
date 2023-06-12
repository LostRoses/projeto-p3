package P3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import P3.code.controller.Cliente;
import P3.code.controller.Empresa;
import P3.code.controller.Menus;
import P3.code.controller.Produto;

public class ComprarProdutoFrame extends JFrame {
    private MainFrame mainFrame;
    private JComboBox<String> empresaComboBox;
    private JComboBox<String> produtoComboBox;
    private ComboBoxPreencher comboBoxPreencher;

    public ComprarProdutoFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.comboBoxPreencher = new ComboBoxPreencher();

        setTitle("Comprar Produto");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(mainFrame);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel empresaLabel = new JLabel("Selecione a Empresa:");
        JLabel produtoLabel = new JLabel("Selecione o Produto:");

        empresaComboBox = new JComboBox<>();
        produtoComboBox = new JComboBox<>();

        JButton comprarButton = new JButton("Comprar");

        mainPanel.add(empresaLabel);
        mainPanel.add(empresaComboBox);
        mainPanel.add(produtoLabel);
        mainPanel.add(produtoComboBox);
        mainPanel.add(comprarButton);

        add(mainPanel);

        comprarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprarProduto();
            }
        });

        preencherComboBoxes();
    }

    private void preencherComboBoxes() {
        comboBoxPreencher.preencherEmpresas(empresaComboBox);
        comboBoxPreencher.preencherProdutos(produtoComboBox, mainFrame.getProdutosCadastrados());
    }

    private void comprarProduto() {
        // Lógica de compra de produtos
    }
}
