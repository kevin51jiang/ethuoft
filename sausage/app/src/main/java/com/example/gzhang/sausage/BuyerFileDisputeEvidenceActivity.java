package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BuyerFileDisputeEvidenceActivity extends Activity {

    Buyer theBuyer;

    Button evidenceSubmitButton;
    EditText buyerEvidenceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_file_dispute_evidence_layout);

        final Intent curIntent = getIntent();
        theBuyer = curIntent.getParcelableExtra("Buyer");

        buyerEvidenceEditText = (EditText) findViewById(R.id.buyerEvidenceEditText);
        evidenceSubmitButton = (Button) findViewById(R.id.evidenceSubmitButton);
        evidenceSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listDisputesIntent = new Intent(BuyerFileDisputeEvidenceActivity.this, BuyerListOfDisputesActivity.class);

                int itemIndex = curIntent.getIntExtra("itemIndex", 0);
                Dispute newDispute = new Dispute();
                newDispute.imageRes = R.drawable.bike;//temporray
                newDispute.title = theBuyer.boughtItemsArrayList.get(itemIndex).title;
                newDispute.desc = buyerEvidenceEditText.getText().toString();
                theBuyer.disputeArrayList.add(newDispute);

                listDisputesIntent.putExtra("Buyer", theBuyer);
                listDisputesIntent.putExtra("itemIndex", itemIndex);
                startActivity(listDisputesIntent);
            }
        });

    }
}