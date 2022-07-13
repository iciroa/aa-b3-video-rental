package VRUI;

import java.util.Date;

public class Rental {
    public static final int FOR_RENTED = 0;
    public static final int FOR_RETURNED = 1;

    private Video video;
    private int status; // 0 for Rented, 1 for Returned
    private Date rentDate;
    private Date returnDate;

    public Rental(Video video) {
        this.video = video;
        status = FOR_RENTED;
        rentDate = new Date();
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public int getStatus() {
        return status;
    }

    public void returnVideo() {
        if (status == FOR_RETURNED) {
            this.status = FOR_RETURNED;
            returnDate = new Date();
        }
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getDaysRentedLimit() {
        int limit = 0;
        int daysRented = getDaysRented();
        if (daysRented <= 2) return limit;

        switch (video.getVideoType()) {
            case Video.VHS:
                limit = 5;
                break;
            case Video.CD:
                limit = 3;
                break;
            case Video.DVD:
                limit = 2;
                break;
        }
        return limit;
    }

    public int getDaysRented() {
        int daysRented;
        long diff = 0;
        if (getStatus() == FOR_RETURNED) { // returned Video
            diff = returnDate.getTime() - rentDate.getTime();
        } else { // not yet returned
            diff = new Date().getTime() - rentDate.getTime();
        }
        daysRented = (int) (diff / (1000 * 60 * 60 * 24)) + 1;
        return daysRented;
    }
    public double getVideoCharge() {
        Video video = getVideo();
        int daysRented = getDaysRented();

        double charge = 0;
        switch (video.getPriceCode()) {
            case Video.REGULAR:
                charge += 2;
                if (daysRented > 2)
                    charge += (daysRented - 2) * 1.5;
                break;
            case Video.NEW_RELEASE:
                charge = daysRented * 3.0;
                break;

        }
        return charge;
    }
    public int getVideoPoint() {
        Video video = getVideo();
        int daysRented = getDaysRented();
        int daysRentedLimit = getDaysRentedLimit();

        int eachPoint = 0;
        eachPoint++;

        if (video.getPriceCode() == Video.NEW_RELEASE)
            eachPoint++;

        if (daysRented > daysRentedLimit)
            eachPoint -= Math.min(eachPoint, video.getLateReturnPointPenalty());
        return eachPoint;
    }
}
