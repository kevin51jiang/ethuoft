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

public class SellerProvideDisputeEvidenceActivity extends Activity{

    Seller theSeller;

    Button evidenceSubmitButton;
    EditText sellerEvidenceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_file_dispute_evidence_layout);

        final Intent curIntent = getIntent();
        theSeller = curIntent.getParcelableExtra("Seller");

        sellerEvidenceEditText = (EditText) findViewById(R.id.buyerEvidenceEditText);
        evidenceSubmitButton = (Button) findViewById(R.id.evidenceSubmitButton);
        evidenceSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listDisputesIntent = new Intent(SellerProvideDisputeEvidenceActivity.this, SellerListOfDisputesActivity.class);

                int itemIndex = curIntent.getIntExtra("itemIndex", 0);
                Dispute newDispute = new Dispute();
                newDispute.imageRes = R.drawable.bike;//temporray
                newDispute.title = theSeller.sellingItemArrayList.get(itemIndex).title;
                newDispute.desc = sellerEvidenceEditText.getText().toString();
                theSeller.disputeArrayList.add(newDispute);

                listDisputesIntent.putExtra("Buyer", curIntent.getParcelableExtra("Buyer"));
                listDisputesIntent.putExtra("Seller", curIntent.getParcelableExtra("Seller"));
                listDisputesIntent.putExtra("itemIndex", curIntent.getIntExtra("itemIndex", 0));
                startActivity(listDisputesIntent);
            }
        });

    }
}