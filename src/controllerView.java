import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class controllerView extends JFrame {
    modelView model;
    Login login;
    View view;

    public String pilkode, pilnamaBrg, pilKategori, piljmlBrg, pilhargaBrg;

    public controllerView(modelView model, View view){
        this.model = model;
        this.view = view;

        if (model.getJmlData()!=0) {
            String[][] dataTransaksi = model.listData();
            view.tabel.setModel((new JTable(dataTransaksi, view.judul)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data masih kosong");
        }

        view.btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kode = view.getkode();
                String nama = view.getnamaBrg();
                String kategori = view.getkategori();
                String jumlah = view.getjmlBrg();
                String harga = view.gethargaBrg();
                //waktu
                double total = view.getTotal();
                model.insertData(kode, nama, kategori, jumlah, harga, total);

                String[][] dataTransaksi = model.listData();
                view.tabel.setModel((new JTable(dataTransaksi, view.judul)).getModel());
            }
        });

        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = view.tabel.getSelectedRow();

                pilkode = view.tabel.getValueAt(baris, 0).toString();
                pilnamaBrg = view.tabel.getValueAt(baris, 1).toString();
                pilKategori = view.tabel.getValueAt(baris, 2).toString();
                pilhargaBrg = view.tabel.getValueAt(baris, 3).toString();
                piljmlBrg = view.tabel.getValueAt(baris, 4).toString();


                view.tfkode.setText(pilkode);
                view.tfnamaBrg.setText(pilnamaBrg);
                view.kategori.setSelectedItem(pilKategori);
                view.tfjmlBrg.setText(piljmlBrg);
                view.tfhargaBrg.setText(pilhargaBrg);
            }

        });

        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String kode = view.getkode();
                String nama = view.getnamaBrg();
                String kategori = view.getkategori();
                String harga = view.gethargaBrg();
                String jumlah = view.getjmlBrg();
                double total = view.getTotal();
                model.updateData(kode, nama, kategori, jumlah, harga, total);

                String[][] dataTransaksi = model.listData();
                view.tabel.setModel((new JTable(dataTransaksi, view.judul)).getModel());
            }
        });

        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String id = view.getkode();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data dengan kode barang (" + id + ")", "Opsi", JOptionPane.YES_NO_OPTION);

                if (confirm == 0) {
                    model.deleteData(id);

                    String[][] data = model.listData();
                    view.tabel.setModel((new JTable(data, view.judul)).getModel());
                }
            }
        });

        view.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.tfkode.setText("");
                view.tfnamaBrg.setText("");
                view.tfjmlBrg.setText("");
                view.tfhargaBrg.setText("");
                String[][] data = model.listData();
                view.tabel.setModel((new JTable(data, view.judul)).getModel());
            }
        });

        view.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pil = "kode";
                String cari = view.getSearch();
                model.cariData(cari, pil);
                String[][] data = model.cariData(cari, pil);
                view.tabel.setModel((new JTable(data, view.judul)).getModel());
            }
        });
        view.btnPilnama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pil = "nama";
                String cari = view.getSearch();
                model.cariData(cari, pil);
                String[][] data = model.cariData(cari, pil);
                view.tabel.setModel((new JTable(data, view.judul)).getModel());
            }
        });
        view.btnPilkat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pil = "kategori";
                String cari = view.getSearch();
                model.cariData(cari, pil);
                String[][] data = model.cariData(cari, pil);
                view.tabel.setModel((new JTable(data, view.judul)).getModel());
            }
        });
    }


}
