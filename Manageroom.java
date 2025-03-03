import java.util.*;

class FlightInformation {
    String flightNumber;
    String seatNumber;
    Date pickupTime;

    public FlightInformation(String flightNumber, String seatNumber, Date pickupTime) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.pickupTime = pickupTime;
    }
}

class Reservation {
    int bookingID;
    String customerName;
    String phoneNumber;
    int roomNumber;
    Date bookingDate;
    FlightInformation flightInfo;

    public Reservation(int bookingID, String customerName, String phoneNumber, int roomNumber, Date bookingDate, FlightInformation flightInfo) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInfo = flightInfo;
    }
}

class ReservationManager {
    List<Reservation> reservations = new ArrayList<>();

    public void addReservation(int bookingID, String customerName, String phoneNumber, int roomNumber, Date bookingDate, String flightNumber, String seatNumber, Date pickupTime) {
        FlightInformation flightInfo = new FlightInformation(flightNumber, seatNumber, pickupTime);
        Reservation reservation = new Reservation(bookingID, customerName, phoneNumber, roomNumber, bookingDate, flightInfo);
        reservations.add(reservation);
        System.out.println("Reservation added successfully.");
    }

    public Reservation findReservation(int bookingID) {
        for (Reservation res : reservations) {
            if (res.bookingID == bookingID) {
                return res;
            }
        }
        return null;
    }

    public void updateReservation(int bookingID, String customerName, String phoneNumber, int roomNumber, Date bookingDate, Date pickupTime) {
        Reservation res = findReservation(bookingID);
        if (res != null) {
            res.customerName = customerName;
            res.phoneNumber = phoneNumber;
            res.roomNumber = roomNumber;
            res.bookingDate = bookingDate;
            res.flightInfo.pickupTime = pickupTime;
            System.out.println("Reservation updated successfully.");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    public void deleteReservation(int bookingID) {
        Reservation res = findReservation(bookingID);
        if (res != null) {
            reservations.remove(res);
            System.out.println("Reservation deleted successfully.");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    public void listReservations() {
        for (Reservation res : reservations) {
            System.out.println(res.bookingID + ", " + res.customerName + ", " + res.phoneNumber + ", " + res.roomNumber + ", " + res.bookingDate + ", " + res.flightInfo.flightNumber);
        }
    }

    public void listPickupOrder() {
        reservations.sort(Comparator.comparing(r -> r.flightInfo.pickupTime));
        listReservations();
    }
}

public class Manageroom {
    public static void main(String[] args) {
        ReservationManager manager = new ReservationManager();
        manager.addReservation(123456, "sage", "123456789012", 1001, new Date(2025-1900, 4, 10), "A123", "12A", new Date(2025-1900, 4, 9, 10, 0));
        manager.listReservations();
        manager.listPickupOrder();
    }
}
