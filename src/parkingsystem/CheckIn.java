package parkingsystem;

import java.util.Date;

public class CheckIn {
    private String nomorPolisi;
    private Date tanggalMasuk;
    private String jamMasuk;

    public CheckIn(String nomorPolisi, Date tanggalMasuk, String jamMasuk) {
        this.nomorPolisi = nomorPolisi;
        this.tanggalMasuk = tanggalMasuk;
        this.jamMasuk = jamMasuk;
    }

    // Getters and Setters

    public String getNomorPolisi() {
        return nomorPolisi;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }
}
