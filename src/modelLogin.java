import javax.swing.*;
import java.sql.*;
public class modelLogin {
    String DBurl      = "jdbc:mysql://localhost/petshop";
    String DBusername = "root";
    String DBpassword = "";
    Connection cn;
    Statement st;

    public modelLogin() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal, " + ex.getMessage());
        }
    }

    public void Login(String username, String password){
        int jmlData=0;
        try {
            String query = "SELECT * FROM `admin` WHERE username = '" + username + "' AND password = '" + password + "'";
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()){
                jmlData++;
            }

            if (jmlData == 0){
                JOptionPane.showMessageDialog(null, "Login GAGAL, akun tidak ada!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                View view = new View();
                modelView model = new modelView();
                controllerView con = new controllerView(model, view);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void Kode(String username, String password, String kode){
        int jmlData=0;

            try {
                String query = "SELECT * FROM `kode` WHERE kode = '" + kode + "'";
                st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next()) {
                    jmlData++;
                }

                if (jmlData == 0) {
                    JOptionPane.showMessageDialog(null, "Kode salah!");
                } else {
                    try {
                        String query2 = "INSERT INTO admin(username, password) VALUES ('" + username + "', '" + password + "')";
                        st = cn.createStatement();
                        st.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null, "Register Berhasil!");

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

    }


}
