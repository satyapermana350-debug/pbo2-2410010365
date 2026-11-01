# Jawaban Eksperimen Praktikum 5 – P07

**Mata Kuliah:** Pemrograman Berorientasi Objek 2  
**Materi:** Tabel, Menu, dan Mini Proyek GUI  
**Nama:** Dian Satya Permana 
**NPM:** 2410010365 
**Kelas:** 5B Reguler Banjarmasin

## 1. Mengomentari `fireTableRowsInserted(baris, baris)`

**Jawaban:** Tabel tidak langsung menampilkan baris baru secara otomatis. Data kontak memang sudah ditambahkan ke dalam `List`, tetapi `JTable` tidak menerima pemberitahuan bahwa ada baris baru.

**Kesimpulan:** `fireTableRowsInserted(baris, baris)` diperlukan agar `JTable` memperbarui tampilan setelah data ditambahkan.

## 2. Mengganti `barisTerpilih()` dengan `getSelectedRow()`

**Jawaban:** Nama yang muncul pada dialog konfirmasi adalah **Budi Santoso**.

**Penjelasan:** Setelah pencarian kata `ah`, Ahmad Fauzi berada pada baris kedua di tampilan tabel, yaitu indeks tampilan `1`. Namun, posisi aslinya di model adalah indeks `2`. Jika konversi indeks tidak dilakukan, program membaca data pada indeks `1` di model, yaitu Budi Santoso.

**Kesimpulan:** `convertRowIndexToModel()` diperlukan agar operasi mengubah atau menghapus data tetap mengarah ke baris yang benar setelah tabel disaring atau diurutkan.

## 3. Mengubah dialog modal menjadi modeless

**Jawaban:** Jika parameter `true` diganti menjadi `false`, dialog tidak lagi mengunci jendela utama. Jendela utama tetap bisa diklik dan digunakan meskipun dialog masih terbuka. Pengguna dapat kembali ke jendela utama dan melakukan penambahan kontak tanpa harus menutup dialog yang pertama.

**Kesimpulan:** Dialog modeless memungkinkan pengguna berinteraksi dengan jendela utama selama dialog masih terbuka, berbeda dengan dialog modal.

## 4. Mencoba pintasan Ctrl+N, Ctrl+E, dan Ctrl+D

**Jawaban:** `Ctrl+N` tetap bisa digunakan untuk menambah kontak. Sementara itu, `Ctrl+E` dan `Ctrl+D` tidak bekerja ketika belum ada baris yang dipilih.

**Penjelasan:** Item menu Ubah dan Hapus dinonaktifkan ketika tidak ada baris yang dipilih. Kondisi ini diatur melalui `perbaruiTombol()`, yang juga mengatur status tombol Ubah dan Hapus.

**Kesimpulan:** Pintasan Ctrl+E dan Ctrl+D tidak dapat menjalankan item menu yang sedang dinonaktifkan.

## 5. Mengubah accelerator Hapus menjadi tombol Delete tanpa Ctrl

**Jawaban:** Baris pada `initComponents()` berubah pada bagian pengaturan accelerator `hapusItem`.

Contoh perubahan:

```java
hapusItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
        java.awt.event.KeyEvent.VK_DELETE, 0));
```

Angka `0` berarti tidak menggunakan tombol modifier seperti Ctrl. Dengan begitu, item menu Hapus menggunakan tombol **Delete** saja.

## 6. Menginisialisasi model setelah `initComponents()`

**Jawaban:** Program mengalami `NullPointerException` saat dijalankan.

**Penjelasan:** `initComponents()` mengatur model tabel melalui baris `kontakTable.setModel(model)`. Jika `model` baru dibuat setelah `initComponents()`, nilai `model` masih `null` ketika baris tersebut dijalankan. Akibatnya, JTable menerima model yang belum dibuat dan program mengalami error.

**Kesimpulan:** `KontakTableModel` harus diinisialisasi sebelum `initComponents()` agar model sudah tersedia saat JTable diatur.
