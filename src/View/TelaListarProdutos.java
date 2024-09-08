package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ProdutoController;
import model.Produto;

import java.awt.*;
import java.util.List;

public class TelaListarProdutos extends JFrame {
    private JTable table;
    private String tipoProduto;

    public TelaListarProdutos(String tipoProduto) {
        this.tipoProduto = tipoProduto;
        setTitle("Listar " + tipoProduto + "s");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Nome", "Preço", "Descrição"}, 0);
        table = new JTable(model);
        List<Produto> produtos = ProdutoController.listarProdutos(tipoProduto);

        for (Produto produto : produtos) {
            model.addRow(new Object[]{produto.getNome(), produto.getPreco(), produto.getDescricao()});
        }

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
