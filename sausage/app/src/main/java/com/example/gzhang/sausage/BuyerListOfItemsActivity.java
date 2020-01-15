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

        BoughtItem dummy2 = new BoughtItem(R.drawable.gokart, "Goosey Duck", "Fun to play with. pink.", 120000.2, 90);
        BoughtItem dummy3 = new BoughtItem(R.drawable.home, "Beautiful home", "home is as large as the eye can see...", 400.2, 70);

        theBuyer = new Buyer();
        theBuyer.boughtItemsArrayList.add(boughtItem);
        theBuyer.boughtItemsArrayList.add(dummy3);
        theBuyer.boughtItemsArrayList.add(dummy2);

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
                i.putExtra("itemIndex", position);
                startActivity(i);
            }
        });

    }
}
