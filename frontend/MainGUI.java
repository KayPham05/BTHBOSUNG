package frontend;

import entity.*;
import backend.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainGUI extends JFrame {
    private CongTy congTy;
    private JComboBox<String> cbChiNhanh;
    private JTextArea taDanhSach;

    public MainGUI(CongTy congTy) {
        this.congTy = congTy;
        setTitle("Quản lý phương tiện công ty XYZ");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cbChiNhanh = new JComboBox<>();
        for (ChiNhanh cn : congTy.getDsChiNhanh()) {
            cbChiNhanh.addItem(cn.getTenChiNhanh());
        }
        cbChiNhanh.addActionListener(e -> hienThiDanhSach());
        add(cbChiNhanh, BorderLayout.NORTH);

        taDanhSach = new JTextArea();
        add(new JScrollPane(taDanhSach), BorderLayout.CENTER);

        hienThiDanhSach();
    }

    private void hienThiDanhSach() {
        int idx = cbChiNhanh.getSelectedIndex();
        if (idx < 0) return;
        ChiNhanh cn = congTy.getDsChiNhanh().get(idx);
        StringBuilder sb = new StringBuilder();
        for (PhuongTien pt : cn.getDsPhuongTien()) {
            sb.append(pt.getTen()).append(" - ").append(pt.loaiPhuongTien()).append(" - ").append(pt.getGia()).append("\n");
        }
        taDanhSach.setText(sb.toString());
    }
}

