package P3.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import P3.code.controller.Cliente;
import P3.code.controller.Menus;

public class CadastroClienteFrame extends JFrame {
    private MainFrame mainFrame;

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    private JTextField nomeClienteField;
    private JTextField cpfField;
    private JTextField senhaField;

    public CadastroClienteFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;

        setTitle("Cadastro de Cliente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(mainFrame);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel nomeClienteLabel = new JLabel("Nome do Cliente:");
        JLabel cpfLabel = new JLabel("CPF:");
        JLabel senhaLabel = new JLabel("Senha:");
        nomeClienteField = new JTextField();
        cpfField = new JTextField();
        senhaField = new JTextField();
        JButton cadastrarButton = new JButton("Cadastrar");
        mainPanel.add(nomeClienteLabel);
        mainPanel.add(nomeClienteField);
        mainPanel.add(cpfLabel);
        mainPanel.add(cpfField);
        mainPanel.add(senhaLabel);
        mainPanel.add(senhaField);
        mainPanel.add(cadastrarButton);
        add(mainPanel);
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });
    }

    private void cadastrarCliente() {
        String nomeCliente = nomeClienteField.getText();
        String cpf = cpfField.getText();
        String senha = senhaField.getText();

        Cliente cliente = new Cliente(nomeCliente, cpf, senha);
        Menus.clientes.add(cliente);

        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
        dispose();
    }
}
