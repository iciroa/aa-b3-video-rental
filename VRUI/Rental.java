package VRUI;

import java.util.Date;

import static VRUI.RentStatus.FOR_RENTED;
import static VRUI.RentStatus.FOR_RETURNED;

public class Rental {
    private Video video;
    private RentStatus status;
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

    public RentStatus getStatus() {
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

    public long getTimeOfGetRentDate() {
        return rentDate.getTime();
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public long getTimeOfReturnDate() {
        return returnDate.getTime();
    }

    public int getDaysRentedLimit() {
        int limit = 0;
        int daysRented = getDaysRented();
        if (daysRented <= 2) return limit;

        return video.getVideoType().getLimit();
    }

    public int getDaysRented() {
        int daysRented;
        long diff = 0;
        if (getStatus() == FOR_RETURNED) { // returned Video
            diff = getTimeOfReturnDate() - getTimeOfGetRentDate();
        } else { // not yet returned
            diff = new Date().getTime() - getTimeOfGetRentDate();
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
