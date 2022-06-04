import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View  extends JFrame{
    JLabel labtitle = new JLabel("PET SHOP SEJAHTERA");
    JLabel labkode = new JLabel("Kode Barang");
    JLabel labnamaBrg = new JLabel("Nama Barang");
    JLabel labkategori = new JLabel("Kategori");
    JLabel labhargaBrg = new JLabel("Harga Barang");
    JLabel labjmlBrg = new JLabel("Jumlah Barang");

    JLabel labSearch = new JLabel("Cari data: ");



    public JTextField tfkode = new JTextField();
    public JTextField tfnamaBrg = new JTextField();
    public JTextField tfkategori = new JTextField();
    public JTextField tfhargaBrg = new JTextField();
    public JTextField tfjmlBrg = new JTextField();
    public JTextField tfSearch = new JTextField();


    String pilihan[] = {"Makanan Kering", "Makanan Basah", "Obat", "Alat", "Aksesoris"};
    public JComboBox kategori = new JComboBox(pilihan);


    public JButton btnInsert = new JButton("Insert");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Reset");
    public JButton btnSearch = new JButton("Kode");
    public JButton btnPilnama = new JButton("Nama");
    public JButton btnPilkat = new JButton("Kategori");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane sp;
    public Object[] judul = {"Kode Barang", "Nama Barang", "Kategori", "Harga Barang", "Jumlah Barang", "Total Harga", "Tangga;", "Waktu"};

    public View(){

        dtm = new DefaultTableModel(judul, 0);
        tabel = new JTable(dtm);
        sp = new JScrollPane(tabel);

        setTitle("Data Stock Pet Shop");
        setSize(850,670);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(null);


        add(sp);
        sp.setBounds(30, 48, 600, 522);

        //add label
        add(labtitle);
        add(labkode);
        add(labnamaBrg);
        add(labkategori);
        add(labjmlBrg);
        add(labhargaBrg);
        add(labSearch);

        //add textfield
        add(tfkode);
        add(tfnamaBrg);
        add(tfjmlBrg);
        add(tfhargaBrg);
        add(tfSearch);

        //add button
        add(btnInsert);
        add(btnUpdate);
        add(btnDelete);
        add(btnReset);
        add(btnSearch);
        add(btnPilnama);
        add(btnPilkat);

        //addJcombo
        add(kategori);

        //setBounds(int x-coordinate, int y-coordinate, int width, int height)
        //desain tampilan ui diatas
        labtitle.setBounds(350, 0, 180, 40);
        labkode.setBounds(655, 40, 90, 25);
        labnamaBrg.setBounds(655, 100, 90, 25);
        labkategori.setBounds(655, 160, 90, 25);
        labjmlBrg.setBounds(655, 220, 90, 25);
        labhargaBrg.setBounds(655, 280, 110, 25);
        labSearch.setBounds(30, 580, 80, 30);

        tfkode.setBounds(655, 70, 140, 25);
        tfnamaBrg.setBounds(655, 130, 140, 25);
        kategori.setBounds(655, 190, 140, 25);
        tfjmlBrg.setBounds(655, 250, 140, 25);
        tfhargaBrg.setBounds(655, 310, 140, 25);
        tfSearch.setBounds(100, 580,140, 30);

        btnInsert.setBounds(655, 420, 140, 30);
        btnUpdate.setBounds(655, 460, 140, 30);
        btnDelete.setBounds(655, 500, 140, 30);
        btnReset.setBounds(655, 540, 140, 30);
        btnSearch.setBounds(260, 580, 80, 30);
        btnPilnama.setBounds(350, 580, 80, 30);
        btnPilkat.setBounds(440, 580, 90, 30);


    }

    public String getkode() {
        return tfkode.getText();
    }

    public String getnamaBrg() {
        return tfnamaBrg.getText();
    }

    public String getkategori() {
        String selectedItemStr = (String) kategori.getSelectedItem();
        return selectedItemStr;
    }

    public String getjmlBrg() {
        return tfjmlBrg.getText();
    }

    public String gethargaBrg() {
        return tfhargaBrg.getText();
    }

    public String getSearch(){return tfSearch.getText();}

    public double getTotal(){
        String harga = gethargaBrg();
        String jumlah = getjmlBrg();

        double harga2 = Float.parseFloat(harga);
        double jumlah2 = Float.parseFloat(jumlah);

        double total = harga2 * jumlah2;

        return total;
    }
}
