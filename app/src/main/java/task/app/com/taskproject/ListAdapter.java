package task.app.com.taskproject;

/**
 * Created by IRFAN on 6/13/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




public class ListAdapter extends BaseAdapter{
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;

    public ListAdapter(Context mainActivity, String[] NameList, int[] Images) {
// TODO Auto-generated constructor stub
        result=NameList;
        context=mainActivity;
        imageId=Images;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
// TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
// TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv_itemtitle;
        ImageView iv_item;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
        Holder holder=new Holder();
        View view;
        view = inflater.inflate(R.layout.listitemlayout, null);

        holder.tv_itemtitle=(TextView) view.findViewById(R.id.tv_itemtitle);
        holder.iv_item=(ImageView) view.findViewById(R.id.iv_itemimage);

        holder.tv_itemtitle.setText(result[position]);
        holder.iv_item.setImageResource(imageId[position]);
       // Picasso.with(context).load(imageId[position]).into(holder.im_language);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}