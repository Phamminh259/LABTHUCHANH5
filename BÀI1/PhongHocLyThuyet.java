
package phonghoc;

class PhongHocLyThuyet extends PhongHoc {
    private boolean coMayChieu;

    public PhongHocLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    @Override
    public String toString() {
        return "PhongHocLyThuyet{" +
                "maPhong='" + getMaPhong() + '\'' +
                ", dayNha='" + getDayNha() + '\'' +
                ", dienTich=" + getDienTich() +
                ", soBongDen=" + getSoBongDen() +
                ", coMayChieu=" + coMayChieu +
                '}';
    }
}
