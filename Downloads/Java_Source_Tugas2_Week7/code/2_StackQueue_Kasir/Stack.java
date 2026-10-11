// Class Stack: riwayat transaksi (LIFO), transaksi terbaru ada di paling atas
public class Stack {
    private Node top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // push: simpan transaksi baru di atas stack
    public void push(Node data) {
        data.next = top; // node baru menunjuk ke top yang lama
        top = data;      // top pindah ke node baru
        size++;
    }

    // display: tampilkan riwayat dari yang terbaru (atas) ke yang paling lama
    public void display() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        System.out.println("Riwayat Transaksi (terbaru -> terlama):");
        Node bantu = top;
        int no = 1;
        long jumlah = 0;
        while (bantu != null) {
            System.out.println(no + ". " + bantu);
            jumlah += bantu.total;
            bantu = bantu.next;
            no++;
        }
        System.out.println("Total transaksi: " + size);
        System.out.println("Total pendapatan: Rp" + String.format("%,d", jumlah).replace(',', '.'));
    }
}
