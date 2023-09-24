package presenters;

import models.Reservation;
import models.Table;
import models.TableService;
import views.BookingView;

import javax.swing.table.TableModel;
import java.util.Date;
import java.util.Collection;

public class BookingPresenter implements ViewObserver {
    private final Model tableService;
    private final View bookingView;

    public BookingPresenter(Model tableService, View bookingView) {
        this.tableService = tableService;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }
    public Collection<Table> loadTables(){
        return tableService.loadTables();
    }

    public void updateTablesUI(){
        bookingView.showTables(loadTables());
    }



    public  void updateReservationResultUI(int reservationId){
        bookingView.printReservationTableResult(reservationId);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = tableService.reservationTable(orderDate,tableNo,name);
        updateReservationResultUI(reservationNo);
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int newResevationNo = tableService.changeReservationTable(oldReservation,reservationDate,tableNo,name);

    }
}
