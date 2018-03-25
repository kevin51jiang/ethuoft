package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by GZhang on 2018-03-25.
 */

public class VoterDisputesListActivity extends Activity{


    ListView voterDisputeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voter_list_of_disputes_layout);

        voterDisputeListView = (ListView) findViewById(R.id.voterDisputeListView);

        Intent curIntent = getIntent();
        final Buyer theBuyer = curIntent.getParcelableExtra("Buyer");
        final Seller theSeller = curIntent.getParcelableExtra("Seller");
        final int itemIndex = curIntent.getIntExtra("itemIndex", 0);

        VoterDisputeAdapter disputeAdapter = new VoterDisputeAdapter(this, R.layout.voter_list_of_disputes_row_layout, theSeller.disputeArrayList);
        voterDisputeListView.setAdapter(disputeAdapter);
        voterDisputeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //to file dispute page
                BoughtItem chosenBuyerItem = (BoughtItem) theSeller.boughtItemsArrayList.get(position);
                Intent i = new Intent(VoterDisputesListActivity.this, BuyerFileDisputeEvidenceActivity.class);
                i.putExtra("Buyer", theBuyer);
                i.putExtra("Seller", theSeller);
                i.putExtra("itemIndex", position);
                startActivity(i);
            }
        });
    }
}
