package com.example.gzhang.sausage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by GZhang on 2018-03-24.
 */

public class Seller extends Person implements Parcelable {

    ArrayList<BoughtItem> sellingItemArrayList;
    ArrayList<Dispute> disputeArrayList;

    public Seller(String name, String address) {
        super(name, address);
        sellingItemArrayList = new ArrayList<BoughtItem>();
        disputeArrayList = new ArrayList<Dispute>();
    }


    public Seller() {
        sellingItemArrayList = new ArrayList<BoughtItem>();
        disputeArrayList = new ArrayList<Dispute>();
    }

    protected Seller(Parcel in) {
        sellingItemArrayList = in.createTypedArrayList(BoughtItem.CREATOR);
        disputeArrayList = in.createTypedArrayList(Dispute.CREATOR);
    }

    public static final Creator<Seller> CREATOR = new Creator<Seller>() {
        @Override
        public Seller createFromParcel(Parcel in) {
            return new Seller(in);
        }

        @Override
        public Seller[] newArray(int size) {
            return new Seller[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(sellingItemArrayList);
        parcel.writeTypedList(disputeArrayList);
    }
}