package repository;

import java.util.ArrayList;
import java.util.List;

import model.Tiket;

public class TiketRepository {
    private List<Tiket> tikets = new ArrayList<>();

    public void addTiket(Tiket tiket) {
        tikets.add(tiket);
    }

    public Tiket findTiket(String datatiket) {
        for (Tiket t : tikets) {
            if (t.getJadwalFilm().getMovie().getNamaFilm().equalsIgnoreCase(datatiket)) {
                return t;
            }
        }
        return null;
    }

    public List<Tiket> getAllTiket() {
        return tikets;
    }

    public List<Tiket> findByUsername(String username) {
        List<Tiket> hasil = new ArrayList<>();
        for (Tiket t : tikets) {
            if (t.getUser() != null &&
                    t.getUser().getUsername().equals(username)) {

                hasil.add(t);
            }
        }
        return hasil;
    }
}
