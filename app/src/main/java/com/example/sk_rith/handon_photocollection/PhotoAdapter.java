package com.example.sk_rith.handon_photocollection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SK_Rith on 6/9/2018.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private final List<Photo> photos;

    public class PhotoViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView userName, date, caption;

        PhotoViewHolder( View itemView ) {
            super(itemView);

            this.image = itemView.findViewById( R.id.photo_image );
            this.userName = itemView.findViewById( R.id.photo_username );
            this.date = itemView.findViewById( R.id.photo_date );

            this.caption = itemView.findViewById( R.id.photo_caption );

        }

    }

    public PhotoAdapter( List<Photo> photos ) {

        this.photos = photos;

    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from( context );
        View containerView = inflater.inflate( R.layout.photo_layout, parent, false );

        return new PhotoAdapter.PhotoViewHolder( containerView );

    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {

        Photo currentPhoto = this.photos.get( position );

        holder.userName.setText( currentPhoto.getOwner() );
        holder.date.setText( currentPhoto.getDatetaken() );
        holder.caption.setText( currentPhoto.getTitle() );

        // Image
        //holder.image.setImageResource(Integer.parseInt(currentPhoto.getId()));


    }

    @Override
    public int getItemCount() { return this.photos.size(); }

}
