package VRUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// test jaeyoung
public class Customer {
    static final String CONGRAT_MESSAGE = "Congrat! you earned one free coupon";
    private String name;

    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);

    }

    public String getReport() {
        String result = "VRUI.Customer Report for " + getName() + "\n";

        List<Rental> rentals = getRentals();

        double totalCharge = 0;
        int totalPoint = 0;

        for (Rental each : rentals) {
            double eachCharge = 0;
            int eachPoint = 0;
            int daysRented = each.getDaysRented();

            eachCharge = each.getVideoCharge();
            eachPoint = each.getVideoPoint();

            result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                    + "\tPoint: " + eachPoint + "\n";

            totalCharge += eachCharge;
            totalPoint += eachPoint;
        }

        result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";


        if (totalPoint >= 10) {
            System.out.println(CONGRAT_MESSAGE);
        }
        if (totalPoint >= 30) {
            System.out.println(CONGRAT_MESSAGE);
        }
        return result;
    }
}
