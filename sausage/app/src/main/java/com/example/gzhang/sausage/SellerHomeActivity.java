package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by GZhang on 2018-03-25.
 */

public class SellerHomeActivity extends Activity {

    ListView sellerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_home_layout);

        final Intent curIntent = getIntent();

        final Buyer theBuyer = curIntent.getParcelableExtra("Buyer");
        final int itemIndex = curIntent.getIntExtra("itemIndex", 0);

        sellerListView = (ListView)findViewById(R.id.sellerListView);

        final Seller theSeller = new Seller();

        ArrayList<BoughtItem> sellingItemArrayList = new ArrayList<BoughtItem>();
        BoughtItem dummy = new BoughtItem(R.drawable.home, "Beautiful home", "home is as large as the eye can see...", 400.2, 70);
        sellingItemArrayList.add(dummy);
        sellingItemArrayList.add(dummy);
        sellingItemArrayList.add(theBuyer.boughtItemsArrayList.get(itemIndex));

        theSeller.sellingItemArrayList = sellingItemArrayList;

        SellerRowAdapter sellerRowAdapter = new SellerRowAdapter(this, R.layout.buyer_row_layout, theSeller.sellingItemArrayList);
        sellerListView.setAdapter(sellerRowAdapter);
        sellerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

               //immediately assume its dispute
                Intent i = new Intent(SellerHomeActivity.this, SellerProvideDisputeEvidenceActivity.class);
                i.putExtra("Buyer", theBuyer);
                i.putExtra("Seller", theSeller);
                i.putExtra("itemIndex", position);
                startActivity(i);
            }
        });

        Toast.makeText(getApplicationContext(), "DISPUTE OCCURRED FOR: \"" + theBuyer.boughtItemsArrayList.get(itemIndex).title + "\"", Toast.LENGTH_LONG).show();
    }
}