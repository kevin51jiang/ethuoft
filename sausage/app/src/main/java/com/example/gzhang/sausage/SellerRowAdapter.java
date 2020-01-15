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

class SellerRowAdapter extends ArrayAdapter<BoughtItem>{

    public SellerRowAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public SellerRowAdapter(Context context, int resource, ArrayList<?> list){
        super(context, resource, (List<BoughtItem>) list);

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

        BoughtItem boughtItem = getItem(position);

        if(boughtItem != null) {
            ImageView itemImageView = (ImageView) v.findViewById(R.id.itemImageView);
            TextView titleTextView = (TextView) v.findViewById(R.id.itemTextView);

            if(itemImageView != null){

                //TEMPORARY
                itemImageView.setImageResource(boughtItem.imageRes);
            }

            if(titleTextView != null){
                titleTextView.setText(boughtItem.title);
            }
        }

        return v;
    }
}
