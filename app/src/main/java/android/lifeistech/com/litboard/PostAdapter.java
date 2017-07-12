package android.lifeistech.com.litboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fumiyauchiyama on 2017/07/10.
 */
public class PostAdapter extends ArrayAdapter<Post> {

    List<Post> items;

    public PostAdapter(Context context, int resourse, List<Post> objects){
        super(context,resourse,objects);
        items = objects;
    }

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public Post getItem(int position){
        return items.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        class ViewHolder{
            TextView userNameText;
            TextView messegeText;
        }

        Post item = getItem(position);
        final ViewHolder viewHolder;

        if(convertView != null){
            viewHolder = (ViewHolder) convertView.getTag();
        }else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_post,parent,false);

            viewHolder = new ViewHolder();
            viewHolder.userNameText = (TextView)convertView.findViewById(R.id.username);
            viewHolder.messegeText = (TextView)convertView.findViewById(R.id.message);

            convertView.setTag(viewHolder);

        }

        viewHolder.userNameText.setText(item.getUserName());
        viewHolder.messegeText.setText(item.getMessage());

        return convertView;

    }

}
