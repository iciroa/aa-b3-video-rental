package VRUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRUI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DataControl datacontrol = new DataControl(scanner);

        boolean quit = false;
        while (!quit) {
            int command = showCommand();
            switch (command) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    datacontrol.listCustomers();
                    break;
                case 2:
                    datacontrol.listVideos();
                    break;
                case 3:
                    datacontrol.registerCustomer();
                    break;
                case 4:
                    datacontrol.registerVideo();
                    break;
                case 5:
                    datacontrol.rentVideo();
                    break;
                case 6:
                    datacontrol.returnVideo();
                    break;
                case 7:
                    datacontrol.getCustomerReport();
                    break;
                case 8:
                    datacontrol.clearRentals();
                    break;
                case -1:
                    datacontrol.init();
                    break;
                default:
                    break;
            }
        }
        System.out.println("Bye");
    }

    public static int showCommand() {
        System.out.println("\nSelect a command !");
        System.out.println("\t 0. Quit");
        System.out.println("\t 1. List customers");
        System.out.println("\t 2. List videos");
        System.out.println("\t 3. Register customer");
        System.out.println("\t 4. Register video");
        System.out.println("\t 5. Rent video");
        System.out.println("\t 6. Return video");
        System.out.println("\t 7. Show customer report");
        System.out.println("\t 8. Show customer and clear rentals");

        int command = scanner.nextInt();

        return command;

    }
}
