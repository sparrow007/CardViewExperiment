package com.example.ankit.cardviewexperiment;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Ankit on 20-11-2016.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Album> list;
    private Uri uri;
    final public static Uri sArtworkUri = Uri
            .parse("content://media/external/audio/albumart");
    public AlbumAdapter(Context context,ArrayList<Album> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.net_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Album currentAlbum = list.get(position);
        holder.title.setText(currentAlbum.getName());
        uri = ContentUris.withAppendedId(sArtworkUri,currentAlbum.getAlId());
        Log.d("MY TAG",""+currentAlbum.getName());
        Glide.with(context).load(uri).centerCrop().into(holder.thumbnails);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopMenu(holder.overflow);
            }
        });
    }

    private void showPopMenu(ImageView overflow) {
        PopupMenu popup = new PopupMenu(context,overflow);
        MenuInflater infalter = popup.getMenuInflater();
        infalter.inflate(R.menu.menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuClick());
        popup.show();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
     TextView title,count;
        ImageView thumbnails, overflow;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            count = (TextView) itemView.findViewById(R.id.count);
            thumbnails = (ImageView) itemView.findViewById(R.id.thumbnail);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);
        }
    }

    private class MyMenuClick implements PopupMenu.OnMenuItemClickListener {
        public MyMenuClick() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.add_item:
                    Toast.makeText(context,"you clicked add item",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.remove:
                    Toast.makeText(context,"you clicked add favaritoe",Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    }
}
