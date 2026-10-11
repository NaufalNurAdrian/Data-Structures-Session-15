// Class Node: menyimpan data satu pelanggan (kode antrian, nama, total belanja)
public class Node {
    String kode;
    String nama;
    long total;  // total belanja dalam rupiah
    Node next;

    public Node(String kode, String nama, long total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }

    // Format tampilan rupiah, contoh 125000 -> Rp125.000
    public String rupiah() {
        return "Rp" + String.format("%,d", total).replace(',', '.');
    }

    @Override
    public String toString() {
        return kode + " | " + nama + " | " + rupiah();
    }
}
