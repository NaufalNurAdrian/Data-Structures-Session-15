import java.util.Scanner;

// Program pengelolaan data buku perpustakaan (Single Linked List)
public class Main {

    // Baca pilihan menu, kalau bukan angka dianggap 0 (pilihan tidak valid)
    static int bacaMenu(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList daftar = new LinkedList();
        int pilih;

        do {
            // Tampilan menu
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilih = bacaMenu(sc);
            System.out.println();

            switch (pilih) {
                case 1: // Tambah buku
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine().trim();
                    // validasi: kode tidak boleh kosong & maksimal 5 karakter
                    if (kode.isEmpty() || kode.length() > 5) {
                        System.out.println("Kode buku tidak valid! Harus 1 - 5 karakter.");
                        break;
                    }
                    // validasi tambahan: kode tidak boleh sama dengan yang sudah ada
                    if (daftar.cariBuku(kode) != null) {
                        System.out.println("Kode buku sudah dipakai! Gunakan kode lain.");
                        break;
                    }
                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine().trim();
                    if (judul.isEmpty() || penulis.isEmpty()) {
                        System.out.println("Judul dan penulis tidak boleh kosong!");
                        break;
                    }
                    daftar.tambahBuku(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    if (daftar.getSize() < LinkedList.MIN_BUKU) {
                        System.out.println("(Baru " + daftar.getSize() + " buku, minimal " + LinkedList.MIN_BUKU + " buku)");
                    }
                    break;

                case 2: // Hapus buku terakhir
                    Node dihapus = daftar.hapusBuku();
                    if (dihapus == null) {
                        System.out.println("Tidak ada data untuk dihapus.");
                    } else {
                        System.out.println("Buku terakhir berhasil dihapus:");
                        System.out.println("Kode: " + dihapus.kodeBuku + " | Judul: " + dihapus.judul
                                + " | Penulis: " + dihapus.penulis);
                    }
                    break;

                case 3: // Cari buku
                    System.out.print("Masukkan Kode Buku yang dicari: ");
                    String cari = sc.nextLine().trim();
                    Node hasil = daftar.cariBuku(cari);
                    if (hasil == null) {
                        System.out.println("Buku tidak ditemukan.");
                    } else {
                        System.out.println("Buku ditemukan!");
                        System.out.println("Kode    : " + hasil.kodeBuku);
                        System.out.println("Judul   : " + hasil.judul);
                        System.out.println("Penulis : " + hasil.penulis);
                    }
                    break;

                case 4: // Tampilkan semua
                    daftar.tampilkanSemua();
                    break;

                case 5:
                    System.out.println("Terima kasih, program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi (1-5).");
            }
        } while (pilih != 5);

        sc.close();
    }
}
