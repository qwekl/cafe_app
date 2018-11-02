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

public class DrinkFragment extends Fragment {

    //Fragment転換
    public DrinkFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        final View v = inflater.inflate(R.layout.fragment_drink,container,false);
        final Spinner s = (Spinner)v.findViewById(R.id.coffee);
        Button tab_1_botton = (Button)v.findViewById(R.id.tab_1_button);

        AllDrinkFragment fragment = new AllDrinkFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sppinerfragment, fragment);
        fragmentTransaction.commit();

        tab_1_botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (s.getSelectedItem().equals("全部")){
                    AllDrinkFragment fragment = new AllDrinkFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("Blendid")) {
                    BlendedFragment fragment = new BlendedFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("Coldbrue")){
                    ColdbrewFragment fragment = new ColdbrewFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("Espresso")){
                    EspressoFragment fragment = new EspressoFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("Capuchino")){
                    CappuccinoFragment fragment = new CappuccinoFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment, fragment);
                    fragmentTransaction.commit();
                }
                else if (s.getSelectedItem().equals("Tea")){
                    TeaFragment fragment = new TeaFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sppinerfragment, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return v;
    }
}
