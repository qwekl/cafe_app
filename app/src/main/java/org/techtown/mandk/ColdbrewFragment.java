package org.techtown.mandk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by LG on 2017-11-06.
 */

public class ColdbrewFragment extends Fragment{

    //Fragment転換
    public ColdbrewFragment(){

    }

    //メニューのクリックボタン
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.coldbrew_fragment,container,false);

        LinearLayout layout09 = (LinearLayout)v.findViewById(R.id.img_coldbrew);
        final String tag09 = (String)layout09.getTag();

        layout09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag09);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout10 = (LinearLayout)v.findViewById(R.id.img_coldbrew_latte);
        final String tag10 = (String)layout10.getTag();

        layout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag10);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout11 = (LinearLayout)v.findViewById(R.id.img_coldbrew_nitro);
        final String tag11 = (String)layout11.getTag();

        layout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag11);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout12 = (LinearLayout)v.findViewById(R.id.img_coldbrew_vanillacream);
        final String tag12 = (String)layout12.getTag();

        layout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag12);
                getContext().startActivity(it);

            }
        });

        return v;
    }
}