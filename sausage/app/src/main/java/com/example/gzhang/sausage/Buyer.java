package com.example.gzhang.sausage;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.gzhang.sausage.Voting;

import org.web3j.protocol.Web3jFactory;

import java.util.ArrayList;

/**
 * Created by GZhang on 2018-03-24.
 */

public class Buyer extends Person implements Parcelable {

    ArrayList<BoughtItem> boughtItemsArrayList;
    ArrayList<Dispute> disputeArrayList;

    public Buyer(){
        boughtItemsArrayList = new ArrayList<BoughtItem>();
        disputeArrayList = new ArrayList<Dispute>();
    }


    protected Buyer(Parcel in) {
        boughtItemsArrayList = in.createTypedArrayList(BoughtItem.CREATOR);
        disputeArrayList = in.createTypedArrayList(Dispute.CREATOR);
    }

    public static final Creator<Buyer> CREATOR = new Creator<Buyer>() {
        @Override
        public Buyer createFromParcel(Parcel in) {
            return new Buyer(in);
        }

        @Override
        public Buyer[] newArray(int size) {
            return new Buyer[size];
        }
    };

    public void raiseDisupute(Seller sell){

    }

    public void initTransfer(Seller sell){
        Web3j web3 = Web3jFactory(new HttpService("https://morden.infura.io/your-token"));
        Voting contract  = Voting.deploy();
    }

    public void startForum(){

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(boughtItemsArrayList);
        parcel.writeTypedList(disputeArrayList);
    }
}