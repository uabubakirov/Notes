package com.example.notes.OnBoard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    List<ModelOnBoard> list;


    public FragmentAdapter(FragmentManager fm,List<ModelOnBoard> list) {
        super(fm);
        this.list= list;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            case 1:
            case 2:
                return OnBoardFragment.newInstance(list.get(position).getText(),list.get(position).getImage());
        }
        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}