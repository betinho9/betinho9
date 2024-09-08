package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JCheckBox chkLembrar;

    public TelaLogin() {
        setTitle("Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel Esquerdo
        JPanel panelEsquerdo = new JPanel();
        panelEsquerdo.setLayout(new GridBagLayout());
        panelEsquerdo.setBackground(new Color(41, 128, 185)); // Azul

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        JLabel lblWelcome = new JLabel("WELCOME");
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 24));
        lblWelcome.setForeground(Color.WHITE);
        panelEsquerdo.add(lblWelcome, gbc);

        gbc.gridy++;
        txtUsuario = new JTextField(15);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 18));
        txtUsuario.setHorizontalAlignment(JTextField.CENTER);
        panelEsquerdo.add(txtUsuario, gbc);

        gbc.gridy++;
        txtSenha = new JPasswordField(15);
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        txtSenha.setHorizontalAlignment(JPasswordField.CENTER);
        panelEsquerdo.add(txtSenha, gbc);

        gbc.gridy++;
        chkLembrar = new JCheckBox("Remember me");
        chkLembrar.setForeground(Color.WHITE);
        chkLembrar.setBackground(new Color(41, 128, 185));
        panelEsquerdo.add(chkLembrar, gbc);

        gbc.gridy++;
        btnEntrar = new JButton("SUBMIT");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setBackground(new Color(46, 204, 113)); // Verde
        btnEntrar.setForeground(Color.WHITE);
        panelEsquerdo.add(btnEntrar, gbc);

        add(panelEsquerdo, BorderLayout.WEST);

        // Painel Direito (com uma imagem ou ilustração)
        JPanel panelDireito = new JPanel();
        panelDireito.setBackground(Color.WHITE);
        panelDireito.setLayout(new BorderLayout());

        JLabel imagemLabel = new JLabel();
        ImageIcon icon = new ImageIcon("/mnt/data/tel.jpeg"); // Substitua pelo caminho correto da imagem
        imagemLabel.setIcon(icon);
        panelDireito.add(imagemLabel, BorderLayout.CENTER);

        add(panelDireito, BorderLayout.CENTER);

        // Evento do botão de login
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (usuario.equals("beto") && senha.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido");
                    new TelaPrincipal().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }
}
