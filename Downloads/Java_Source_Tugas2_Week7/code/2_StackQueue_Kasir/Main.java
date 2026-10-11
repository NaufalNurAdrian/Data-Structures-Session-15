import java.util.Scanner;

// Program sistem kasir toko: Queue untuk antrian, Stack untuk riwayat transaksi
public class Main {

    static int bacaMenu(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilih;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilih = bacaMenu(sc);
            System.out.println();

            switch (pilih) {
                case 1: // enqueue
                    System.out.print("Masukkan Nomor Antrian: ");
                    String kode = sc.nextLine().trim();
                    if (kode.isEmpty()) {
                        System.out.println("Nomor antrian tidak boleh kosong!");
                        break;
                    }
                    if (antrian.sudahAda(kode)) {
                        System.out.println("Nomor antrian sudah ada di antrian!");
                        break;
                    }
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine().trim();
                    if (nama.isEmpty()) {
                        System.out.println("Nama pelanggan tidak boleh kosong!");
                        break;
                    }
                    System.out.print("Masukkan Total Belanja: ");
                    long total;
                    try {
                        total = Long.parseLong(sc.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Total belanja harus berupa angka!");
                        break;
                    }
                    if (total <= 0) {
                        System.out.println("Total belanja harus lebih dari 0!");
                        break;
                    }
                    antrian.enqueue(kode, nama, total);
                    System.out.println("Data pelanggan ditambahkan ke antrian!");
                    if (antrian.getSize() < Queue.MIN_ANTRIAN) {
                        System.out.println("(Baru " + antrian.getSize() + " pelanggan, minimal " + Queue.MIN_ANTRIAN + " pelanggan)");
                    }
                    break;

                case 2: // dequeue + push ke stack
                    Node dilayani = antrian.dequeue();
                    if (dilayani == null) {
                        System.out.println("Antrian kosong, tidak ada pelanggan yang bisa dilayani.");
                    } else {
                        System.out.println("Melayani pelanggan " + dilayani.kode + " (" + dilayani.nama + ")");
                        System.out.println("Total belanja: " + dilayani.rupiah());
                        riwayat.push(dilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3:
                    antrian.tampilkan();
                    break;

                case 4:
                    riwayat.display();
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
