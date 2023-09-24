package views;

import models.Reservation;
import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;
import java.util.Iterator;

public class BookingView implements View {

    private ViewObserver observer;

    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. номер брони: #%d\n", reservationNo);
        else
            System.out.printf("Не удалось забронировать столик\n");
    }

    public void reservationTable(Date orderDate, int tableNo, String name) {
        observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * Перерезрвировнаие столика
     * @param oldReservation номер старой брони
     * @param reservationDate новая дата бронирования
     * @param tableNo новый номер столика
     * @param name новое имя
     */
    public  void changeReservationTable(int oldReservation,Date reservationDate,int tableNo, String name){
        observer.onChangeReservationTable(oldReservation,reservationDate,tableNo,name);
    }
}


