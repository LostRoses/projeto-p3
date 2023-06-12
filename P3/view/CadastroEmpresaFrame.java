package P3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import P3.code.controller.Empresa;
import P3.code.controller.Menus;

public class CadastroEmpresaFrame extends JFrame {
    private MainFrame mainFrame;
    private JTextField nomeEmpresaField;
    private JTextField cnpjField;

    public CadastroEmpresaFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setTitle("Cadastro de Empresa");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(mainFrame);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel nomeEmpresaLabel = new JLabel("Nome da Empresa:");
        JLabel cnpjLabel = new JLabel("CNPJ:");

        nomeEmpresaField = new JTextField();
        cnpjField = new JTextField();

        JButton cadastrarButton = new JButton("Cadastrar");

        mainPanel.add(nomeEmpresaLabel);
        mainPanel.add(nomeEmpresaField);
        mainPanel.add(cnpjLabel);
        mainPanel.add(cnpjField);
        mainPanel.add(cadastrarButton);

        add(mainPanel);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarEmpresa();
            }
        });
    }

    private void cadastrarEmpresa() {
        String nomeEmpresa = nomeEmpresaField.getText();
        String cnpj = cnpjField.getText();

        Empresa empresa = new Empresa(nomeEmpresa, cnpj);
        Menus.empresas.add(empresa);

        mainFrame.getProdutosCadastrados().add(rootPane, empresa.toString());

        JOptionPane.showMessageDialog(this, "Empresa cadastrada com sucesso!");
        dispose();
    }
}
