package org.techtown.mandk;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by LG on 2017-10-29.
 */

public class pager extends Fragment implements ViewPager.OnClickListener {


    ViewPager pager;
    boolean b_Timer = false;
    boolean onlyOneTime = false;

    private LinearLayout Dots_Layout;
    private ImageView[] dots;

    CountDownTimer CountTimer = new CountDownTimer(5000,1000){
        @Override
        public void onTick(long millisUntilFinished)
        {
        }
        @Override
        public void onFinish(){
            int position = pager.getCurrentItem();

            if(b_Timer == false && onlyOneTime == false && position < 4)
                pager.setCurrentItem(position+1,true);
            else if(b_Timer == false && position ==4  )
            {
                b_Timer = true;
                onlyOneTime = true;
            }

            else if (b_Timer ==true && onlyOneTime == false && position > 0)
            {
                pager.setCurrentItem(position-1,true);
            }

            else if(b_Timer == true && position == 0 )
            {
                b_Timer = false;
                onlyOneTime = true;
            }

            onlyOneTime = false;
            start();
        }
    };

    public pager(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        pager = (ViewPager)view.findViewById(R.id.pager);

        CustomAdapter adapter = new CustomAdapter(getActivity().getLayoutInflater());

        //Viewpagerに Adapter設定
        pager.setAdapter(adapter);


        Dots_Layout = (LinearLayout)view.findViewById(R.id.dotsLayout);
        createDots(0);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position,float positionOffset, int positionOffsetPixels){ }

            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }
            @Override
            public void onPageScrollStateChanged(int state){ }
        });
        CountTimer.start();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        CountTimer.cancel();
    }

    private void createDots(int current_position)
    {
        if(Dots_Layout != null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[4];

        for(int i = 0; i < 4; i++)
        {
            dots[i] = new ImageView(this.getActivity().getApplicationContext());
            if(i==current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this.getActivity().getApplicationContext(), R.drawable.active_dots));
            }
            else
            {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this.getActivity().getApplicationContext(),R.drawable.default_dots));
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);

            Dots_Layout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View v)
    {

    }
}
