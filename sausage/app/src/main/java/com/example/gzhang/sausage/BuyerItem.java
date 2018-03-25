package com.example.gzhang.sausage;

/**
 * Created by GZhang on 2018-03-24.
 */

class BuyerItem {
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
}
