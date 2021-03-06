package com.ox3dr.services.android.lib.drone.property;

import android.os.Parcel;
import android.os.Parcelable;

import com.ox3dr.services.android.lib.coordinate.LatLngAlt;

/**
 * Location from which the drone took off.
 */
public class Home implements Parcelable {

    /**
     * Lauch pad 3D coordinate.
     */
    private final LatLngAlt mCoordinate;

    public Home(float latitude, float longitude, float altitude){
        mCoordinate = new LatLngAlt(latitude, longitude, altitude);
    }

    public Home(LatLngAlt coordinate){
        mCoordinate = coordinate;
    }

    /**
     * @return the launch pad 3D coordinate.
     */
    public LatLngAlt getCoordinate(){
        return mCoordinate;
    }

    public boolean isValid(){
        return mCoordinate != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Home)) return false;

        Home home = (Home) o;

        return !(mCoordinate != null ? !mCoordinate.equals(home.mCoordinate) : home.mCoordinate != null);

    }

    @Override
    public int hashCode() {
        return mCoordinate != null ? mCoordinate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LaunchPad{" +
                "mCoordinate=" + mCoordinate +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mCoordinate, 0);
    }

    private Home(Parcel in) {
        this.mCoordinate = in.readParcelable(LatLngAlt.class.getClassLoader());
    }

    public static final Parcelable.Creator<Home> CREATOR = new Parcelable.Creator<Home>() {
        public Home createFromParcel(Parcel source) {
            return new Home(source);
        }

        public Home[] newArray(int size) {
            return new Home[size];
        }
    };
}
