package controller;

import model.Usuario;
import util.FileUtil;

import java.util.List;
import view.LoginView;
import view.MenuView;

public class LoginController {
    private static final String USER_FILE = "users.dat";
    private List<Usuario> usuarios;

    public LoginController() {
        usuarios = FileUtil.readFromFile(USER_FILE);
    }

    public LoginController(LoginView loginView, MenuView menuView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LoginController(LoginView loginView, MenuView menuView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LoginController(LoginView loginView, MenuView menuView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LoginController(LoginView loginView, MenuView menuView) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean autenticar(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
