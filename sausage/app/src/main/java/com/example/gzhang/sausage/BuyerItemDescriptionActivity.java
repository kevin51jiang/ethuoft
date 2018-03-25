package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BuyerItemDescriptionActivity extends Activity {

    Button buyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_item_desc_layout);

        buyButton = (Button)findViewById(R.id.buyButton);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BuyerItemDescriptionActivity.this, BuyerTermsOfAgreementActivity.class);
            }
        });
    }
}
