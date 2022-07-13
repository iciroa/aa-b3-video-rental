package VRUI;

import java.util.Date;

public class Video {
    public static final int REGULAR = 1;
    public static final int NEW_RELEASE = 2;

    public VideoType videoType;


    private String title;
    private VideoPriceCode priceCode;
    private Date registeredDate;
    private boolean rented;

    public Video(String title, VideoType videoType, int priceCode, Date registeredDate) {
        this.setTitle(title);
        this.setVideoType(videoType);
        if(priceCode == REGULAR)
            this.setPriceCode(VideoPriceCode.REGULAR);
        if(NEW_RELEASE == priceCode) {
            this.setPriceCode(VideoPriceCode.NEW_RELEASE);
        }
        this.registeredDate = registeredDate;
    }

    public int getLateReturnPointPenalty() {
        return videoType.getPentalty();
    }

    public VideoPriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(VideoPriceCode priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }

}
