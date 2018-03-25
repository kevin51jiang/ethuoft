package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BuyerHomeActivity extends Activity{

    ListView buyerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_home_page);

        buyerListView = (ListView)findViewById(R.id.buyerListView);

        final ArrayList<BuyerItem> buyerItemsList = new ArrayList<BuyerItem>();

        BuyerItem dummy = new BuyerItem(R.drawable.bike, "This is a dummy item");
        BuyerItem bike = new BuyerItem(R.drawable.bike, "This is a bike desc");
        buyerItemsList.add(dummy);
        buyerItemsList.add(dummy);
        buyerItemsList.add(dummy);
        buyerItemsList.add(bike);

        BuyerRowAdapter buyerRowAdapter = new BuyerRowAdapter(this, R.layout.buyer_row_layout, buyerItemsList);
        buyerListView.setAdapter(buyerRowAdapter);

        buyerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //to description screen
                BuyerItem chosenBuyerItem = (BuyerItem) buyerItemsList.get(position);
                Intent i = new Intent(BuyerHomeActivity.this, BuyerItemDescriptionActivity.class);
                i.putExtra("BuyerItem", chosenBuyerItem);
                startActivity(i);
            }
        });
    }
}
