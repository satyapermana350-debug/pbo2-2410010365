/*
 * Nama : NAMA_ANDA
 * NPM  : NPM_ANDA
 */
package id.ac.uniska.pbo2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class data satu mahasiswa beserta perhitungan nilai akhir dan huruf mutu.
 */
public class NilaiMahasiswa {

    private final String npm;
    private final String nama;
    private final int nilaiTugas;
    private final int nilaiUts;
    private final int nilaiUas;

    public NilaiMahasiswa(String npm, String nama, int nilaiTugas, int nilaiUts, int nilaiUas) {
        this.npm = npm;
        this.nama = nama;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    public String getNpm() {
        return npm;
    }

    public String getNama() {
        return nama;
    }

    public int getNilaiTugas() {
        return nilaiTugas;
    }

    public int getNilaiUts() {
        return nilaiUts;
    }

    public int getNilaiUas() {
        return nilaiUas;
    }

    /**
     * Nilai akhir dikali 10 (bilangan bulat).
     * 30% tugas + 30% UTS + 40% UAS = (3*tugas + 3*UTS + 4*UAS) / 10.
     * Memakai bilangan bulat supaya batas huruf mutu (misalnya tepat 80)
     * tidak terganggu pembulatan bilangan desimal.
     */
    public int getNilaiAkhirX10() {
        return 3 * nilaiTugas + 3 * nilaiUts + 4 * nilaiUas;
    }

    public double getNilaiAkhir() {
        return getNilaiAkhirX10() / 10.0;
    }

    /** Nilai akhir dengan dua angka di belakang koma, misalnya 82,50. */
    public String getNilaiAkhirTeks() {
        return BigDecimal.valueOf(getNilaiAkhirX10(), 1)
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString()
                .replace('.', ',');
    }

    public String getHuruf() {
        int x10 = getNilaiAkhirX10();
        if (x10 >= 800) {
            return "A";
        } else if (x10 >= 750) {
            return "B+";
        } else if (x10 >= 700) {
            return "B";
        } else if (x10 >= 650) {
            return "C+";
        } else if (x10 >= 600) {
            return "C";
        } else if (x10 >= 400) {
            return "D";
        } else {
            return "E";
        }
    }
}
