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

public class AllProductFragment extends Fragment {


    //Fragment転換
    public AllProductFragment(){

    }

    //メニューのクリックボタン

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.all_product_fragment,container,false);

        LinearLayout layout01= (LinearLayout)v.findViewById(R.id.img_red_cup);
        final String tag01 = (String)layout01.getTag();

        layout01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag01);
                getContext().startActivity(it);
            }
        });

        LinearLayout layout02= (LinearLayout)v.findViewById(R.id.img_blue_cup);
        final String tag02 = (String)layout02.getTag();

        layout02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag02);
                getContext().startActivity(it);
            }
        });

        LinearLayout layout03 = (LinearLayout)v.findViewById(R.id.img_siren);
        final String tag03 = (String)layout03.getTag();

        layout03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag03);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout04 = (LinearLayout)v.findViewById(R.id.img_cherry_double);
        final String tag04 = (String)layout04.getTag();

        layout04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag04);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout05 = (LinearLayout)v.findViewById(R.id.img_heritage);
        final String tag05 = (String)layout05.getTag();

        layout05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag05);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout06 = (LinearLayout)v.findViewById(R.id.img_snowman);
        final String tag06 = (String)layout06.getTag();

        layout06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag06);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout07 = (LinearLayout)v.findViewById(R.id.img_singlewall);
        final String tag07 = (String)layout07.getTag();

        layout07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag07);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout08 = (LinearLayout)v.findViewById(R.id.img_tibana);
        final String tag08 = (String)layout08.getTag();

        layout08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag08);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout09 = (LinearLayout)v.findViewById(R.id.img_gangleung);
        final String tag09 = (String)layout09.getTag();

        layout09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag09);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout10 = (LinearLayout)v.findViewById(R.id.img_gyungju);
        final String tag10 = (String)layout10.getTag();

        layout10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag10);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout11 = (LinearLayout)v.findViewById(R.id.img_badge);
        final String tag11 = (String)layout11.getTag();

        layout11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag11);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout12 = (LinearLayout)v.findViewById(R.id.img_graphi);
        final String tag12 = (String)layout12.getTag();

        layout12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order3.class);
                it.putExtra("it_tag", tag12);
                getContext().startActivity(it);

            }
        });

        return v;
    }
}
