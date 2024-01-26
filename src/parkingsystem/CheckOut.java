package parkingsystem;

import java.util.Date;

public class CheckOut {
    private String nomorPolisi;
    private Date tanggalKeluar;
    private String jamKeluar;

    public CheckOut(String nomorPolisi, Date tanggalKeluar, String jamKeluar) {
        this.nomorPolisi = nomorPolisi;
        this.tanggalKeluar = tanggalKeluar;
        this.jamKeluar = jamKeluar;
    }

    // Getters and Setters

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public Date getTanggalKeluar() {
        return tanggalKeluar;
    }

    public String getJamKeluar() {
        return jamKeluar;
    }
}
