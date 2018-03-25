package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BuyerItemDescriptionActivity extends Activity {

    Button buyButton;

    ImageView itemDescImageView;
    TextView itemDescTitleTextView,
            itemMoreDescTextView,
            itemDescCostTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_item_desc_layout);

        Intent curIntent = getIntent();
        BuyerItem chosenBuyerItem = curIntent.getParcelableExtra("BuyerItem");

        final BoughtItem boughtItem = new BoughtItem();
        boughtItem.desc = "This bike is in good quality. Only rode it for a year and only during summer. No scratches. Minimal rust.";
        boughtItem.title = chosenBuyerItem.desc; //messed up .... buyerItem...
        boughtItem.imageRes = chosenBuyerItem.imageRes;
        boughtItem.cost = 100;

        itemDescImageView = (ImageView) findViewById(R.id.itemDescImageView);
        itemDescImageView.setImageResource(boughtItem.imageRes);

        itemDescTitleTextView = (TextView) findViewById(R.id.itemDescTitleTextView);
        itemDescTitleTextView.setText(boughtItem.title);

        itemMoreDescTextView = (TextView) findViewById(R.id.itemMoreDescTextView);
        itemMoreDescTextView.setText(boughtItem.desc);

        itemDescCostTextView = (TextView)findViewById(R.id.itemDescCostTextView);
        itemDescCostTextView.setText(boughtItem.cost + " ETH");

        buyButton = (Button)findViewById(R.id.buyButton);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BuyerItemDescriptionActivity.this, BuyerTermsOfAgreementActivity.class);
                i.putExtra("BoughtItem", boughtItem);
                startActivity(i);
            }
        });

    }
}
