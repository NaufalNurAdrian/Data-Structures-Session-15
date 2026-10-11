// Class Queue: antrian pelanggan (FIFO) pakai linked list
public class Queue {
    private Node front; // depan antrian (yang dilayani duluan)
    private Node rear;  // belakang antrian (tempat pelanggan baru masuk)
    private int size;

    public static final int MIN_ANTRIAN = 5;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Cek apakah nomor antrian sudah ada di antrian
    public boolean sudahAda(String kode) {
        Node bantu = front;
        while (bantu != null) {
            if (bantu.kode.equalsIgnoreCase(kode)) {
                return true;
            }
            bantu = bantu.next;
        }
        return false;
    }

    // enqueue: tambah pelanggan di belakang antrian
    public void enqueue(String kode, String nama, long total) {
        Node baru = new Node(kode, nama, total);
        if (isEmpty()) {
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        size++;
    }

    // dequeue: ambil pelanggan paling depan. Return null kalau antrian kosong
    public Node dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node keluar = front;
        front = front.next;
        if (front == null) {
            rear = null; // antrian jadi kosong
        }
        keluar.next = null;
        size--;
        return keluar;
    }

    // Tampilkan antrian dari depan ke belakang
    public void tampilkan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Antrian saat ini (depan -> belakang):");
        Node bantu = front;
        int no = 1;
        while (bantu != null) {
            System.out.println(no + ". " + bantu);
            bantu = bantu.next;
            no++;
        }
        System.out.println("Jumlah antrian: " + size);
    }
}
