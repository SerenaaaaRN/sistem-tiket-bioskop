package sistem.tiket.bioskop.controller;

import java.util.List;

import sistem.tiket.bioskop.model.Movie;
import sistem.tiket.bioskop.model.Schedule;
import sistem.tiket.bioskop.model.Studio;
import sistem.tiket.bioskop.repository.ScheduleRepository;

public class ScheduleController {
    private ScheduleRepository schRepo;

    public ScheduleController(ScheduleRepository schRepo) {
        this.schRepo = schRepo;
    }

    public boolean addSchedule(Movie mv, Studio std, String jamTayang) {
        if (mv == null || std == null || jamTayang == null || jamTayang.trim().isEmpty()) {
            return false;
        }

        for (Schedule s : schRepo.getAllSchedule()) {
            if (s.getStudio().getNamaStudio().equals(std.getNamaStudio())
                    && s.getJamTayang().equalsIgnoreCase(jamTayang)) {
                System.out.println("Studio sudah dipakai di jam tayang tersebut");
                return false;
            }
        }

        Schedule newSchedule = new Schedule(mv, std, jamTayang);

        schRepo.addSchedule(newSchedule);
        return true;
    }

    public List<Studio> getAllStudios() {
        return schRepo.getAllStudios();
    }

    public List<Schedule> getAllSchedules() {
        return schRepo.getAllSchedule();
    }
}