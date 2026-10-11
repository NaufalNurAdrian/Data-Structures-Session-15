// Class LinkedList: Single Linked List untuk menyimpan data buku perpustakaan
public class LinkedList {
    private Node head; // node pertama
    private Node tail; // node terakhir (biar tambah data di akhir cepat, O(1))
    private int size;  // jumlah buku saat ini

    public static final int MIN_BUKU = 5;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Tambah buku di akhir daftar (Push)
    public void tambahBuku(String kode, String judul, String penulis) {
        Node baru = new Node(kode, judul, penulis);
        if (isEmpty()) {
            head = baru;      // kalau masih kosong, node baru jadi head sekaligus tail
            tail = baru;
        } else {
            tail.next = baru; // sambungkan tail lama ke node baru
            tail = baru;      // tail pindah ke node baru
        }
        size++;
    }

    // Hapus buku terakhir (Pop). Return data yang dihapus, null kalau list kosong
    public Node hapusBuku() {
        if (isEmpty()) {
            return null;
        }
        Node dihapus = tail;
        if (head == tail) {
            // cuma ada satu node
            head = null;
            tail = null;
        } else {
            // cari node sebelum tail (single linked list tidak punya pointer prev)
            Node bantu = head;
            while (bantu.next != tail) {
                bantu = bantu.next;
            }
            bantu.next = null; // putus hubungan ke node terakhir
            tail = bantu;
        }
        size--;
        return dihapus;
    }

    // Cari buku berdasarkan kode (linear search dari head)
    public Node cariBuku(String kode) {
        Node bantu = head;
        while (bantu != null) {
            if (bantu.kodeBuku.equalsIgnoreCase(kode)) {
                return bantu; // ketemu
            }
            bantu = bantu.next;
        }
        return null; // tidak ketemu
    }

    // Tampilkan semua buku sesuai urutan input + total di akhir
    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Daftar buku masih kosong.");
            System.out.println("Total Buku: 0");
            return;
        }
        System.out.println("Daftar Buku:");
        Node bantu = head;
        while (bantu != null) {
            System.out.println("Kode: " + bantu.kodeBuku + " | Judul: " + bantu.judul
                    + " | Penulis: " + bantu.penulis);
            bantu = bantu.next;
        }
        System.out.println("Total Buku: " + size);
        if (size < MIN_BUKU) {
            System.out.println("(Catatan: data baru " + size + " buku, minimal harus " + MIN_BUKU + " buku)");
        }
    }
}
