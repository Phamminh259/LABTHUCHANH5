
package phonghoc;


class PhongHocMayTinh extends PhongHoc {
    private int soMayTinh;

    public PhongHocMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    @Override
    public String toString() {
        return "PhongHocMayTinh{" +
                "maPhong='" + getMaPhong() + '\'' +
                ", dayNha='" + getDayNha() + '\'' +
                ", dienTich=" + getDienTich() +
                ", soBongDen=" + getSoBongDen() +
                ", soMayTinh=" + soMayTinh +
                '}';
    }
}
