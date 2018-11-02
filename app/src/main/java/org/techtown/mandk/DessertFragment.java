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

public class DessertFragment extends Fragment{

    public DessertFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.fragment_dessert,container,false);
        final Spinner s = (Spinner)v.findViewById(R.id.dessert);
        Button tab_2_button = (Button)v.findViewById(R.id.tab_2_button);

        AllDessertFragment fragment = new AllDessertFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sppinerfragment2, fragment);
        fragmentTransaction.commit();


        //tabボタン
        tab_2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s.getSelectedItem().equals("")){
                    AllDessertFragment fragment = new AllDessertFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment2, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("ケーキ")) {
                    CakeFragment fragment = new CakeFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment2, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("ベーカーリー")){
                    BakeryFragment fragment = new BakeryFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment2, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("サンドイッチ,サラダ")){
                    SandwitchFragment fragment = new SandwitchFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment2, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("アイスクリーム全部")){
                    IcecreamFragment fragment = new IcecreamFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment2, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return v;
    }
}