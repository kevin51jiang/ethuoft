package com.example.gzhang.sausage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BoughtItem implements Parcelable {
    int imageRes;
    String title;
    String desc;
    double cost;
    int downPaymentPercent;

    public BoughtItem(){
        imageRes = -1;
        title = "";
        desc = "";
        cost = 0;
        downPaymentPercent = 0;
    }

    public BoughtItem(int imageRes, String title, String desc, double cost, int downPaymentPercent){
        this.imageRes = imageRes;
        this.title = title;
        this.desc = desc;
        this.cost = cost;
        this.downPaymentPercent = downPaymentPercent;
    }

    protected BoughtItem(Parcel in) {
        imageRes = in.readInt();
        title = in.readString();
        desc = in.readString();
        cost = in.readDouble();
        downPaymentPercent = in.readInt();
    }

    public static final Creator<BoughtItem> CREATOR = new Creator<BoughtItem>() {
        @Override
        public BoughtItem createFromParcel(Parcel in) {
            return new BoughtItem(in);
        }

        @Override
        public BoughtItem[] newArray(int size) {
            return new BoughtItem[size];
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
        parcel.writeDouble(cost);
        parcel.writeInt(downPaymentPercent);
    }
}
