package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ListView;

import java.util.List;

/**
 * Created by GZhang on 2018-03-25.
 */

public class BuyerListOfDisputesActivity extends Activity {

ListView buyerDisputeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_list_of_disputes_layout);

        buyerDisputeListView = (ListView) findViewById(R.id.buyerDisputeListView);

        Intent curIntent = getIntent();
        final Buyer theBuyer = curIntent.getParcelableExtra("Buyer");
        final int itemIndex = curIntent.getIntExtra("itemIndex", 0);

        DisputeAdapter disputeAdapter = new DisputeAdapter(this, R.layout.buyer_list_of_disputes_row_layout, theBuyer.disputeArrayList);
        buyerDisputeListView.setAdapter(disputeAdapter);

        FloatingActionButton fab = findViewById(R.id.disputeFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(BuyerListOfDisputesActivity.this, MainActivity.class);
               i.putExtra("Buyer", theBuyer);
               i.putExtra("itemIndex", itemIndex);
               startActivity(i);
            }
        });
    }
}
