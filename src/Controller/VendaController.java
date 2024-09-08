package controller;

import java.util.ArrayList;
import model.Produto;
import util.FileUtil;

import java.util.List;
import view.VendaView;

public class VendaController {
    public static void efetuarVenda(String nomeProduto, int quantidade) {
        List<Produto> pizzas = FileUtil.loadProdutos("Pizza");
        List<Produto> salgados = FileUtil.loadProdutos("Salgado");

        List<Produto> produtos = new ArrayList<>();
        produtos.addAll(pizzas);
        produtos.addAll(salgados);

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) {
                // Lógica para realizar a venda (estoque, etc.)
                if (produto instanceof model.Pizza) {
                    FileUtil.saveProdutos(pizzas, "Pizza");
                } else {
                    FileUtil.saveProdutos(salgados, "Salgado");
                }
                break;
            }
        }
    }

    public VendaController(VendaView vendaView, List<Produto> produtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
