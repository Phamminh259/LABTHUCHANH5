
package phonghoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class QuanLyPhongHoc {
    private List<PhongHoc> danhSachPhongHoc;

    public QuanLyPhongHoc() {
        danhSachPhongHoc = new ArrayList<>();
    }

    public void themPhongHoc(PhongHoc phongHoc) {
        for (PhongHoc phong : danhSachPhongHoc) {
            if (phong.getMaPhong().equals(phongHoc.getMaPhong())) {
                System.out.println("Thêm không thành công. Mã phòng đã tồn tại.");
                return;
            }
        }
        danhSachPhongHoc.add(phongHoc);
        System.out.println("Thêm phòng học thành công.");
    }

    public PhongHoc timPhongHoc(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                return phongHoc;
            }
        }
        return null;
    }

    public void inDanhSachPhongHoc() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            System.out.println(phongHoc);
        }
    }

    public void inDanhSachPhongHocDatChuan() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongHocLyThuyet) {
                if (((PhongHocLyThuyet) phongHoc).isCoMayChieu()) {
                    System.out.println(phongHoc);
                }
            } else if (phongHoc instanceof PhongHocMayTinh) {
                if (((PhongHocMayTinh) phongHoc).getSoMayTinh() > 0) {
                    System.out.println(phongHoc);
                }
            } else if (phongHoc instanceof PhongHocThiNghiem) {
                if (((PhongHocThiNghiem) phongHoc).isCoBonRua()) {
                    System.out.println(phongHoc);
                }
            }
        }
    }

    public void sapXepTheoDayNha() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDayNha));
    }

    public void sapXepTheoDienTichGiamDan() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getDienTich).reversed());
    }

    public void sapXepTheoSoBongDenTangDan() {
        Collections.sort(danhSachPhongHoc, Comparator.comparing(PhongHoc::getSoBongDen));
    }
}

