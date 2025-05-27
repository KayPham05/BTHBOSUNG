package entity;

public abstract class PhuongTien {
    protected String maPhuongTien;
    protected String ten;
    protected String hangSanXuat;
    protected double gia;
    protected double soKmDaDi;
    protected int namSanXuat;

    public PhuongTien(String maPhuongTien, String ten, String hangSanXuat, double gia, double soKmDaDi, int namSanXuat) {
        this.maPhuongTien = maPhuongTien;
        this.ten = ten;
        this.hangSanXuat = hangSanXuat;
        this.gia = gia;
        this.soKmDaDi = soKmDaDi;
        this.namSanXuat = namSanXuat;
    }

    public abstract String loaiPhuongTien();

    public boolean sanXuatTruocNam(int nam) {
        return this.namSanXuat < nam;
    }

    public double getSoKmDaDi() {
        return soKmDaDi;
    }

    public String getTen() {
        return ten;
    }

    public double getGia() {
        return gia;
    }
}

