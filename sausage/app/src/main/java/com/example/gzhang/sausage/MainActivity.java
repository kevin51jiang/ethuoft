package com.example.gzhang.sausage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button buyerButton,
           sellerButton,
           voterButton;

    Buyer buyer;
    Seller seller;
    Voter[] voters;

    final int NUM_VOTERS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_choose);

        voters = new Voter[NUM_VOTERS];
        for(int i = 0; i < NUM_VOTERS; i++){

        }

        Intent curIntent = getIntent();
        final Buyer theBuyer = curIntent.getParcelableExtra("Buyer");
            buyer = theBuyer;
        final Seller theSeller = curIntent.getParcelableExtra("Seller");
            seller = theSeller;
        final int itemIndex = curIntent.getIntExtra("itemIndex", 0);

        buyerButton = (Button)findViewById(R.id.buyerButton);
        buyerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send to buy screen

                Intent i = new Intent(MainActivity.this, BuyerHomeActivity.class);
                if(theBuyer != null) {
                    i.putExtra("Buyer", theBuyer);
                    i.putExtra("itemIndex", itemIndex);
                }
                if(theSeller != null){
                    i.putExtra("Seller", theSeller);
                }
                startActivity(i);
            }
        });

        sellerButton = (Button)findViewById(R.id.sellerButton);
        sellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ///
                Intent i = new Intent(MainActivity.this, SellerHomeActivity.class);

                //TEMPORARY
                Buyer newBuyer = new Buyer();
                ArrayList<BoughtItem> items = new ArrayList<BoughtItem>();
                BoughtItem boughtItem = new BoughtItem(R.drawable.bike, "Bike", "Bike desc", 100.0, 50);
                items.add(boughtItem);
                newBuyer.boughtItemsArrayList = items;

                if(theBuyer != null) {
                    i.putExtra("Buyer", theBuyer);
                    i.putExtra("itemIndex", itemIndex);
                }else{
                    //TEMPORARY
                    i.putExtra("Buyer", newBuyer);
                    i.putExtra("itemIndex", itemIndex);
                }

                if(theSeller != null){
                    i.putExtra("Seller", theSeller);
                }
                startActivity(i);
            }
        });

        voterButton = (Button)findViewById(R.id.voterButton);
        voterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, VoterDisputesListActivity.class);
                if(theBuyer != null) {
                    i.putExtra("Buyer", theBuyer);
                    i.putExtra("itemIndex", itemIndex);
                }
                if(theSeller != null){
                    i.putExtra("Seller", theSeller);
                }
                startActivity(i);
            }
        });


    }
}
