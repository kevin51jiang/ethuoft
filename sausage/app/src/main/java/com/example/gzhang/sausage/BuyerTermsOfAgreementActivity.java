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

public class BuyerTermsOfAgreementActivity extends Activity{

    Button purchaseMadeButton;

    ImageView TOAItemImageView;

    TextView TOADownPaymentTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_terms_of_agreement_layout);

        Intent curIntent = getIntent();
        final BoughtItem boughtItem = curIntent.getParcelableExtra("BoughtItem");

        TOAItemImageView = (ImageView) findViewById(R.id.TOAItemImageView);
        TOAItemImageView.setImageResource(boughtItem.imageRes);

        boughtItem.downPaymentPercent = 50;
        TOADownPaymentTextView = (TextView) findViewById(R.id.TOADownPaymentTextView);
        TOADownPaymentTextView.setText(boughtItem.downPaymentPercent + "%");

        purchaseMadeButton = (Button)findViewById(R.id.purchaseMadeButton);
        purchaseMadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //purchase made
                Intent i = new Intent(BuyerTermsOfAgreementActivity.this , BuyerListOfItemsActivity.class);
                i.putExtra("BoughtItem", boughtItem);
                startActivity(i);
            }
        });
    }
}
