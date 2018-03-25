package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by GZhang on 2018-03-25.
 */

public class DisputeBuyerAndSellerActivity extends Activity{

    Button buyerSwitchButton,
           sellerSwitchButton,
           voteButton;

    TextView switchTextView;
    Spinner spinToWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispute_buyer_and_seller_layout);

        Intent curIntent = getIntent();
        final Buyer theBuyer = curIntent.getParcelableExtra("Buyer");
        final Seller theSeller = curIntent.getParcelableExtra("Seller");
        final int itemIndex = curIntent.getIntExtra("itemIndex", 0);

        switchTextView = (TextView) findViewById(R.id.switchTextView);
        switchTextView.setText("BUYER: " + theBuyer.disputeArrayList.get(itemIndex).desc);

        buyerSwitchButton = (Button) findViewById(R.id.buyerSideButton);
        buyerSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTextView.setText("BUYER: " + theBuyer.disputeArrayList.get(itemIndex).desc);
                Toast.makeText(getApplicationContext(), "Buyer's description", Toast.LENGTH_LONG).show();
            }
        });

        sellerSwitchButton = (Button) findViewById(R.id.sellerSideButton);
        sellerSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTextView.setText("SELLER: " + theSeller.disputeArrayList.get(itemIndex).desc);
                Toast.makeText(getApplicationContext(), "Seller's description", Toast.LENGTH_LONG).show();
            }
        });

        spinToWin = (Spinner) findViewById(R.id.spinToWin);
        String entries[] = { "BUYER", "SELLER" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, entries);
        spinToWin.setAdapter(adapter);

        voteButton = (Button)findViewById(R.id.voteButton);
        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DisputeBuyerAndSellerActivity.this, Solution.class);
                i.putExtra("Buyer", theBuyer);
                i.putExtra("Seller", theSeller);
                i.putExtra("itemIndex", itemIndex);
                i.putExtra("voteVal", spinToWin.getSelectedItem().toString()); //if isBuyer == true then
                startActivity(i);
            }
        });
    }
}
