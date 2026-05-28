package view;

import model.Room;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelView {

    private Scanner sc;

    public HotelView(Scanner sc) {
        this.sc = sc;
    }

    public void showMenu() {
        System.out.println("\n--- Hotel Menu ---");
        System.out.println("1. Display Rooms");
        System.out.println("2. Book Room");
        System.out.println("3. Add Charges");
        System.out.println("4. Checkout");
        System.out.println("5. Save");
        System.out.println("6. Exit");
    }

    public int getChoice() {
        System.out.print("Choice: ");
        return sc.nextInt();
    }

    public int getRoomNumber(String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    public String getCustomerName() {
        System.out.print("Customer name: ");
        sc.nextLine();
        return sc.nextLine();
    }

    public String getPhone() {
        System.out.print("Phone: ");
        return sc.next();
    }

    public String getEmail() {
        System.out.print("Email: ");
        return sc.next();
    }

    public int getDaysStayed() {
        System.out.print("Days stayed: ");
        return sc.nextInt();
    }

    public int getCharges() {
        System.out.print("Extra charges: ");
        return sc.nextInt();
    }

    public void displayRooms(ArrayList<Room> list) {
        System.out.println("\nRooms:");
        for (Room r : list) {
            System.out.println("Room " + r.roomNumber + " - " + r.type +
                    (r.booked ? " (Booked)" : " (Available)"));
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
