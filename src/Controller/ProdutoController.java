package controller;

import model.Pizza;
import model.Produto;
import model.Salgado;
import util.FileUtil;

import java.util.List;

public class ProdutoController {
    public static void cadastrarProduto(String tipo, String nome, double preco, String descricao) {
        Produto produto;
        if (tipo.equals("Pizza")) {
            produto = new Pizza(nome, preco, descricao);
            FileUtil.saveProduto(produto, "Pizza");
        } else {
            produto = new Salgado(nome, preco, descricao);
            FileUtil.saveProduto(produto, "Salgado");
        }
    }

    public static List<Produto> listarProdutos(String tipo) {
        return FileUtil.loadProdutos(tipo);
    }
}
