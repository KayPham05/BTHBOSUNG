import entity.*;

public class Main {
    public static void main(String[] args) {
        // Tạo công ty
        CongTy congTy = new CongTy("Công ty XYZ", "123 Đường ABC, TP.HCM");

        // Tạo chi nhánh 1
        ChiNhanh cn1 = new ChiNhanh("Chi nhánh 1", "Quận 1, TP.HCM");
        cn1.themPhuongTien(new XeOto("O1", "Toyota Camry", "Toyota", 1200000, 15000, 2020, "2.5L", 5));
        cn1.themPhuongTien(new XeMay("M1", "Honda AirBlade", "Honda", 40000, 18000, 2021, 8.5, "Tay ga"));
        cn1.themPhuongTien(new XeTai("T1", "Isuzu QKR", "Isuzu", 800000, 50000, 2019, 2.5, 2));
        cn1.themPhuongTien(new XeMay("M2", "Yamaha Sirius", "Yamaha", 20000, 22000, 2018, 6.0, "Số"));

        // Tạo chi nhánh 2
        ChiNhanh cn2 = new ChiNhanh("Chi nhánh 2", "Quận 3, TP.HCM");
        cn2.themPhuongTien(new XeOto("O2", "Kia Morning", "Kia", 350000, 120000, 2017, "1.2L", 4));
        cn2.themPhuongTien(new XeMay("M3", "Honda SH", "Honda", 90000, 8000, 2022, 10.0, "Tay ga"));
        cn2.themPhuongTien(new XeTai("T2", "Hino 500", "Hino", 1500000, 110000, 2016, 5.0, 3));

        // Thêm chi nhánh vào công ty
        congTy.themChiNhanh(cn1);
        congTy.themChiNhanh(cn2);

        // --- In ra các chức năng trên console ---
        for (ChiNhanh cn : congTy.getDsChiNhanh()) {
            System.out.println("\n--- " + cn.getTenChiNhanh() + " ---");
            // 1. Phương tiện đi nhiều km nhất
            PhuongTien maxKm = backend.QuanLyPhuongTien.timNhieuKmNhat(cn);
            if (maxKm != null)
                System.out.println("Phương tiện đi nhiều km nhất: " + maxKm.getTen() + " (" + maxKm.getSoKmDaDi() + " km)");
            // 2. Danh sách phương tiện hoạt động tốt
            System.out.println("Phương tiện hoạt động tốt (≤ 20.000 km):");
            for (PhuongTien pt : backend.QuanLyPhuongTien.phuongTienHoatDongTot(cn)) {
                System.out.println("- " + pt.getTen() + " (" + pt.getSoKmDaDi() + " km)");
            }
            // 3. Danh sách phương tiện cần bảo dưỡng
            System.out.println("Phương tiện cần bảo dưỡng (> 100.000 km):");
            for (PhuongTien pt : backend.QuanLyPhuongTien.phuongTienCanBaoDuong(cn)) {
                System.out.println("- " + pt.getTen() + " (" + pt.getSoKmDaDi() + " km)");
            }
            // 4. Thống kê số lượng phương tiện theo loại
            System.out.println("Thống kê số lượng phương tiện theo loại:");
            for (var entry : backend.QuanLyPhuongTien.thongKeTheoLoai(cn).entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            // 5. Sắp xếp theo tên (tăng dần)
            backend.QuanLyPhuongTien.sapXepTheoTen(cn);
            System.out.println("\nDanh sách phương tiện (sắp xếp theo tên):");
            for (PhuongTien pt : cn.getDsPhuongTien()) {
                System.out.println("- " + pt.getTen());
            }
            // 6. Sắp xếp theo giá (giảm dần)
            backend.QuanLyPhuongTien.sapXepTheoGia(cn);
            System.out.println("\nDanh sách phương tiện (sắp xếp theo giá giảm dần):");
            for (PhuongTien pt : cn.getDsPhuongTien()) {
                System.out.println("- " + pt.getTen() + " (" + pt.getGia() + ")");
            }
        }
        // 7. Chi nhánh có nhiều phương tiện hoạt động tốt nhất
        ChiNhanh cnTotNhat = backend.QuanLyPhuongTien.chiNhanhNhieuPTTotNhat(congTy.getDsChiNhanh());
        if (cnTotNhat != null) {
            System.out.println("\nChi nhánh có nhiều phương tiện hoạt động tốt nhất: " + cnTotNhat.getTenChiNhanh());
        }

        // Hiển thị giao diện
        javax.swing.SwingUtilities.invokeLater(() -> {
            new frontend.MainGUI(congTy).setVisible(true);
        });
    }
}

