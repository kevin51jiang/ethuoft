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
 * Created by GZhang on 2018-03-24.
 */

class BuyerRowAdapter extends ArrayAdapter<BuyerItem>{

    public BuyerRowAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public BuyerRowAdapter(Context context, int resource, ArrayList<?> list){
        super(context, resource, (List<BuyerItem>) list);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.buyer_row_layout, null);
        }

        BuyerItem buyerItem = getItem(position);

        if(buyerItem != null) {
            ImageView itemImageView = (ImageView) v.findViewById(R.id.itemImageView);
            TextView descTextView = (TextView) v.findViewById(R.id.itemTextView);

            if(itemImageView != null){

                //TEMPORARY
                itemImageView.setImageResource(R.drawable.bike);
            }

            if(descTextView != null){
                descTextView.setText(buyerItem.desc);
            }
        }

        return v;
    }
}
