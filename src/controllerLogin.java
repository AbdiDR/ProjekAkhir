import javax.swing.*;
import java.awt.event.*;

public class controllerLogin extends JFrame{
    modelLogin model;
    Login login;


    public controllerLogin(Login login, modelLogin model) {
        this.model = model;
        this.login = login;

        login.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = login.getUsername();
                String password = login.getPassword();
                model.Login(username, password);

            }
        });

        login.btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = login.getUsername();
                String password = login.getPassword();

                JLabel labkode = new JLabel("Kode: ");
                JTextField tfkode = new JTextField();
                JButton btnenter = new JButton("Enter");
                setTitle("Register");
                setSize(400, 200);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setLocationRelativeTo(null);
                setVisible(true);
                setResizable(false);
                setLayout(null);

                add(labkode);
                add(tfkode);
                add(btnenter);

                labkode.setBounds(80, 20, 120, 25);
                tfkode.setBounds(200, 25, 120, 20);
                btnenter.setBounds(80, 80, 245, 25);

                JOptionPane.showMessageDialog(null, "Masukkan kode keamanan");
                btnenter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        String kode = tfkode.getText();
                        model.Kode(username, password, kode);
                        Login login = new Login();
                        modelLogin model = new modelLogin();
                        controllerLogin con = new controllerLogin(login, model);
                    }
                });
            }
        });
    }
}
