package com.example.gzhang.sausage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GZhang on 2018-03-25.
 */

public class Dispute implements Parcelable{
    int imageRes;
    String title; //refers to same title as item
    String desc; //new desc; refers to argument...
    //store other tings...
    double voterAmount;
    double bounty;

    public Dispute(){
        imageRes = R.drawable.bike;
        title = "";
        desc = "";
        voterAmount = 0;
        bounty = 0;
    }

    public Dispute(int imageRes, String title, String desc, double voterAmount, double bounty){
        this.imageRes = imageRes;
        this.title = title;
        this.desc = desc;
        this.voterAmount = voterAmount;
        this.bounty = bounty;
    }


    protected Dispute(Parcel in) {
        imageRes = in.readInt();
        title = in.readString();
        desc = in.readString();
        voterAmount = in.readDouble();
        bounty = in.readDouble();
    }

    public static final Creator<Dispute> CREATOR = new Creator<Dispute>() {
        @Override
        public Dispute createFromParcel(Parcel in) {
            return new Dispute(in);
        }

        @Override
        public Dispute[] newArray(int size) {
            return new Dispute[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageRes);
        parcel.writeString(title);
        parcel.writeString(desc);
        parcel.writeDouble(voterAmount);
        parcel.writeDouble(bounty);
    }
}
