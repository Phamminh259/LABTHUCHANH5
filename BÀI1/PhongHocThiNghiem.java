
package phonghoc;

class PhongHocThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongHocThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh, int sucChua, boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    @Override
    public String toString() {
        return "PhongHocThiNghiem{" +
                "maPhong='" + getMaPhong() + '\'' +
                ", dayNha='" + getDayNha() + '\'' +
                ", dienTich=" + getDienTich() +
                ", soBongDen=" + getSoBongDen() +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                ", sucChua=" + sucChua +
                ", coBonRua=" + coBonRua +
                '}';
    }
}
