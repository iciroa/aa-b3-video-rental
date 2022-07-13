package VRUI;
public enum VideoPriceCode {
    REGULAR {
        double getRentCharge (int daysRented) {
            double charge = 2;
            if (daysRented > 2) charge += (daysRented-2)*1.5;
            return charge;
        }
    },

    NEW_RELEASE {
        double getRentCharge (int daysRented) {
            return daysRented * 3.0;
        }
    };

    abstract double getRentCharge(int dayRented);
}
