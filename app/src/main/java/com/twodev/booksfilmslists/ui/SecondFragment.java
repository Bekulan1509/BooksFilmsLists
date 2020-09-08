package com.twodev.booksfilmslists.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twodev.booksfilmslists.R;
import com.twodev.booksfilmslists.adapters.SlidePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {


    private ViewPager pager;
    private PagerAdapter pagerAdapter;
    List<Fragment> list  = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list.add(new PageFragment());
        list.add(new PageFragment2());
        list.add(new PageFragment3());

        pager = view.findViewById(R.id.pager);
        pagerAdapter= new SlidePagerAdapter(getParentFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
    }
}