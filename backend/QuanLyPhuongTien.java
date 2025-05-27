package backend;

import entity.*;
import java.util.*;

public class QuanLyPhuongTien {
    // Tìm phương tiện đi nhiều km nhất trong chi nhánh
    public static PhuongTien timNhieuKmNhat(ChiNhanh cn) {
        return cn.getDsPhuongTien().stream().max(Comparator.comparingDouble(PhuongTien::getSoKmDaDi)).orElse(null);
    }

    // Lấy danh sách phương tiện hoạt động tốt (≤ 20.000 km)
    public static List<PhuongTien> phuongTienHoatDongTot(ChiNhanh cn) {
        List<PhuongTien> result = new ArrayList<>();
        for (PhuongTien pt : cn.getDsPhuongTien()) {
            if (pt.getSoKmDaDi() <= 20000) result.add(pt);
        }
        return result;
    }

    // Tìm chi nhánh có nhiều phương tiện hoạt động tốt nhất
    public static ChiNhanh chiNhanhNhieuPTTotNhat(List<ChiNhanh> ds) {
        return ds.stream().max(Comparator.comparingInt(cn -> phuongTienHoatDongTot(cn).size())).orElse(null);
    }

    // Lấy danh sách phương tiện cần bảo dưỡng (> 100.000 km)
    public static List<PhuongTien> phuongTienCanBaoDuong(ChiNhanh cn) {
        List<PhuongTien> result = new ArrayList<>();
        for (PhuongTien pt : cn.getDsPhuongTien()) {
            if (pt.getSoKmDaDi() > 100000) result.add(pt);
        }
        return result;
    }

    // Sắp xếp phương tiện theo tên (tăng dần)
    public static void sapXepTheoTen(ChiNhanh cn) {
        cn.getDsPhuongTien().sort(Comparator.comparing(PhuongTien::getTen));
    }

    // Sắp xếp phương tiện theo giá (giảm dần)
    public static void sapXepTheoGia(ChiNhanh cn) {
        cn.getDsPhuongTien().sort(Comparator.comparing(PhuongTien::getGia).reversed());
    }

    // Thống kê số lượng phương tiện theo loại
    public static Map<String, Integer> thongKeTheoLoai(ChiNhanh cn) {
        Map<String, Integer> map = new HashMap<>();
        for (PhuongTien pt : cn.getDsPhuongTien()) {
            String loai = pt.loaiPhuongTien();
            map.put(loai, map.getOrDefault(loai, 0) + 1);
        }
        return map;
    }
}

