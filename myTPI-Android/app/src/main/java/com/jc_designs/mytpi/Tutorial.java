package com.jc_designs.mytpi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tutorial extends AppCompatActivity {


    private ViewPager viewPager;
    private int[] layouts;
    private TextView[] dots;
    private LinearLayout dotsLayout;
    private Button nextButton;
    private Button skipButton;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        nextButton = (Button) findViewById(R.id.tutorialNext);
        skipButton = (Button) findViewById(R.id.tutorialSkip);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);

        //Add layouts to array to add new pages
        layouts = new int[] {R.layout.tutorial_page_1, R.layout.tutorial_page_2, R.layout.tutorial_page_3,
                R.layout.tutorial_page_4, R.layout.tutorial_page_5, R.layout.tutorial_page_6, R.layout.tutorial_page_7, R.layout.tutorial_page_8};

        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN);
        }

        addDots(0);
        clearStatusBar();
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListner);

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tutorial.this, Home.class);
                startActivity(i);
                finish();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int current = getPagePosition(+1);

                if (current<layouts.length) {
                    viewPager.setCurrentItem(current);
                } else {
                    Intent i = new Intent(Tutorial.this, Home.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }

    private int getPagePosition(int i){
        return viewPager.getCurrentItem() + i;
    }

    private void addDots(int position){
        dots = new TextView[layouts.length];
        int[] colorActive = getResources().getIntArray(R.array.dotsActiveArray);
        int[] colorInactive = getResources().getIntArray(R.array.dotsInactiveArray);
        dotsLayout.removeAllViews();

        for (int i=0; i<dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInactive[position]);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(colorActive[position]);
        }
    }

    private void clearStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            w.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            if (position == layouts.length-1){
                nextButton.setText("Finish");
                skipButton.setVisibility(View.GONE);
            } else {
                nextButton.setText("Next");
                skipButton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



    public class ViewPagerAdapter extends PagerAdapter {

        private LayoutInflater inflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(layouts[position],container, false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View)object;
            container.removeView(v);
        }
    }

}
