package app;
import repository.*;
import controller.*;

/*
 * ini adalah app atau main untuk menjalankan project
 */

public class App {
    public static void main(String[] args) {

        UserRepository userRepo = new repository.UserRepository();
        MovieRepository movieRepo = new repository.MovieRepository();
        ScheduleRepository schRepo = new repository.ScheduleRepository();
        TiketRepository tiketRepo = new repository.TiketRepository();

        AuthController authCtrl = new controller.AuthController(userRepo);
        MovieController movieCtrl = new controller.MovieController(movieRepo);
        ScheduleController schCtrl = new controller.ScheduleController(schRepo);
        BookingController bookCtrl = new controller.BookingController(tiketRepo);

        java.awt.EventQueue.invokeLater(() -> {
            new view.MainFrame(authCtrl, movieCtrl, schCtrl, bookCtrl).setVisible(true);
        });
    }
}