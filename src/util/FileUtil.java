package util;

import model.Pizza;
import model.Produto;
import model.Salgado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class FileUtil {
    private static final String PIZZA_FILE_NAME = "pizzas.txt";
    private static final String SALGADO_FILE_NAME = "salgados.txt";

    public static void saveProduto(Produto produto, String tipo) {
        String fileName = tipo.equals("Pizza") ? PIZZA_FILE_NAME : SALGADO_FILE_NAME;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(produto.getNome() + ";" + produto.getPreco() + ";" + produto.getDescricao());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Produto> loadProdutos(String tipo) {
        String fileName = tipo.equals("Pizza") ? PIZZA_FILE_NAME : SALGADO_FILE_NAME;
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String nome = parts[0];
                double preco = Double.parseDouble(parts[1]);
                String descricao = parts[2];

                Produto produto;
                if (tipo.equals("Pizza")) {
                    produto = new Pizza(nome, preco, descricao);
                } else {
                    produto = new Salgado(nome, preco, descricao);
                }
                produtos.add(produto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public static List<Usuario> readFromFile(String USER_FILE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     }

  /*  public static List<Produto> loadProdutos(String pizza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void saveProdutos(List<Produto> pizzas, String pizza) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
*/