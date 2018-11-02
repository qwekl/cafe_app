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

public class AllDrinkFragment extends Fragment{

    //Fragment転換
    public AllDrinkFragment(){

    }

    //メニューのクリックボタン

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.all_drink_fragment,container,false);

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

        LinearLayout layout05 = (LinearLayout)v.findViewById(R.id.img_pappuccino_espresso);
        final String tag05 = (String)layout05.getTag();

        layout05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag05);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout06 = (LinearLayout)v.findViewById(R.id.img_pappuccino_javachip);
        final String tag06 = (String)layout06.getTag();

        layout06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag06);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout07 = (LinearLayout)v.findViewById(R.id.img_pappuccino_moka);
        final String tag07 = (String)layout07.getTag();

        layout07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag07);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout08 = (LinearLayout)v.findViewById(R.id.img_pappuccino_toffee);
        final String tag08 = (String)layout08.getTag();

        layout08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag08);
                getContext().startActivity(it);

            }
        });

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

        LinearLayout layout13 = (LinearLayout)v.findViewById(R.id.img_espresso_ice);
        final String tag13 = (String)layout13.getTag();

        layout13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag13);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout14 = (LinearLayout)v.findViewById(R.id.img_espresso_icetoffee);
        final String tag14 = (String)layout14.getTag();

        layout14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag14);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout15 = (LinearLayout)v.findViewById(R.id.img_espresso_toffelatte);
        final String tag15 = (String)layout15.getTag();

        layout15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag15);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout16 = (LinearLayout)v.findViewById(R.id.img_espresso_very);
        final String tag16 = (String)layout16.getTag();

        layout16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag16);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout17 = (LinearLayout)v.findViewById(R.id.img_tea_icejoyful);
        final String tag17 = (String)layout17.getTag();

        layout17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag17);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout18 = (LinearLayout)v.findViewById(R.id.img_tea_iceorange);
        final String tag18 = (String)layout18.getTag();

        layout18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag18);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout19 = (LinearLayout)v.findViewById(R.id.img_tea_joyful);
        final String tag19 = (String)layout19.getTag();

        layout19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag19);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout20 = (LinearLayout)v.findViewById(R.id.img_tea_orange);
        final String tag20 = (String)layout20.getTag();

        layout20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order2.class);
                it.putExtra("it_tag", tag20);
                getContext().startActivity(it);

            }
        });



        return v;
    }
}
