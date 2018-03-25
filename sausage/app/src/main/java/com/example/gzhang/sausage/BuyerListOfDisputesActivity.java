package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
        Buyer theBuyer = curIntent.getParcelableExtra("Buyer");

        DisputeAdapter disputeAdapter = new DisputeAdapter(this, R.layout.buyer_list_of_disputes_row_layout, theBuyer.disputeArrayList);
        buyerDisputeListView.setAdapter(disputeAdapter);

        System.out.println(theBuyer.disputeArrayList.get(0).desc);
    }
}
