import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login extends JFrame{
    JLabel labusername = new JLabel("Username");
    JLabel labpassword = new JLabel("Password");
    JLabel lablogin = new JLabel("Belum memiliki akun?");

    public JTextField tfusername = new JTextField();
    public JTextField tfpassword = new JTextField();

    public JButton btnLogin = new JButton("Login");
    public JButton btnRegister = new JButton("Register");

    public Login(){
        setTitle("Login");
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);

        //add label
        add(labusername);
        add(labpassword);
        add(lablogin);

        //add textfield
        add(tfusername);
        add(tfpassword);

        //add button
        add(btnLogin);
        add(btnRegister);

        //setBounds(int x-coordinate, int y-coordinate, int width, int height)
        //label
        labusername.setBounds(80, 20, 120, 25);
        labpassword.setBounds(80, 45, 120, 25);
        lablogin.setBounds(80, 120, 150, 25);

        //textfield
        tfusername.setBounds(200, 25, 120, 20);
        tfpassword.setBounds(200, 50, 120, 20);

        //button
        btnRegister.setBounds(220, 120, 103, 25);
        btnLogin.setBounds(80, 80, 245, 25);

    }
    public String getUsername(){
        return tfusername.getText();
    }

    public String getPassword() {
        return tfpassword.getText();
    }
}
