import models.TableService;
import presenters.BookingPresenter;
import views.BookingView;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Program {
    public static void main(String[] args) {
        TableService model = new TableService();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model,view);
        bookingPresenter.updateTablesUI();
        view.reservationTable(new Date(), 3, "XXX");
        view.reservationTable(new Date(), 5, "XXX");
        view.reservationTable(new Date(), 4, "XXX");
        view.reservationTable(new Date(), 1, "XXX");
        view.changeReservationTable(103,new Date(),4,"AAA");

    }
}