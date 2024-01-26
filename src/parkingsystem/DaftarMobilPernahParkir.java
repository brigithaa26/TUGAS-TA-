package parkingsystem;

import java.util.ArrayList;
import java.util.List;

public class DaftarMobilPernahParkir {
    private List<Kendaraan> mobilPernahParkir;

    public DaftarMobilPernahParkir() {
        this.mobilPernahParkir = new ArrayList<>();
    }

    public void tambahMobilPernahParkir(Kendaraan kendaraan) {
        mobilPernahParkir.add(kendaraan);
    }

    public void tampilkanDaftarMobilPernahParkir() {
        System.out.println("Daftar Mobil Pernah Parkir:");
        for (Kendaraan kendaraan : mobilPernahParkir) {
            System.out.println("Nomor Polisi: " + kendaraan.getNomorPolisi());
        }
    }
}
