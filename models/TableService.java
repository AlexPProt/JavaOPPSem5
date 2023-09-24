package models;

import presenters.Model;

import javax.swing.event.TableModelListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class TableService implements Model {

    private Collection<Table> tables;

    public TableService() {
    }


    /**
     * Получить список всех столиков
     * @return  коллекция столиков
     */
    public  Collection<Table> loadTables(){
        if (tables==null){
            tables = new ArrayList<>();

            tables.add (new Table());
            tables.add (new Table());
            tables.add (new Table());
            tables.add (new Table());
            tables.add (new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate    дата
     * @param tableNo           номер столика
     * @param name              имя клиента
     * @return                  номер брони
     */
    public int reservationTable (Date reservationDate, int tableNo, String name){
        for (Table table: loadTables()){
            if (table.getNo()==tableNo){
                Reservation reservation= new Reservation(reservationDate,name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Некорректный номер столика");
    }

    /**
     * Изменение номера брони столика
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */

        public int changeReservationTable(int oldReservation,Date reservationDate,int tableNo, String name){

        for (Table table: loadTables()){
            if (table.getNo()==tableNo){
                Reservation reservation= new Reservation(reservationDate,name);
                table.getReservations().add(reservation);
                System.out.println("Бронь столика добавлена");
                delReservation(oldReservation);

                /*/ЧТО ПЕРВИЧНО??????

                Iterator<Table.> reservationIterator =reservations.iterator();
                System.out.printf("Ок",reservations.);
                while (reservationIterator.hasNext()){
                    System.out.println("Ок1");
                    Reservation nextReservation = reservationIterator.next();
                    if (nextReservation.getId()==oldReservation){
                        System.out.println("Ок2");
                        reservationIterator.remove();
                    }
                }*/
                return reservation.getId();
            }
        }
        return -1;
    }

    /**
     * Попытка работать с списком Резервов - фиаско
     */
    public Collection<Reservation> reservations ;



    /**
     * Удаление резерва из списка резервов
     * @param idReserv  - идентификатор резерва
     * @return
     */
    public boolean delReservation (int idReserv){

        System.out.printf("Дел в работе %d\n",reservations.size());
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
    }
}
