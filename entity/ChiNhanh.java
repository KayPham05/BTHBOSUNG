package entity;

import java.util.*;

public class ChiNhanh {
    private String tenChiNhanh;
    private String diaChi;
    private List<PhuongTien> dsPhuongTien;

    public ChiNhanh(String tenChiNhanh, String diaChi) {
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
        this.dsPhuongTien = new ArrayList<>();
    }

    public void themPhuongTien(PhuongTien pt) {
        dsPhuongTien.add(pt);
    }

    public List<PhuongTien> getDsPhuongTien() {
        return dsPhuongTien;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public String getDiaChi() {
        return diaChi;
    }
}

