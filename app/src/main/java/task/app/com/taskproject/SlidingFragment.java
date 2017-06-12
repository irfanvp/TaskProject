

package task.app.com.taskproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.chabbal.slidingdotsplash.SlidingSplashView;


public class SlidingFragment extends Fragment {

    ImageView play;

    private SlidingTabLayout mSlidingTabLayout;

   
    private ViewPager mViewPager;

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
         View v= inflater.inflate(R.layout.fragment_sample, container, false);
        play= (ImageView) v.findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/user/JustinBieberVEVO"));
                startActivity(intent);
            }
        });
         return v;
    }

  
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    	 setUpPager(view);
         setUpTabColor();
    }
    void setUpPager(View view){
    	 mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
         mViewPager.setAdapter(new TabsPagerAdapter(getActivity()));
         mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
         mSlidingTabLayout.setCustomTabView(R.layout.customicon, 0);
         mSlidingTabLayout.setViewPager(mViewPager); 
    }
    void setUpTabColor(){
    	 mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
 			@Override
 			public int getIndicatorColor(int position) {
 				// TODO Auto-generated method stub
 				return SlidingFragment.this.getResources().getColor(R.color.red);
 			}
 			@Override
 			public int getDividerColor(int position) {
 				// TODO Auto-generated method stub
 				return SlidingFragment.this.getResources().getColor(R.color.red);
 			}
         });

    }
    
   
}
