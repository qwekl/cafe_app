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

public class IcecreamFragment extends Fragment {

    //Fragment転換
    public IcecreamFragment() {

    }

    //メニューのクリックボタン

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.icecream_fragment, container, false);

        LinearLayout layout13 = (LinearLayout)v.findViewById(R.id.img_nutsbanila_ice);
        final String tag13 = (String)layout13.getTag();

        layout13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag13);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout14 = (LinearLayout)v.findViewById(R.id.img_nuts_choco);
        final String tag14 = (String)layout14.getTag();

        layout14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag14);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout15 = (LinearLayout)v.findViewById(R.id.img_banila_ice);
        final String tag15 = (String)layout15.getTag();

        layout15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag15);
                getContext().startActivity(it);

            }
        });

        LinearLayout layout16 = (LinearLayout)v.findViewById(R.id.img_choco_ice);
        final String tag16 = (String)layout16.getTag();

        layout16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getContext(), Order1.class);
                it.putExtra("it_tag", tag16);
                getContext().startActivity(it);

            }
        });

        return v;
    }
}