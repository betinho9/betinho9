package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal() {
        setTitle("ELL GREGO - Sistema de Gestão");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(41, 128, 185)); // Azul

        // Menu Pizzas
        JMenu menuPizzas = new JMenu("Pizzas");
        menuPizzas.setForeground(Color.WHITE);

        JMenuItem itemCadastrarPizza = new JMenuItem("Cadastrar Pizza");
        JMenuItem itemListarPizzas = new JMenuItem("Listar Pizzas");

        itemCadastrarPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroProduto("Pizza").setVisible(true);
            }
        });

        itemListarPizzas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaListarProdutos("Pizza").setVisible(true);
            }
        });

        menuPizzas.add(itemCadastrarPizza);
        menuPizzas.add(itemListarPizzas);

        // Menu Salgados
        JMenu menuSalgados = new JMenu("Salgados");
        menuSalgados.setForeground(Color.WHITE);

        JMenuItem itemCadastrarSalgado = new JMenuItem("Cadastrar Salgado");
        JMenuItem itemListarSalgados = new JMenuItem("Listar Salgados");

        itemCadastrarSalgado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastroProduto("Salgado").setVisible(true);
            }
        });

        itemListarSalgados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaListarProdutos("Salgado").setVisible(true);
            }
        });

        menuSalgados.add(itemCadastrarSalgado);
        menuSalgados.add(itemListarSalgados);

        // Menu Vendas
        JMenu menuVendas = new JMenu("Vendas");
        menuVendas.setForeground(Color.WHITE);

        JMenuItem itemNovaVenda = new JMenuItem("Nova Venda");

        itemNovaVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaVenda().setVisible(true);
            }
        });

        menuVendas.add(itemNovaVenda);

        // Adiciona menus à barra de menus
        menuBar.add(menuPizzas);
        menuBar.add(menuSalgados);
        menuBar.add(menuVendas);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}

