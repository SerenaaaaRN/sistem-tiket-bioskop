package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Tiket;
import model.User;

public class TiketRepository {
    private List<Tiket> tikets = new ArrayList<>();

    public void addTiket() {
        UserRepository custRepo = new UserRepository();

        List<User> custs = custRepo.getAllUsers();

        Tiket t1 = new Tiket(1, custs.get(0), null, "A-10", 45000);
        Tiket t2 = new Tiket(2, custs.get(1), null, "B-12", 45000);
        Tiket t3 = new Tiket(3, custs.get(2), null, "D-7", 45000);
        Tiket t4 = new Tiket(4, custs.get(4), null, "F-18", 60000);
        Tiket t5 = new Tiket(5, custs.get(5), null, "G-9", 60000);
        tikets.addAll(Arrays.asList(t1, t2, t3, t4, t5));
    }

    public Tiket findTiket(String datatiket) {
        for (Tiket t : tikets) {
            if (t.getJadwalFilm().equals(datatiket)) {
                return t;
            }
        }
        return null;
    }

    public List<Tiket> getAllMovies() {
        return tikets;

    }

    public void addTiket(Tiket tiket) {
        tikets.add(tiket);
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
