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

public class BlendedFragment extends Fragment {

    //Fragment転換
    public BlendedFragment() {

    }

    //メニューのクリックボタン
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.blended_fragment, container, false);

        LinearLayout layout01= (LinearLayout)v.findViewById(R.id.img_blended_banana);
        final String tag01 = (String)layout01.getTag();

        layout01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag01);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout02 = (LinearLayout)v.findViewById(R.id.img_blended_mango);
        final String tag02 = (String)layout02.getTag();

        layout02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag02);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout03 = (LinearLayout)v.findViewById(R.id.img_blended_orange);
        final String tag03 = (String)layout03.getTag();

        layout03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag03);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout04 = (LinearLayout)v.findViewById(R.id.img_blended_strawberry);
        final String tag04 = (String)layout04.getTag();

        layout04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag04);
                getContext().startActivity(it);

            }
        });

        return v;
    }
}
