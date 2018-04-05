package com.example.myf19.intelligentlock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<Member> {

    private int resourceId;

    public MemberAdapter(Context context, int textViewResourceId,
                         List<Member> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Member member = getItem(position); // 获取当前项的Fruit实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById (R.id.user_image);
            viewHolder.fruitName = (TextView) view.findViewById (R.id.user_name);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.fruitImage.setImageResource(member.getImageId());
        viewHolder.fruitName.setText(member.getName());
        return view;
    }

    class ViewHolder {

        ImageView fruitImage;

        TextView fruitName;

    }

}
