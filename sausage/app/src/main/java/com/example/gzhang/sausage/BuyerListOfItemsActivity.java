package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BuyerListOfItemsActivity extends Activity {

    ListView buyersListOfItemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyers_list_of_items_layout);

        Intent curIntent = getIntent();

        buyersListOfItemsListView = (ListView) findViewById(R.id.boughtItemsListView);

    }
}
