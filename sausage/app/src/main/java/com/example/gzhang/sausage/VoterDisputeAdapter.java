package com.example.gzhang.sausage;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by GZhang on 2018-03-25.
 */

class VoterDisputeAdapter extends ArrayAdapter<Dispute> {
    public VoterDisputeAdapter(VoterDisputesListActivity voterDisputesListActivity, int voter_list_of_disputes_row_layout, ArrayList<Dispute> disputeArrayList) {
        super(voterDisputesListActivity, voter_list_of_disputes_row_layout, disputeArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.voter_list_of_disputes_row_layout, null);
        }

        Dispute dispute = getItem(position);

        if(dispute != null) {
            ImageView itemImageView = (ImageView) v.findViewById(R.id.voterDisputeImageView);
            TextView titleTextView = (TextView) v.findViewById(R.id.voterTitleTextView);
            TextView descTextView = (TextView) v.findViewById(R.id.voterDisputeDescTextView);
            TextView ethAmountTextView = (TextView) v.findViewById(R.id.ethAmountTextView);

            if(itemImageView != null){

                //TEMPORARY
                itemImageView.setImageResource(dispute.imageRes);
            }

            if(descTextView != null){
                descTextView.setText(dispute.desc);
            }

            if(titleTextView != null){
                titleTextView.setText(dispute.title);
            }

            if(ethAmountTextView != null){
                //TEMPORARY
                ethAmountTextView.setText(0 + " ETH");
            }
        }

        return v;
    }
}
