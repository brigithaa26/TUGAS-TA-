package parkingsystem;

public class LahanParkir {
    private int kapasitas;
    private Kendaraan[] kendaraans;
    private int jumlahKendaraan;

    public LahanParkir(int kapasitas) {
        this.kapasitas = kapasitas;
        this.kendaraans = new Kendaraan[kapasitas];
        this.jumlahKendaraan = 0;
    }

    public boolean parkirKendaraan(Kendaraan kendaraan) {
        if (jumlahKendaraan < kapasitas) {
            kendaraans[jumlahKendaraan] = kendaraan;
            jumlahKendaraan++;
            return true;
        } else {
            System.out.println("Lahan parkir penuh!");
            return false;
        }
    }

    public boolean isLahanFull() {
        return jumlahKendaraan == kapasitas;
    }

    public void displayLahanParkir() {
        System.out.println("Lahan Parkir:");
        for (int i = 0; i < jumlahKendaraan; i++) {
            System.out.println("Nomor Polisi: " + kendaraans[i].getNomorPolisi());
        }
    }

    // Getter untuk mendapatkan jumlah kendaraan yang sedang parkir
    public int getJumlahKendaraan() {
        return jumlahKendaraan;
    }

    // Getter untuk mendapatkan array kendaraan
    public Kendaraan[] getKendaraans() {
        return kendaraans;
    }
}
