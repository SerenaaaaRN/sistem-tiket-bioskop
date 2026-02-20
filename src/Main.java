import model.*;

public class Main {
    public static void main(String[] args) {

        Customer c1 = new Customer("Rillah", "rila11", 100000);
        Movie m1 = new Movie(1, "Doraemon: Stand By Me", 120, "Animasi");
        Studio s1 = new Studio(1, "Studio 1 - CGV", 50, "Reguler");
        Schedule sch1 = new Schedule(101, m1, s1, "19:00 WIB");
        Tiket t1 = new Tiket(5001, u1, sch1, "C4", 35000);

        t1.printTiket();

    }
}