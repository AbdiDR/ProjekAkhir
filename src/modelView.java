import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class modelView {
    String DBurl      = "jdbc:mysql://localhost/petshop";
    String DBusername = "root";
    String DBpassword = "";
    Connection cn;
    Statement st;

    public modelView() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal, " + ex.getMessage());
        }
    }

    public int getJmlData(){

        int bykData = 0;

        try {
            st = cn.createStatement();
            String querySQL = "SELECT * FROM inventaris";
            ResultSet rs = st.executeQuery(querySQL);

            while (rs.next()){
                bykData++;
            }

            return bykData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    public int getJmlCari(String cari, String pil){

        int bykData = 0;

        try {
            st = cn.createStatement();

            String sql = null;
            if (pil == "kode") {
                sql = "SELECT * FROM inventaris WHERE kode_barang LIKE '%" + cari + "%'";
            } else if (pil == "nama") {
                sql = "SELECT * FROM inventaris WHERE nama_barang LIKE '%" + cari + "%'";
            }else {
                sql = "SELECT * FROM inventaris WHERE kategori LIKE '%" + cari + "%'";
            }
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                bykData++;
            }

            return bykData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public String[][] listData(){

        int bykData = 0;

        try {
            String[][] data = new String[getJmlData()][8];

            String querySQL = "SELECT * FROM inventaris";
            ResultSet rs = st.executeQuery(querySQL);

            while (rs.next()){
                data[bykData][0] = rs.getString("kode_barang");
                data[bykData][1] = rs.getString("nama_barang");
                data[bykData][2] = rs.getString("kategori");
                data[bykData][3] = rs.getString("harga_barang");
                data[bykData][4] = rs.getString("jumlah_barang");
                data[bykData][5] = rs.getString("total_harga");
                data[bykData][6] = rs.getString("tanggal");
                data[bykData][7] = rs.getString("waktu");

                bykData++;
            }

            return data;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void insertData(String kode, String nama, String kategori, String jumlah, String harga, double total){
        int jmlData=0;
        double fharga = Float.parseFloat(harga);
        double fjumlah = Float.parseFloat(jumlah);
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        try {
            String query = "SELECT * FROM inventaris WHERE kode_barang = '" + kode + "'";
            System.out.println(kode + " " + nama + " " + kategori + " " + jumlah + " " + harga + " " + " " + total);
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                jmlData++;
            }

            if (jmlData == 0) {
                query = "INSERT INTO inventaris VALUES('" + kode + "','" + nama + "','" + kategori + "','" + fharga + "','" + fjumlah + "','" + total + "','"+ date +"', '"+ time +"')";
                st = cn.createStatement();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateData(String kode, String nama, String kategori, String jumlah, String harga, double total){
        int jmlData = 0;
        double fharga = Float.parseFloat(harga);
        double fjumlah = Float.parseFloat(jumlah);
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        try {
            String query = "SELECT * FROM inventaris WHERE kode_barang = '" + kode + "'";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                jmlData++;
            }

            if (jmlData == 1) {
                query = "UPDATE inventaris SET kode_barang = '" + kode + "', nama_barang = '" + nama + "', kategori = '" + kategori + "', harga_barang = '" + fharga + "', jumlah_barang = '" + fjumlah + "', total_harga = '" + total + "', tanggal = '" + date + "', waktu = '" + time + "'WHERE kode_barang = '" + kode + "'";
                st = (Statement) cn.createStatement();
                st.executeUpdate(query);
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate!");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void deleteData (String data) {
        try{
            String query = "DELETE FROM inventaris WHERE kode_barang = '" + data + "'";
            st = cn.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String[][] cariData(String cari, String pil){

        int bykData = 0;

        try {
            String[][] data = new String[getJmlCari(cari, pil)][8];

            String sql = null;
            if (pil == "kode") {
                sql = "SELECT * FROM inventaris WHERE kode_barang LIKE '%" + cari + "%'";
            } else if (pil == "nama") {
                sql = "SELECT * FROM inventaris WHERE nama_barang LIKE '%" + cari + "%'";
            }else {
                sql = "SELECT * FROM inventaris WHERE kategori LIKE '%" + cari + "%'";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                data[bykData][0] = rs.getString("kode_barang");
                data[bykData][1] = rs.getString("nama_barang");
                data[bykData][2] = rs.getString("kategori");
                data[bykData][3] = rs.getString("harga_barang");
                data[bykData][4] = rs.getString("jumlah_barang");
                data[bykData][5] = rs.getString("total_harga");
                data[bykData][6] = rs.getString("tanggal");
                data[bykData][7] = rs.getString("waktu");

                bykData++;
            }

            return data;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}