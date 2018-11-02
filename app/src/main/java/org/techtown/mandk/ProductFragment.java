package org.techtown.mandk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by LG on 2017-11-06.
 */

public class ProductFragment extends Fragment {

    public ProductFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.fragment_product,container,false);
        final Spinner s = (Spinner)v.findViewById(R.id.product);
        Button tab_3_button = (Button)v.findViewById(R.id.tab_3_button);

        AllProductFragment fragment = new AllProductFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sppinerfragment3, fragment);
        fragmentTransaction.commit();

        tab_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s.getSelectedItem().equals("全部")){
                    AllProductFragment fragment = new AllProductFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment3, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("マグカップ")) {
                    MugeFragment fragment = new MugeFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment3, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("グラス")){
                    GlassFragment fragment = new GlassFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment3, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("タンブラー")) {
                    TumblerFragment fragment = new TumblerFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment3, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return v;
    }
}
