package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.ProdutoController;

public class TelaCadastroProduto extends JFrame {
    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextArea txtDescricao;
    private String tipoProduto;

    public TelaCadastroProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
        setTitle("Cadastrar " + tipoProduto);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        JLabel lblPreco = new JLabel("Preço:");
        txtPreco = new JTextField();

        JLabel lblDescricao = new JLabel("Descrição:");
        txtDescricao = new JTextArea(3, 20);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                double preco = Double.parseDouble(txtPreco.getText());
                String descricao = txtDescricao.getText();

                ProdutoController.cadastrarProduto(tipoProduto, nome, preco, descricao);
                JOptionPane.showMessageDialog(null, tipoProduto + " cadastrado com sucesso!");
                dispose();
            }
        });

        panel.add(lblNome);
        panel.add(txtNome);
        panel.add(lblPreco);
        panel.add(txtPreco);
        panel.add(lblDescricao);
        panel.add(new JScrollPane(txtDescricao));
        panel.add(new JLabel());
        panel.add(btnSalvar);

        add(panel, BorderLayout.CENTER);
    }

    TelaCadastroProduto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
