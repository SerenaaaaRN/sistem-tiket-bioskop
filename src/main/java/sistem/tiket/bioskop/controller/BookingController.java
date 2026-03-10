package sistem.tiket.bioskop.controller;

import java.util.List;

import sistem.tiket.bioskop.model.Customer;
import sistem.tiket.bioskop.model.Schedule;
import sistem.tiket.bioskop.model.Tiket;
import sistem.tiket.bioskop.repository.TiketRepository;

public class BookingController {
    private TiketRepository tiketRepo;

    public BookingController(TiketRepository tiketRepo) {
        this.tiketRepo = tiketRepo;
    }

    public boolean isSeatAvailable(Schedule schedule, String seat) {
        for (Tiket t : tiketRepo.getAllTiket()) {
            if (t.getJadwalFilm().equals(schedule) &&
                    t.getSeat().equalsIgnoreCase(seat)) {
                return false;
            }
        }
        return true;
    }

    public boolean pesanTiket(Customer cust, Schedule sch, String seat) {
        if (!isSeatAvailable(sch, seat)) {
            System.out.println("Kursi sudah terisi!");
            return false;
        }
        int harga = sch.getHarga();

        if (cust.getSaldo() < harga) {
            System.out.println("Saldo tidak mencukupi! Harga: Rp" + harga + ", Saldo anda: Rp" + cust.getSaldo());
            return false;
        }

        cust.setSaldo(cust.getSaldo() - harga);
        Tiket newTiket = new Tiket(cust, sch, seat, harga);

        tiketRepo.addTiket(newTiket);
        return true;
    }

    public List<Tiket> getTiketByUsername(String username) {
        return tiketRepo.findByUsername(username);
    }
}