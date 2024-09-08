package view;

import controller.ProdutoController;
import javax.swing.*;
import controller.VendaController;
import model.Produto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaVenda extends JFrame {
    private JComboBox<String> comboProdutos;
    private JTextField txtQuantidade;

    public TelaVenda() {
        setTitle("Nova Venda");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblProduto = new JLabel("Produto:");
        comboProdutos = new JComboBox<>();
        List<Produto> produtos = ProdutoController.listarProdutos("Pizza");
        produtos.addAll(ProdutoController.listarProdutos("Salgado"));

        for (Produto produto : produtos) {
            comboProdutos.addItem(produto.getNome());
        }

        JLabel lblQuantidade = new JLabel("Quantidade:");
        txtQuantidade = new JTextField();

        JButton btnVender = new JButton("Vender");
        btnVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProduto = (String) comboProdutos.getSelectedItem();
                int quantidade = Integer.parseInt(txtQuantidade.getText());

                VendaController.efetuarVenda(nomeProduto, quantidade);
                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                dispose();
            }
        });

        panel.add(lblProduto);
        panel.add(comboProdutos);
        panel.add(lblQuantidade);
        panel.add(txtQuantidade);
        panel.add(new JLabel());
        panel.add(btnVender);

        add(panel, BorderLayout.CENTER);
    }
}
