package entity;

import java.util.*;

public class CongTy {
    private String tenCongTy;
    private String diaChi;
    private List<ChiNhanh> dsChiNhanh;

    public CongTy(String tenCongTy, String diaChi) {
        this.tenCongTy = tenCongTy;
        this.diaChi = diaChi;
        this.dsChiNhanh = new ArrayList<>();
    }

    public void themChiNhanh(ChiNhanh cn) {
        dsChiNhanh.add(cn);
    }

    public List<ChiNhanh> getDsChiNhanh() {
        return dsChiNhanh;
    }
}

