package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuPrincipal extends JFrame {
    private JButton btnCadastrarProduto;
    private JButton btnEfetuarVenda;

    public TelaMenuPrincipal() {
        setTitle("Menu Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnCadastrarProduto = new JButton("Cadastrar Produto");
        btnEfetuarVenda = new JButton("Efetuar Venda");

        setLayout(new java.awt.GridLayout(2, 1));
        add(btnCadastrarProduto);
        add(btnEfetuarVenda);

        btnCadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroProduto().setVisible(true);
            }
        });

        btnEfetuarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaVenda().setVisible(true);
            }
        });
    }
}
