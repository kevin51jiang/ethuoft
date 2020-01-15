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

    final int NUM_VOTERS = 3;

    Buyer buyer;
    Seller seller;
    Voter[] voters;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_choose);

        voters = new Voter[NUM_VOTERS];


        voters[0] = new Voter ("Jim", "1","0xDf37FFD6f626F5521AAB3F81f343C6A5DE06c1a9", "4067b112d6474a9cddce8694a028a8d6972ecc4fd664924aec2a992b28ff3e77");
        voters[1] = new Voter ("Not Jim", "1", "0xD12aE811f20eD54Ac76FF540dfE226C67809768C",  "9656e097d2a40b981944540dfa956ce537554e1247b74a9710d60b753557c13b");
        voters[2] = new Voter ("Maybe Jim", "2", "0x73fB6a191159FBca1D96b68d135a258F1e144Fbc",  "526ed3324aadea0169f32a966eacce5303ba9f3d6bec80ec80f84f0a2ac59f6d");

        Intent curIntent = getIntent();
        final Buyer theBuyer = curIntent.getParcelableExtra("Buyer");
            buyer = theBuyer;
            theBuyer.pubKey = "0xC1511a2a7a07C7DeBd0FF7B9b1Ec8F20e6415fB5";
            theBuyer.privKey = "62a5bdba5ed9eadb322d907c37a1c9090832aeda8748f6efb7e2f59be47666fe";


        final Seller theSeller = curIntent.getParcelableExtra("Seller");
            seller = theSeller;
            theBuyer.pubKey = "0x7c37572EE39dE90529e3e0fDb92153Fa473Ab645";
            theBuyer.privKey = "72e25909e2173fdaf37e43383f8a50efb3fe5ec75d8f962abcbb2c1f4fc60b0b";

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

                ArrayList<Dispute> disputes = new ArrayList<Dispute>();
                Dispute dispute = new Dispute(R.drawable.bike, "Bike", "you all being lied to. its a lieeeeeeeeeeeeeeeeee", 2.5, 10);
                disputes.add(dispute);
                newBuyer.disputeArrayList = disputes;

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
