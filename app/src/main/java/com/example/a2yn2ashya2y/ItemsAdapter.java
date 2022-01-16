package com.example.a2yn2ashya2y;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.io.File;
import java.io.InputStream;

public class ItemsAdapter extends ArrayAdapter<String> {

    String[] ItemsName;
    String[] Images;
    Context context;

    //constructor to initialize value
    public ItemsAdapter(Context context, String[] genres, String[] images) {
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

        Uri uri = Uri.parse(Images[position]);
        Log.println(Log.DEBUG, uri.toString(), "Unable to set ImageView from URI: URI");
        InputStream is = null;
        try {
            if(uri != null) {
                Bitmap map = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
                holder.item_image.setImageBitmap(map);
            }
        } catch(Exception e) {
            Log.println(Log.DEBUG, e.toString(), "Unable to set ImageView from URI: ");
        }


//        File file = new File(Images[position]);
//        holder.item_image.setImageUrl(file);
        holder.item_name.setText(ItemsName[position]);


        //sets data
        return convertView; //update views
    }
}
