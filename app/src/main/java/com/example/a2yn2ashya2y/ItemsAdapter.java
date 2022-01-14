package com.example.a2yn2ashya2y;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

public class ItemsAdapter extends ArrayAdapter<String> {

    String[] ItemsName;
    int Images;
    Context context;

    //constructor to initialize value
    public ItemsAdapter(Context context, String[] genres, int images) {
        super(context, R.layout.itemlist);
        this.ItemsName = genres;
        this.Images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return ItemsName.length;
    }

    // reduce number of calling findViewById() -> speed up performance
    static class ViewHolder {
        ImageView item_image;
        TextView item_name;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        //check if the view is being reused
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemlist,parent,false);

            //data population
            holder.item_image = (ImageView) convertView.findViewById(R.id.itemImage);
            holder.item_name = (TextView) convertView.findViewById(R.id.itemName);
            convertView.setTag(holder); //Initialize view
        }
        else { //if not null get tag, don't initialize
            holder = (ViewHolder) convertView.getTag();
        }

        //sets data
        holder.item_image.setImageResource(Images);
        holder.item_name.setText(ItemsName[position]);

        return convertView; //update views
    }
}
