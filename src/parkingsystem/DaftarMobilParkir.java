package parkingsystem;

import java.util.ArrayList;
import java.util.List;

public class DaftarMobilParkir {
    private List<Kendaraan> mobilSedangParkir;

    public DaftarMobilParkir() {
        this.mobilSedangParkir = new ArrayList<>();
    }

    public void tambahMobilParkir(Kendaraan kendaraan) {
        mobilSedangParkir.add(kendaraan);
    }

    public void tampilkanDaftarMobilParkir() {
        System.out.println("Daftar Mobil Sedang Parkir:");
        for (Kendaraan kendaraan : mobilSedangParkir) {
            System.out.println("Nomor Polisi: " + kendaraan.getNomorPolisi());
        }
    }

    public void hapusMobilParkir(String nomorPolisiCheckOut) {
        for (Kendaraan kendaraan : mobilSedangParkir) {
            if (kendaraan.getNomorPolisi().equals(nomorPolisiCheckOut)) {
                mobilSedangParkir.remove(kendaraan);
                System.out.println("Kendaraan dengan nomor polisi " + nomorPolisiCheckOut + " berhasil check-out.");
                return; // Keluar dari metode setelah kendaraan ditemukan dan dihapus
            }
        }
        System.out.println("Kendaraan dengan nomor polisi " + nomorPolisiCheckOut + " tidak ditemukan.");
    }

    public Kendaraan ambilKendaraan(String nomorPolisiCheckOut) {
        for (Kendaraan kendaraan : mobilSedangParkir) {
            if (kendaraan.getNomorPolisi().equals(nomorPolisiCheckOut)) {
                return kendaraan; // Mengembalikan kendaraan ketika ditemukan
            }
        }
        System.out.println("Kendaraan dengan nomor polisi " + nomorPolisiCheckOut + " tidak ditemukan.");
        return null; // Mengembalikan null jika kendaraan tidak ditemukan
    }

}
