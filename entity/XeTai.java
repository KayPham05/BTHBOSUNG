package entity;

public class XeTai extends PhuongTien {
    private double trongTai;
    private int soTruc;

    public XeTai(String maPhuongTien, String ten, String hangSanXuat, double gia, double soKmDaDi, int namSanXuat, double trongTai, int soTruc) {
        super(maPhuongTien, ten, hangSanXuat, gia, soKmDaDi, namSanXuat);
        this.trongTai = trongTai;
        this.soTruc = soTruc;
    }

    @Override
    public String loaiPhuongTien() {
        return "Xe tải";
    }
}

