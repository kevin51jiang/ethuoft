package com.example.gzhang.sausage;


import org.web3j.crypto.Credentials;

/**
 * Created by GZhang on 2018-03-24.
 */

public class Person {
    public String name,
            pubKey,
            privKey;
    public Credentials cred;

    public Person(){
        name = "";
        pubKey = "";
    }

    public Person(String name, String pubKey, String privKey){
        this.name = name;
        this.pubKey = pubKey;
        this.privKey = privKey;

        cred = Credentials.create(pubKey, privKey);
    }


}