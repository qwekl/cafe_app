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

public class TeaFragment extends Fragment{

    //Fragment転換
    public TeaFragment(){

    }

    //メニューのクリックボタン
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.tea_fragment,container,false);

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