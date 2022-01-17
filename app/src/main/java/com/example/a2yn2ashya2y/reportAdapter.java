package com.example.a2yn2ashya2y;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
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
import java.io.FileDescriptor;
import java.io.InputStream;

public class reportAdapter extends ArrayAdapter<String> {

    String[] ItemsName;
    int Images;
    Context context;

    //constructor to initialize value
    public reportAdapter(Context context, String[] genres, int images) {
        super(context, R.layout.reportitem);
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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.reportitem,parent,false);

            //data population
            holder.item_image = (ImageView) convertView.findViewById(R.id.itemImage);
            holder.item_name = (TextView) convertView.findViewById(R.id.itemName);
            convertView.setTag(holder); //Initialize view
        }
        else { //if not null get tag, don't initialize
            holder = (ViewHolder) convertView.getTag();
        }


        holder.item_name.setText(ItemsName[position]);
        holder.item_image.setImageResource(Images);


        //sets data
        return convertView; //update views
    }
}
