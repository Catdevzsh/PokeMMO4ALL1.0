import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokeMMO extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public PokeMMO() {
        setTitle("Login HUD");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.anchor = GridBagConstraints.WEST;

        // Username Label
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new JLabel("Username:"), constraints);

        // Username Field
        constraints.gridx = 1;
        usernameField = new JTextField(20);
        add(usernameField, constraints);

        // Password Label
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(new JLabel("Password:"), constraints);

        // Password Field
        constraints.gridx = 1;
        passwordField = new JPasswordField(20);
        passwordField.setText("<Saved>");
        add(passwordField, constraints);

        // Forget Password Button
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton forgetPasswordButton = new JButton("Forget Saved Password");
        forgetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
            }
        });
        add(forgetPasswordButton, constraints);

        // Login Button
        constraints.gridy = 3;
        JButton loginButton = new JButton("LOGIN");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Add login logic here
                JOptionPane.showMessageDialog(PokeMMO.this,
                        "Username: " + username + "\nPassword: " + password,
                        "Login Info",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        add(loginButton, constraints);

        setLocationRelativeTo(null); // Center the window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PokeMMO().setVisible(true);
            }
        });
    }
}
