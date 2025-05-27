package entity;

public class XeOto extends PhuongTien {
    private String dongCo;
    private int soChoNgoi;

    public XeOto(String maPhuongTien, String ten, String hangSanXuat, double gia, double soKmDaDi, int namSanXuat, String dongCo, int soChoNgoi) {
        super(maPhuongTien, ten, hangSanXuat, gia, soKmDaDi, namSanXuat);
        this.dongCo = dongCo;
        this.soChoNgoi = soChoNgoi;
    }

    @Override
    public String loaiPhuongTien() {
        return "Xe ô tô";
    }
}

