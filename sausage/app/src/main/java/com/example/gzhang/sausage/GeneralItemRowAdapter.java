package com.example.gzhang.sausage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GZhang on 2018-03-24.
 */

public class GeneralItemRowAdapter extends ArrayAdapter<BoughtItem>{

    public GeneralItemRowAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public GeneralItemRowAdapter(Context context, int resource, ArrayList<?> list){
        super(context, resource, (List<BoughtItem>) list);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.general_item_row_layout, null);
        }

        BoughtItem boughtItem = getItem(position);

        if(boughtItem != null) {
            ImageView boughtItemImageView = (ImageView) v.findViewById(R.id.boughtItemImageView);
            TextView boughtItemTitleTextView = (TextView) v.findViewById(R.id.boughtItemTitleTextView);
            ImageView initiateDisputeButton = (ImageView) v.findViewById(R.id.initiateDisputeButton);

            if(boughtItemImageView != null){

                //TEMPORARY
                boughtItemImageView.setImageResource(boughtItem.imageRes); //cannot hard code forever...
            }

            if(boughtItemTitleTextView != null){
                boughtItemTitleTextView.setText(boughtItem.title);
            }

            /*
            if(initiateDisputeButton != null){
                initiateDisputeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println("asdasdasd");
                    }
                });
            }
            *///assume click on row is a click on button
        }

        return v;
    }
}
