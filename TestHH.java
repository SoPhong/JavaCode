/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Thao
 */
public class TestHH {

    private boolean flag = false;
    private ArrayList<HangHoa> lstHH;
    private BufferedReader input = null;
    private final String strMenu = "---------- Quan Ly Hang Hoa ----------\n"
            + " 1. Nhap hang hoa\n"
            + " 2. Hien thi hang hoa\n"
            + " 3. Thoat\n"
            + "- Nhap lua chon: ";

    private void runTest() {
        input = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print(strMenu);
            int choice = 0;
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (IOException | NumberFormatException ex) {
                System.err.println("--- " + ex.getMessage());
            }
            switch (choice) {
                case 1:
                    nhapHH();
                    break;
                case 2:
                    hienThiHH();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("--- Lua chon khong hop le.");
                    break;
            }
        } while (true);
    }

    private void nhapHH() {
        System.out.println("\n---------- Nhap Thong Tin Hang Hoa ----------");
        input = new BufferedReader(new InputStreamReader(System.in));
        int soHH = 0;

        do {
            System.out.print("- Nhap so hang hoa: ");
            try {
                soHH = Integer.parseInt(input.readLine());
                if (soHH <= 0) {
                    throw new Exception("So hang hoa phai la so duong.");
                }
            } catch (Exception ex) {
                System.err.println("--- " + ex.getMessage());
            }
        } while (soHH <= 0);

        lstHH = new ArrayList<>(soHH); // Khoi tao mang so hang hoa

        for (int i = 0; i < soHH; i++) {
            HangHoa hangHoa = new HangHoa();
            System.out.println("\n- STT: " + (i + 1));
            do {
                flag = true;
                System.out.print("- Nhap ma hang hoa: ");
                try {
                    String maHH = input.readLine();
                    if (maHH.equals("")) {
                        throw new Exception("Ma hang hoa khong duoc de trong.");
                    }
                    if (lstHH != null) {
                        for (HangHoa hh : lstHH) {
                            if (hh.getMaHang().equals(maHH)) {
                                throw new Exception("Ma hang hoa da ton tai.");
                            }
                        }
                    }
                    hangHoa.setMaHang(maHH);
                    flag = false;
                } catch (Exception ex) {
                    System.err.println("--- " + ex.getMessage());
                }
            } while (flag);

            do {
                flag = true;
                System.out.print("- Nhap ten hang hoa: ");
                try {
                    String tenHH = input.readLine();
                    if (tenHH.equals("")) {
                        throw new Exception("Ten hang hoa khong duoc de trong.");
                    }
                    if (tenHH.length() < 3) {
                        throw new Exception("Ten hang hoa phai lon hon 3 ky tu.");
                    }
                    hangHoa.setTenHang(tenHH);
                    flag = false;
                } catch (Exception ex) {
                    System.err.println("--- " + ex.getMessage());
                }
            } while (flag);

            do {
                flag = true;
                System.out.print("- Nhap don gia: ");
                try {
                    float donGia = Float.parseFloat(input.readLine());
                    if (donGia <= 0) {
                        throw new Exception("Don gia phai la so duong.");
                    }
                    hangHoa.setDonGia(donGia);
                    flag = false;
                } catch (Exception ex) {
                    System.err.println("--- " + ex.getMessage());
                }
            } while (flag);

            lstHH.add(hangHoa); // Them 1 doi tuong hang hoa vao list
        }
    }

    private void hienThiHH() {
        System.out.println("\n---------- Thong Tin Hang Hoa ----------");
        if (lstHH == null) {
            System.err.println("--- Danh sach hang hoa rong.");
        } else {
            System.out.println("Ma hang hoa\tTen hang hoa\tDon gia");
            System.out.println("-----------\t------------\t-------");
            for (HangHoa hangHoa : lstHH) {
                System.out.println(hangHoa.getMaHang() + "\t\t" + hangHoa.getTenHang() + "\t\t" + String.format("%.2f", hangHoa.getDonGia()));
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestHH objTest = new TestHH();
        objTest.runTest();
    }

}
