
package khachhang;


class KhachHang {
    private String soCMND;
    private String ten;
    private String gaDen;
    private double giaTien;

    public KhachHang(String soCMND, String ten, String gaDen, double giaTien) {
        this.soCMND = soCMND;
        this.ten = ten;
        this.gaDen = gaDen;
        this.giaTien = giaTien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public String getTen() {
        return ten;
    }

    public String getGaDen() {
        return gaDen;
    }

    public double getGiaTien() {
        return giaTien;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "soCMND=" + soCMND + ", ten=" + ten + ", gaDen=" + gaDen + ", giaTien=" + giaTien + '}';
    }

 
}
