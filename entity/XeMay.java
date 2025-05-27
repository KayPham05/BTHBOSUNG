package entity;

public class XeMay extends PhuongTien {
    private double congSuat;
    private String loaiXe;

    public XeMay(String maPhuongTien, String ten, String hangSanXuat, double gia, double soKmDaDi, int namSanXuat, double congSuat, String loaiXe) {
        super(maPhuongTien, ten, hangSanXuat, gia, soKmDaDi, namSanXuat);
        this.congSuat = congSuat;
        this.loaiXe = loaiXe;
    }

    @Override
    public String loaiPhuongTien() {
        return "Xe máy";
    }

    public boolean laXeMayCuaHang(String hang) {
        return this.hangSanXuat.equalsIgnoreCase(hang);
    }
}

