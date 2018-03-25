package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;

/**
 * Created by GZhang on 2018-03-25.
 */

public class SellerListOfDisputesActivity extends Activity{
    ListView buyerDisputeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_list_of_disputes_layout);

        buyerDisputeListView = (ListView) findViewById(R.id.buyerDisputeListView);

        Intent curIntent = getIntent();
        final Buyer theBuyer = curIntent.getParcelableExtra("Buyer");
        final Seller theSeller = curIntent.getParcelableExtra("Seller");
        final int itemIndex = curIntent.getIntExtra("itemIndex", 0);

        DisputeAdapter disputeAdapter = new DisputeAdapter(this, R.layout.buyer_list_of_disputes_row_layout, theSeller.disputeArrayList);
        buyerDisputeListView.setAdapter(disputeAdapter);

        FloatingActionButton fab = findViewById(R.id.disputeFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SellerListOfDisputesActivity.this, MainActivity.class);
                i.putExtra("Buyer", theBuyer);
                i.putExtra("Seller", theSeller);
                i.putExtra("itemIndex", itemIndex);
                startActivity(i);
            }
        });
    }
}
