package Controller;

import controller.ProdutoController;
import model.Pizza;
import model.Salgado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Ell Grego - Menu Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(173, 216, 230));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton cadastrarPizzaButton = new JButton("Cadastrar Pizza");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(cadastrarPizzaButton, gbc);

        JButton cadastrarSalgadoButton = new JButton("Cadastrar Salgado");
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(cadastrarSalgadoButton, gbc);

        JButton listarPizzasButton = new JButton("Listar Pizzas");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(listarPizzasButton, gbc);

        JButton listarSalgadosButton = new JButton("Listar Salgados");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(listarSalgadosButton, gbc);

        JButton efetuarVendaButton = new JButton("Efetuar Venda");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(efetuarVendaButton, gbc);

        cadastrarPizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome da Pizza:");
                String precoStr = JOptionPane.showInputDialog("Preço da Pizza:");
                String descricao = JOptionPane.showInputDialog("Descrição da Pizza:");

                double preco = Double.parseDouble(precoStr);
                ProdutoController.cadastrarProduto("Pizza", nome, preco, descricao);
                JOptionPane.showMessageDialog(null, "Pizza cadastrada com sucesso!");
            }
        });

        cadastrarSalgadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Salgado:");
                String precoStr = JOptionPane.showInputDialog("Preço do Salgado:");
                String descricao = JOptionPane.showInputDialog("Descrição do Salgado:");

                double preco = Double.parseDouble(precoStr);
                ProdutoController.cadastrarProduto("Salgado", nome, preco, descricao);
                JOptionPane.showMessageDialog(null, "Salgado cadastrado com sucesso!");
            }
        });

        listarPizzasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<model.Produto> pizzas = ProdutoController.listarProdutos("Pizza");
                StringBuilder sb = new StringBuilder("Pizzas:\n");
                for (model.Produto pizza : pizzas) {
                    sb.append(pizza.getNome()).append(" - ").append(pizza.getPreco()).append(" - ").append(pizza.getDescricao()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        listarSalgadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List<model.Produto> salgados = ProdutoController.listarProdutos("Salgado");
                StringBuilder sb = new StringBuilder("Salgados:\n");
                for (model.Produto salgado : salgados) {
                    sb.append(salgado.getNome()).append(" - ").append(salgado.getPreco()).append(" - ").append(salgado.getDescricao()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        efetuarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProduto = JOptionPane.showInputDialog("Nome do Produto para Venda:");
                String quantidadeStr = JOptionPane.showInputDialog("Quantidade:");

                int quantidade = Integer.parseInt(quantidadeStr);
                controller.VendaController.efetuarVenda(nomeProduto, quantidade);
                JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
