package app.test.com.fragements;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> fragmentlist = new ArrayList<>();
    private final List<String> str = new ArrayList<>();

    //private Context mContext;

    public PagerAdapter(FragmentManager fm){
        super(fm);
       // this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int i) {
        /*switch (i){
            case 0 :
                Lay1 lay1 = new Lay1();
                return lay1;

            case 1:
                Lay2 lay2 = new Lay2();
                return lay2;
            default:
                return null;

        }*/
        return fragmentlist.get(i);
    }

    @Override
    public int getCount() {
        return str.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
      /*  switch (position){
           case 0: return mContext.getString(R.string.eboks);
           case 1: return mContext.getString(R.string.links);
           default: return null;
       } */
      return str.get(position);
    }
    public void AddFragment(Fragment fragment,String string){
        fragmentlist.add(fragment);
        str.add(string);
    }

}
