package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BuyerListOfItemsActivity extends Activity {

    ListView buyersListOfItemsListView;

    Buyer theBuyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyers_list_of_items_layout);

        Intent curIntent = getIntent();
        BoughtItem boughtItem = curIntent.getParcelableExtra("BoughtItem");

        BoughtItem dummy = new BoughtItem(R.drawable.bike, "Dummy bike", "Dummy desc", 150.2, 20);

        theBuyer = new Buyer();
        theBuyer.boughtItemsArrayList.add(dummy);
        theBuyer.boughtItemsArrayList.add(boughtItem);
        theBuyer.boughtItemsArrayList.add(dummy);
        theBuyer.boughtItemsArrayList.add(dummy);

        buyersListOfItemsListView = (ListView) findViewById(R.id.boughtItemsListView);

        GeneralItemRowAdapter generalItemRowAdapter = new GeneralItemRowAdapter(this, R.layout.general_item_row_layout, theBuyer.boughtItemsArrayList);
        buyersListOfItemsListView.setAdapter(generalItemRowAdapter);
        buyersListOfItemsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //to file dispute page
                BoughtItem chosenBuyerItem = (BoughtItem) theBuyer.boughtItemsArrayList.get(position);
                Intent i = new Intent(BuyerListOfItemsActivity.this, BuyerFileDisputeEvidenceActivity.class);
                i.putExtra("Buyer", theBuyer);
                startActivity(i);
            }
        });

    }
}
