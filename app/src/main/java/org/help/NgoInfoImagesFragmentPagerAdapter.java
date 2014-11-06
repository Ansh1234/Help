package org.help;
import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

public class NgoInfoImagesFragmentPagerAdapter extends FragmentStatePagerAdapter {
 
    private ArrayList<Integer> itemData;
 
    public NgoInfoImagesFragmentPagerAdapter(android.support.v4.app.FragmentManager fm, ArrayList<Integer> itemData) {
    	super(fm);
    	this.itemData=itemData;
    }
    public NgoInfoImagesFragmentPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return itemData.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
    @Override
    public Fragment getItem(int position) {
        NgoInfoImagesFragment f = NgoInfoImagesFragment.newInstance();
        f.setImageList(itemData.get(position));
        return f;
    }
}