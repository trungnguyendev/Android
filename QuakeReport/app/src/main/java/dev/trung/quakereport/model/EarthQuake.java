package dev.trung.quakereport.model;

/**
 * Created by trungnv on 8/23/2016.
 */
public class EarthQuake {
    private String mMagnitude;
    private String mLocationPrimary;
    private String mDate;
    private String mTime;
    private String mLocationOffset;

    public EarthQuake() {
    }

    public EarthQuake(String mMagnitude, String mLocationOffset, String mLocationPrimary, String mDate, String mTime) {
        this.mMagnitude = mMagnitude;
        this.mLocationPrimary = mLocationPrimary;
        this.mDate = mDate;
        this.mTime = mTime;
        this.mLocationOffset = mLocationOffset;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(String mMagnitude) {
        this.mMagnitude = mMagnitude;
    }

    public String getmLocationPrimary() {
        return mLocationPrimary;
    }

    public void setmLocationPrimary(String mLocationPrimary) {
        this.mLocationPrimary = mLocationPrimary;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getmLocationOffset() {
        return mLocationOffset;
    }

    public void setmLocationOffset(String mLocationOffset) {
        this.mLocationOffset = mLocationOffset;
    }
}
