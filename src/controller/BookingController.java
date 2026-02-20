package controller;

import model.Customer;
import model.Schedule;
import model.Tiket;
import repository.TiketRepository;
import service.BookingService;

public class BookingController {

    private BookingService bookingService;
    private TiketRepository tiketRepo;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public boolean pesanTiket(Customer customer, Schedule schedule, String seat, int harga) {
        if (!bookingService.isSeatAvailable(schedule, seat)) {
            return false;
        }
        if (customer.getSaldo() < harga) {
            return false;
        }
        customer.setSaldo(customer.getSaldo() - harga);

        Tiket tiketBaru = new Tiket(
                tiketRepo.getAllTiket().size() + 1,
                customer,
                schedule,
                seat,
                harga);

        tiketRepo.addTiket(tiketBaru);

        return true;
    }
}
