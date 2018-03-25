package com.example.gzhang.sausage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by GZhang on 2018-03-24.
 */

public class BuyerFileDisputeEvidenceActivity extends Activity {

    Buyer theBuyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_file_dispute_evidence_layout);

        Intent curIntent = getIntent();
        theBuyer = curIntent.getParcelableExtra("Buyer");

    }
}