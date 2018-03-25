package com.example.gzhang.sausage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by GZhang on 2018-03-24.
 */

class BuyerItem implements Parcelable {
    int imageRes;
    String desc;

    public BuyerItem(){
        imageRes = -1;
        desc = "";
    }

    public BuyerItem(int imageRes, String desc){
        this.imageRes = imageRes;
        this.desc = desc;
    }

    protected BuyerItem(Parcel in) {
        imageRes = in.readInt();
        desc = in.readString();
    }

    public static final Creator<BuyerItem> CREATOR = new Creator<BuyerItem>() {
        @Override
        public BuyerItem createFromParcel(Parcel in) {
            return new BuyerItem(in);
        }

        @Override
        public BuyerItem[] newArray(int size) {
            return new BuyerItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageRes);
        parcel.writeString(desc);
    }
}
