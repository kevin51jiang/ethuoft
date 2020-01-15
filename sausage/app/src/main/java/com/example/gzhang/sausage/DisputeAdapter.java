package com.example.gzhang.sausage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GZhang on 2018-03-25.
 */

public class DisputeAdapter extends ArrayAdapter<Dispute> {
    public DisputeAdapter(@NonNull Context context, int resource, ArrayList<?> list) {
        super(context, resource, (List<Dispute>) list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.buyer_list_of_disputes_row_layout, null);
        }

        Dispute disputeItem = getItem(position);

        if(disputeItem != null) {
            ImageView disputeImageView = (ImageView) v.findViewById(R.id.buyerDisputeImageView);
            TextView disputeTitleTextView = (TextView) v.findViewById(R.id.disputeTitleTextView);
            TextView disputeDescTextView = (TextView) v.findViewById(R.id.disputeDescTextView);

            if(disputeImageView != null){

                //TEMPORARY
                disputeImageView.setImageResource(disputeItem.imageRes);
            }

            if(disputeTitleTextView != null){
                disputeTitleTextView.setText(disputeItem.title);
            }

            if(disputeDescTextView != null){
                disputeDescTextView.setText(disputeItem.desc);
            }
        }

        return v;
    }
}
