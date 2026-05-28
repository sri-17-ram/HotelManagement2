import controller.HotelController;
import view.HotelView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelController controller = new HotelController();
        HotelView view = new HotelView(sc);

        while (true) {
            view.showMenu();
            int choice = view.getChoice();

            switch (choice) {
                case 1 -> view.displayRooms(controller.getRooms());
                case 2 -> {
                    int rn = view.getRoomNumber("Room number: ");
                    String name = view.getCustomerName();
                    String phone = view.getPhone();
                    String email = view.getEmail();
                    int days = view.getDaysStayed();
                    view.showMessage(controller.bookRoom(rn, name, phone, email, days));
                }
                case 3 -> {
                    int rn = view.getRoomNumber("Room number: ");
                    int charges = view.getCharges();
                    view.showMessage(controller.addCharges(rn, charges));
                }
                case 4 -> {
                    int rn = view.getRoomNumber("Room number: ");
                    view.showMessage(controller.checkoutRoom(rn));
                }
                case 5 -> view.showMessage("Data saved.");
                case 6 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
