package service;
import repository.TikeRepository;
import model.Schedule;
import model.Tiket;
import model.Customer;

public class BookingService {
    //logic nanti apakah kursi sudah dipesan atau belum
    private TikeRepository tiketRepo;

    public BookingService(TikeRepository tiketRepo){
        this.tiketRepo = tiketRepo;
    }

    public boolean isSeatAvailable(Schedule schedule, String seat){
        for(Tiket t : tiketRepo.getAllTiket()){
            if(t.getJadwalFilm().equals(schedule) &&
               t.getSeat().equalsIgnoreCase(seat)){
                return false;
            }
        }
        return true;
    }

    public boolean pesanTiket(Customer customer, Schedule schedule, String seat, int harga){

        
        if(!isSeatAvailable(schedule, seat)){
            return false;
        }

        
        if(customer.getSaldo() < harga){
            return false;
        }

        
        customer.setSaldo(customer.getSaldo() - harga);

        
        Tiket tiketBaru = new Tiket(
                tiketRepo.getAllTiket().size() + 1,
                customer,
                schedule,
                seat,
                harga
        );

        tiketRepo.addTiket(tiketBaru);

        return true;
    }
}
