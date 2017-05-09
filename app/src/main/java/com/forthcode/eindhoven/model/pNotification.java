package com.forthcode.eindhoven.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chetan.Nayak on 2017-04-24.
 */

public class pNotification implements Parcelable {
    private String pid,pTitle,pMessage;
    public static final String TABLE_NAME = "notification";
    public static final String P_ID = "pID";
    public static final String P_TITLE = "pTitle";
    public static final String P_MESSGAE = "pTitle";

    public pNotification() {
    }

    protected pNotification(Parcel in) {
        pid = in.readString();
        pTitle = in.readString();
        pMessage = in.readString();
    }

    public static final Creator<pNotification> CREATOR = new Creator<pNotification>() {
        @Override
        public pNotification createFromParcel(Parcel in) {
            return new pNotification(in);
        }

        @Override
        public pNotification[] newArray(int size) {
            return new pNotification[size];
        }
    };

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpMessage() {
        return pMessage;
    }

    public void setpMessage(String pMessage) {
        this.pMessage = pMessage;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public pNotification(String pid, String pTitle, String pMessage) {
        this.pid = pid;
        this.pTitle = pTitle;
        this.pMessage = pMessage;
    }

    public pNotification(String pTitle, String pMessage) {
        this.pTitle = pTitle;
        this.pMessage = pMessage;
    }

    public static String CREATE_TABLE() {
        String PlaceTable = "CREATE TABLE " + TABLE_NAME + " ("
                + P_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + P_TITLE+ " TEXT, "
                + P_MESSGAE + " TEXT)";
        return PlaceTable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(pid);
        parcel.writeString(pTitle);
        parcel.writeString(pMessage);
    }
}
