package controller;
import model.Customer;
import model.Schedule;
import service.BookingService;

public class BookingController {
    // nanti untuk alur booking
    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public boolean pesanTiket(Customer customer, Schedule schedule, String seat, int harga){

        boolean berhasil = bookingService.pesanTiket(customer, schedule, seat, harga);

        if(!berhasil){
            System.out.println("Gagal memesan tiket!");
            return false;
        }

        System.out.println("Tiket berhasil dipesan!");
        return true;
    }
}

