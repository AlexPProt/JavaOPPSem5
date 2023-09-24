package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Table {

    private static int counter;
    {
        no=++counter;
    }
    private final int no;

    public Collection<Reservation> reservations = new ArrayList<>();


 /*   public boolean delReservation (int idReserv){

                Iterator<Reservation> reservationIterator =reservations.iterator();
                System.out.printf("Дел в работе %d\n",reservations.size());
                while (reservationIterator.hasNext()){
                    System.out.printf("CHECK ID %d",idReserv);
                    Reservation nextReservation = reservationIterator.next();
                    System.out.printf("Ок1 %d\n",nextReservation.getId());
                    if (nextReservation.getId()==idReserv){
                        reservationIterator.remove();
                        System.out.printf("Удаляем бронь номер - %d\n",nextReservation.getId());
                        return true;
                    }
                }
                return false;
    }*/

    public int getNo() {
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public String toString() {
        return String.format("Столик #%d",no);
    }
}
