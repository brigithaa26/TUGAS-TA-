import parkingsystem.*;

import java.util.Scanner;
import java.util.Date;

class MainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminLogin adminLogin = new AdminLogin();
        DaftarMobilParkir daftarMobilParkir = new DaftarMobilParkir();
        DaftarMobilPernahParkir daftarMobilPernahParkir = new DaftarMobilPernahParkir();

        boolean loggedIn = false;
        String username = "";
        String password = "";
        CheckIn checkIn = null; // Deklarasi variabel checkIn di luar loop

        while (true) {
            System.out.println("===============================");
            System.out.println("ADMIN SISTEM LAHAN PARKIR MOBIL");
            System.out.println("===============================");
            System.out.println("1. LOGIN");
            System.out.println("2. CHECK-IN KENDARAAN");
            System.out.println("3. CHECK-OUT KENDARAAN + CETAK STRUK");
            System.out.println("4. DAFTAR MOBIL YANG SEDANG PARKIR");
            System.out.println("5. DAFTAR MOBIL YANG PERNAH PARKIR");
            System.out.println("6. LOGOUT");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Masukkan username: ");
                    username = scanner.nextLine();
                    System.out.println("Masukkan password: ");
                    password = scanner.nextLine();

                    loggedIn = adminLogin.login(username, password);
                    if (loggedIn) {
                        System.out.println("Login berhasil!");
                    } else {
                        System.out.println("Login gagal. Username atau password salah.");
                    }
                    break;

                case 2:
                    if (loggedIn) {
                        System.out.println("Masukkan nomor polisi kendaraan: ");
                        String nomorPolisi = scanner.nextLine();
                        Date tanggalMasuk = new Date(); // Waktu check-in diambil saat itu juga
                        System.out.println("Masukkan jam masuk (format: HH:mm): ");
                        String jamMasuk = scanner.nextLine();

                        Kendaraan kendaraan = new Kendaraan(nomorPolisi);
                        checkIn = new CheckIn(nomorPolisi, tanggalMasuk, jamMasuk);

                        LahanParkir lahanParkir = new LahanParkir(10);

                        if (!lahanParkir.isLahanFull()) {
                            lahanParkir.parkirKendaraan(kendaraan);
                            daftarMobilParkir.tambahMobilParkir(kendaraan);
                            System.out.println("Kendaraan berhasil check-in.");
                        } else {
                            System.out.println("Gagal check-in. Lahan parkir penuh.");
                        }
                    } else {
                        System.out.println("Silakan login terlebih dahulu.");
                    }
                    break;

                case 3:
                    if (loggedIn) {
                        System.out.println("Masukkan nomor polisi kendaraan: ");
                        String nomorPolisiCheckOut = scanner.nextLine();
                        Date tanggalKeluar = new Date(); // Waktu check-out diambil saat itu juga
                        System.out.println("Masukkan jam keluar (format: HH:mm): ");
                        String jamKeluar = scanner.nextLine();

                        CheckOut checkOut = new CheckOut(nomorPolisiCheckOut, tanggalKeluar, jamKeluar);
                        PembayaranParkir pembayaranParkir = new PembayaranParkir(checkIn, checkOut, username);
                        pembayaranParkir.cetakStruk();
                        daftarMobilPernahParkir.tambahMobilPernahParkir(daftarMobilParkir.ambilKendaraan(nomorPolisiCheckOut));
                        daftarMobilParkir.hapusMobilParkir(nomorPolisiCheckOut);
                    } else {
                        System.out.println("Silakan login terlebih dahulu.");
                    }
                    break;

                case 4:
                    if (loggedIn) {
                        daftarMobilParkir.tampilkanDaftarMobilParkir();
                    } else {
                        System.out.println("Silakan login terlebih dahulu.");
                    }
                    break;

                case 5:
                    if (loggedIn) {
                        daftarMobilPernahParkir.tampilkanDaftarMobilPernahParkir();
                    } else {
                        System.out.println("Silakan login terlebih dahulu.");
                    }
                    break;

                case 6:
                    loggedIn = false;
                    System.out.println("Logout berhasil.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

            if (!loggedIn) {
                break;
            }
        }
    }
}
