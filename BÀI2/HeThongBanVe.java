
package khachhang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class HeThongBanVe {
    private static final String FILE_KHACHHANG = "khachhang.txt";
    private Queue<KhachHang> hangDoiKhachHang;
    private List<KhachHang> veDaBan;

    public HeThongBanVe() {
        hangDoiKhachHang = new LinkedList<>();
        veDaBan = new ArrayList<>();
    }

    public void chay() {
        loadKhachHangTuFile();

        Scanner scanner = new Scanner(System.in);
        int luaChon;

        do {
            hienThiMenu();
            luaChon = scanner.nextInt();
            scanner.nextLine(); 

            switch (luaChon) {
                case 1:
                    themKhachHang(scanner);
                    break;
                case 2:
                    banVe();
                    break;
                case 3:
                    hienThiDanhSachKhachHang();
                    break;
                case 4:
                    huyKhachHang();
                    break;
                case 5:
                    thongKeTinhHinhBanVe();
                    break;
                case 6:
                    luuKhachHangVaoFile();
                    break;
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.Nhap lại");
            }

            System.out.println();
        } while (luaChon != 0);

    scanner.close();
}

private void hienThiMenu() {
    System.out.println("Menu He thong ban ve:");
    System.out.println("1. Them khach hang moi vao hang doi mua ve");
    System.out.println("2. Ban ve cho khach hang");
    System.out.println("3. Hien thi danh sach khach hang");
    System.out.println("4. Huy khach hang khoi danh sach");
    System.out.println("5. Thong ke tinh hinh ban ve");
    System.out.println("6. Luu danh sach khach hang vao file");
    System.out.println("0. Thoat");
    System.out.print("Nhap lua chon cua ban: ");
}

private void themKhachHang(Scanner scanner) {
    System.out.print("Nhap so CMND khach hang: ");
    String soCMND = scanner.nextLine();
    System.out.print("Nhap ten khach hang: ");
    String ten = scanner.nextLine();
    System.out.print("Nhap ga den: ");
    String gaDen = scanner.nextLine();
    System.out.print("Nhap gia tien: ");
    double giaTien = scanner.nextDouble();
    scanner.nextLine(); 


    for (KhachHang khachHang : hangDoiKhachHang) {
        if (khachHang.getSoCMND().equals(soCMND)) {
            hangDoiKhachHang.remove(khachHang);
            hangDoiKhachHang.add(new KhachHang(soCMND, ten, gaDen, giaTien));
            System.out.println("Khach hang da duoc cap nhat.");
            return;
        }
    }

    hangDoiKhachHang.add(new KhachHang(soCMND, ten, gaDen, giaTien));
    System.out.println("Them khach hang vao hang doi thanh cong.");
}

private void banVe() {
    if (hangDoiKhachHang.isEmpty()) {
        System.out.println("Khong co khach hang trong hang doi.");
        return;
    }

    KhachHang khachHang = hangDoiKhachHang.poll();
    veDaBan.add(khachHang);
    System.out.println("Da ban ve cho khach hang: " + khachHang.getTen());
}

private void hienThiDanhSachKhachHang() {
    if (hangDoiKhachHang.isEmpty()) {
        System.out.println("Khong co khach hang trong hang doi.");
        return;
    }

    System.out.println("Danh sach khach hang:");
    for (KhachHang khachHang : hangDoiKhachHang) {
        System.out.println(khachHang);
    }
}

private void huyKhachHang() {
    if (hangDoiKhachHang.isEmpty()) {
        System.out.println("Khong co khach hang trong hang doi.");
        return;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhap so CMND khach hang de huy: ");
    String soCMND = scanner.nextLine();

    for (KhachHang khachHang : hangDoiKhachHang) {
        if (khachHang.getSoCMND().equals(soCMND)) {
            hangDoiKhachHang.remove(khachHang);
            System.out.println("Khach hang da duoc huy khoi hang doi.");
            return;
        }
    }

    System.out.println("Khach hang khong ton tai trong hang doi.");
}

private void thongKeTinhHinhBanVe() {
    int soKhachHangCho = hangDoiKhachHang.size();
    int soKhachHangDaBan = veDaBan.size();
    double tongDoanhThu = 0;

    for (KhachHang khachHang : veDaBan) {
        tongDoanhThu += khachHang.getGiaTien();
    }

    System.out.println("Thong ke tinh hinh ban ve:");
    System.out.println("So khach hang cho: " + soKhachHangCho);
    System.out.println("So khach hang da mua ve: " + soKhachHangDaBan);
    System.out.println("Tong doanh thu: " + tongDoanhThu);
}

private void loadKhachHangTuFile() {
    try {
        File file = new File(FILE_KHACHHANG);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            hangDoiKhachHang = (Queue<KhachHang>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Du lieu khach hang da duoc tai tu file.");
        } else {
            System.out.println("Khong tim thay du lieu khach hang. Bat dau voi hang doi trong.");
        }
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Loi khi tai du lieu khach hang tu file: " + e.getMessage());
    }
}

private void luuKhachHangVaoFile() {
    try {
        File file = new File(FILE_KHACHHANG);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(hangDoiKhachHang);
        oos.close();
        fos.close();
        System.out.println("Du lieu khach hang da duoc luu vao file.");
    } catch (IOException e) {
        System.out.println("Loi khi luu du lieu khach hang vao file: " + e.getMessage());
    }
}

public static void main(String[] args) {
    HeThongBanVe heThongBanVe = new HeThongBanVe();
    heThongBanVe.chay();
}
}