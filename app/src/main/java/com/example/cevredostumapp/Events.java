package com.example.cevredostumapp;
//gizemozgen
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.firestore.Exclude;
import java.text.SimpleDateFormat;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Events implements Parcelable {
    @Exclude
    private String name;
    private String description;
    private String date;
    private Double time;
    private String location;
    private int userNum;

    private List<String> events = new ArrayList<>();


    public Events(String name,String description,String date,Double time,String location, int userNum){


        this.name = name;
        this.description= description;
        this.date= date;
        this.time= time;
        this.location = location;
        this.userNum = userNum;



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.date);
        dest.writeValue(this.time);
        dest.writeString(this.location);
        dest.writeInt(this.userNum);
        dest.writeStringList(this.events);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.description = source.readString();
        this.date = source.readString();
        this.time = (Double) source.readValue(Double.class.getClassLoader());
        this.location = source.readString();
        this.userNum = source.readInt();
        this.events = source.createStringArrayList();
    }

    protected Events(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.date = in.readString();
        this.time = (Double) in.readValue(Double.class.getClassLoader());
        this.location = in.readString();
        this.userNum = in.readInt();
        this.events = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Events> CREATOR = new Parcelable.Creator<Events>() {
        @Override
        public Events createFromParcel(Parcel source) {
            return new Events(source);
        }

        @Override
        public Events[] newArray(int size) {
            return new Events[size];
        }
    };
}
