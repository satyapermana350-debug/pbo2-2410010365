/*
 * Nama : Dian Satya Permana 
 * NPM  : 2410010365
 */
package id.ac.uniska.pbo2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabel untuk JTable: menyimpan daftar NilaiMahasiswa.
 */
public class NilaiTableModel extends AbstractTableModel {

    private static final String[] NAMA_KOLOM = {"NPM", "Nama", "Tugas", "UTS", "UAS", "Akhir", "Huruf"};

    private final List<NilaiMahasiswa> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return NAMA_KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return NAMA_KOLOM[kolom];
    }

    @Override
    public Class<?> getColumnClass(int kolom) {
        // Kolom Tugas, UTS, UAS bertipe Integer agar otomatis rata kanan.
        if (kolom >= 2 && kolom <= 4) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        NilaiMahasiswa m = daftar.get(baris);
        switch (kolom) {
            case 0:
                return m.getNpm();
            case 1:
                return m.getNama();
            case 2:
                return m.getNilaiTugas();
            case 3:
                return m.getNilaiUts();
            case 4:
                return m.getNilaiUas();
            case 5:
                return m.getNilaiAkhirTeks();
            default:
                return m.getHuruf();
        }
    }

    public void tambah(NilaiMahasiswa m) {
        daftar.add(m);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public boolean adaNpm(String npm) {
        for (NilaiMahasiswa m : daftar) {
            if (m.getNpm().equals(npm)) {
                return true;
            }
        }
        return false;
    }

    public int getJumlah() {
        return daftar.size();
    }

    /** Rata-rata nilai akhir dengan dua angka di belakang koma, misalnya 71,80. */
    public String getRataRataAkhirTeks() {
        if (daftar.isEmpty()) {
            return "0,00";
        }
        long totalX10 = 0;
        for (NilaiMahasiswa m : daftar) {
            totalX10 += m.getNilaiAkhirX10();
        }
        return BigDecimal.valueOf(totalX10)
                .divide(BigDecimal.valueOf(10L * daftar.size()), 2, RoundingMode.HALF_UP)
                .toPlainString()
                .replace('.', ',');
    }
}
