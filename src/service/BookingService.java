package service;

import model.Schedule;
import model.Tiket;
import repository.TiketRepository;

public class BookingService {
    private TiketRepository tiketRepo;

    public BookingService(TiketRepository tiketRepo) {
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

}
