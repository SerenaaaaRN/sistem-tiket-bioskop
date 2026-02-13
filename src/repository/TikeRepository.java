package repository;

import java.util.ArrayList;
import java.util.List;
import model.Tiket;

public class TikeRepository {
    private List<Tiket> tikets = new ArrayList<>();
    
    public void addTiket(){
        Tiket t1 = new Tiket(1, null, null, null, 0);
    }
}
