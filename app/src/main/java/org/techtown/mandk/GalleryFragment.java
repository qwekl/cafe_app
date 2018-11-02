package org.techtown.mandk;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LG on 2017-10-29.
 */

public class GalleryFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    //Fragment転換
    public GalleryFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        View contenedor = (View)container.getParent();
        appBar = (AppBarLayout)contenedor.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#ffffff"), Color.parseColor("#ffffff"));
        tabs.setBackgroundColor(Color.parseColor("#606060"));
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));
        appBar.addView(tabs);

        viewPager = (ViewPager)view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        appBar.removeView(tabs);
    }


    //Tab Fragment
    public class ViewPagerAdapter extends FragmentStatePagerAdapter{
        public ViewPagerAdapter(FragmentManager fragmentManager) {super(fragmentManager);}
        String[] tituloTabs={"飲み物","デザート","商品"};

        @Override
        public Fragment getItem(int position){
            switch(position){
                case 0: return new DrinkFragment();
                case 1: return new DessertFragment();
                case 2: return new ProductFragment();
                default:
            }
            return null;
        }

        @Override
        public int getCount() { return 3; }

        @Override
        public CharSequence getPageTitle(int position) {return tituloTabs[position];}
    }
}
