package com.example.gzhang.sausage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buyerButton,
           sellerButton,
           voterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_choose);

        buyerButton = (Button)findViewById(R.id.buyerButton);
        buyerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send to buy screen

                Intent i = new Intent(MainActivity.this, BuyerHomeActivity.class);
                startActivity(i);
            }
        });

        sellerButton = (Button)findViewById(R.id.sellerButton);
        sellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ///
                Intent i = new Intent(MainActivity.this, SellerHomeActivity.class);
                startActivity(i);
            }
        });

        voterButton = (Button)findViewById(R.id.voterButton);
        voterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            ///
            }
        });


    }
}
