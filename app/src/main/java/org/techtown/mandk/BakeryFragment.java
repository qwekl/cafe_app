package org.techtown.mandk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import static java.security.AccessController.getContext;

/**
 * Created by LG on 2017-12-01.
 */

public class BakeryFragment extends Fragment {

    //Fragment転換
    public BakeryFragment() {

    }

    //メニューのクリックボタン
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.bakery_fragment, container, false);

        LinearLayout layout05 = (LinearLayout)v.findViewById(R.id.img_dart);
        final String tag05 = (String)layout05.getTag();

        layout05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag05);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout06 = (LinearLayout)v.findViewById(R.id.img_marong);
        final String tag06 = (String)layout06.getTag();

        layout06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag06);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout07 = (LinearLayout)v.findViewById(R.id.img_sangkem);
        final String tag07 = (String)layout07.getTag();

        layout07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag07);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout08 = (LinearLayout)v.findViewById(R.id.img_winter);
        final String tag08 = (String)layout08.getTag();

        layout08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag08);
                getContext().startActivity(it);

            }
        });

        return v;
    }
}