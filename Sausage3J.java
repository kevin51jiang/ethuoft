package com.kevin51jiang.cardofhouses;

import com.kevin51jiang.cardofhouses.people.*;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

import static java.lang.System.currentTimeMillis;

/**
 * Created by KEVIN on 3/24/2018.
 */


/**
 * Interfaces with Exchange SC
 */
public class Sausage3J {
    Web3j web3;

    public Sausage3J(Buyer buyer, String nodeURL){
        web3 = Web3jFactory.build(new HttpService(nodeURL));
        web3.
    }

    public static long getEpochTime() throws IOException {
        return currentTimeMillis();
    }
}
