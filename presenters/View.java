package presenters;

import models.Reservation;
import models.Table;

import java.util.Collection;

public interface View {
    /**
     * Отобразить список столиков в приложении
     * @param tables список столиков
     */
    void showTables (Collection<Table> tables);



  //  void  showReservation(Collection<Reservation> reservations);




    /**
     * Регистрация наблюдателя
     * @param observer
     */
    void setObserver(ViewObserver observer);

    /**
     * Распечатаь результата бронирования столика
     * @param reservationNo номер резерва
     */
    void printReservationTableResult (int reservationNo);
}
