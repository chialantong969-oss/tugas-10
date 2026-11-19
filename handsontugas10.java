
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// Generic Class Produk
class Produk<T, U> {
    private T nama;
    private U harga;
    private Integer stok;

    // Constructor
    public Produk(T nama, U harga, Integer stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Mengubah objek menjadi String
    @Override
    public String toString() {
        return nama + "," + harga + "," + stok;
    }
}

// Generic Class untuk data lain
class Data<T, U, V> {
    private T nama;
    private U informasi;
    private V jumlah;

    public Data(T nama, U informasi, V jumlah) {
        this.nama = nama;
        this.informasi = informasi;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return nama + "," + informasi + "," + jumlah;
    }
}

public class handsontugas10 {
    public static void main(String[] args) {

        // Membuat daftar produk
        List<Produk<String, Double>> produkList = new ArrayList<>();

        produkList.add(new Produk<>("Laptop", 15000000.0, 10));
        produkList.add(new Produk<>("Mouse", 150000.0, 25));
        produkList.add(new Produk<>("Keyboard", 350000.0, 15));

        // Menentukan lokasi file
        Path filePath = Paths.get("produk_output.txt");

        try {
            // Menyimpan data produk ke file
            List<String> lines = new ArrayList<>();

            for (Produk<String, Double> p : produkList) {
                lines.add(p.toString());
            }

            Files.write(filePath, lines);

            System.out.println("Data produk berhasil disimpan!");

            // Membaca kembali isi file
            List<String> hasilBaca = Files.readAllLines(filePath);

            System.out.println("\n=== DATA PRODUK ===");

            for (String data : hasilBaca) {
                System.out.println(data);
            }

            // Contoh penggunaan Generic untuk pelanggan
            Data<String, String, Integer> pelanggan =
                new Data<>("Andi", "Makassar", 20);

            System.out.println("\n=== DATA PELANGGAN ===");
            System.out.println(pelanggan);

            // Contoh penggunaan Generic untuk transaksi
            Data<String, String, Integer> transaksi =
                new Data<>("TR001", "Pembelian Laptop", 1);

            System.out.println("\n=== DATA TRANSAKSI ===");
            System.out.println(transaksi);

        } catch (IOException e) {
            System.out.println("Gagal mengelola file: " + e.getMessage());
        }
    }
}
