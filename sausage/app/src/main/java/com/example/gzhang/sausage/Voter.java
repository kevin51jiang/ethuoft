package com.example.gzhang.sausage;

/**
 * Created by GZhang on 2018-03-24.
 */

public class Voter extends Person {
    public String toVoteFor;

    public Voter(String name, String toVoteFor, String pubKey, String privKey) {
        super(name, pubKey, privKey);
        this.toVoteFor = toVoteFor;
    }

    public Voter() {

    }

    public void vote(Seller sell, Buyer buy){

    }


}