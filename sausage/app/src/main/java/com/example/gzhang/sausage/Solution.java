package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by GZhang on 2018-03-25.
 */

public class Solution extends Activity{
    Buyer theBuyer;
    Seller theSeller;
    int itemIndex;

    Button evidenceSubmitButton;
    EditText buyerEvidenceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solution_layout);

        final Intent curIntent = getIntent();
        theBuyer = curIntent.getParcelableExtra("Buyer");

        buyerEvidenceEditText = (EditText) findViewById(R.id.buyerEvidenceEditText);
        evidenceSubmitButton = (Button) findViewById(R.id.evidenceSubmitButton);
        evidenceSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listDisputesIntent = new Intent(Solution.this, VoterDisputesListActivity.class);

                itemIndex = curIntent.getIntExtra("itemIndex", 0);
                theSeller = curIntent.getParcelableExtra("Seller");
                listDisputesIntent.putExtra("Buyer", theBuyer);
                listDisputesIntent.putExtra("Seller", theSeller);
                listDisputesIntent.putExtra("itemIndex", itemIndex);
                startActivity(listDisputesIntent);
            }
        });

    }
}
