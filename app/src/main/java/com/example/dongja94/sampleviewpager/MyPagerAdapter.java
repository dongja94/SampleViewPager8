package com.example.dongja94.sampleviewpager;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2015-10-08.
 */
public class MyPagerAdapter extends PagerAdapter {

    List<View> scrappedView = new ArrayList<View>();

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view;
        if (scrappedView.size() > 0) {
            view = scrappedView.remove(0);
        } else {
            view = LayoutInflater.from(container.getContext()).inflate(R.layout.view_item, container, false);
        }
        TextView tv = (TextView)view.findViewById(R.id.text_number);
        tv.setText("number : " + position);
        container.addView(view);
        return view;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.5f;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
        scrappedView.add(view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
