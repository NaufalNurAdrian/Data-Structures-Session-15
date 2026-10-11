// Class Node: satu node = satu data buku + pointer ke node berikutnya
public class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next; // penunjuk ke node selanjutnya (null kalau node terakhir)

    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}
