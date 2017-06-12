package task.app.com.taskproject;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class TabsPagerAdapter extends PagerAdapter {
	String tabs[]={"VIDEO","IMAGE","MILETSONE","NAV MILETSONE","ABOUT US"};
	Activity activity;
    ListAdapter list_adapter;
    String[] namelist = new String[] { "Baby, Jestin bieber",
            "Thriller, Micheal Jackson",
            "Taylor swift",
            "Jennifer Lopez",
            "Accent",
            "Katty perry",
    };

    public static int [] images={R.drawable.jestin,
            R.drawable.jackson,
            R.drawable.taylor,
            R.drawable.jennifer,
            R.drawable.accent,
            R.drawable.katty,
         };


	public TabsPagerAdapter(Activity activity){
		this.activity=activity;
	}
    @Override
    public int getCount() {
        return tabs.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //return tabs[position];
        return "";
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Inflate a new layout from our resources
    	View view=null;

          view = activity.getLayoutInflater().inflate(R.layout.pager_item,container, false);

        // Add the newly created View to the ViewPager
        container.addView(view);

        // Retrieve a TextView from the inflated View, and update it's text
        ListView lv = (ListView) view.findViewById(R.id.list);
         list_adapter=new ListAdapter(activity,namelist,images);
         lv.setAdapter(list_adapter);
        // Return the View
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}