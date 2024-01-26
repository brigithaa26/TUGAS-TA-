package parkingsystem;

public class PembayaranParkir {
    private CheckIn checkIn;
    private CheckOut checkOut;
    private String petugas;

    public PembayaranParkir(CheckIn checkIn, CheckOut checkOut, String petugas) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.petugas = petugas;
    }

    public void cetakStruk() {
        long durasiParkir = hitungDurasiParkir(checkIn, checkOut);
        int tarifPerJam = 5000; // Tarif per jam
        int biayaParkir = (int) (Math.ceil((double) durasiParkir / 60) * tarifPerJam); // Pembulatan ke atas durasi parkir dalam jam

        System.out.println("==================");
        System.out.println("PT SINAR");
        System.out.println("Bukti Pembayaran Parkir Mobil");
        System.out.println();
        System.out.println("No Polisi: " + checkIn.getNomorPolisi());
        System.out.println("Masuk: " + checkIn.getJamMasuk());
        System.out.println("Keluar: " + checkOut.getJamKeluar());
        System.out.println("Lama Parkir: " + durasiParkir + " menit");
        System.out.println("Sewa Parkir: Rp " + biayaParkir);
        System.out.println("Petugas: " + petugas);
        System.out.println("====================");
        System.out.println("Terimakasih - Selamat Jalan");
    }

    private long hitungDurasiParkir(CheckIn checkIn, CheckOut checkOut) {
        // Menghitung durasi parkir dalam menit
        long masukMillis = checkIn.getTanggalMasuk().getTime();
        long keluarMillis = checkOut.getTanggalKeluar().getTime();
        long durasiMillis = keluarMillis - masukMillis;

        return durasiMillis / (60 * 1000); // Konversi ke menit
    }
}
